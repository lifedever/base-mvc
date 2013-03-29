//修正低版本IE浏览器不支持  Object.create方法
if (typeof Object.create!=='function'){
     
	Object.create = function(obj){
        function F(){};
        F.prototype = obj;
        return new F();
    };
};



/* UTILS 工具类 */
(function(){
	
	var root = this;
	
	//字符串工具类
	root.StringUtils = {
				
			/** 
			 * 向URL中添加新的参数键值
			 */
			  addParamToUrl:function(url,param){
				if (url.indexOf('?')==-1){
					return url+'?'+param;
				}else{
					return url+'&'+param;
				}
			  },
			
			  insert:function(str,position,newContent){
				return str.substr(0,position) + newContent + str.substr(position);  
			  },
			
	          /*将开始和结束标示的文字替换成新内容
	            str: String 文本
	            startFlag: String 开始标识（支持正则）
	            endFlag: String 结束标识（支持正则）
	            newContent: String 替换的新内容
	            multiLine: Boolean 是否为多行文本
	          */
	          replaceByFlag:function(str,startFlag,endFlag,newContent,multiLine){
	            var pattern = new RegExp('('+startFlag+')([\\s\\S]*)(' + endFlag+')',"gm"),
	              content = '';
	            if (typeof(newContent)=='string'&&newContent.length>0){
	              
	              buildContent('$1');
	              buildContent(newContent);
	              buildContent('$3');
	              
	              function buildContent(str){
	                content+=str;
	                if (multiLine) content+='\n';
	              }
	            }

	            return str.replace(pattern,content);
	          },
	         
	          //按注释替换内容,一般用于替换特定格式的文本。注释内容需要符合特定格式，例如 /*example*/.../*example-end*/
	          replaceByCommentFlag:function(str,commantFlag,newContent){
	               var comments = this.getCommentsRegexByFlag(commantFlag);
	               return this.replaceByFlag(str, comments[0], comments[1],newContent,true); 
	          },
	          
	        
	          //按开始和结束标示符删除内容
	          removeByFlag:function(str,startFlag,endFlag){
	            return this.replaceByFlag(str, startFlag, endFlag);
	          },

	          //按注释删除内容,一般用于删除特定格式的文本。注释内容需要符合特定格式，例如 /*example*/.../*example-end*/
	          removeByCommentFlag:function(str,commantFlag){
	        	  var comments = this.getCommentsRegexByFlag(commantFlag);
	            return this.removeByFlag(str, comments[0], comments[1]);
	          },
	          //根据注释标识得到注释正则表达式文本,内部函数
	          getCommentsRegexByFlag:function(commantFlag){
	        	  var startFlag = '\\/\\*' + commantFlag + '\\*\\/',
	                endFlag = '\\/\\*' + commantFlag + '-end\\*\\/';
	                return [startFlag,endFlag];
	          },
	          //根据注释标识得到注释文本,内部函数
	          getCommentsByFlag:function(commantFlag){
	        	  var startFlag = '/*' + commantFlag + '*/',
	        	  		endFlag = '/*' + commantFlag + '-end*/';
	                return [startFlag,endFlag];
	          },
	          
	          //字符串限制为固定长度
	          stringToLimitedLength:function(str,length){
	        	  if (str.length>length+3){
	        		  return str.substring(0,length-3) + '...';
	        	  }else{
	        		 return str;
	        	  }
	          },
	          
	          //将文件名设定为规定长度，超出的部分用省略号代替
	          filenameToLimitedLength:function(filename,length){
	        	  var base = filename.substring(0,filename.lastIndexOf('.')-1),
	        	  	  extension = filename.substring(filename.lastIndexOf('.'),filename.length);
	        	  return base.substring(0,length-3) + '... ' +  extension;
	          }
	          
	  };
	
	//文件工具类
	root.FileUtils = {
			fileSizeToString:function(size) {
			    var suffix = ["B", "KB", "MB", "GB"];

			    var place = Math.floor(Math.log(size) / Math.log(1024));
			    var fileSize = Math.round(size / Math.pow(1024, place));

			    return (fileSize + suffix[place]);
			}
	};
	
	//其它工具类
	root.delayedAlert = function(msg,time){
		setTimeout(function(){
			alert(msg);
		},time);
	};
	
	
	
})();
 


//删除确认
(function($){
	
	var doConfirmGo = function($element){
		var message = $element.data('message')||'您确定要删除该数据吗？',
		href=$element.attr('href')||$element.data('href');
		if (confirm(message)){
			location.href = href;
		}
	};
	
	
	$.fn.confirmGo = function(){
		return this.each(function(){
			var $this = $(this);
			$this.on('click.confirm',function(e){
				e.preventDefault();
				doConfirmGo($this);
			});
		});
	};
	
	$(document).on('click.confirm.data-api', '[data-toggle="confirm"]', function (e) {
		e.preventDefault();
		var $this = $(this);
		doConfirmGo($this);
	});
	
})(jQuery);

(function($){
	// jQuery code 
	var i = document.createElement("input"); 
	// Only bind if placeholder isn't natively supported by the browser 
	if (!("placeholder" in i)) { 
		$("input[placeholder]").each(function () { 
			var self = $(this).css({'color':'#aaa'}); 
			self.val(self.attr("placeholder")).bind({ 
				focus: function () { 
					if (self.val() === self.attr("placeholder")) { 
						self.val("").css({'color':'#333'});
					}
				}, 
				blur: function () { 
					var label = self.attr("placeholder"); 
					if (label && self.val() === "") { 
						self.val(label).css({'color':'#aaa'}); 
					} 
				} 
			}); 
		});
	};
})(jQuery);

/**
 * 加载js模版的工具类，适用于handlebars.js,并将模版后的内容返回
 * add by gfs
 */
(function($){
	$.fn.handlebars = function(options){
		var settings = {
			context:{}
		}
		$.extend(settings,options);
		var source = $(this).html(); 
		var template = Handlebars.compile(source);
		var context = settings.context;
		var html = template(context);
		return html;
	}
})(jQuery);




