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
	%>
		<p style="color:red">商品登録に失敗</p>
	<form action="ProductRegisterConfirmServlet"method="post">
		商品名：<input type="text"name="name"><br>
		カテゴリ名：<input type="text"name="category"><br>
		値段；<input type="number"name="price"><br>
		内容：<input type="text"name="content"><br>
		在庫：<input type="number"name="stock"><br>
		<input type="submit"value="送信"><br>
	</form>
	<a href="TopServlet">メニューへ</a>
	<%
		} else {
	%>
	<form action="ProductRegisterConfirmServlet"method="post">
		商品名：<input type="text"name="name"><br>
		カテゴリ名：<input type="text"name="category"><br>
		値段；<input type="number"name="price"><br>
		内容：<input type="text"name="content"><br>
		在庫：<input type="number"name="stock"><br>
		<input type="submit"value="送信"><br>
	</form>
	<a href="TopServlet">メニューへ</a>
	<%
		}
	%>
</body>
</html>