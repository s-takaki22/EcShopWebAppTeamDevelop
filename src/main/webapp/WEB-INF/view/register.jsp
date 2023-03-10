<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/style.css">
		<title>EC-SHOP</title>
	</head>
	<body>
		<form action="RegisterAccountServlet" enctype="multipart/form-data" method="post" class="mb-3 m-5">
			<label class="form-label">名前</label>
				<input type="text" name="name" required class="form-control">
			<label class="form-label">メールアドレス</label>
				<input type="email" name="mail" required="required" class="form-control">
			<label class="form-label">パスワード</label>
				<input type="password" name="pass" required="required" class="form-control">
			<br>
			<input type="submit" class="btn btn-primary">
		</form>
	</body>
</html>