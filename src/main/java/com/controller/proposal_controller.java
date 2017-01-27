package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
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

import com.dao.common_dao;
import com.dao.crtproject_dao;
import com.service.feature_service;
import com.service.job_service;
import com.service.projecttasks_service;
import com.service.proposal_service;
import com.service.team_service;
import com.vo.crtproject_vo;
import com.vo.proposaltasks_vo;
import com.vo.registration_vo;

@Controller
public class proposal_controller {

	@Autowired
	private common_dao comDao;
	
	@Autowired
	private proposal_service proposalService;

	@Autowired
	private job_service jobService;

	@Autowired
	private projecttasks_service taskGroupService;

	@Autowired
	private feature_service featureSetsService;
	
	
	@Autowired
	private team_service teamService;

	@Autowired
	private crtproject_dao crtDao;

	@RequestMapping(value = "/detailproposal", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String detailproposal() throws Exception {
		
		return "true";

	}

	//proposal page loading information
	@RequestMapping(value = "/proposal", method = { RequestMethod.GET, RequestMethod.POST })
	
	public String proposal(@RequestParam("token") String token, Model model,
			HttpServletRequest request, Principal principal) throws Exception {

		
		String username = principal.getName();
		int project_id=proposalService.getprojectid(token);
		int team_id = proposalService.getteam_id(project_id, username);
		HttpSession session = request.getSession(true);
		session.setAttribute("team_id", team_id);
		model.addAttribute("user_id", jobService.getuserid(username));
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("tasktype", taskGroupService.gettasktype());
		model.addAttribute("tasksize", taskGroupService.gettasksize());
		model.addAttribute("estimatedhours", proposalService.getestimated_hrs());
		model.addAttribute("projectname", crtDao.pro_name(project_id));
		model.addAttribute("taskdetails", proposalService.gettaskdetails(project_id));
		model.addAttribute("feature", featureSetsService.getfeaturepro_sets(project_id));
		model.addAttribute("viewdetail", proposalService.getproposalfirstviewdetails(project_id));
		model.addAttribute("team", proposalService.getteamdetails(team_id));
		model.addAttribute("count", proposalService.getcount(project_id));
		model.addAttribute("teamstatus",teamService.getteamstatus(project_id,team_id));

		return "/job/proposal";
	}

	//save proposaltasks
	@RequestMapping(value = "/proposaltasks", method = RequestMethod.POST)
	@ResponseBody
	public String tasksave(@RequestParam("project_id") int project_id, @RequestParam(value = "file") MultipartFile file,
			proposaltasks_vo taskdetails) throws Exception {


		String fileName = null;
		final String token = UUID.randomUUID().toString();
		try {
			fileName = file.getOriginalFilename();
			long filesize = file.getSize();
			byte[] bytes = file.getBytes();
			BufferedOutputStream buffStream = new BufferedOutputStream(
					new FileOutputStream(new File("C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/file/" + fileName)));
			buffStream.write(bytes);
			buffStream.close();
			proposalService.addTask(taskdetails, file, project_id, token, fileName, filesize);

			return "true";

		} catch (Exception e) {
			return "You failed to upload " + fileName + ": " + e.getMessage();
		}

	}

	//proposal task view
	@RequestMapping(value = "/proposaltaskview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String teamview(proposaltasks_vo ptv, Model model) throws Exception {
	//	model.addAttribute("teamview", proposalService.getproposalviewdetails(ptv));

		return proposalService.getproposalviewdetails(ptv);
	}

	//feature based proposal task details
	@RequestMapping(value = "/featureproposaldetails",  method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String gettaskgpbaseddetails(@RequestParam("project_id") int project_id, proposaltasks_vo taskgp)
			throws Exception {

		return proposalService.getfeatureviewdetails(project_id, taskgp);
	}

	//proposal tasks and estimated hours count
	@RequestMapping(value = "/featurebasedcount", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String featurebasedcount(@RequestParam("project_id") int project_id, proposaltasks_vo taskgp)
			throws Exception {

		return proposalService.get_featurebased_count(project_id, taskgp);
	}

	//edit proposal tasks
	@RequestMapping(value = "/proposaledit", method = RequestMethod.POST)
	@ResponseBody
	public String tasks(@RequestParam(value = "file") MultipartFile file,
			proposaltasks_vo ptv ) throws Exception {
		String fileName = null;
		final String token = UUID.randomUUID().toString();
		try {
			fileName = file.getOriginalFilename();
			long filesize = file.getSize();
			byte[] bytes = file.getBytes();
			BufferedOutputStream buffStream = new BufferedOutputStream(
					new FileOutputStream(new File("C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/file/" + fileName)));
			buffStream.write(bytes);
			buffStream.close();
			proposalService.editproposaltaskdetails(ptv, file);

			return "true";

		} catch (Exception e) {
			return "You failed to upload " + fileName + ": " + e.getMessage();
		}

	}
	

	@RequestMapping(value = "/sampleproposal/{token:.+}", method = { RequestMethod.GET, RequestMethod.POST })
	public String sampleproposal(@PathVariable("token") String token,proposaltasks_vo ptv, Model model,HttpServletRequest request,Principal principal) throws Exception {
		int project_id=proposalService.getprojectid(token);
		String username = principal.getName();
		int team_id = proposalService.getteam_id(project_id, username);
		HttpSession session = request.getSession(true);
		session.setAttribute("team_id", team_id);
		model.addAttribute("user_id", jobService.getuserid(username));
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("tasktype", taskGroupService.gettasktype());
		model.addAttribute("tasksize", taskGroupService.gettasksize());
		model.addAttribute("estimatedhours", proposalService.getestimated_hrs());
		model.addAttribute("projectname", crtDao.pro_name(project_id));
		model.addAttribute("taskdetails", proposalService.gettaskdetails(project_id));
		model.addAttribute("feature", featureSetsService.getfeaturepro_sets(project_id));
		model.addAttribute("teamdetail", proposalService.getproposalfirstviewdetails(project_id));
		model.addAttribute("team", proposalService.getteamdetails(team_id));
		model.addAttribute("count", proposalService.getcount(project_id));
		
		return "/job/proposal";
	}
	

	@RequestMapping(value = "/checkrateandcode", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String memberrate(@RequestParam("user_id") int user_id) throws Exception {

		return proposalService.getmember_rateandcode(user_id);
	}

	@RequestMapping(value = "/submitproposal", method = { RequestMethod.GET, RequestMethod.POST })
	public String submitproposal(@RequestParam("project_id") int project_id,@RequestParam("team_id") int team_id) throws Exception {

		proposalService.submit_proposal(project_id,team_id);
		return "/job/proposal";
	}
    
	@RequestMapping(value = "/userproposal", method = { RequestMethod.GET, RequestMethod.POST  })
    public String proposal(Model model,registration_vo reg,Principal principal) throws Exception {
        String username=principal.getName();
        int userid=comDao.getuser_id(username);
        model.addAttribute("userid", comDao.getuser_id(username));
        model.addAttribute("project", proposalService.getmyproposals(userid));
        
        return "/member/proposals.blade";
    }
	
	
}
