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
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Super Simple Scheduling System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"></a>
        </li>
        
      </ul>
      <form class="d-flex"  >
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchString" />
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
	
	<div class="container mt-4">
		<h4>Student List</h4>
		<div class="card border-info">

			<div class="card-header bg-info text-white">
				<a class="btn btn-light" href="studentForm">Add Student</a>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${list}">
							<tr>
								<td>${student.studentId}</td>
								<td>${student.firstname}</td>
								<td>${student.lastname}</td>
								<td><a class="btn btn-outline-warning"
									href="editStudent/${student.studentId}">Edit</a> <a
									class="btn btn-outline-danger"
									href="deleteStudent/${student.studentId}">Delete</a> <a
									class="btn btn-outline-primary" 
									href="viewAssignClass/${student.studentId}">View</a>
									</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br /> <a class="btn btn-primary" href="viewClassList">View Class
			List</a>
	</div>
	
</body>
</html>

