var exec = require('cordova/exec');

exports.getToken = function (arg0, success, error) {
    exec(success, error, "CordovaHMSPushPlugin", "getToken", [arg0]);
}

function getIntentData() {
	exec(null, null, "CordovaHMSPushPlugin", "getIntentData", []);
}

function setPushEventDispatcher() {
	const intentData = getIntentData();
    console.log("intentData", intentData);
    
	const json = JSON.parse(intentData);
		
	if(json.isNotification) {
		// Dispatch the event.
		elem.dispatchEvent(new CustomEvent('onNotificationOpened', json));
	}
}

document.addEventListener("resume", setPushEventDispatcher, false);

document.addEventListener("deviceready", setPushEventDispatcher, false);
