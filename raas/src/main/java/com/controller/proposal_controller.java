package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.crtproject_dao;
import com.service.ProposalService;
import com.service.featureService;
import com.service.jobService;
import com.service.projectTasks_service;
import com.vo.ProposalTasksVO;
import com.vo.crtproject_vo;
import com.vo.projectTasks_vo;
import com.wrapper.wrapper;

@Controller
public class proposal_controller {

	@Autowired
	private ProposalService proposalservice;

	@Autowired
	private jobService jobservice;

	@Autowired
	private projectTasks_service taskgroupservice;

	@Autowired
	private featureService featuresetsservice;

	@Autowired
	private crtproject_dao crtdao;

	@RequestMapping(value = "/detailproposal", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String detailproposal(@PathVariable("project_id") int project_id, ProposalTasksVO ptv, Model model,
			HttpServletRequest request) throws Exception {
		return "true";

	}

	//proposal page loading information
	@RequestMapping(value = "/proposal/{project_id:.+}", method = { RequestMethod.GET, RequestMethod.POST })
	public String proposal(@PathVariable("project_id") int project_id, ProposalTasksVO ptv, Model model,
			HttpServletRequest request, Principal principal) throws Exception {

		System.out.println("Pathvariable" + project_id);

		String username = principal.getName();
		int team_id = proposalservice.getteam_id(project_id, username);

		HttpSession session = request.getSession(true);
		session.setAttribute("team_id", team_id);
		model.addAttribute("project_id", taskgroupservice.getproject_id(project_id));
		model.addAttribute("tasktype", taskgroupservice.gettasktype());
		model.addAttribute("tasksize", taskgroupservice.gettasksize());
		model.addAttribute("estimatedhours", proposalservice.getestimated_hrs());
		model.addAttribute("projectname", crtdao.pro_name(project_id));
		model.addAttribute("taskdetails", proposalservice.gettaskdetails(project_id));
		model.addAttribute("feature", featuresetsservice.getfeaturepro_sets(project_id));
		model.addAttribute("teamdetail", proposalservice.getproposalfirstviewdetails(project_id));
		model.addAttribute("team", proposalservice.getteamdetails(team_id));
		model.addAttribute("count", proposalservice.getcount(project_id));

		return "/job/proposal";
	}

	//save proposaltasks
	@RequestMapping(value = "/proposaltasks", method = RequestMethod.POST)
	@ResponseBody
	public String tasksave(@RequestParam("project_id") int project_id, @RequestParam(value = "file") MultipartFile file,
			ProposalTasksVO taskdetails, Model model, Principal principal) throws Exception {

		System.out.println("proposaltasks");

		String fileName = null;
		final String token = UUID.randomUUID().toString();
		try {
			fileName = file.getOriginalFilename();
			long filesize = file.getSize();
			byte[] bytes = file.getBytes();
			BufferedOutputStream buffStream = new BufferedOutputStream(
					new FileOutputStream(new File("D:/Attachmentssave/" + fileName)));
			buffStream.write(bytes);
			buffStream.close();
			proposalservice.addTask(taskdetails, file, project_id, token, fileName, filesize);

			return "true";

		} catch (Exception e) {
			return "You failed to upload " + fileName + ": " + e.getMessage();
		}

	}

	//proposal task view
	@RequestMapping(value = "/proposaltaskview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String teamview(ProposalTasksVO ptv, crtproject_vo crt, Model model) throws Exception {
		model.addAttribute("teamview", proposalservice.getproposalviewdetails(ptv));

		return proposalservice.getproposalviewdetails(ptv);
	}

	//feature based proposal task details
	@RequestMapping(value = "/featurebaseddetails", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String gettaskgpbaseddetails(@RequestParam("project_id") int project_id, ProposalTasksVO taskgp, Model model)
			throws Exception {

		return proposalservice.getfeatureviewdetails(project_id, taskgp);
	}

	//proposal tasks and estimated hours count
	@RequestMapping(value = "/featurebasedcount", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String featurebasedcount(@RequestParam("project_id") int project_id, ProposalTasksVO taskgp, Model model)
			throws Exception {

		return proposalservice.get_featurebased_count(project_id, taskgp);
	}

	//edit proposal tasks
	@RequestMapping(value = "/proposaledit", method = RequestMethod.POST)
	@ResponseBody
	public String tasks(@RequestParam("project_id") int project_id, @RequestParam(value = "file") MultipartFile file,
			ProposalTasksVO ptv, Model model, Principal principal) throws Exception {
		String fileName = null;
		final String token = UUID.randomUUID().toString();
		try {
			fileName = file.getOriginalFilename();
			long filesize = file.getSize();
			byte[] bytes = file.getBytes();
			BufferedOutputStream buffStream = new BufferedOutputStream(
					new FileOutputStream(new File("D:/Attachmentssave/" + fileName)));
			buffStream.write(bytes);
			buffStream.close();
			proposalservice.editproposaltaskdetails(ptv, file);

			return "true";

		} catch (Exception e) {
			return "You failed to upload " + fileName + ": " + e.getMessage();
		}

	}

}
