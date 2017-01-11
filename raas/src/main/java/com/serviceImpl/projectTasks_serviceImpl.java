package com.serviceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.projectTasks_dao;
import com.dao.projectteam_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.projectTasks_service;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

@Service
public class projectTasks_serviceImpl implements projectTasks_service {

	@Autowired
	projectTasks_dao taskgroupdao;
	
	@Autowired
	projectteam_dao prjtteamdao;
	
	

	public void saveptaskgroup(feature_vo tasks, int project_id,String username) throws Exception {
		taskgroupdao.saveptaskgroup(tasks, project_id,username);
	}

	

	public List<wrapper> gettasktype() throws Exception {
		return taskgroupdao.gettasktype();
	}

	public List<wrapper> gettasksize() throws Exception {
		return taskgroupdao.gettasksize();
	}

	public List<wrapper> gettaskdetails(int project_id) throws Exception {
		List<wrapper> newlist =taskgroupdao.gettaskdetails(project_id);
		List<wrapper> list=new ArrayList();
		int sflag1=0;
		
	    int index=newlist.size();
	    for(int i=0;i<index;i++){
	    	  
	    	  int task_id=newlist.get(i).gettask_id();
	    	  int task_type_id=newlist.get(i).getTask_type_id();	
			  String task_type_name=newlist.get(i).gettask_type_name();	
			  int feature_id=newlist.get(i).getfeature_id();
			  String taskname=newlist.get(i).gettask_name();	
              String taskdes=newlist.get(i).gettask_description();
              String tasksignoff=newlist.get(i).getTask_signoff_criteria();
              String sizecode=newlist.get(i).gettask_size_code();
			  String status=newlist.get(i).getTask_status();
			  Date datebegin=newlist.get(i).getDate_begin();	
			  Date dateend=newlist.get(i).getDate_end();
			  String taskAssign=newlist.get(i).getTask_AssignedTo();
			  String filename=newlist.get(i).getFile_name();	
		      int projectid=newlist.get(i).getProject_id();
		      String userrole=newlist.get(i).getUser_role();
		      
		      wrapper obj = new wrapper();
	    	 
	    	 if(userrole.equals("EMPLOYER")){
	    		 if(status.equals("crt")){
	    		    sflag1=1;
	                obj.setStatusflag(sflag1);
	    		 }else if(status.equals("rwf")){
	    			sflag1=0;
		            obj.setStatusflag(sflag1); 
	    		 }else if(status.equals("inp")){
	    			 sflag1=0;
			         obj.setStatusflag(sflag1); 
	    		 }else if(status.equals("cmp")){
	    			 sflag1=0;
			         obj.setStatusflag(sflag1); 
	    		 }else if(status.equals("sgf")){
	    			 sflag1=0;
			         obj.setStatusflag(sflag1); 
	    		 }
	    		obj.setTask_status(status);
	    		obj.setTask_id(task_id);
	    		obj.setStatus_type_id(task_type_id);
	    		obj.settask_type_name(task_type_name);
	    		obj.setfeature_id(feature_id);
	    		obj.setTask_name(taskname);
	    		obj.setTask_description(taskdes);
	    		obj.setTask_signoff_criteria(tasksignoff);
	    		obj.settask_size_code(sizecode);
	    		obj.setDate_end(datebegin);
	    		obj.setDate_end(dateend);
	    		obj.setTask_AssignedTo(taskAssign);
	    		obj.setFile_name(filename);
	    		obj.setProject_id(projectid);
			    obj.setUser_role(userrole);  
			 }else if(userrole.equals("EMPLOYEE")){
				    if(status.equals("crt")){ 
	    		    sflag1=0;
	    		    obj.setStatusflag(sflag1);
				    }else if(userrole.equals("rwf")){
				    	sflag1=0;
		    		    obj.setStatusflag(sflag1);
		    		}else if(userrole.equals("inp")){
		    			 sflag1=0;
				         obj.setStatusflag(sflag1); 
		    		 }else if(userrole.equals("cmp")){
		    			 sflag1=0;
				         obj.setStatusflag(sflag1); 
		    		 }else if(userrole.equals("sgf")){
		    			 sflag1=0;
				         obj.setStatusflag(sflag1); 
		    		 }
		    		obj.setTask_status(status);
		    		obj.setTask_id(task_id);
		    		obj.setStatus_type_id(task_type_id);
		    		obj.settask_type_name(task_type_name);
		    		obj.setfeature_id(feature_id);
		    		obj.setTask_name(taskname);
		    		obj.setTask_description(taskdes);
		    		obj.setTask_signoff_criteria(tasksignoff);
		    		obj.settask_size_code(sizecode);
		    		obj.setDate_end(datebegin);
		    		obj.setDate_end(dateend);
		    		obj.setTask_AssignedTo(taskAssign);
		    		obj.setFile_name(filename);
		    		obj.setProject_id(projectid);
		    		obj.setUser_role(userrole); 
				   
				    
	    	}
	    	 list.add(obj);
	    }

		return list;
	}

//	public void saveptaskdetails(projectTasks_vo taskdetails, MultipartFile file, int project_id,String username) throws Exception {
//		taskgroupdao.saveptaskdetails(taskdetails, file, project_id,username);
//
//	}

