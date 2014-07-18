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
   			 <img alt="" width="100%;" src="images/121.png">
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
			<div class="title-brown">变成‘甲’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此类型的人具有敏锐的观察力及特殊的才能，一生可能只为了追求一件事而努力；喜欢助强扶弱，打抱不平；渴望在社会上与人群中有作为，并担当他们的领导者，个性冲动，权威自信，有正义感，自强不息，爱出风头，喜欢替他人作主和发号施令。关注权利、独断，并且控制空间和领域否认弱点和缺陷充满活力，向往刺激和精彩愤怒爆发直接、面对面相信“强权就是公理”，别人会觉得专横霸道喜欢控制大局和授权给别人的乐趣，但却不喜欢被控制会保护、支持自己的朋友、家人和下属很难听从别人的意见喜欢被人尊重而不是被人喜爱是一个坚强、自信、果断和会马上采取行动去解决问题的人。比较适合开创性、冒险性的工作，因为其前进行动力是比较明显的。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：外向、主动、乐观、冲动、专制、有正义感。在感情上相对可能会比较平淡。他们在年轻时的境遇可能较辛苦，所以他们的心境大半保持冷静；谈恋爱时也一样，即使是在热恋期也会理性大于感性。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘由’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此类型的人在团体中，通常是大家能够信赖依靠器重的人材，具有强烈的责任感，重视自己的道德、价值观，但是喜欢出风头，有些狂妄自大。渴望事业有成就，以目标为主导，重视自我形象，希望被人肯定，受人注意和羡慕。他们能在每一刻中都适当地表现出该有的反应，善于掌握每一个机会，务求达到成功。渴望被肯定、赞赏、被他人羡慕。这类人比较适合稳定性、规律性的工作，因为比较偏好稳扎稳打。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：外向、主动、擅于交际,注意力集中在结果，而非过程，经常会疏忽自己的感受，坚持自己的目标，达不到目标就恼火，会强迫自己，因此显得比较急躁，有时会为了求效率而牺牲完美走捷径，精力充沛、热爱工作、奋力追求成功、以获得地位和赞赏，为了事业成功、声望、财富，有时牺牲情感、婚姻、家庭或朋友是一个受人欣赏、有能力、出众的人。与他们谈恋爱是最好的，因为他们很会照顾人，且对伴侣忠贞，不会有复杂的异性关系；但有些人会认为他们有思想上的洁癖，而且跟他们在一起经常会因为工作很忙而经常无法正常交往，容易出现感情分离。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘申’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此类型的人性格内向、被动、乐观、随和、顺从。通常给人亲切、善良、人际关系好的感觉，在团体中是非常受欢迎的人物，渴望人人能和平共处，怕引起冲突，怕得罪别人，怕左右为难，不争名逐利，性格温顺，与世无争，爱好大自然，写意随和，但往往给予人一种懒洋洋，没有个性，慢条斯理和满不在乎的感觉。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向:但是因为其性格的原因，容易耽搁事情，别人会觉得其被动和优柔寡断，虽然不喜欢命令别人，但当别人命令自己时，会反感和变得倔强对于不同观点的分歧和争论。而有时为了人际关系的圆融，推卸责任和善于说谎也变成他们的特质。有着良好的事务协调能力，很懂得察颜观色。不过，此类型的女生会把婚姻和爱情摆在第一位，视野也因此受限；男性则是太受欢迎而容易有外遇的情况发生。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘田’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此种类型的人喜欢思考、追求知识、渴望比人知得多，懂得快，喜欢运用自己的智慧和理论去驾驭他人，他们冷静，机智，分析力强，好学不倦，善于理性，有逻辑地去处理问题并将情感抽离，不喜欢自己的空间受到骚扰。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：内向，被动，自我，喜欢思考，关注探究，喜欢寻求孤零感觉，不喜欢自己的空间受到骚扰，不擅长对他人说好听的话，喜欢独自解决问题或独自计划并执行一项计划，喜欢一个人独自思考、观察、并找寻生命的意义，是一个理解力强、重分析、好奇心强、有洞察力的人。感情方面相对比较保守，但是成功率反而更高，而且几乎没有感情方面的纠纷和外遇。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘旧’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此类型的人相当特立独行，他们的人生计划是那种“孤军奋战”型的，他们非常有自信能达成他们的计划，所以们喜欢听人家的称赞。渴望受到保护和关怀，为人忠心耿耿，但多疑过虑，怕出风头，怕生事端，怕自己力不从心，怕人虚伪，口是心非，怕事与愿违。时时需要防范被人利用和陷害，所以喜欢寻求权威的庇护，但对权威有着不信任感。所以内心深处常隐藏着恐惧和不安，对人和事缺乏安全感。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：内向、主动、保守、忠诚。关注潜在的伤害、危险、威胁。但容易放大危险、灾害，而且生性多疑，不会轻易相信别人，可是内心深处却希望得到别人欣赏和肯定常问自己是否有做错事，因为害怕犯错误而被责备要求公平，期望付出和所得想得到对事情通常想的太认真。但却是是一个忠诚、值得信赖、勤力的人。对于感情方面，喜欢标新立异，与从不同，因此也不太安定。而且在谈恋爱时，他们不是那么在乎对方的情绪，因为他们常满足于自我的情绪中而忽略了对方。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘白’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此种类型的人自我意识很强，在美感方面有独特的见解，不会盲目追求流行，而自尊心也比较高，拥有与众不同的理想，且会为实践理想而努力不懈怠。觉得这世界充满了刺激的事物和体验，人生的目的在于追求快乐，而“好玩”更是其做事的动力。对于爱情他们可以马上选择出他们所要的，而且绝对忠贞，但这也意谓他们的占有欲极强，而且因为他们通常在心中已有一个理想的情人模型，所以想掳获他们的心，最好的方法就是彻底的了解他。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：外向好动，活泼开朗，精力充沛，兴趣广泛，时常想办法去满足自己想要的，爱玩，贪新鲜而怕作承诺，渴望拥有更多，倾向逃避烦恼，痛苦和焦虑。外向、主动、乐观、贪玩、缺乏责任感。多才多艺，兴趣广泛，不喜欢被限制，乐于探索，贪图享乐，对有兴趣的事很入迷，喜欢上餐馆、娱乐、旅行或同朋友谈天说地的美好享受，但不善于处理繁琐和细节的任务，是一个快乐、热心、思想正面的人。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘目’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此种类型的人，你可以说他具有协调性，也可以说他优柔寡断、没原则。他们非常害怕自己受到伤害，所以自我防卫心很强，有时还会因过度防卫而伤了对方。他们希望每件事都做得最完美、使自己和世界变得更完美，但却经常有些急于求成反而没有如愿以偿。做事力求正确完美，有原则，有标准，常有自我批判并要求他人按自己标准去做事情的倾向，理性正直，时常压抑自己人性中不理性的一面，怨而不宣。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：内向、被动、批判。关注错误，纠正错误，有责任、独立、勤奋工作，有理性、成熟、有目标，有原则、有标准、且看中效率，但是喜欢批评别人，吹毛求疵，做事没有耐性、喜欢先工作，后享乐，喜欢压抑冲动和渴望过度刚性，是一个合理、实际、脚踏实地的人。但是在爱情路上，他们很容易受到诱惑而转移目标，虽然不是故意的，却因此伤了很多人的心。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘电’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp; 此类型的人个性非常复杂，有多方面的特质，只要一不小心就很容易迷失自我，因为搞不清楚自己到底是怎样的一个人。喜欢把焦点放在关系和感觉上，不开心时，喜欢独自一人来处理，和不熟的人交往时，会表现沉默和冷淡，特别容易被人生哀愁、悲剧所触动，认为被他人误解是一件特别痛苦的事，但是其创造力、热情和丰富的感情却非常地吸引人，所以在其身边从不缺少朋友！ </div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向:当遭到拒绝、挫折时，便会退缩，变得沉没、害羞，当别人面临危机时，会很支持及同情他们，有很丰富及活跃的想象力，喜欢把事物重组一个新的模式。是一个直觉、敏感、有创造力的人。在爱情方面，他们因为拥有多方面的特质，所以很容易吸引到异性。</div>
		</div>
		</div>
	</div>
	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">变成‘旦’字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;此类型的人常常非常喜欢帮助他人，渴望被爱，受人感激和认同，善解人意，有同理心，热情地去满足他人需要而又希望不被察觉。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：外向、主动、感情丰富，关注去满足重要的其他人，乐于付出，希望努力满足他人需要，成为他人不可缺少的人，喜欢压抑或疏忽自己的感受，不喜欢向人直接表达自己的真实感受，缺乏自主和想法，喜欢与朋友相处，并乐于倾听他们的事情，对人热情、友善、有爱心和有耐心，重视人际关系，是一个关怀、乐于助人、慷慨的人。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;其感情生活非常地细腻，所以能与这类人谈恋爱，会让你活得更愉快。但是因为不善于拒绝别人，所以有时候也会把自己搞得很累，给自己增加了许多不必要的麻烦。</div>
		</div>
		</div>
	</div>

