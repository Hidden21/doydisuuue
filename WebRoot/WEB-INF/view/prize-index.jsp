<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>我的福利</title>

<meta charset="utf-8">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1.0,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="aplus-waiting" content="1">
<link rel="stylesheet" type="text/css" href="styles/basic.css">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<style type="text/css">
.pxbtn{
	border-radius: 5px;
	margin: 0px;
	padding: 0px;
	line-height: 25px;
	font-size: 14px;
	text-shadow: none;
	text-decoration: none;
}
ul.data-ul{
	list-style: none;
	width: 98%;
	margin:0px auto;
	padding: 0px;
}
ul.data-ul li{
	margin-top: 5px;
	width: 100%;
	position: relative;
}
.act-box{
	position: relative;
	padding: 10px 10px 10px 72px;
	min-height: 70px;
	background: rgba(251, 251, 251, 1);
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}
.act-pic{
	width: 55px;
	height: 55px;
	position: absolute;
	top: 10px;
	left: 10px;
}
.act-pic div{
	width: 100%;
	height: 100%;
	background-position: center center;
	background-size: cover;
}
.act-pic img{
	width: 100%;
	vertical-align: center;
}
i.act-info-show-detail{
	float: right;
	margin-right: 8px;
}
i.act-info-show-detail img{
	width: 13px;
}
.act-info-desc{
	color: #909090;
}
.act-info-prize{
	color: #E04242;
	border-bottom: 1px solid #E3E3E3;
}
.act-info-validDate{
	color: #6B7888;
}
.act-detail-box{
	background: rgba(251, 251, 251, 0.9);
	display: none;
	padding-bottom: 5px;
	margin-bottom: 5px;
}
.act-detail-showAct{
	padding: 5px 20px;
}
.act-detail-box dd{
	padding: 0px 10px 0px 20px;
}
.act-detail-box dt.title-brown {
	margin: 5px 0px;
	padding: 0px 25px;
	background: url(images/title-bg-brown.png) no-repeat 20px 0;
	border-radius: 3px 3px 3px 0;
	color: #ffffff;
	height: 22px;
	line-height: 22px;
	/*-moz-text-shadow:0 1px 0 #8d0001;-webkit-text-shadow:0 1px 0 #8d0001;text-shadow:0 1px 0 #8d0001;
	text-shadow:0px 1px 0 #8d0001;*/
}
.schedule-plan{
	display: none;
}
.mleft_5{
	margin-left: 75px;
}
</style>
<script type="text/javascript">
function showDetail(prizeId){
	var actObj = $("#prize-"+prizeId);
	if(actObj.hasClass("box-show")){
		actObj.removeClass("box-show");
		actObj.find(".act-detail-box").slideUp();
		actObj.find(".act-box .act-info i.act-info-show-detail img").get(0).src = "images/showinfo.png";
	}else{
		var oldActObj = $("li.box-show");
		oldActObj.removeClass("box-show");
		oldActObj.find(".act-detail-box").slideUp();
		
		actObj.addClass("box-show");
		actObj.find(".act-detail-box").slideDown();
		actObj.find(" .act-box .act-info i.act-info-show-detail img").get(0).src = "images/hideinfo.png";
	}
}

function showSchedulePlan(prizeId){
	var actObj = $("#prize-"+prizeId);
	var scheduleBtnBarObj = actObj.find(".act-detail-schedule .schedule-btn-bar");
	var schedulePlanObj = actObj.find(".act-detail-schedule .schedule-plan");
	scheduleBtnBarObj.hide();
	schedulePlanObj.show();
	var scheduleId = parseInt(schedulePlanObj.attr("scheduleId"));
	if(scheduleId>0){
		schedulePlanObj.addClass("mleft_5");
	}else{
		schedulePlanObj.removeClass("mleft_5");
	}
}

function saveSchedulePlan(prizeId){
	var actObj = $("#prize-"+prizeId);
	var scheduleBtnBarObj = actObj.find(".act-detail-schedule .schedule-btn-bar");
	var schedulePlanObj = actObj.find(".act-detail-schedule select.schedule-plan");
	var actId = schedulePlanObj.attr("actId");
	var oldScheduleId = parseInt(schedulePlanObj.attr("scheduleId"));
	var scheduleId = parseInt(schedulePlanObj.find("option:selected").val());
	if(scheduleId==oldScheduleId){
		scheduleBtnBarObj.hide();
		schedulePlanObj.show();
		return;
	}
	var scheduleAt = schedulePlanObj.find("option:selected").text();
	var oldScheduleAt = actObj.find(".act-detail-schedule .schedule-at").text();
	$.post('prize/schedule.htm?${cu.ticket}&r='+Math.random(), {prizeId:prizeId, actId:actId, scheduleId:scheduleId}, function(data){
		if(data.state){
			actObj.find('.act-detail-schedule .schedule-at').text(scheduleId==0?"":scheduleAt);
			schedulePlanObj.attr("scheduleId", scheduleId);
			schedulePlanObj.hide();
			scheduleBtnBarObj.show();
			if(scheduleId<=0){
				scheduleBtnBarObj.find(">span:eq(0)").addClass("hidden");
				scheduleBtnBarObj.find(">span:eq(1)").removeClass("hidden");
			}else{
				scheduleBtnBarObj.find(">span:eq(0)").removeClass("hidden");
				scheduleBtnBarObj.find(">span:eq(1)").addClass("hidden");
			}
		}
	},'json');
}
</script>
</head>

