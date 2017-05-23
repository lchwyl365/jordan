<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>互联网综合管理业务平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${contextPath}/resources/css/login.css" />
    <link rel="stylesheet" href="${contextPath}/resources/js/icheck-1.0.2/skins/all.css?v=1.0.2" />
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/aes_1.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/sec.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/icheck-1.0.2/icheck.js?v=1.0.2"></script>
</head>
<body>
	<noscript>
		<div style="position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="${contextPath}/resources/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div id="container">
		<div id="bd">
			<form id="contentLoginForm" method="post">
			<div class="login">
            	<div class="login-top"><h1 class="logo"></h1></div>
                <div class="login-input">
                	<p class="user ue-clear">
                    	<label>用户名</label>
                        <input type="text" name="username" id="username" value="sysadmin"/>
                    </p>
                    <p class="password ue-clear">
                    	<label>密&nbsp;&nbsp;&nbsp;码</label>
                        <input type="password" name="password" id="password" value="abcd1234" />
                    </p>
                </div>
                <div class="login-btn ue-clear">
                	<a href="javascript:void(0);" class="btn" id="login-btn">登录</a>
                	<span style="display:inline-block;padding-left:15px;">
	                    <input type="checkbox" id="check1">
	                    <label for="check1">记住密码</label>
                    </span>
                </div>
            </div>
            </form>
		</div>
	</div>
    <div id="ft">CopyRight&nbsp;2017&nbsp;&nbsp;版权所有&nbsp;&nbsp;山东普元数智信息技术有限公司</div>
</body>

<script type="text/javascript">
$(function() {
	
	if(self != top){
		window.parent.sessionTimeout();
	}
	
	var height = $(window).height();
	$("#container").height(height);
	$("#bd").css("padding-top",height/2 - $("#bd").height()/2);
	
	$(window).resize(function(){
		var height = $(window).height();
		$("#bd").css("padding-top",$(window).height()/2 - $("#bd").height()/2);
		$("#container").height(height);
		
	});
	
	$('input').iCheck({
	    checkboxClass: 'icheckbox_flat-blue',
	    radioClass: 'iradio_flat-blue'
	});
	
	$("#login-btn").click(function(){
		var username = $.trim($("#username").val());
		if (username.length<=0){
			alert("请输入用户名!");
		}
		var password = $.trim($("#password").val());
		
		if (password.length<=0){
			alert("请输入密码!");
		}
		var pwd = Encrypt(password);//进行加密
		$.post("${contextPath}/login",{username:username,password:pwd}, function(data){
			if(data.status == 200){
				window.self.location = "${contextPath}/index";
			} else {
				alert('登录错误:'+data.msg);
			}
		});
        
	});

});
</script>
</html>