<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/base.jsp" %>

<html>
<head>
<title>导航菜单</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/zTreeStyle3/zTreeStyle.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.ztree.excheck.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/blue/menu.css">
  <script type="text/javascript" >

			var setting = {
					view: {
						dblClickExpand: false,
						showLine: true,
						selectedMulti: false
					},
					data: {
						simpleData: {
							enable:true,
							idKey: "menuId",
							pIdKey: "parentId",
							rootPId: ""
						}
					}
			};
 
			$().ready(function(){
				$.post("/OA/menu/menuItemAction_findAll.action",null,function(data){
					var t = $("#tree");
					t = $.fn.zTree.init(t, setting, data.oList);
				}) ;
			});
  </script>
</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="tree" class="ztree" >
        
    </ul>
</div>
</body>
</html>
