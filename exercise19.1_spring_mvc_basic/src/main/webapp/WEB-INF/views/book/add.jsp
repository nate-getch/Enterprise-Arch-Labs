<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
</head>
<body>
	<form action="/books" method="post">
	<table>
		<tr>
			<td>title:</td>
			<td><input type="text" name="title" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="ISBN" /> </td>
		</tr>
		<tr>
			<td>author:</td>
			<td><input type="text" name="author" /> </td>
		</tr>
		<tr>
			<td>price:</td>
			<td><input type="text" name="price" /> </td>
		</tr>
	</table>
	<input type="submit"/>
	
	</form>
</body>
</html>