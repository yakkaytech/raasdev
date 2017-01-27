<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="/WEB-INF/pages/layout/header.jsp"%>

<nav class="navbar-xs navbar-center" style="background-color:gray;">
	 <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".main-nav">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse main-nav">
                <ul class="nav navbar-nav navbar-center">
                    <li><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
                     <li><a href="${pageContext.request.contextPath}/projectlist">Projects</a></li>
                      <li><a href="${pageContext.request.contextPath}/userproposal">Proposals</a></li>
                       <li><a href="#">Message Box</a></li>
                        <li><a href="${pageContext.request.contextPath}/userdetail?user_id=${userid}">Profile</a></li>
                         <li><a href="#">Settings</a></li>

                </ul>
            </div>
        </div>
</nav>

<!--<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 text-center boarder=1">
			<div class="col-lg-2">
				<button type="button" class="knob btn-lg" data-fgColor="#418bca"
					data-thickness=".2" data-width="80%" readonly value="0">
					<i class="glyphicon glyphicon-dashboard"></i>
				</button>
				Dashboard
			</div>
			<div class="col-lg-2">
				<button type="button" class="knob btn-lg" data-fgColor="#418bca"
					data-thickness=".2" data-width="80%" readonly value="60">
					<i class="glyphicon glyphicon-time"></i>
				</button>
				Availability
			</div>
			<div class="col-lg-2">
				<button type="button" class="knob btn-lg" data-fgColor="#418bca"
					data-thickness=".2" data-width="80%" readonly value="0">
					<i class="glyphicon glyphicon-plus"></i>
				</button>
				Apply jobs
			</div>
			<div class="col-lg-2">
				<button type="button" class="knob" data-fgColor="#418bca"
					data-thickness=".2" data-width="80%" readonly value="80">
					<i class="glyphicon glyphicon-usd"></i>
				</button>
				Payments
			</div>
			<div class="col-lg-2">

				<button type="button" class="knob btn-lg" data-fgColor="#418bca"
					data-thickness=".2" data-width="80%" readonly value="22">
					<a
						href="${pageContext.request.contextPath}/userdetail?user_id=${userid}">
						<i class="glyphicon glyphicon-user"></i>
					</a>
				</button>
				Profile
			</div>
			<div class="col-lg-2">
				<button type="button" class="knob" data-fgColor="#418bca"
					data-thickness=".2" data-width="80%" readonly value="0">

					<i class="glyphicon glyphicon-cog"></i>
				</button>
				Settings
			</div>
		</div>
	</div>

</div>-->





