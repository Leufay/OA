/**
 * OA的自定义插件
 * @param jQuery
 */
(function(jQuery){
	jQuery.oaConfirm = function(){
		$("a").each(
			function(){		//function为回调函数
			//this代表调用回调函数的对象
			if($(this).text()=='删除'){
				$(this).unbind("click") ;			
				$(this).bind("click",
					function(){
						if(window.confirm("您确认要删除么")){
							return true ;
						}else{
							return false ;
						}
					}
				);
			}
		});
	};
})(jQuery) ;