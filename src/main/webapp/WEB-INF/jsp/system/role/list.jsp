<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/base.jsp" %>
<html>
<head>
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/zTreeStyle3/zTreeStyle.css"/>
    <style type="text/css">
    	.disabledA{
    		opacity: 0.2;
    	}
    </style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/privilege.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
        	<s:iterator value="#oList" var="role">
        		<tr class="TableDetail1 template">
				<td><s:property value="roleName"/>&nbsp;</td>
				<td hidden="hidden"><s:property value="roleId"/></td>
				<td><s:property value="roleDescr"/>&nbsp;</td>
				<td>
					<s:a onClick="return delConfirm()" href="roleAction_delete.action?roleId=%{roleId}">删除</s:a>
					<s:a href="roleAction_toUpdate.action?roleId=%{roleId}">修改</s:a>
					<s:a href="javascript:return false" cssClass="disabledA" >设置权限</s:a>
				</td>
			</tr>
        	</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="saveUI.html"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>
<img src="${pageContext.request.contextPath}/style/images/loading.gif" id="loading" hidden="hidden"/>
<!--显示表单内容-->
<div id="privilDiv" hidden="hidden" style="width:500px;margin:0 auto;">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 正在为【<span id="roleName"></span>】配置权限 </div>
        	<input type="hidden" id="roleId" name="roleId"/> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<ul id="tree" class="ztree" style="width:230px; overflow:auto;">
								</ul>
								<img src="${pageContext.request.contextPath}/style/images/loading.gif" id="loading2" hidden="hidden"/>
							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png" id="submitForm"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
</div>
</body>
</html>
