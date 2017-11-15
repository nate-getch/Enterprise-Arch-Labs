<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Book</title>
</head>
<body>
	<c:url value="/books/${book.id}" var="updateBook" />
	<form:form modelAttribute="newBook" action="${updateBook}" method="post">
	<table>
		<tr>
			<td>title:</td>
			<td><form:input path="title" value="${book.title}" />
				<form:errors path="title" cssStyle="color : red;" /></td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><form:input path="ISBN" value="${book.ISBN}" />
				<form:errors path="ISBN" cssStyle="color : red;" /></td>
		</tr>
		<tr>
			<td>author:</td>
			<td><form:input path="author" value="${book.author}" />
				<form:errors path="author" cssStyle="color : red;" />
			</td>
		</tr>
		<tr>
			<td>price:</td>
			<td><form:input path="price" value="${book.price}" />
				<form:errors path="price" cssStyle="color : red;" />
			</td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form:form>
	<c:url value="/books/delete?bookId=${book.id}" var="delBook" />
	<form:form action="${delBook}" method="post">
		<button type="submit">Delete</button>
	</form:form>
</body>
</html>