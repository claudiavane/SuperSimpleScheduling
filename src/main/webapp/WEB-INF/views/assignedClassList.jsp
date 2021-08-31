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
		
		<div class="card border-info">
			<div class="card-header bg-info text-white">
				<c:if test="${student!=null}">
					<h4>Student: ${student.firstname}  ${student.lastname} </h4>
				</c:if>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Code</th>
							<th>Title</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cl" items="${listClassAssigned}">
							<tr>
								<td>${cl.code}</td>
								<td>${cl.title}</td>
								<td>${cl.description}</td>								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br /> <a class="btn btn-primary" onclick="history.back()">Go back</a>
	</div>
</body>
</html>
