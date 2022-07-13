/**
 * ceate WebSocket
 * url格式 127.0.0.1:8080/websocket/socketServer
 * 或 localhost:8080/websocket/socketServer
 * @param  url
 */
function createWebSocket(url) {
	var websocket = false;
	try {
		var clientID = uuid();
		url = '/' == url.charAt(url.length - 1) ? url + clientID : url + '/' + clientID;
		if('WebSocket' in window) {
			websocket = new WebSocket('ws://' + url);
		} else if('MozWebSocket' in window) {
			websocket = new MozWebSocket('ws://' + url);
		} else {
			websocket = new SockJS('http://' + url);
		}
	} catch(e) {
		console.error(e);
	}
	if(websocket) {
		websocket.onopen = onOpen;
		websocket.onmessage = onMessage;
		websocket.onerror = onError;
		websocket.onclose = onClose;
		window.close = function() {
			websocket.close();
		}
	}
	return websocket;
}

function onOpen(evt) {
	console.log("websocket连接上:" + evt);
}

function onMessage(evt) {
	console.log("接收到服务器信息:" + evt.data);
}

function onError(evt) {
	console.error("websocket错误:" + evt);
}

function onClose() {
	console.log("websocket关闭");
}

function uuid() {
	var s = [];
	var hexDigits = "0123456789abcdef";
	for(var i = 0; i < 36; i++) {
		s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	}
	s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
	s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
	s[8] = s[13] = s[18] = s[23] = "-";

	var uuid = s.join("");
	return uuid;
}