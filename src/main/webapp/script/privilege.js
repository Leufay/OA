var setting={
		initData:{
			rolename:"",
			roleId:"",
			prvilids:"",
			submitFlag:true,			//防止表单重复提交的标示
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
		},
		initEvent:{
			showDiv:function(){						//显示隐藏的DIV
				$("div[hidden='hidden']").show(500) ;
				$("#roleName").text(setting.initData.rolename.trim()) ;
				$("#roleId").val(setting.initData.roleId.trim()) ;
			},
			hideTree:function(){					//隐藏DIV
				$("#privilDiv").hide() ;
			},
			initClick:function(){					//给<设置权限超链接标签绑定单击事件>
				$("a").each(function(){
					if($(this).text()=="设置权限"){
						$(this).unbind("click");
						$(this).bind("click",function(){
							$("#loading").show() ;
							setting.initEvent.hideTree() ;
							setting.initData.rolename = $(this).parent().siblings().eq(0).text() ;
							setting.initData.roleId= $(this).parent().siblings().eq(1).text() ;
							
							
							//回显checkbox
							$.post("/OA/privilege/privilegeAction_findExistPrivilege.action",{roleId:setting.initData.roleId},function(data){
								setting.initEvent.cancelChecked();
								for(var i=0;i<data.pIds.length;i++){
									var treeObj = setting.zTreePlugin;
									var node = treeObj.getNodeByParam("id",data.pIds[i],null);
									treeObj.checkNode(node,true,false) ;				//选中节点（回显）
								}
								$("#loading").hide() ;
								setting.initEvent.showDiv() ;
							});
							return false ;							//return false可以让超链接不跳转
						});
					}
				});
			},
			submitForm:function(){									//表单提交按钮事件
				$("#submitForm").unbind("click");
				$("#submitForm").bind("click",function(){
					var nodes = setting.zTreePlugin.getCheckedNodes(true);
					if(setting.initData.submitFlag){				//防止重复点击提交按钮
						if(nodes.length==0){
							alert("请至少选择一个");
						}else{
							var checkedValues = "";
							for(var i =0 ;i<nodes.length;i++){		//拼接id串
								if(i==nodes.length-1){				//如果是最后一个
									checkedValues+= nodes[i].id+"" ;
								}else{
									checkedValues += nodes[i].id+",";
								}
							}
							$("#loading2").show();
							setting.initData.submitFlag = false ;
							$.post("/OA/role/roleAction_setPrivilege.action",{roleId:setting.initData.roleId,privilIds:checkedValues},function(data,staus){
								setting.initData.submitFlag = true ;
								$("#loading2").hide() ;
								alert("设置完成！");
								setting.initEvent.hideTree() ;		//设置完成后隐藏DIV
							});
						}
					}else{
						alert("请勿重复提交！");
					}
				});
			},
			loadTree:function(){									//加载zTree
				$.ajax({
					type:"post",
					async:true,
					url:"/OA/privilege/privilegeAction_findAll.action",
					data:null,
					success:function(data){
						var t = $("#tree");
						t = $.fn.zTree.init(t, setting, data.oList);
						setting.zTreePlugin = t ;
						setting.zTreePlugin.expandAll(true);			//设置展开全部节点
						setting.initData.completeFlag = data.completeFlag ;
						$(".disabledA").removeClass("disabledA");
						setting.initEvent.initClick() ;					//给超链接绑定事件
					}
				});
			},
			cancelChecked:function(){								//将所有选中状态节点设为checked=false
				var nodes = setting.zTreePlugin.getCheckedNodes(true) ;
				for(var i=0;i<nodes.length;i++){
					setting.zTreePlugin.checkNode(nodes[i],false,true) ;
				}	
			}
		}
};
$().ready(function(){
	setting.initEvent.loadTree() ;
	setting.initEvent.submitForm();
});