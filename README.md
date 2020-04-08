# [WIP] Cordova - HMS Push Plugin

This plugin is created to serve native HMS Push Kit functionality on the Android platform. 

It supports handy features like triggering custom `onNotificationOpened` event to catch notification related data on JS layer when user clicks and opens push notification sent from [Huawei Push Kit Server.](https://developer.huawei.com/consumer/en/doc/development/HMS-Guides/push-basic-capability#h1-1576221162135)

## Preparation

Follow official [codelab](https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#0) for HMS Core enablement.

## Usage

1. Add plugin to your projects.

```sh
cordova plugin add https://github.com/onurkenis/cordova-hms-push-plugin.git
```

2. Add following line to the activity in src/android where you configured to open after user notification click.

```
PushUtils.setIntentData(bundle);
```

3. Add event listener to deviceready Event Handler and get notification data in JS when app is opened.

```javascript
document.addEventListener('onNotificationOpened', function (notification) {
    console.log("onNotificationOpened Title: " + notification.detail.title);
	console.log("onNotificationOpened Body: " + notification.detail.body);
}, false);
```

## How to send HMS Push Notification with data?
*This part will be updated.*

## How to configure your applications to receive click action and notification data?
*This part will be updated.*

## Contributing

Commit messages must comply with [conventional commits](https://www.conventionalcommits.org). Otherwise [commitlint](https://github.com/conventional-changelog/commitlint) will complain.

Thanks to [commitizen](https://github.com/commitizen), `npm run commit` command can be used to create commit messages complying with conventional commits.

Don't forget to install dependencies before to use it with `npm install`.