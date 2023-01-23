<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録ページ</title>
</head>
<body>
	<form action="ProductRegisterFormServlet"method="post">
		<input type="text"name="name"><br>
		<input type="text"name="category"><br>
		<input type="text"name="price"><br>
		<input type="text"name="content"><br>
		<input type="text"name="stock"><br>
		<input type="submit"value="送信"><br>
	</form>
</body>
</html>