var exec = require('cordova/exec');

exports.getToken = function (arg0, success, error) {
    exec(success, error, "CordovaHMSPushPlugin", "getToken", [arg0]);
}

function getIntentData() {
	exec(setPushEventDispatcher, getIntentDataFail, "CordovaHMSPushPlugin", "getIntentData", []);
}

function setPushEventDispatcher(intentData) {
	const json = JSON.parse(intentData);
	console.log("intentData ", intentData);
	
	if(json.isNotification) {
		// Dispatch the event.
		console.log("onNotificationOpened ", "dispatched");
		document.dispatchEvent(new CustomEvent('onNotificationOpened', null));
	}
}

function getIntentDataFail() {
	console.log("getIntentData failed");
}

document.addEventListener("resume", getIntentData, false);

document.addEventListener("deviceready", getIntentData, false);
