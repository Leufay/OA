<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/base.jsp" %>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/privilege.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
        	<s:iterator value="#oList">
            <tr class="TableDetail1 template">
                <td><s:property value="username"/>&nbsp;</td>
                <td><s:property value="realName"/>&nbsp;</td>
                <td><s:property value="dept.deptName"/>&nbsp;</td>
                <td>
					<s:iterator value="roles">
						<s:property value="roleName"/>,
					</s:iterator>                 
                </td>
                <td><s:property value="descr"/>&nbsp;</td>
                <td><s:a onClick="return delConfirm()" href="userAction_delete.action?userId=%{userId}">删除</s:a>
                    <s:a href="userAction_toUpdate.action?userId=%{userId}">修改</s:a>
					<s:a href="#">初始化密码</s:a>
                </td>
            </tr>
            </s:iterator>
           
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="userAction_toAdd.action"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<a>修改</a>
</body>
</html>
