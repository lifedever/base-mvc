<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>消息发送页面</h1>
	<form action="/message/send/send" method="post">
		<input type="text" placeholder="请输入消息内容" name="message"/>
		<button type="submit">发送</button>
	</form>
</body>
</html>