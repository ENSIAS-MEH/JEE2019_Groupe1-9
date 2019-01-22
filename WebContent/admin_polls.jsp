<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" prefix="og: http://ogp.me/ns#">
<%@include file="head.jsp"%>
<body>
	<%@include file="Navbar_header.jsp"%>
	<section>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2 sidebar">
					<div class="sidebar-holder">
						<div class="box-holder profile">
							<div class="row">
								<div class="col-md-3 avatar">
									<img
										src="https://www.gravatar.com/avatar/8d794b8902701a460bd62cd9b85aa5d4?s=150"
										alt="Gravatar">
								</div>
								<div class="col-md-9">
									<a href="/cdn-cgi/l/email-protection" class="__cf_email__"
										data-cfemail="791b18171817101f180d1014180318110b18571f031b391e14181015571a1614">[email&#160;protected]</a>
								</div>
							</div>
						</div>
						<!-- <form action="https://gempixel.com/polls/user/search"
							class="search" id="poll_search_form">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-search"></i></span> <input type="text"
									class="form-control" id="poll_search_q"
									placeholder="Search of a poll">
							</div>
						</form> -->
						<ul class="nav nav-sidebar">
							<li><a href="dashboard.admin" ><span
									class="glyphicon glyphicon-home"></span> Dashboard</a></li>
							<li><a href="polls.admin" class="active"><span
									class="glyphicon glyphicon-th-list"></span> Polls</a></li>
							<li><a href="users.admin"><span
									class="glyphicon glyphicon-user"></span> Users</a></li>
							<li><a href="settings.admin"><span
									class="glyphicon glyphicon-cog"></span> Settings</a></li>
						</ul>
						<h3>
							Website Info
							<!-- <span class="label label-primary pull-right">Free</span> -->
						</h3>
						<div class="stats">
							<p>
								<span>${poll_model.number_of_polls }</span> Polls
							</p>
							<p>
								<span>${user_model.number_of_users }</span> Users
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-10 content">
					<div class='ads ad728'>
						<img src="http://placehold.it/728x90/E8117F/FFFFFF">
					</div>
					<%-- <div class="row">
						<div class="container">
							<div class="col-lg-3 col-md-6">
								<div class="card">
									<div class="card-body">
										<div class="stat-widget-five">
											<div class="glyphicon glyphicon-th-list">
												<i class="pe-7f-browser"></i>
											</div>
											<div class="stat-content">
												<div class="text-left dib">
													<div class="stat-text">
														<span class="count">${poll_model.number_of_polls }</span>
													</div>
													<div class="stat-heading">Polls</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="card">
									<div class="card-body">
										<div class="stat-widget-five">
											<div class="glyphicon glyphicon-user">
												<i class="pe-7f-users"></i>
											</div>
											<div class="stat-content">
												<div class="text-left dib">
													<div class="stat-text">
														<span class="count">${user_model.number_of_users }</span>
													</div>
													<div class="stat-heading">Users</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> --%>
						<%-- <div class="container">
							<div class="h4">New Users</div>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>User ID</th>
										<th>Firstname</th>
										<th>Lastname</th>
										<th>Email</th>
										<th>Birth Date</th>
										<th>Nationality</th>
										<th>Gender</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${user_model.recent_users}" var="u">
										<tr>
											<td>${u._id}</td>
											<td>${u._first_name}</td>
											<td>${u._last_name}</td>
											<td>${u._email}</td>
											<td>${u._birth_date}</td>
											<td>${u._nationality}</td>
											<td>${u._gender}</td>
											<td><a onclick="return confirm('Etes vous sur?')"
												href="Supprime.admin?id=${u._id}">Delete</a></td>
											<td><a href="Edit.admin?id=${u._id}">Check</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div> --%>
						<br> <br> 

						<div class="container">
							<div class="h4">All Polls</div>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Description</th>
										<th>Date</th>
										<th>Category</th>
										<th>User ID</th>
										<th>Number Of Voters</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${poll_model.all_polls}" var="p">
										<tr>
											<td>${p._description}</td>
											<td>${p._pollDate}</td>
											<td>${p._category}</td>
											<td>${p._userId}</td>
											<td>${poll_metier._get_number_of_voters(p)}</td>
											<td><a onclick="return confirm('Etes vous sur?')"
												href="Supprime.admin?id=${p._pollId }">Delete</a></td>
											<td><a href="Edit.admin?id=${p._pollId}">Check</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<br> <br>
				<form action='https://gempixel.com/polls/user/delete'
					id='delete_all_form' method='post'>
					<ul class='poll-list'></ul>
					<input type='hidden' name='token'
						value='d4aa544fe947aa33eec030ed601b100e1a9400d6' />
				</form>
			</div>
			<br> <br>
		</div>
		</div>
	</section>
	<script type="text/javascript" src="static/applicationc619.js?v=1.0"></script>
</body>
</html>