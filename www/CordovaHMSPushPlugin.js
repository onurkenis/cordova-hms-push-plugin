var exec = require('cordova/exec');

exports.getToken = function (arg0, success, error) {
    exec(success, error, "CordovaHMSPushPlugin", "getToken", [arg0]);
}

function getIntentData() {}

function setPushEventDispatcher() {}

document.addEventListener("resume", setPushEventDispatcher, false);

document.addEventListener("deviceready", setPushEventDispatcher, false);