<body>
	<ul class="data-ul prize-list">
		<c:if test="${empty rows}">
			<li>
				<div class="act-box">
					<div class="act-pic">
						<div style="background-image: url('images/no-prize.jpg');"></div>
					</div>
					<dl class="act-info">
						<dt class="act-info-name word-wrap">暂时没有获得任何福利</dt>
						<dd class="act-info-prize"><span class="hint">请在<span class="error">福利来了</span>菜单下参与我们的活动</span></dd>
					</dl>
				</div>
			</li>
		</c:if>
		<c:forEach var="row" items="${rows }">
			<li id="prize-${row.prizeId }">
				<div class="act-box" onclick="showDetail(${row.prizeId })">
					<div class="act-pic" style="background-image: url('${row.actPic }');">
						<c:if test="${not empty row.actPic }">
							<div style="background-image: url('${row.actPic }');"></div>
						</c:if>
					</div>
					<dl class="act-info">
						<dt class="act-info-name word-wrap">${row.actName }</dt>
						<dd class="act-info-prize">${row.ptypeDesc }${row.ptypeUnit }
							<i class="act-info-show-detail"><img src="images/showinfo.png"></i>
						</dd>
						<c:if test="${not empty row.validDateFrom or not empty row.validDateTo }">
							<dd class="act-info-validDate">有效期：${row.validDateFrom }
								<c:if test="${not empty row.validDateTo }">至</c:if>
								${row.validDateTo }
							</dd>
						</c:if>
					</dl>
				</div>
				<div class="act-detail-box">
					<dl>
						<dt class="act-detail-showAct"></dt>
						<dd>
							<c:if test="${row.actState>=3 }"><span class="error">活动已结束</span></c:if>
						</dd>
						<c:if test="${not empty row.realName }">
							<dd class="act-detail-realName"><div>领奖人姓名： ${row.realName }</div></dd>
						</c:if>
						<dd class="act-detail-phone"><div>领奖手机： ${row.phone }</div></dd>
						<dd class="act-detail-prizeCode"><div>领奖密码： ${row.prizeCode }</div></dd>
						<c:if test="${row.scheduleState==1 }">
							<dd class="act-detail-schedule">
								<div>${row.scheduleTypeName }：
									<span class="schedule-at">
										<c:if test="${row.scheduleId>0 }">
											${row.scheduleContent }
										</c:if>
									</span>
									<c:if test="${row.actState<=2 }">
										<c:if test="${row.myScheduleInvalidState==0 }">
											<span class="schedule-btn-bar">
												<span class="${row.scheduleId>0?'':'hidden' }"><a class="pxbtn-blue mleft_5" href="javascript:showSchedulePlan(${row.prizeId })" >修改${row.scheduleTypeName }</a></span>
												<span class="${row.scheduleId<=0?'':'hidden' }"><a class="pxbtn-blue" href="javascript:showSchedulePlan(${row.prizeId })" >选定${row.scheduleTypeName }</a></span>
											</span>
											<select class="schedule-plan" name="scheduleId" actId="${row.actId }" scheduleId="${row.scheduleId }" onchange="saveSchedulePlan(${row.prizeId })">
												<option value="0">--请选择${row.scheduleTypeName }--</option>
												<c:forEach var="actSchedule" items="${row.actScheduleList }">
													<c:if test="${actSchedule.scheduleId==row.scheduleId or actSchedule.maxNum==0 or actSchedule.maxNum>actSchedule.currentNum }">
														<option value="${actSchedule.scheduleId }" <c:if test="${actSchedule.scheduleId==row.scheduleId }">selected="selected"</c:if>>
															${actSchedule.scheduleContent}
														</option>
													</c:if>
												</c:forEach>
											</select>
										</c:if>
										<c:if test="${row.myScheduleInvalidState==1 }">
											<span class="error">（已自动失效）</span>
										</c:if>
									</c:if>
								</div>
							</dd>
						</c:if>
						<c:if test="${not empty row.receiveDesc }">
							<dt class="act-detail-receiveDesc title-brown">领奖须知</dt>
							<dd class="act-detail-receiveDesc"><div>${row.receiveDesc }</div></dd>
						</c:if>
					</dl>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
