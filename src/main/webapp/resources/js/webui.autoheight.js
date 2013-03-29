
//autoHeight 帮助插件
(function($){
	
	var settings={
		fixed:false  //强制为clientHeight的高度
	};
	
	$.fn.autoHeight = function(options){
		
		$.extend(settings,options);
		
		function setAutoHeight(options){
			var $this = $(this),
				top= $this.data('offset-top')||options.offsetTop||$(this).offset().top+5,
				clientHeight = (options.fixed)?document.documentElement.clientHeight
											:Math.max(document.documentElement.clientHeight,$(document).height()),
				padding = $this.outerHeight()- $this.height();
			if (options.fixed||$this.height()<clientHeight){
				$this.css({'height':clientHeight-top-padding});
			}
		}
		
		return this.each(function(){
			var proxyHandler = $.proxy(setAutoHeight,this,true);
			$(document).off('resize',proxyHandler);
			setAutoHeight.call(this,settings);
			$(document).on('resize', proxyHandler);
		});
	};
	
})(jQuery);
