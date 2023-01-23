<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>下記の図書が登録されています</h1><br>
	
	<table border="1">
		<tr>
			<th>名前</th>
			<th>年齢</th>
			<th>性別</th>
			<th>電話番号</th>
			<th>メールアドレス</th>
		</tr>
	<%
	List<Product> list = (ArrayList<Product>)request.getAttribute("list");
	for(Product b : list) {
	%>
		<tr>
			<td><%=b.getName() %></td>
			<td><%=b.getAge() %></td>
			<td><%=b.getGender() %></td>
			<td><%=b.getPhonenum() %></td>
			<td><%=b.getMail() %></td>
		</tr>
	<%} %>
</body>
</html>