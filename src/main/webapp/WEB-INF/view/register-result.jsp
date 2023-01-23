<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/style.css">
		<title></title>
	</head>
	<body>
	<h1>登録内容の確認</h1>
		<%Account register = (Account)session.getAttribute("register"); %>
			<div style="margin:5%">
				<ul class="list-group">
					<label class="form-label">名前</label>
						<li class="list-group-item"><%=register.getName() %></li>
					<label class="form-label">メールアドレス</label>
						<li class="list-group-item"><%=register.getMail()%></li>
					<label class="form-label">パスワード</label>
						<li class="list-group-item">********(セキュリティ上の理由により伏せております。)</li>
				</ul>
			</div>
		<a href="RegisterComplete" class="btn btn-primary">送信</a>
	</body>
</html>