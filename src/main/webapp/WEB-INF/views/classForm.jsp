<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
		<h4>Add New Class</h4>
		<div class="card border-info">
			<div class="card-body">
				<form:form method="post" action="saveClass">
					<table>
						<tr>
							<td>Code :</td>
							<td><form:input path="code" /></td>
						</tr>
						<tr>
							<td>Title :</td>
							<td><form:input path="title" /></td>
						</tr>
						<tr>
							<td>Description :</td>
							<td><form:input path="description" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<br /> <a class="btn btn-primary" onclick="history.back()">Go
			Back</a>
	</div>
</body>
</html>
