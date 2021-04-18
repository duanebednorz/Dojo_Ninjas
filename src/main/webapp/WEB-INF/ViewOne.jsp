<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View One</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to Coding Dojo!</h1>
		</div>
		<a href ="/dashboard">Dashboard</a>
		<hr>
		<h1>${thisDojo.name}</h1>
		<hr>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age Name</th>
				</tr>
				<c:forEach items ="${thisDojo.ninja}" var ="nin">
				<tr>
				
					<td>${nin.first_name}</td>
					<td>${nin.last_name}</td>
					<td>${nin.age}</td>
					
				</tr>
				</c:forEach>
				
			</table>
			<hr>
			<a href="/dojo/${dojo.id}/delete">Delete</a>
		</div>
	</div>

</body>
</html>