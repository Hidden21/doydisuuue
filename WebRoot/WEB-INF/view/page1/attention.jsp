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
<title>三道“神题”整疯了很多人</title>
<link href="styles/basic.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js" type="text/javascript"></script>
</head>

<body  data-role="page" class="activity-scratch-card-winning" >
<div class="shareDiv " onclick="$('.shareDiv').hide();"  style="background-color: #666666;">
   			 <img alt="" width="100%;" src="images/121.png">
</div>
<div class="main">
<div class="content">
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="Detail">
			<p><strong>“神题”答案大揭秘，千万要<font color="red">HOLD</font>哦！</strong>    </p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">神题一：</div>
			<div class="Detail">
					<p>张柏芝前夫是谢霆锋，</p>
					<p>谢霆锋前女友是王菲，</p>
					<p>王菲老公是李亚鹏，</p>
					<p>李亚鹏前女友叫瞿颖，</p>
					<p>瞿颖现男友是张亚东，</p>
					<p>朴树有个前女友叫周迅，</p>
					<p>周迅有个前男友叫李亚鹏，</p>
					<p>王菲前夫是窦唯，</p>
					<p>窦唯有个堂弟叫窦鹏，</p>
					<p>窦鹏有个前女友叫周迅，</p>
					<p>窦鹏堂姐是窦颖，</p>
					<p>窦颖前夫是张亚东，</p>
					<p>张亚东现女友是瞿颖，</p>
					<p>瞿颖前男友叫李亚鹏。</p>
					<p></p>
					<p style="color: red;">请问张柏芝和李亚鹏什么关系？
					</p>
					<p> <font color="red">神题答案 &nbsp;<span style="padding-top: 10px;">︾</span></font></p>
				 <div  id="answer1">
				 	 <p>1.张柏芝是李亚鹏妻子（王菲）的前男友（谢霆锋）的前妻</p>
				 	 <p>2.张柏芝是李亚鹏前女友之一（周迅）的前男友（窦鹏）的堂哥（窦唯）的前妻（王菲）的前男友（谢霆锋）的前妻</p>
				 	 <p>3.张柏芝是李亚鹏前女友之一（瞿颖）的现任男友（张亚东）的前妻（窦颖）的堂弟（窦鹏）的堂哥（窦唯）的前妻（王菲）的前男友（谢霆锋）的前妻</p>
				 </div>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">神题二：</div>
			<div class="Detail">
			<p> 长江商学院入学考试逻辑题 :</p>
			  <p>80后男孩如果买不起房子，80后女孩可以嫁给40岁的男人。</p>
			  <p>80后男人如果有条件了，到40岁再娶20岁的女孩子也是不错的选择…… </p>
			  <p>【1楼】回复：
			  		<br/>我终于到40岁了，找到一个年轻貌美的20岁女友去她家见家长。
			  		<br/>开门的是当年读大学时相处了几年的初恋女友。新女友喊了一声：妈~ 
			  </p>
			 <p>【2楼】补充：
					<br/>她妈看到我，惊得倒吸一口冷气。
			  		<br/>没等我反应过来，然后把女儿拉进房间里，对女儿说“你不能和他在一起，他是你亲生父亲啊！	  
			  </p>
			 <p>【3楼】继续补充：
					<br/>女儿：我已经有了他的骨肉…… 
			  </p>
			  <p>【4楼】：
					<br/>这时女孩的60多岁的父亲走出来看见了女孩的男友，小声的对他说：“你怎么来了，给你妈和你的生活费不是每月都按时打去的吗？
			  </p>
			 <p>【5楼】：
					<br/>这时"叮咚"，女孩男友的妈来见亲家。见到女孩的父亲："怎么是你..." 
			  </p>
			 <p>【6楼】：
					<br/>女孩男友的父亲停完车也上楼了，一见女孩的父亲马上泪流满面："你不就是我失散多年的弟弟吗?" 
			  </p>
			  <p>【7楼】：
					<br/>女孩母亲见到男友母亲:"妈!" 
			  </p>
			    <p>【8楼】：
					<br/>女孩母亲见到男友他爸，叫了一声“爹！”，立刻晕厥过去。  
			  </p>
			   <p style="color: red;">
					请问男友他妈的妈见到女友他妈的爸叫什么?
				   
			   </p>
			  	<p> <font color="red">神题答案 &nbsp;<span style="padding-top: 10px;">︾</span></font></p>
			 	<div  id="answer2">
			 		 <br/>
			 		  <img alt="" src="images/guanxi.jpg">
			 		  <br/>
			 		  男友他妈的妈就是男友他姥姥，女友他妈的爸就是男友的爸。   男友的姥姥见了男友的爸爸叫什么？  叫女婿
			 	</div>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">无敌神题三：</div>
			<div class="Detail">
			<p>老总打电话给秘书，这几天去丽江玩玩你准备一下。 </p>
			<p>秘书打给老公：这几天我要和老总去丽江开会。</p>
			<p>老公打给情人：这几天老婆不在家，陪我。 </p>
			<p>情人打电话给辅导学生：这几天老师有事，停课。 </p>
			<p>学生打电话给爷爷：这几天不上课，爷爷你陪我玩。</p>
			<p>爷爷给秘书打电话：丽江去不了了，孙子要我陪。</p>
			<p>秘书给老公打电话：老总突然有事不去丽江开会了。 </p>
			<p>老公给情人打电话：老婆不走了下次再说。</p>
			<p>情人给辅导学生打电话：这几天照常上课。</p>
			<p>学生给爷爷打电话：老师说这几天照常上课。</p>
			<p>爷爷给秘书打电话：还是去丽江吧，你准备准备！ </p>
			 <p style="color: red;">
					请问如何解救秘书？
			   </p>
			<p> <font color="red">神题答案 &nbsp;<span style="padding-top: 10px;">︾</span></font></p>
			<div  id="answer3">
				<p>小编被整疯了，先来解救小编吧！！！</p>
			</div>
		</div>
		</div>
	</div>



	

	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">友情提示：</div>
			<div class="Detail">
			<p>分享给好友，也把Ta们给整疯吧！？</p>
			<p align="center">
			 <input  type="button" class="pxbtn" onclick="$('.shareDiv').show();" value="分享给好友"/>
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
			   shareUrl:"<%=basePath%>/lt/visitIssue1.html",
			   shareTitle:"我都被整疯了，快救救我吧！",
			   shareDesc:"这三道“神题”整疯了很多人",
			   userName:"",
			   shareImg:"<%=basePath%>images/shenti.jpg"
	    	    };
</script>
<script src="js/mm.js" type="text/javascript"></script>
</body>
</html>

