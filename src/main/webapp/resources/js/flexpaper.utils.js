
(function($,w){
	var defaults = {
            Scale : 0.6, 
            ZoomTransition : 'easeOut',
            ZoomTime : 0.5,
            ZoomInterval : 0.2,
            FitPageOnLoad : false,
            FitWidthOnLoad : true,
            FullScreenAsMaxWindow : false,
            ProgressiveLoading : false,
            MinZoomSize : 0.2,
            MaxZoomSize : 5,
            SearchMatchAll : false,
            InitViewMode : 'Portrait',
            ViewModeToolsVisible : true,
            ZoomToolsVisible : true,
            NavToolsVisible : true,
            CursorToolsVisible : true,
            SearchToolsVisible : true,
            localeChain: 'zh_CN'
	};
	w.createFlexpaper = function(url){
		var fp = new FlexPaperViewer( 
	             '/resources/js/flexpaper/FlexPaperViewer',
	             'paperContainer', { config : $.extend(defaults,{SwfFile : escape(url)})});
		return fp;
	};
})(jQuery,window);
