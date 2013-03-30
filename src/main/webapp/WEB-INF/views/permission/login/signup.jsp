<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<style type="text/css">
body {
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

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
				<form:form cssClass="form-signin" action="" commandName="user" method="POST">
					<fieldset>
						<legend>
							<strong>用户注册</strong>
						</legend>
						<label>用户名</label>
						<form:input type="text" class="input-block-level" path="username" />
						<label>密码</label>
						<form:input type="password" class="input-block-level" path="password" />
						<label>确认密码</label> <input type="password" class="input-block-level" />
						<button type="submit" class="btn btn-primary ">注册</button>
						<button type="button" class="btn" onclick="window.location.href='/signin'">登录</button>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /container -->
	<jsp:include page="../../common/js.jsp"></jsp:include>
</body>
</html>