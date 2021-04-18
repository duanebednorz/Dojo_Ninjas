<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome</h1>
		</div>
		<hr>
		<a href="/dojos/new">New Dojo</a> | <a href="/ninjas/new">New Ninja</a> | <a href ="/dashboard">Dashboard</a>
		<hr>
		<div class="row">
			<div class="col-sm-4">
				<form:form action="/dojo/create" method="post"
					modelAttribute="aDojo">
					<div class="form-group">
						<label>Dojo Name:</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<input type="submit" value="Add Dojo" class="btn btn-primary" />
				</form:form>
			</div>
		</div>

	</div>
</body>
</html>