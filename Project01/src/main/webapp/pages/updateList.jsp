<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>
		<thead>
			<tr>
				<td>User Id</td>
				<td>User Name</td>
				<td>User UName</td>
				<td>User Password</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="ud">
				<tr>
					<td>${ud.ID }</td>
					<td>${ud.Name }</td>
					<td>${ud.UserName }</td>
					<td>${ud.Password }</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>