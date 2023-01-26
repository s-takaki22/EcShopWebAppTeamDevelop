<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録ページ</title>
</head>
<body>
		<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
		Product pr=(Product)session.getAttribute("input-product");
	%>
		<p style="color:red">商品登録に失敗</p>
	<form action="ProductRegisterConfirmServlet"method="post">
		商品名：<input type="text"name="name"value="<%= pr.getName()%>" autofocus required><br>
		カテゴリ名：<input type="text"name="category"value="<%= pr.getCategory()%>"autofocus required><br>
		値段:<input type="number"name="price"value="<%= pr.getPricce()%>"autofocus required><br>
		内容：<input type="text"name="content"value="<%= pr.getContent()%>"autofocus required><br>
		在庫：<input type="number"name="stock"value="<%= pr.getStock()%>"autofocus required><br>
		<input type="submit"value="送信"><br>
	</form>
	<a href="TopServlet">メニューへ</a>
	<%
		} else {
	%>
	<form action="ProductRegisterConfirmServlet"method="post">
		商品名：<input type="text"name="name"autofocus required><br>
		カテゴリ名：<input type="text"name="category"autofocus required><br>
		値段:<input type="number"name="price"autofocus required><br>
		内容：<input type="text"name="content"autofocus required><br>
		在庫：<input type="number"name="stock"autofocus required><br>
		<input type="submit"value="送信"><br>
	</form>
	<a href="TopServlet">メニューへ</a>
	<%
		}
	%>
</body>
</html>