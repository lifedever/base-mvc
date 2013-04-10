<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<jsp:include page="css.jsp"></jsp:include>
<jsp:include page="js.jsp"></jsp:include>
<link rel="shortcut icon" href="/resources/assets/ico/favicon.png">
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="brand" href="/">LifeRefactor</a>
				<strong>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="active"><a href="/">首页</a></li>
							<li class="dropdown"><a href="#" id="drop2" role="button" class="dropdown-toggle" data-toggle="dropdown"> Java <b class="caret"></b>
							</a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="drop2">
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Java基础</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Java高级</a></li>
									<li role="presentation" class="divider"></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">开源推荐</a></li>
								</ul></li>
							<li class=""><a href="#">关于</a></li>
						</ul>
						<form class="navbar-search pull-right" action="">
							<div class="input-append">
								<input type="text" class="span2" placeholder="输入关键字进行搜索"> <a class="btn btn-primary" href="#"><i class="icon-search icon-white"></i></a>
							</div>
						</form>
						<ul class="nav pull-right">
							<c:if test="${!empty(sessionScope.user) }">
								<li><a href="">欢迎你：${sessionScope.user.username }</a></li>
							</c:if>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 管理 <b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<c:choose>
										<c:when test="${empty(sessionScope.user) }">
											<li><a href="/signin">登录</a></li>
											<li><a href="/signup">注册</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/blog/${sessionScope.user.username }/newpost">发表文章</a></li>
											<li role="presentation" class="divider"></li>
											<li><a href="/signout">登出</a></li>
										</c:otherwise>
									</c:choose>
										
								</ul>
							</li>
						</ul>
					</div>
				</strong>
			</div>
		</div>
	</div>
	<div style="margin-bottom: 60px;"></div>