<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<spring:url
	value="/resources/common/css/taskboard1.css"
	var="css1" />
	
	
	<spring:url
	value="/resources/common/js/taskboard1.js"
	var="js1" />
	
	

<link href="${css1}" rel="stylesheet">


<script src="${js1}"></script>

</head>
<body class="pushmenu-push">
<div id="nav_list">MENU</div>

<nav class="pushmenu pushmenu-left">

  <ul class="links">

    <li> <a href="#">Home</a> </li>

    <li> <a href="#">About</a> </li>

    <li> <a href="#">Projects</a> </li>
    <li> <a href="#">Blog</a> </li>

    <li> <a href="#">Contacts</a> </li>

  </ul>

</nav>
<div>
user_group_id` INT(11) NOT NULL ,
 INDEX `fk_project_resource_user1` (`user_id` ASC) ,
 INDEX `fk_project_resource_Project1` (`project_id` ASC) ,
 INDEX `fk_project_resource_project_infrastructure1` (`project_infrastructure_id` ASC) ,
 PRIMARY KEY (`team_id`) ,
 INDEX `fk_project_team_user_group1` (`user_group_id` ASC) )
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

[4:26]  
Tamil, above is the table for team..

[4:26]  
The project owner is part of the team, hence, we will create the link between the project and the team

[4:26]  
This table has the user id, project_id.

[4:27]  
You need to copy the firstname, lastname, email, rate for the user table while creating the team record

[4:30]  
INSERT INTO `raasdev`.`user_group` (`user_group_id`, `name`) VALUES (1, 'Project Owner');
INSERT INTO `raasdev`.`user_group` (`user_group_id`, `name`) VALUES (2, 'Member');
INSERT INTO `raasdev`.`user_group` (`user_group_id`, `name`) VALUES (3, 'Administrator');

[4:31]  
Update the team table user_group_id to 1 as the project creator is the owner..

[4:32]  
In summary, create the team table, insert records into the user_group table, create the link between the user/project immediately after creating the project record

[4:32]  
Let me know if you guys have any question

kumraj [5:18 AM]  
Create an github private account - yakkaytechus

[5:18]  
create an account in github for the team and let me know..

[5:18]  
I will provide acce



</div>

</body>
</html>