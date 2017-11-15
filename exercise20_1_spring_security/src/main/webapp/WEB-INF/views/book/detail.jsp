<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
</head>
<body>
	<form action='<c:url value = "/books/edit/${book.id}"/>' method="post">
	<table>
		<tr>
			<td>title:</td>
			<td><input type="text" name="title" value="${book.title}" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
		</tr>
		<tr>
			<td>author:</td>
			<td><input type="text" name="author" value="${book.author}" /> </td>
		</tr>
		<tr>
			<td>price:</td>
			<td><input type="text" name="price" value="${book.price}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<form action='<c:url value = "/books/delete?bookId=${book.id}"/>' method="post">
		<button type="submit">Delete</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</body>
</html>