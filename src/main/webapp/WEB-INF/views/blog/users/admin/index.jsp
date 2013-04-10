<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/header"></jsp:include>

<div class="container">
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="#">首页</a> <span class="divider">/</span></li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="hero-unit">
				<h1>${sessionScope.user.username }的首页</h1>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/footer"></jsp:include>