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
	<p>商品名：<%=pr.getName()%></p>
	<p>カテゴリ：<%=pr.getCategory() %></p>
	<p>値段：<%=pr.getPricce() %></p>
	<p>内容：<%=pr.getContent()%></p>
	<p>在庫：<%=pr.getStock()%></p>
	<form action="ProductRegisterExecuteServlet">
	<input type="submit"value="登録">
	</form>
</body>
</html>