<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="/WEB-INF/pages/layout/header.jsp"%>

<div class="container">
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

</div>





