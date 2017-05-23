<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>互联网综合管理业务平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src='${contextPath}/resources/js/outlook2.js'> </script>
    <script type="text/javascript">
	 /* var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"控件使用",
							"menus":[{"menuid":"m001","menuname":"菜单管理","icon":"icon-nav","url":"${contextPath}/menu/list"},
									{"menuid":"m002","menuname":"添加用户","icon":"icon-plus","url":"http://www.baidu.com"},
									{"menuid":"m003","menuname":"用户管理","icon":"icon-users","url":"${contextPath}/user/list"},
									{"menuid":"m004","menuname":"代码生成","icon":"icon-log","url":"${contextPath}/tables/list"},
									{"menuid":"m005","menuname":"自定义字典","icon":"icon-role","url":"${contextPath}/box/list"},
									{"menuid":"m006","menuname":"权限设置","icon":"icon-set","url":"demo.html"},
									{"menuid":"m007","menuname":"系统日志","icon":"icon-log","url":"demo.html"},
									{"menuid":"m008","menuname":"测试管理","icon":"icon-log","url":"${contextPath}/test/list"},
									{"menuid":"m009","menuname":"员工管理","icon":"icon-log","url":"demo.html"},
									{"menuid":"m010","menuname":"员工管理","icon":"icon-log","url":"demo.html"}
								]
						},{"menuid":"8","icon":"icon-sys","menuname":"员工管理",
							"menus":[{"menuid":"m011","menuname":"员工列表","icon":"icon-nav","url":"demo.html"},
									{"menuid":"m012","menuname":"视频监控","icon":"icon-nav","url":"demo1.html"}
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"部门管理",
							"menus":[{"menuid":"m013","menuname":"添加部门","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"m014","menuname":"部门列表","icon":"icon-nav","url":"demo2.html"}
								]
						},{"menuid":"28","icon":"icon-sys","menuname":"财务管理",
							"menus":[{"menuid":"m015","menuname":"收支分类","icon":"icon-nav","url":"demo.html"},
									{"menuid":"m016","menuname":"报表统计","icon":"icon-nav","url":"demo1.html"},
									{"menuid":"m017","menuname":"添加支出","icon":"icon-nav","url":"demo.html"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"商城管理",
							"menus":[{"menuid":"m018","menuname":"商品分","icon":"icon-nav","url":"/shop/productcatagory.aspx"},
									{"menuid":"m019","menuname":"商品列表","icon":"icon-nav","url":"/shop/product.aspx"},
									{"menuid":"m020","menuname":"商品订单","icon":"icon-nav","url":"/shop/orders.aspx"}
								]
						}
				]}; */
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();
            //
            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

           

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '${contextPath}/loginout';
                    }
                });

            });
            
            $("#northPanel").show();
            $("#homeTab").show();
            $("#southPanel").show();
            
            $(".main-nav li a").click(function(){
            	$(".main-nav li").removeClass("current");
            	$(this).parent().addClass("current");
            	
            	//清空 panel
            	var panels = $('#menu').accordion("panels");
            	for ( var i = panels.length-1 ; i >= 0 ; i-- ){
            		var index = $('#menu').accordion('getPanelIndex',panels[i]);
    				$('#menu').accordion('remove',index);
            	}
            	var id = $(this).parent().attr("data-id");
            	refreshLeftMenu(id);
            	
            });
 
        });
        
        function sessionTimeout(){
        	window.self.location = "${contextPath}/login";
        }
    </script>

</head>
<body>
<noscript>
	<div style="position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
	    <img src="${contextPath}/resources/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
	</div>
</noscript>
	<div id="main-content" class="easyui-layout" fit="true" style="overflow-y: hidden;"  scroll="no">
	    <div region="north" split="false" border="false" style="height:79px;padding:0px;">
			<div id="hd">
				<div class="hd-wrap clearfix">
					<div class="top-light"></div>
            		<h1 class="logo"></h1>
            		<ul class="main-nav clearfix">
            			<c:forEach items="${topMenus}" var="topMenu" varStatus="status">
            				<c:if test="${status.index == 0}">
            					<li class="current" data-id="${topMenu.menuid}"><a href="javascript:;">${topMenu.name}</a></li>
            				</c:if>
            				<c:if test="${status.index != 0}">
            					<li class="" data-id="${topMenu.menuid}"><a href="javascript:;">${topMenu.name}</a></li>
            				</c:if>
            			</c:forEach>
		            </ul>
		            <!-- <div class="notice clearfix">
		                <ul class="clearfix">
		                    <li class="current"><a href="javascript:;">关于客票行程单打印通知</a></li>
		                    <li><a href="javascript:;">关于网银付款升级通知</a></li>
		                    <li><a href="javascript:;">关于客票行程单打印通知</a></li>
		                </ul>
		                <div class="notice-btn">
		                    <a href="javascript:;" class="prev"></a>
		                    <a href="javascript:;" class="next"></a>
		                </div>
		            </div> -->
		            <div class="toolbar">
		                <div class="login-info clearfix">
		                    <div class="welcome clearfix"><span>欢迎您,</span><a href="javascript:;" class="user-name">Admin</a></div>
		                    <div class="login-msg clearfix">
		                        <a href="javascript:;" class="msg-txt">消息</a>
		                        <a href="javascript:;" class="msg-num">10</a>
		                    </div>
		                </div>
		                <div class="tool clearfix">
		                    <a class="tips" href="javascript:;">合作须知</a>
		                    <a class="tips" href="javascript:;">协议</a>
		                    <a href="javascript:;" class="help-btn">帮助</a>
		                    <a id="loginOut" href="javascript:;" class="quit-btn exit">退出</a>
		                </div>
		            </div>
				</div>
			</div>
	    </div>
	    <div region="south" split="true" style="height: 30px;">
	        <div id="southPanel" class="footer">
	        	Copyright © 2017   山东普元数智信息技术有限公司 
	        </div>
	    </div>
	    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
				<div id="menu" class="easyui-accordion" fit="true" border="false">
				</div>
	    </div>
	    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
	        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
				<div title="欢迎使用" data-options="iconCls:'icon-home'" style="padding:20px;overflow:hidden;display:none;" id="homeTab">
					<h1>Welcome to 互联网综合服务平台</h1>
				</div>
			</div>
	    </div>
	    
	    <!--修改密码窗口-->
	    <!-- <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
	        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
	        background: #fafafa;">
	        <div class="easyui-layout" fit="true">
	            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
	                <table cellpadding=3>
	                    <tr>
	                        <td>新密码：</td>
	                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
	                    </tr>
	                    <tr>
	                        <td>确认密码：</td>
	                        <td><input id="txtRePass" type="password" class="txt01" /></td>
	                    </tr>
	                </table>
	            </div>
	            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
	                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
	                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
	            </div>
	        </div>
	    </div> -->
	
		<div id="mm" class="easyui-menu" style="width:150px;">
			<div id="mm-tabclose">关闭</div>
			<div id="mm-tabcloseall">全部关闭</div>
			<div id="mm-tabcloseother">除此之外全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-tabcloseright">当前页右侧全部关闭</div>
			<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-exit">退出</div>
		</div>
	</div>
</body>
</html>