<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../common/header.jsp"></jsp:include>
	<div class="container">
		<section class="row">
			<div class="span12">
				<div class="toolbar toolbar-primary">
					<h3 class="head-center">用户注册</h3>
				</div>
			</div>
		</section>
		<div class="row">
			<div class="span12">
				<form:form cssClass="form-horizontal" action="" commandName="user" method="POST">
					<div class="control-group">
						<label class="control-label" for="inputEmail">用户名</label>
						<div class="controls">
							<form:input type="text" path="username" placeholder="Email address"></form:input>
							<span class="help-block"> <form:errors path="username"></form:errors>
							</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">用户名</label>
						<div class="controls">
							<form:input type="password" path="password" placeholder="Password"></form:input>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox"> <input type="checkbox"> Remember me
							</label>
							<button type="submit" class="btn btn-primary">注册</button>
							<button type="submit" class="btn">重置</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /container -->
	<jsp:include page="../../common/js.jsp"></jsp:include>
</body>
</html>