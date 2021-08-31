<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>


<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Super Simple Scheduling System</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#"> Super Simple Scheduling System </a>
	</nav>
	<div class="container mt-4">
		<h4>Class List</h4>
		<c:if test="${idStudent!=null}">
			<h2>Student ${idStudent}</h2>
		</c:if>
		<div class="card border-info">
			<div class="card-header bg-info text-white">
				<a class="btn btn-light" href="classForm">Add Class</a>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Code</th>
							<th>Title</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cl" items="${list}">
							<tr>
								<td>${cl.code}</td>
								<td>${cl.title}</td>
								<td>${cl.description}</td>
								<td><a class="btn btn-outline-warning" href="editClass/${cl.code}">Edit</a>
								<a class="btn btn-outline-danger" href="deleteClass/${cl.code}">Delete</a>
								<a class="btn btn-outline-primary" href="viewAssignStudent/${cl.code}">View</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br /> <a class="btn btn-primary" href="<c:url value = "/"/>">Go back</a>
	</div>
</body>
</html>