	public String gettaskgpbaseddetails(projectTasks_vo taskgp) throws Exception {
		List<wrapper> newlist=taskgroupdao.gettaskgpbaseddetails(taskgp);
		List<wrapper> list=new ArrayList();
		int sflag1=0;
		String json;
		int index=newlist.size();
		
		
		
		 for(int i=0;i<index;i++){
	    	 
	    	  int task_id=newlist.get(i).gettask_id();
	    	  int task_type_id=newlist.get(i).getTask_type_id();	
			  String task_type_name=newlist.get(i).gettask_type_name();	
			  int feature_id=newlist.get(i).getfeature_id();
			  String taskname=newlist.get(i).gettask_name();	
             String taskdes=newlist.get(i).gettask_description();
             String tasksignoff=newlist.get(i).getTask_signoff_criteria();
             String sizecode=newlist.get(i).gettask_size_code();
			  String status=newlist.get(i).getTask_status();
			  Date datebegin=newlist.get(i).getDate_begin();	
			  Date dateend=newlist.get(i).getDate_end();
			  String taskAssign=newlist.get(i).getTask_AssignedTo();
			  String filename=newlist.get(i).getFile_name();	
		      int projectid=newlist.get(i).getProject_id();
		      String userrole=newlist.get(i).getUser_role();
		     
		      wrapper obj = new wrapper();
	    	 
		      if(userrole.equals("EMPLOYER")){
		    		 if(status.equals("crt")){
		    		    sflag1=1;
		                obj.setStatusflag(sflag1);
		    		 }else if(status.equals("rwf")){
		    			sflag1=0;
			            obj.setStatusflag(sflag1); 
		    		 }else if(status.equals("inp")){
		    			 sflag1=0;
				         obj.setStatusflag(sflag1); 
		    		 }else if(status.equals("cmp")){
		    			 sflag1=0;
				         obj.setStatusflag(sflag1); 
		    		 }else if(status.equals("sgf")){
		    			 sflag1=0;
				         obj.setStatusflag(sflag1); 
		    		 }
	    		
	    		obj.setTask_status(status);
	    		obj.setTask_id(task_id);
	    		obj.setStatus_type_id(task_type_id);
	    		obj.settask_type_name(task_type_name);
	    		obj.setfeature_id(feature_id);
	    		obj.setTask_name(taskname);
	    		obj.setTask_description(taskdes);
	    		obj.setTask_signoff_criteria(tasksignoff);
	    		obj.settask_size_code(sizecode);
	    		obj.setDate_end(datebegin);
	    		obj.setDate_end(dateend);
	    		obj.setTask_AssignedTo(taskAssign);
	    		obj.setFile_name(filename);
	    		obj.setProject_id(projectid);
			      
			 }else if(userrole.equals("EMPLOYEE")){
				    if(status.equals("crt")){ 
		    		    sflag1=0;
		    		    obj.setStatusflag(sflag1);
					    }else if(status.equals("rwf")){
					    	sflag1=0;
			    		    obj.setStatusflag(sflag1);
			    		}else if(status.equals("inp")){
			    			 sflag1=0;
					         obj.setStatusflag(sflag1); 
			    		 }else if(status.equals("cmp")){
			    			 sflag1=0;
					         obj.setStatusflag(sflag1); 
			    		 }else if(status.equals("sgf")){
			    			 sflag1=0;
					         obj.setStatusflag(sflag1); 
			    		 }
	    		   
	    		  
		    		obj.setTask_status(status);
		    		obj.setTask_id(task_id);
		    		obj.setStatus_type_id(task_type_id);
		    		obj.settask_type_name(task_type_name);
		    		obj.setfeature_id(feature_id);
		    		obj.setTask_name(taskname);
		    		obj.setTask_description(taskdes);
		    		obj.setTask_signoff_criteria(tasksignoff);
		    		obj.settask_size_code(sizecode);
		    		obj.setDate_end(datebegin);
		    		obj.setDate_end(dateend);
		    		obj.setTask_AssignedTo(taskAssign);
		    		obj.setFile_name(filename);
		    		obj.setProject_id(projectid);
	    	
				   
				    
	    	}
	    	 list.add(obj);
	    }

		   Gson gson = new GsonBuilder().setPrettyPrinting().create();
		   json = gson.toJson(list);
		return json;
	}

