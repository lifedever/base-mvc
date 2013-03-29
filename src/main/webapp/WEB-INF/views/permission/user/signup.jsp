<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<style type="text/css">
.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
</head>
<body>
	<jsp:include page="../../common/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="span12">
				<form:form class="form-signin" action="" commandName="user" method="POST">
					<h2 class="form-signin-heading">请先注册</h2>
					<form:input type="text" class="input-block-level" path="username" placeholder="Email address"></form:input>
					<form:input type="password" class="input-block-level" path="password" placeholder="Password"></form:input>
					<form:button class="btn btn-large btn-primary" type="submit">注册</form:button>
					<form:button class="btn btn-large" type="reset">重置</form:button>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /container -->
	<jsp:include page="../../common/js.jsp"></jsp:include>
</body>
</html>