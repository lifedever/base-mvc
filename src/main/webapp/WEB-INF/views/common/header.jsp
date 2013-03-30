<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="brand" href="/">LifeRefactor</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="/">首页</a></li>
					<li class=""><a href="#">关于</a></li>
					<li class="dropdown">
						<a href="#" id="drop2" role="button" class="dropdown-toggle" data-toggle="dropdown"> 
							Java <b class="caret"></b>
						</a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="drop2">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
							<li role="presentation" class="divider"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav pull-right">
					<li><a href="#">信息</a></li>
					<li class="divider-vertical"></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							管理 <b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a href="/signin">登录</a></li>
							<li><a href="/signup">注册</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-search pull-right" action="">
					<input type="text" class="search-query span2" placeholder="输入关键字并回车">
				</form>
			</div>
		</div>
	</div>
</div>