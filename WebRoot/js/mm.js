//微信内嵌浏览器特有的js对象和事件
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	var restName = $('.title span').text();
	var appId = '', type = 0, imgUrl = "", desc = "";
	var title = "";
	var link = "";
	var time = new Date().getTime();
	var uoi = getUrlParam('uoi');
	link += link.indexOf("?") > 0 ? "&" : "?";
	link += "method=index";
	link += "&time=" + time;
	link += "&type=";
	var content = '#微信分享#，页面内容。' + link;
	// 发送给好友
	WeixinJSBridge.on('menu:share:appmessage', function(argv) {
		type = 1;
		link = link + type;
		WeixinJSBridge.invoke('sendAppMessage', {
			"appid" : appId,
			"img_url" : share.init.shareImg,
			"img_width" : "640",
			"img_height" : "640",
			"link" : share.init.shareUrl
					+ (share.init.shareUrl.indexOf("?") > 0 ? "&" : "?")
					+ "&method=index" + "&time=" + time + "&type=" + type,
			"desc" : share.init.shareDesc,
			"title" : share.init.userName + share.init.shareTitle
		}, function(res) {
			if (res.err_msg === 'send_app_msg:ok') {
				sendShareRequest(uoi);
			}
		});
	});
	// 分享到朋友圈
	WeixinJSBridge.on('menu:share:timeline', function(argv) {
		type = 2;
		link = link + type;
		sendShareRequest(uoi);
		WeixinJSBridge.invoke('shareTimeline', {
			"img_url" : share.init.shareImg,
			"img_width" : "640",
			"img_height" : "640",
			"link" : share.init.shareUrl
					+ (share.init.shareUrl.indexOf("?") > 0 ? "&" : "?")
					+ "&method=index" + "&time=" + time + "&type=" + type,
			"desc" : share.init.shareDesc,
			"title" : share.init.userName + share.init.shareTitle
		}, function(res) {
			WeixinJSBridge.log(res.err_msg);
			if (res.err_msg === 'share_timeline:ok') {
				// 接口回调被限制
			}
			;
		});
	});

	// 分享到微博
	var weiboContent = '';
	WeixinJSBridge.on('menu:share:weibo', function(argv) {
		type = 3;
		link = link + type;
		WeixinJSBridge.invoke('shareWeibo', {
			"content" : content,
			"url" : link,
		}, function(res) {

		});
	});

	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (null != r)
			return unescape(r[2]);
		return null;
	}

	function sendShareRequest(uoi) {
		$.ajax({
			url : "lottery.do",
			dataType : "json",
			data : {
				method : "share",
				uoi : uoi,
				t : Math.random()
			},
			success : function(data) {
				// location.reload();
			},
			timeout : 8000
		});

	}

	$('.follow').bind('click', function() {
		alert('clicked');
		WeixinJSBridge.invoke('profile', {
			'username' : 'szlife0755',
			'scene' : '57'
		});
	});
	function _addContact(callback) {
		WeixinJSBridge.invoke('addContact', {
			"webtype" : "1", // 添加联系人的场景，1表示企业联系人。
			"username" : wxid, // 需要添加的联系人username
		}, function(res) {
			// 关注成功提交表单
			if (res.err_msg == 'add_contact:ok') {
				if (typeof callback == 'function')
					callback();
			}
		});
	}
}, false);