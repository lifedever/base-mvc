
// form操作相关



(function($){
	
	 var methods = {
			    init : function( options ) { 
			    	
			    },
			    //复制字段到目标对象，to: 目标container，一般多为表单对象，
			    //options为指定复制字段选项,如果不传则拷贝除了button以外的所有字段， 如果只传入字符串，则表示为要排除的字段，
			    //如果 options 为对象，options.includes为指定复制的字段 options.excludes为指定要排除的字段
			    copyFields:function(to,options){
				  			var fields=undefined;
				  			if (!options){
				  				fields = findDefaultFields(this);
				  			}else if (typeof options==="string"){
					  			fields = findDefaultFields(this);
				  				excludesFields(options);
				  			}else if (typeof options ==='object'){
				  				if (options.includes){
			  						var includes = options.includes;
			  						if (includes.indexOf('input')!=-1){
			  							fields = this.find(includes);
			  						}else{
			  							inFields = includes.split(',');
			  							var filters = '';
			  							for(var i= 0;i<inFields.length;i++){
			  								 i>0&&(filters+=',');
			  								 filters += ':input[name="'+ inFields[i] + '"]';
			  							};
			  							fields = this.find(filters);
			  						}
				  				};
				  				if (options.excludes){
				  					if (!fields) 
				  						fields = findDefaultFields(this);
					  				excludesFields(options.excludes);
				  				};
				  			};
				  			
				  			function findDefaultFields(src){
				  				var selectos = ':input:not(:button)';
				  				return  src.find(selectos);
				  			};
				  			
				  			function excludesFields(excludes){
				  				if (excludes){
					  				if (excludes.indexOf('input')!=-1){
					  					fields = fields.not(excludes);
					  				}else{
						  				exFields = excludes.split(',');
						  				for(var i = 0;i<exFields.length;i++){
						  					fields = fields.not(':input[name="'+ exFields[i] + '"]');
						  				}
					  				}
					  			};
				  			};
				  			
				  			if (fields){
				  				to.children().filter(':input').remove();
				  				fields.clone().appendTo(to);
				  			}
		  			
			    },
			    otherMeathod:function(){
			    	//添加其它方法
			    }
    };
	
	
	$.fn.webuiForm = function(method){
		
		if ( methods[method] ) {
		      return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
		    } else if ( typeof method === 'object' || ! method ) {
		      return methods.init.apply( this, arguments );
		    } else {
		      $.error( 'Method ' +  method + ' does not exist on jQuery.webuiForm' );
		    }    
	};
})(jQuery);




