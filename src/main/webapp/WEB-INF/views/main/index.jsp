<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/header"></jsp:include>
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="hero-unit">
				<h1>这是首页</h1>
				<p>点击按钮弹出对话框</p>
				<p>
					<a href="#myModal" role="button" class="btn btn-primary btn-large" data-toggle="modal">查看更多</a> <a id="alert" role="button" class="btn btn-large btn-danger">弹出错误</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span6">
			<!-- Button to trigger modal -->
			<div id="myError" class="alert alert-block alert-error fade in">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<h4 class="alert-heading">Oh snap! You got an error!</h4>
				<p>Change this and that and try again. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>
				<p>
					<a class="btn btn-danger" href="#">Take this action</a> <a class="btn" href="#">Or do this</a>
				</p>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel">这是警告框的标题</h3>
	</div>
	<div class="modal-body">
		<p>内容一</p>
		<p>内容二</p>
		<p>内容三</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<button class="btn btn-primary">保存</button>
	</div>
</div>
<script>
	(function() {
		$('#alert').on('click', function() {
			$(".alert").alert()
		});
	})();
</script>
<jsp:include page="/footer"></jsp:include>