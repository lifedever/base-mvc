<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tags.jsp"%>
<jsp:include page="/header"></jsp:include>
<div class="container">
	<div class="row">
		<div class="span12">
			<form:form cssClass="form-signin" action="" commandName="user" method="POST">
				<fieldset>
					<c:if test="${error ne null}">
						<div class="alert alert-error">
							${error }
							<button type="button" class="close" data-dismiss="alert">&times;</button>
						</div>
					</c:if>
					<c:if test="${message ne null}">
						<div class="alert alert-success">
							${message }
							<button type="button" class="close" data-dismiss="alert">&times;</button>
						</div>
					</c:if>
					<legend>
						<strong>用户登录</strong>
					</legend>
					<label>用户名</label>
					<form:input type="text" class="input-block-level" path="username" />
					<label>密码</label>
					<form:input type="password" class="input-block-level" path="password" />
					<button type="submit" class="btn btn-large btn-primary ">登录</button>
					<button type="button" class="btn btn-large" onclick="window.location.href='/signup'">注册</button>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
<!-- /container -->
<jsp:include page="/footer"></jsp:include>