<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">无法组成字</div>
			<div class="Detail">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;无法组成字此类型的人常觉得自己和别人不同，是不平凡和独特的人。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;觉得自己是一个感情丰富的、浪漫的、有品位、有个性和喜欢我行我素的人。渴望自我了解和他们的内心感受被人认同，喜欢我行我素，不媚俗，感情丰富，思想浪漫有创意，拥有敏锐的触觉和审美眼光。</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;性格倾向：内向，被动，多愁善感、感情丰富，喜欢把焦点放在关系和感觉上，不开心时，喜欢独自一人来处理，和不熟的人交往时，会表现沉默和冷淡，特别被人生哀愁、悲剧所触动。认为被他人误解是一件特别痛苦的事，当遭到拒绝、挫折时，便会退缩，变得沉没、害羞。当别人面临危机时，会很支持及同情他们，有很丰富及活跃的想象力，喜欢把事物重组一个新的模式是一个直觉、敏感、有创造力的人。感情方面有些过分小心而经常受到挫折，而且也容易失恋，其感情生活要嘛就一生只有一个，要嘛，就可能经常更换其身边的女朋友。</div>
		</div>
		</div>
	</div>

	<div class="boxcontent boxwhite" style="margin-top: 20px;" >
		<div class="box">
			<div class="title-brown">友情提示：</div>
			<div class="Detail">
			<p>小编已经算过了，非常准！</p>
			<p>亲，你觉得算的准吗？</p>
			<p>分享给好友，看看他们是什么样性格的人！</p>
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

