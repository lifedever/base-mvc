(function($){

	var WebuiPopover = {

		init:function(options,element){
			this.$element = $(element);
			
			this.options = $.extend(self.options,$.fn.webuiPopover.defaults,options);

			this.getTarget();
			
			//是否已显示过
			this.showed = false;


			if (this.options.trigger=='click'){
				this.$element.on('click',$.proxy(this.toggle,this));
			}else{
				this.$element.on('mouseenter',$.proxy(this.enter,this));
				this.$target.on('mouseenter',$.proxy(this.enter,this));


				this.$element.on('mouseleave',$.proxy(this.leave,this));
				this.$target.on('mouseleave',$.proxy(this.leave,this));
			}

			this.$target.on('click','.close', $.proxy(this.hide,this));

		},
		destroy:function(){
			this.hide();
			this.$element.off('click mouseenter mouseleave');
			if (this.$target){
				this.$target.remove();
			}
		},
		enter:function(e){
			var self = this;
			if (self.timeout) clearTimeout(self.timeout);
			self.show();
		},

		leave:function(){
			var self = this;
			//这里是关键，一定要设置一个setTimeout 结合 鼠标离开时 clearTimeout使用
			self.timeout = setTimeout(function(){
				self.hide();
			},self.options.delay);
			
		},

		//最核心的函数之一，显示弹出框
		show:function(){
			
			
			
			var pos,
				$target,
			    actualWidth,
				actualHeight,
				placement,
				tp,
				buffer,
				arrowOffset;

			$target = this.getTarget();
			
			if (!this.options.multi){
				this.hideAll();
			}
					
			pos = this.getPosition();
			buffer = 16;
			
			//如果没有设置缓存，则重新设置内容
			if (!this.options.cache||!this.showed){
				//如果调用插件时传入了title或content等信息，则设置这些内容
				if (this.hasContent()) 
					this.setContent();
				if (this.hasTitle())
					this.setTitle();
				this.$target.show();
			}
			
			
			$target.removeClass('fade in top bottom top-left top-right bottom-left bottom-right left right');
			

			if (this.options.width!=='auto')  $target.width(this.options.width);
			if (this.options.height!=='auto') $target.find('.webui-popover-content').height(this.options.height);
			
			
		  	//将弹出框初始化并添加到html文档中，默认添加到body标签
		  	
			$target.remove()
         	 	.css({ top: 0, left: 0, display: 'block' })
         		.appendTo(document.body);
         	this.attachTargetEvent();	


			actualWidth = $target[0].offsetWidth;
        	actualHeight = $target[0].offsetHeight;
        	
        	//根据触法元素在上下文的位置，得到弹出框的方位
        	placement = this.getPlacement(pos,actualWidth,actualHeight);
        	
        	var elementW = this.$element.outerWidth();
        	

        	switch (placement) {
	          case 'bottom':
	            tp = {top: pos.top + pos.height, left: pos.left + pos.width / 2 - actualWidth / 2}
	            break
	          case 'top':
	            tp = {top: pos.top - actualHeight-buffer, left: pos.left + pos.width / 2 - actualWidth / 2}
	            break
	          case 'left':
	            tp = {top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left - actualWidth -buffer}
	            break
	          case 'right':
	            tp = {top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left + pos.width}
	            break
	          case 'top-right':
	            tp = {top: pos.top - actualHeight -buffer, left: pos.left -buffer}
	            arrowOffset = {left: elementW /2 + buffer}
	            break
	          case 'top-left':
	            tp = {top: pos.top - actualHeight -buffer, left: pos.left -actualWidth +pos.width +buffer}
	            arrowOffset = {left: actualWidth - elementW /2 -buffer}
	            break
	          case 'bottom-right':
	            tp = {top: pos.top + pos.height, left: pos.left -buffer}
	            arrowOffset = {left: elementW /2 + buffer}
	            break 
			  case 'bottom-left':
	            tp = {top: pos.top + pos.height, left: pos.left -actualWidth +pos.width +buffer}
	            arrowOffset = {left: actualWidth- elementW /2 - buffer}
	            break 
	        };
	        
	      
			this.$target.css(tp).addClass(placement).addClass('in');
			if (arrowOffset){
				this.$target.find('.arrow').css(arrowOffset);
			}
			
			this.showed = true;
			this.trggerShowEvent();
			
		},
		trggerShowEvent:function(){
			if (this.options.onShow&&typeof(this.options.onShow)=='function'){
				var popContainer = this.$target[0];
				this.options.onShow(popContainer);
			}
		},
		
		hide:function(e){
			if (e) e.preventDefault();
			this.$target.removeClass('in').hide();
		},
		toggle:function(e){
			if (e) e.preventDefault();
			this[this.getTarget().hasClass('in') ? 'hide' : 'show']();
		},
		hideAll:function(){
			$('div.webui-popover').removeClass('in').hide();
		},

		getPosition:function(){
			return $.extend({},this.$element.offset(), {
		        width: this.$element[0].offsetWidth,
		        height: this.$element[0].offsetHeight
		    });
		},

		//获取弹出框
		getTarget:function(){
			this.$target = this.$target||$(this.options.template);
			return this.$target;
		},

		//计算弹出框出现的位置
		getPlacement:function(pos,actualWidth,actualHeight){
			var placement,
				de,
				db,
				clientWidth,
				clientHeight,
				pageX,
				pageY,
				scrollTop,
				scrollLeft,
				buffer;

			de = document.documentElement;
			db = document.body;
			clientWidth = de.clientWidth;
			clientHeight = de.clientHeight;

			scrollTop = Math.max(db.scrollTop,de.scrollTop);
			scrollLeft = Math.max(db.scrollLeft,de.scrollLeft);

			pageX = Math.max(0,pos.left - scrollLeft);
			pageY = Math.max(0,pos.top - scrollTop);
			buffer = 20;

			//如果位置设置为auto，则根据实际情况计算出弹出框的位置
			if (this.options.placement==='auto'){
				if (pageX<clientWidth/3){
					placement= pageY>actualHeight+buffer?'top-right':'bottom-right';
				}else if (pageX<clientWidth*2/3){
					placement = pageY>actualHeight+buffer?'top':'bottom';
				}else{
					placement = pageY>actualHeight+buffer?'top-left':'bottom-left';
				}
			}else{
				placement = this.options.placement;
			}
			return placement;
		},
		
		hasContent:function(){
			return this.getContent();
		},
		
		getContent:function(){
				if (!this.content){
					var content,
						$e = this.$element;
					if ($.isFunction(this.options.content)){
						content = this.options.content.apply(this.$element,arguments);
					}else{
						content = this.options.content;
					}
					this.content = $e.attr('data-content')||content;
				}
				return this.content;
		},

		getTitle:function(){
			var title,
				$e = this.$element;
			return $e.attr('data-title')||this.options.title;			
		},
		hasTitle:function(){
			return this.getTitle();
		},

		setContent:function(){
			var $target = this.getTarget(),
				content = this.getContent(false);
			$target.find('.webui-popover-content').html(content);
			this.$target = $target;
			if (this.options.onSetContent&&typeof(this.options.onSetContent=='function')){
				this.options.onSetContent($target[0]);
			}
		},

		setTitle:function(){
			var $target = this.getTarget(),
			title = this.getTitle();
			$target.find('.webui-popover-title').html(title);
			this.$target = $target;
		},

		//弹出层做隐藏操作(移出html)再添加到系统中会导致事件丢失，需要重新绑定事件
		attachTargetEvent:function(){
			if (this.options.trigger!='click'){
				this.$target.on('mouseenter',$.proxy(this.enter,this));
				this.$target.on('mouseleave',$.proxy(this.leave,this));
			};
			this.$target.on('click','.close', $.proxy(this.hide,this));
		}

	};

	

	$.fn.webuiPopover = function(options){
		return this.each(function(){
			var webuiPopover = Object.create(WebuiPopover);
			if (typeof options =='string'){
				webuiPopover.init(null,this);
				webuiPopover[options]();
			}else if (typeof options =='object'){
				webuiPopover.init(options,this);
			}	
		});
	};

	$.fn.webuiPopover.defaults={
			placement:'auto',
			width:'auto',
			height:'auto',
			trigger:'hover',
			delay:300,
			cache:true,
			multi:false,
			template: '<div class="webui-popover"><div class="arrow"></div><div class="webui-popover-inner"><a href="#" class="close">x</a><h3 class="webui-popover-title"></h3><div class="webui-popover-content"><p></p></div></div></div>'
			//title
			//content
			//target	
	};

})(jQuery);