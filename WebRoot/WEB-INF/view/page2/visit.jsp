<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="description" content="深圳潮生活">
<base href="<%=basePath%>"/>
<title>性格测试</title>
<link href="styles/basic.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js" type="text/javascript"></script>
</head>
<body  data-role="page" class="activity-scratch-card-winning" >
<div class="shareDiv " onclick="$('.shareDiv').hide();"  style="background-color: #666666;">
   			 <img alt="" width="100%;" src="images/200.png">
</div>
<div class="main">
<div class="content">
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="Detail">
			<p><strong>超级准！<font color="red">“日”</font>字加一笔，看出你是什么性格的人！</strong>    </p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">神题测试：</div>
			<div class="Detail">
					<p>“日”字加一笔，你最先想到什么字？可以看出你是什么性格的人，超级准。先想好了，再点击“测一测”！
					</p>
					<p></p>
					<p><a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('.shareDiv').show();">测一测</a></p>
			 <div style="display: none;" id="answer1">
			 	 <p>第1步 请点击右上角，选择“关注官方帐号”或“查看公众号”，然后点击关注
      如之前已关注，请直接执行第2步</p>
			 	 <p>第2步 回到微信主页，发送“日”字加一笔先想到的字，即可测出你的性格</p>
			 </div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">友情提示：</div>
			<div class="Detail">
			<p>亲，你最先想到的是什么字？</p>
			<p>小编最先想到的是<font color="red">田</font>字,测试还真准!</p>
			<p align="center">
			 <input  type="button" class="pxbtn" onclick="$('.shareDiv').show();" value="测一测"/>
			 </p>
		</div>
		</div>
	</div>
</div>
<div style="clear:both;"></div>
</div>
<script type="text/javascript">
	   var share = {};
	   share.init = {
			   shareUrl:"<%=basePath%>/lt/visitIssue2.html",
			   shareTitle:"“日”字加一笔算性格，超级准！",
			   shareDesc:"超级准！“日”字加一笔，你最先想到什么字？",
			   userName:"",
				   shareImg:"<%=basePath%>images/shenti.jpg"
	    	    };
</script>
<script src="js/mm.js" type="text/javascript"></script>
</body>
</html>

