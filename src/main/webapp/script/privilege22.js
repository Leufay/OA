var setting = {
	initData:{
		rolename:"",
		roleId:"",
		prvilids:"",
		submitFlag:true			//防止表单重复提交的标示
	},
	initEvent:{
		showDiv:function(){
			$("div[hidden='hidden']").show(500) ;
			$("#roleName").text(setting.initData.rolename.trim()) ;
			$("#roleId").val(setting.initData.roleId.trim()) ;
		},
		hideTree:function(){
			$("#privilDiv").hide() ;
		},
		initClick:function(){
			$("a").each(function(){
				if($(this).text()=="设置权限"){
					$(this).unbind("click");
					$(this).bind("click",function(){
						setting.initEvent.hideTree() ;
						setting.initData.rolename = $(this).parent().siblings().eq(0).text() ;
						setting.initData.roleId= $(this).parent().siblings().eq(1).text() ;
						setting.initEvent.showDiv() ;
						$.post("/OA/privilege/privilegeAction_findExistPrivilege.action",{roleId:setting.initData.roleId},function(data){
							for(var i=0;i<data.pIds.length;i++){
								$(":checkbox").length ;
								var treeObj = $.fn.zTree.getZTreeObj("tree");
								var node = treeObj.getNodeByParam("id",data.pIds[i],null);
								treeObj.checkNode(node,true,false) ;				//选中节点（回显）
							};
						});
						return false ;				//这里return false 超链接标签才不会跳转
					});
				}
			},
		submitForm:function(){
			$("#submitForm").unbind("click");
			$("#submitForm").bind("click",function(){
				var nodes = setting.zTreePlugin.getCheckedNodes(true);
				if(setting.initData.submitFlag){				//防止重复点击提交按钮
					if(nodes.length==0){
						alert("请至少选择一个");
					}else{
						var checkedValues = "";
						for(var i =0 ;i<nodes.length;i++){
							if(i==nodes.length-1){		//如果是最后一个
								checkedValues+= nodes[i].id+"" ;
							}else{
								checkedValues += nodes[i].id+",";
							}
						}
						$("#loading").show() ;
						setting.initData.submitFlag = false ;
						$.post("/OA/role/roleAction_setPrivilege.action",{roleId:setting.initData.roleId,privilIds:checkedValues},function(data,staus){
							setting.initData.submitFlag = true ;
							$("#loading").hide() ;
							alert("设置完成！");
							setting.initEvent.hideTree() ;		//设置完成后隐藏DIV
						});
					}
				}else{
					setting.initEvent.alert("请勿重复提交！");
				}
			});
		},
		loadTree:function(){			//加载zTree
			$.post("/OA/privilege/privilegeAction_findAll.action",null,function(data){
				$("#loading").hide() ;
				var t = $("#tree");
				t = $.fn.zTree.init(t, setting, data.oList);
				setting.zTreePlugin = t ;
				setting.zTreePlugin.expandAll(true);			//设置展开全部节点
				}) ;
			},
		},
		zTreePlugin:"",
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: ""
			}
		},
		check:{
			enable:true,
		}
	};
$().ready(function(){
	setting.initEvent.loadTree() ;
	setting.initEvent.initClick() ;//给超链接绑定事件
	setting.initEvent.submitForm();
	
});