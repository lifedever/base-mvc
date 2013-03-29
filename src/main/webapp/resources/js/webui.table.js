
/* table utils   */

(function($){
	
	//显式的的prototype解决方法
	WebuiTableControl = function(){
  		
	};
	
	WebuiTableControl.prototype={
		
		init:function(options,parent){
			this.options = $.extend($.fn.webuiTable.options,options);
			$this = this;
			parent.on('mouseenter mouseleave','tr',function(e){
				$this.toggleActionRow.call(this,e,$this.options);
			});
			
			if ($this.options.inlineEdit){
				
				parent.on('click',$this.options.quickEditClass,function(e){
					$this.showInlineEdit.call(this,e,$(this).closest('tr'));
				});
				
				var editRow = 'tr.' + $this.options.inlineEditClass;
				var cancel = editRow + ' .cancel';
				parent.on('click',cancel,function(e){
					$this.closeInlineEdit.call(this,e,$(this).closest(editRow));
				});
			}
			
			
		},
		toggleActionRow:function(e,options){
			var $rowActionClass = $(this).find(options.rowActionClass),
			display = e.type === 'mouseenter' ? 'visible' : 'hidden';
			$rowActionClass.css('visibility',display);
		},
		
		showInlineEdit:function(e,dataRow){
			dataRow.hide().next().show();
		},
		
		closeInlineEdit:function(e,inlineRow){
			inlineRow.hide().prev().show();
		}
		
	};
	
	$.fn.webuiTable = function (options){
		
		return this.each(function(){
			table = new WebuiTableControl();
			table.init(options, $(this));
		});
	};
	
	$.fn.webuiTable.options = {
			rowActionClass:'.row-action,.order-action',
			inlineEditClass:'.inline-edit',
			removeClass:'.remove',
			quickEditClass:'.quick-edit',
			confirmRemove:true,
			inlineEdit:false
	};
	
})
(jQuery);