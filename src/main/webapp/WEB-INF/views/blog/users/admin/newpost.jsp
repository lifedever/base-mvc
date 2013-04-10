<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/header"></jsp:include>
<script type="text/javascript" charset="utf-8" src="/resources/third-party/ueditor/editor_config.js"></script>
<script type="text/javascript" charset="utf-8" src="/resources/third-party/ueditor/editor_all.js"></script>

<div class="container">
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="#">首页</a> <span class="divider">/</span></li>
				<li class="active">新建文章</li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="">
				<h1>新建文章页</h1>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span12">
			<script id="editor" type="text/plain">这里可以书写，编辑器的初始内容</script>
		</div>
	</div>
</div>
<script type="text/javascript">
	//实例化编辑器
	(function() {
		var ue = UE.getEditor('editor');
		ue.addListener('ready', function() {
			this.focus()
		});
	})();
</script>

<jsp:include page="/footer"></jsp:include>