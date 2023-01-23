<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Product pr=(Product)session.getAttribute("input-product");%>
<p><%=pr.getName()%></p>
<p><%=pr.getCategory() %></p>
</body>
</html>