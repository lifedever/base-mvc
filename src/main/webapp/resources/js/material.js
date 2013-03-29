/* 素材列表显示 */
(function($) {
	var settings = {
		width : 750,// 设置modal的宽度
		type : '',// 素材类型，''代表全部；cover：封面大图；icon：图标
		onSelect : null// 回调函数
	};
	var methods = {
		init : function(options) {// 初始化函数
			$.extend(settings, options);
			$('body').append(
					'<div class="modal hide fade" id="material_model"></div>')// 创建素材modal
			$(this).on('click', function(data) {
				var url = '/material';
				if('cover' == settings.type||'icon' == settings.type){
					url = url + '?f_fileType='+settings.type+"&type="+settings.type 
				}
				$.ajax(url, {
					dataType : 'html',
					success : function(data) {
						$('#material_model').css({
							'width' : settings.width,
							'margin-left' : -(settings.width / 2)
						}).html(data).modal('show');
					}
				});
			});
			$('#material_model').on('click', 'a', function(e) {// 阻止a标签页面刷新
				var url = $(this).attr('href');
				var cls = $(this).attr('class');
				if ((!cls || cls.indexOf('unprevent') < 0) && url != '#') {
					if('cover' == settings.type||'icon' == settings.type){
						url = url +'&f_fileType='+settings.type+"&type="+settings.type;
					}
					e.preventDefault();
					$.ajax("/material" + url, {
						dataType : 'html',
						success : function(data) {
							$('#material_model').html(data);
						}
					});
				}
			});

			$('#material_model').on('click', 'button.btn-image', function(e) {// 点击选择后调用的函数
				if (settings.onSelect) {
					settings.onSelect.call(this, $(this).data('url'));
					$('#material_model').modal('hide');
				}
			});
		}
	};
	$.fn.material = function(method) {
		if (methods[method]) {
			methods[method].apply(this, Array.prototype.slice
					.call(arguments, 1));
		} else {
			methods.init.apply(this, arguments);
		}
		return this;
	};
})(jQuery);