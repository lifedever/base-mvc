/**
 * webui.notify.js v1.0.0 from bootstrap-notify.js
 * 增强bootstrap-notify.js
 * 
 */

(function ($) {
  var Notification = function (element, options) {
    // Element collection
    this.$element = $(element);
    this.$note    = $('<div class="alert"></div>');
    this.options  = $.extend(true, $.fn.webuiNotify.defaults, options);

    // Setup from options
    if(this.options.transition)
      if(this.options.transition == 'fade')
        this.$note.addClass('in').addClass(this.options.transition);
      else this.$note.addClass(this.options.transition);
    else this.$note.addClass('fade').addClass('in');

    if(this.options.type)
      this.$note.addClass('alert-' + this.options.type);
    else this.$note.addClass('alert-success');

    if(this.options.message)
      if(typeof this.options.message === 'string')
        this.$note.html(this.options.message);
      else if(typeof this.options.message === 'object')
        if(this.options.message.html)
          this.$note.html(this.options.message.html);
        else if(this.options.message.text)
          this.$note.text(this.options.message.text);
    if(this.options.closable)
      var link = $('<a class="close pull-right">&times;</a>');
      $(link).on('click', $.proxy(onClose, this));
      this.$note.prepend(link);

    return this;
  };

  onClose = function() {
    this.options.onClose();
    $(this.$note).remove();
    this.options.onClosed();
  };

  Notification.prototype.show = function () {
    if(this.options.fadeOut.enabled)
      this.$note.delay(this.options.fadeOut.delay || 3000).fadeOut('slow', $.proxy(onClose, this));
    this.$element.append(this.$note);
    
    var placement = this.$element.data('placement');
    placement = placement||this.options.placement;
    var cw = document.documentElement.clientWidth,
    	ch = document.documentElement.clientHeight,
    	posLeft = (cw - this.$element.width()) /2,
    	posTop  = (ch - this.$element.height()) /2;
    switch (placement) {
    	case 'top-center':
        	this.$element.css({'top':this.options.offsetY,'left':posLeft});
        	break;
    	case 'top-left':
    		this.$element.css({'top':this.options.offsetY,'left':this.options.offsetX});
    		break;
    	case 'top-right':
    		this.$element.css({'top':this.options.offsetY,'right':this.options.offsetX});
    		break;
    	case 'bottom-center':
    		this.$element.css({'bottom':this.options.offsetY,'left':posLeft});
    		break;
    	case 'bottom-left':
    		this.$element.css({'bottom':this.options.offsetY,'left':this.options.offsetX});
    		break;
    	case 'bottom-right':
    		this.$element.css({'bottom':this.options.offsetY,'right':this.options.offsetX});
    		break;
    	case 'center':
    		this.$element.css({'top':posTop,'left':posLeft});
    		break;
    }
  
    this.$note.alert();
  };
  
  

  Notification.prototype.hide = function () {
    if(this.options.fadeOut.enabled)
      this.$note.delay(this.options.fadeOut.delay || 3000).fadeOut('slow', $.proxy(onClose, this));
    else onClose.call(this);
  };

  $.fn.webuiNotify = function (options) {
    return new Notification(this, options);
  };

  $.fn.webuiNotify.defaults = {
    type: 'success',
    offsetY:0,
    offsetX:0,
    placement:'top-center',
    closable: true,
    transition: 'fade',
    fadeOut: {
      enabled: true,
      delay: 2000
    },
    message: null,
    onClose: function () {},
    onClosed: function () {}
  };
  
  $(window).on('load', function (e) {
	  var $notify = $('[data-toggle="notify"]'), 
		  message=$notify.data('message'),
		  offset = $notify.data('offset')||0,
		  ntype = $notify.data('type');
	  if (message){
		    var options = {type:ntype,offsetX:offset,offsetY:offset,message:{text:message}};
			return new Notification($notify,options).show();
	  };
  });
})(window.jQuery);
