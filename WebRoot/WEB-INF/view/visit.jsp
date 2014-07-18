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
<title>史上最变态7个问题</title>
<link href="styles/basic.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js" type="text/javascript"></script>
</head>

<body  data-role="page" class="activity-scratch-card-winning" >
<div class="shareDiv " onclick="$('.shareDiv').hide();"  style="background-color: #666666;">
   			 <img alt="" width="100%;" src="images/visitanswer.png">
</div>
<div class="main">
<div class="content">
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="Detail">
			<p align="center"><strong>史上最变态7个问题，答对4个算你厉害！</strong>    </p>
			<p >
			&nbsp;&nbsp;
			
			真的太变态了，悄悄告诉你，小编只猜中了<font color="red">3个</font>，传说
			李嘉诚答对<font color="red">4个</font>
			。你能答对几个，都答对你就是天才～</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">企鹅问题：</div>
			<div class="Detail">
			<p> 一个女孩有一天给一个男孩做了一道菜，男孩吃完了，但是觉得味道怪怪的，于是他问那女孩，这是什么肉啊？女孩说，这是企鹅肉，男孩沉思了一会……痛哭起来，自杀了，为什么？
				<a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('#answer1').toggle();">查看答案</a>
			 <span style="display: none;" id="answer1">
			 	 <br/>&nbsp;&nbsp;&nbsp;&nbsp;
				   男孩以前曾和女友一起去北极考察，因为没东西吃，女孩把自己的肉一片片割给男孩吃，骗他说是企鹅肉，结果男孩活下来了，女孩却饿死了。
				   多年后男孩吃到了真正的企鹅肉，终于明白当时女孩的苦心，伤心之下，自杀徇情。
			 </span>
			</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">跳火车问题：</div>
			<div class="Detail">
			<p> 一个人坐火车去领镇看病，看完以后病好了。回来的时候经过一个隧道，这个人就跳车自杀了，为什么？
				<a href="javascript:void(0);" style="font-size: 18px;"
				 onclick="$('#answer2').toggle();">查看答案</a>
			 	<span style="display: none;" id="answer2">
			 		 <br/>&nbsp;&nbsp;&nbsp;&nbsp;
					  此人原是瞎子，看好后终于得见光明，经过隧道时一片黑暗，他以为自己又瞎了，绝望之下，自杀而亡。
			 	</span>
			</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">葬礼问题：</div>
			<div class="Detail">
			<p> 有母女三人，母亲死了，姐妹俩去参加葬礼，妹妹在葬礼上遇见一个很型的男子，并对他一见倾心。但是葬礼后那个男子就不见了，妹妹怎么找也找不到他。后来过了一个月，妹妹把姐姐杀了，为什么？
			<a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('.shareDiv').show();">查看答案</a>
			</p>
		</div>
		</div>
	</div>

<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">半根火柴问题：</div>
			<div class="Detail">
			<p> 有一个人在沙漠中，头朝下死了，身边散落着几个行李箱子，而这个人的手里紧紧地抓着半根火柴，推理这个人是怎么死的？
				<a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('.shareDiv').show();">查看答案</a>
			</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">满地木屑问题：</div>
			<div class="Detail">
			<p> 马戏团里有两个侏儒，瞎子侏儒比另外一个侏儒矮，马戏团只要一个侏儒，马戏团的侏儒当然是越矮越好了。两个侏儒决定比谁的个子矮，个子高的就去自杀，可是在约定比个子的前一天，瞎子侏儒也就是那个矮的侏儒已经在家里自杀死了。在他家里只发现木头做的家具和满地的木屑。他为什么自杀？
				<a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('.shareDiv').show();">查看答案</a>
			</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">夜半敲门问题：</div>
			<div class="Detail">
			<p> 一个人住在山顶的小屋里，半夜听见有敲门声音，但是他打开门却没有人，于是去睡了，等了一会儿又有敲门声，去开门，还是没人，反复好几次。第二天，有人在山脚下发现一具死尸，警察来把山顶的那个人带走了。为什么？
			<a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('.shareDiv').show();">查看答案</a>
			</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">水草问题：</div>
			<div class="Detail">
			<p> 有个男子和他女友去河边散步，突然他的女友掉进河里了，那个男子就急忙跳进河里去找，可没找到他的女友，他伤心的离开了这里。过了几年后，他故地重游，这时看到有个老人家在钓鱼，可老人家掉上来的鱼身上没有水草，他就问那个老人家为什么鱼身上没有沾上一点水草，那老人家说，“你不知道啊，这河从没长过水草。”说到这时那男子突然跳到水里，自杀了，为什么？
			<a href="javascript:void(0);" style="font-size: 18px;"
			 onclick="$('.shareDiv').show();">查看答案</a>
			</p>
		</div>
		</div>
	</div>
	
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">友情提示：</div>
			<div class="Detail">
			<p> 亲，看完了吗？你能猜中几个答案？</p>
			<p>猜中<font color="red">1~3个</font>，一般人</p>
			<p>猜中<font color="red">4~6上</font>，你是天才</p>
			<p>猜中<font color="red">7个</font>，你是天才，更是聪明的变态</p>
			<p>猜中<font color="red">0个</font>，题目太变态了</p>
			<p>点击右上方的按钮，关注我们的微信号，发送'查看答案',即可知道你是
			<font color="red">天才？</font>，还是
			<font color="red">题目太变态？</font></p>
			<p align="center">
			 <input  type="button" class="pxbtn" onclick="$('.shareDiv').show();" value="查看答案"/>
		</div>
		</div>
	</div>
</div>
<div style="clear:both;"></div>
</div>
<script type="text/javascript">
	   var share = {};
	   share.init = {
				   shareUrl:"<%=basePath%>/lt/visit.html",
				   shareTitle:"这7个问题够变态的！",
				   shareDesc:"李嘉诚答对了4个，你能答对几个？",
				   userName:"",
				   shareImg:"<%=basePath%>images/dengni43.jpg"
	    	    };
</script>
<script src="js/mm.js" type="text/javascript"></script>
</body>
</html>

