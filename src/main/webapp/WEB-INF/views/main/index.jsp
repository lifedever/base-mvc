<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是首页</title>
<jsp:include page="../common/css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h1>这就是首页</h1>
	${success }
	<jsp:include page="../common/js.jsp"></jsp:include>
</body>
</html>