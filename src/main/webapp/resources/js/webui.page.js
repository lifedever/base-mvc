
/* pagination utils   */

(function($){
	
	//创建普通javascript对象，并利用Object.create方法生成function并将该对象加入到funciton的原型链中
	//属于隐式的prototype解决方法
	//webui.utils.js 修正了低版本浏览器的兼容性，具体查看webui.utils.js 
	var WebuiPage = {
			
			init: function(pageNav,options){
				var self = this;
				self.$pageNav = pageNav;
				self.config = $.extend(this.config,$.fn.webuiPage.config);
				
				self.$pageNav.on('change','select.limit',function(e){
					self.setPageSize.call(this,e,self.config);
				});
				
				self.$pageNav.on('keyup','input.page-goto',function(e){
					self.gotoPage.call(this,e,self.config);
				});
				
				self.$pageNav.on('click','li.page-goto a',function(e){
					var input = $(this).next()[0];
					self.gotoPage.call(input,e,self.config);
				});
			},
			
			
			setPageSize : function(e,config){
				var	params = $(this).data(config.paramParams),
					size = $(this).val(),
					url = '?' + config.paramPage + '=0&' + config.paramPageSize + '=' + size;
					params&&(url+= '&' + params);
					location.href= encodeURI(url);
			},
			gotoPage:  function(e,config){
							e.preventDefault();
							if (e.type==='keyup'&&e.keyCode!==13) 
								return;
							var pageInput = $(this),
								//oldPage = pageInput.data(config.paramPage),
								newPage = pageInput.val(),
								pageSize = pageInput.data(config.paramPageSize),
								pageCount = pageInput.data(config.paramPageCount),
								params = pageInput.data(config.paramParams),
								reg = /^[0-9]+.?[0-9]*$/,
								errorPage = false;
							if (!reg.test(newPage)||newPage<1){
								newPage = 1;
								errorPage = true;
							}else if (newPage>pageCount){
								newPage = pageCount;
								errorPage = true;
							}
							errorPage&&alert('提示：请输入1-' + pageCount + '之间的数字，本次将跳转到第' + newPage + '页');
							
							var url = '?' + config.paramPage + '=' + (newPage-1) + '&' + config.paramPageSize +'=' + pageSize;
							params&&(url+="&" + params);
							location.href= encodeURI(url);
			}
	};
	
	
	$.fn.webuiPage = function(options){
		return this.each(function(){
			var webuiPage = Object.create(WebuiPage);
				webuiPage.init(options,this);
		});
	};
	
	$.fn.webuiPage.config={
			paramPage:'page',
			paramPageSize:'limit',
			paramPageCount:'page-count',
			paramParams:'params'	
	};
	
	var defaultPage = Object.create(WebuiPage);
		defaultPage.init($('div.page-navigation'));
	
})
(jQuery);