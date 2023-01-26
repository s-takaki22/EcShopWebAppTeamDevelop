<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>下記の商品が登録されています</h1><br>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>カテゴリー</th>
			<th>値段</th>
			<th>コンテンツ</th>
			<th>在庫</th>
		</tr>
	<%
	List<Product> list = (ArrayList<Product>)request.getAttribute("list");
	for(Product b : list) {
	%>
		<tr>
			<td><%=b.getId() %></td>
			<td><%=b.getName() %></td>
			<td><%=b.getCategory() %></td>
			<td><%=b.getPricce() %></td>
			<td><%=b.getContent() %></td>
			<td><%=b.getStock() %></td>
		</tr>
	<%} %>
</body>
</html>