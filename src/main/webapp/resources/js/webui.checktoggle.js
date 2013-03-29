
//checkall帮助插件
(function($){
	var doCheckToggle = function($element,$target){
		if ($element.is(':checked')){
			$target.attr('checked','checked');
		}else{
			$target.removeAttr('checked');
		}
	};
	
	$.fn.checkToggle = function(){
		return this.each(function(){
			var $this = $(this),
				$target = $($this.data('target'));
			$this.on('click.check.data-api',function(e){
				doCheckToggle($this,$target);
			});
			
		});
	};
	
	$(document).on('click.check.data-api', '[data-toggle="check"]', function (e) {
		var $this = $(this),
		$target = $($this.data('target'));
		doCheckToggle($this,$target);
	});
})(jQuery);



