<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/pages/layout/header.jsp"%>
<div class="">
 <aside class="left-side sidebar-offcanvas" style="min-height:200px">
            <section class="sidebar">
                <div class="page-sidebar sidebar-nav">
                    <!-- Begin Sidebar -->
                        <ul id="menu" class="page-sidebar-menu">
                            <li>
                              <a href="${pageContext.request.contextPath}/dashboard">
                                <span class="Title">Dashboard</span>
                                </a>      
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/projectlist">
                                </i>
                                <span class="Title">Projects</span>
                                </a>  
                            </li>
                            
                                <a id="atag" href="${pageContext.request.contextPath}/userproposal" >
                                <span class="Title">Proposals</span>
                                </a> 
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/userdetail?user_id=${userid}" >
                                <span class="Title">Edit Profile</span>
                                </a>  
                            </li>  
                            <li>
                                <a href="{{ URL::to('messages')}}">
                                <span class="Title">Messages</span>
                                </a>  
                            </li>  
                        </ul>    
                    <!-- End Sidebar -->
                </div>    
          </section>    
 </aside></div>   