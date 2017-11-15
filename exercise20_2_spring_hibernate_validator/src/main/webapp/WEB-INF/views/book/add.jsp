<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
</head>
<body>
	<c:url value="/addBook" var="addBook" />
	<form:form modelAttribute="newBook" action="${addBook}" method="post">
		<%--<form:errors path="*" cssStyle="color : red;" />--%>
	<table>
		<tr>
			<td>title:</td>
			<td>
				<form:input type="text" path="title" /> <br/>
				<form:errors path="title" cssStyle="color : red;" /></td>

		</tr>
		<tr>
			<td>ISBN:</td>
			<td>
				<form:input type="text" path="ISBN" /> <br/>
				<form:errors path="ISBN" cssStyle="color : red;" />
			</td>
		</tr>
		<tr>
			<td>author:</td>
			<td><form:input type="text" path="author" /> <br/>
				<form:errors path="author" cssStyle="color : red;" />
			</td>
		</tr>
		<tr>
			<td>price:</td>
			<td><form:input type="text" path="price" /> <br/>
				<form:errors path="price" cssStyle="color : red;" />
			</td>
		</tr>
	</table>
	<input type="submit"/>
	
	</form:form>
</body>
</html>