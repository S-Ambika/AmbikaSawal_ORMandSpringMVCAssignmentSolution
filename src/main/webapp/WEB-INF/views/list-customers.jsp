<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

.button {
	border: 2px;
	color: white;
	padding: 5px 12px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 13px;
	margin: 5px 3px;
	cursor: pointer;

}
 
.buttonGreen {
background-color: #4CAF50;
} /* Blue */
.buttonRed {
	background-color: #f44336;
} /* Red */
.buttonBlack {
	background-color: #555555;
} /* Black */
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

<title>Customers Directory</title>
</head>
<body>

	<div class="container">
		<h3 class="h3">Customer Relationship Management</h3>
		<hr>

		<!-- Add a button -->
		<a href="/CustomerRelationshipManagement/customers/addCustomer"
			class="button buttonBlack"> Add Customer </a>



		<table class="table table-bordered table-striped">
			<thead class="thead-light">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.first_name}" /></td>
						<td><c:out value="${tempCustomer.last_name}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationshipManagement/customers/UpdateCustomer?customerId=${tempCustomer.id}"
							class="button buttonGreen"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/CustomerRelationshipManagement/customers/delete?customerId=${tempCustomer.id}"
							class="button buttonRed"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>



