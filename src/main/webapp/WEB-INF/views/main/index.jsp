<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/header"></jsp:include>
<div class="container">
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="#">首页</a> <span class="divider">/</span></li>
				<li><a href="#">Library</a> <span class="divider">/</span></li>
				<li class="active">Data</li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="hero-unit">
				<h1>这是首页</h1>
				<p>点击按钮弹出对话框</p>
				<p>
					<a href="#myModal" role="button" class="btn btn-primary btn-large" data-toggle="modal">查看更多</a> <a id="alert" role="button" class="btn btn-large btn-danger">关闭错误</a>
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
		<div class="span6">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>地址</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>张三</td>
						<td>李四</td>
						<td>王五</td>
						<td>赵六</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>李四</td>
						<td>王五</td>
						<td>赵六</td>
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li><a href="#">上一页</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
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
	$('#alert').on('click', function() {
		$(".alert").alert('close')
	});
</script>
<jsp:include page="/footer"></jsp:include>