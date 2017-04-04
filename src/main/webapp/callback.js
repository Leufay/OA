//创建XMLHTTPRequest对象
function ajaxFunction(){
	var xmlHttpRequest ;
	try{		//FireFox
		xmlHttpRequest = new XMLHttpRequest() ;
	}
	catch(e){
		try{
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e){
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttpRequest ;
}

function ajax(ajaxJson){
	var xmlHttp = ajaxFunction() ;
	/**
	 * 回调函数
	 */
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.status==200 || xmlHttp.status==304){
			
		}
	} ;
	xmlHttp.open(ajaxJson.method, ajaxJson.url, true) ;
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") ;
	xmlHttp.send(ajaxJson.data) ;
}

$().ready(function(){
	ajax({
		method:'post',url:'HelloServlet',data:{"username":"lxf"}
	}) ;
});