	public String editTask(projectTasks_vo edtsk) throws Exception {
		return taskgroupdao.editTask(edtsk);
	}

	public List<wrapper> gettaskviewbaseddetails(projectTasks_vo taskgp) throws Exception {
		return taskgroupdao.gettaskviewbaseddetails(taskgp);
	}

	public void getUsername(Principal principal, String userName) throws Exception {
		taskgroupdao.getUsername(principal, userName);

	}

	public List<wrapper>  getproject_id(int project_id) throws Exception {
		return taskgroupdao.getproject_id(project_id);
	}

	public void getupdatetaskdetail(projectTasks_vo ptv) throws Exception {
		taskgroupdao.getupdatetaskdetail(ptv);

	}

	public String editptaskgroup(feature_vo tasks, int project_id) throws Exception {
		return taskgroupdao.editptaskgroup(tasks, project_id);
	}
	public String edittaskdetails(projectTasks_vo taskdetails,MultipartFile file) throws Exception {
		 return taskgroupdao.edittaskdetails(taskdetails,file);
		
	}

	public void deletedetails(int feature_id) throws Exception {
		taskgroupdao.deletedetails(feature_id);
		
	}

	public List<wrapper> getpriority_code() throws Exception {
		
		return taskgroupdao.getpriority_code();
	}

	public String loadeditgroup(int feature_id) throws Exception {
		return taskgroupdao.loadeditgroup(feature_id);
	}

	public List<wrapper> getteambrddetails(int project_id) throws Exception {
		return  prjtteamdao.getteambrddetails(project_id);
	}

	public String getteamviewdetails(projectTasks_vo ptv) throws Exception {
		
		return prjtteamdao.getteamviewdetails(ptv);
	}

	public List<wrapper> getteaminpdetails(int project_id) throws Exception {
		return prjtteamdao.getteaminpdetails(project_id);
	}

	public List<wrapper> getteamcmpdetails(int project_id) throws Exception {
		return prjtteamdao.getteamcmpdetails(project_id);
	}

	public List<wrapper> getteamsignoffdetails(int project_id) throws Exception {
		return prjtteamdao.getteamsignoffdetails(project_id);
	}

	public List<wrapper> getteamfirstddetails(int project_id) throws Exception {
		return prjtteamdao.getteamfirstdetails(project_id);
	}

	public List<wrapper> getuserrole(String userName) throws Exception {
		// TODO Auto-generated method stub
		 List<wrapper> list=new ArrayList<wrapper>();
	        int sflag=0;
	        String userrole=taskgroupdao.getuserrole(userName).get(0).getUser_role();
	    
	         wrapper obj = new wrapper();
	        if(userrole.equals("EMPLOYER")){
	            sflag=1;
	            obj.setStatusflag(sflag);
	            
	        }else if(userrole.equals("EMPLOYEE")){
	            sflag=0;
	            obj.setStatusflag(sflag);
	            
	        }
	        list.add(obj);
	        
	        return list;
	    }

	public List<wrapper> getteamfirstviewdetails(int project_id) throws Exception {
		return prjtteamdao.getteamfirstviewdetails(project_id);
	}



	public String gettaskgpviewdetails(int project_id, projectTasks_vo taskgp) throws Exception {
		return prjtteamdao.gettaskgpviewdetails(project_id,taskgp);
	}



	

}
