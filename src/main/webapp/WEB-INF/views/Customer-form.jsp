<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 6px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.buttonBlue {background-color: #008CBA;} /* Blue */
.h3{
  font: normal normal normal 20px/1 Helvetica, arial, sans-serif;
  border-bottom: 2px solid #000;
  background:lightblue;
  color:#fff;

  padding:3px 10px;
  margin-left:6px;
}
.h3after{ /* the line under H2 */
  left:0px;
  display:block;
  position:absolute;
  width:100%;
  height:3px;
  margin-top:2px;
  content: " ";
  background:#000;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>
<body>
	<div class="container">
		<h3 class ="h3">Customer Relationship Management</h3>
		<hr>
		<p style="color:black">Enter Customer Details</p>
		
		<form action="/CustomerRelationshipManagement/customers/save"
			method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="first_name" value="${Customer.first_name}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>
			<div class="form-inline">
				<input type="text" name="last_name" value="${Customer.last_name}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>
			<button type="submit" class="button buttonBlue">Save</button>
		</form>
		<hr>
		<a href="/CustomerRelationshipManagement/customers/list">Back to
			Customers List</a>
	</div>
</body>

</html>
