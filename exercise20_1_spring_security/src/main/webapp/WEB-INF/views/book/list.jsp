<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books currently in the shop</title>
</head>
<body>
	<h1>Books currently in the shop</h1>
	<table>
	<c:forEach var="book" items="${books}">
	<tr>
		<td>${book.title}</td>
		<td>${book.ISBN}</td>
		<td>${book.author}</td>
		<td>${book.price}</td>
		<security:authorize access="hasRole('ADMIN')">
			<td><a href='<c:url value = "/books/${book.id}"/>'>edit</a></td>
		</security:authorize>
	</tr>
	</c:forEach>
	</table>

	<security:authorize access="hasRole('ADMIN')">
	<a href="<c:url value = "/books/add"/>"> Add Book</a>
	</security:authorize>

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit">Logout</button>
	</form>
	<%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
		<%--<a href="javascript:document.getElementById('logout').submit()">Logout</a>--%>
	<%--</c:if>--%>
</body>
</html>