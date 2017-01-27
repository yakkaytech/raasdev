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
	value="/resources/common/css/metisMenu.min.css"
	var="css1" />
	<spring:url
	value="/resources/common/css/bootstrap.min.css"
	var="css2" />
	
	<spring:url
	value="/resources/common/js/metisMenu.min.js"
	var="js1" />
	<spring:url
	value="/resources/common/js/bootstrap.min.js"
	var="js2" />
	<spring:url
	value="/resources/common/js/metisMenu.min.js"
	var="js3" />

<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">

<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js3}"></script>

<script>

	
	$(function () {
	    $('#menu').metisMenu();
	    activeClass: 'active'
	  });

  
</script>
</head>
<body>

<div class="container-fluid">
  <div class="row">
    <div class="col-xs-2">
      <aside class="sidebar">
        <nav class="sidebar-nav">
          <ul class="metismenu" id="menu">
            <li class="active">
              <a href="#" aria-expanded="true">
                <span class="sidebar-nav-item-icon fa fa-github fa-lg"></span>
                <span class="sidebar-nav-item">metisMenu</span>
                <span class="fa arrow"></span>
              </a>
              <ul aria-expanded="true">
                <li>
                  <a href="https://githu/onokumus/metisMenu">
                    <span class="sidebar-nav-item-icon fa fa-code-fork"></span> Fork
                  </a>
                </li>
                <li>
                  <a href="https://github/onokumus/metisMenu">
                    <span class="sidebar-nav-item-icon fa fa-star"></span> Star
                  </a>
                </li>
                <li>
                  <a href="https://gith/onokumus/metisMenu/issues">
                    <span class="sidebar-nav-item-icon fa fa-exclamation-triangle"></span> Issues
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="#" aria-expanded="false">Menu 0 <span class="fa arrow"></span></a>
              <ul aria-expanded="false">
                <li><a href="#">item 0.1</a></li>
                <li><a href="#">item 0.2</a></li>
                <li><a href="http://onoku.com">onokumus</a></li>
                <li><a href="#">item 0.4</a></li>
              </ul>
            </li>
            <li>
              <a href="#" aria-expanded="false">Menu 1 <span class="glyphicon arrow"></span></a>
              <ul aria-expanded="false">
                <li><a href="#">item 1.1</a></li>
                <li><a href="#">item 1.2</a></li>
                <li>
                  <a href="#" aria-expanded="false">Menu 1.3 <span class="fa plus-times"></span></a>
                  <ul aria-expanded="false">
                    <li><a href="#">item 1.3.1</a></li>
                    <li><a href="#">item 1.3.2</a></li>
                    <li><a href="#">item 1.3.3</a></li>
                    <li><a href="#">item 1.3.4</a></li>
                  </ul>
                </li>
                <li><a href="#">item 1.4</a></li>
                <li>
                  <a href="#" aria-expanded="false">Menu 1.5 <span class="fa plus-minus"></span></a>
                  <ul aria-expanded="false">
                    <li><a href="#">item 1.5.1</a></li>
                    <li><a href="#">item 1.5.2</a></li>
                    <li><a href="#">item 1.5.3</a></li>
                    <li><a href="#">item 1.5.4</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li>
              <a href="#" aria-expanded="false">Menu 2 <span class="glyphicon arrow"></span></a>
              <ul aria-expanded="false">
                <li><a href="#">item 2.1</a></li>
                <li><a href="#">item 2.2</a></li>
                <li><a href="#">item 2.3</a></li>
                <li><a href="#">item 2.4</a></li>
              </ul>
            </li>
          </ul>
        </nav>
      </aside>
    </div>
  </div>
</div>


</body>
</html>