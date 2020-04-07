package com.huawei.cordovahmspushplugin;

import android.os.Bundle;

/**
 * Class to store the push notification data.
 *
 * @author Onur Kenis
 */
class IntentData {

    private boolean onNotificationOpened;
    private String title;
    private String body;

    IntentData(Bundle extras) {

        if (extras != null && extras.getBoolean("onNotificationOpened", false)) {
            this.onNotificationOpened = true;
            this.title = extras.getString(Constants.TITLE);
            this.body = extras.getString(Constants.BODY);
        }

    }

    boolean isOnNotificationOpened() {
        return onNotificationOpened;
    }

    void setOnNotificationOpened(boolean onNotificationOpened) {
        this.onNotificationOpened = onNotificationOpened;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getBody() {
        return body;
    }

    void setBody(String body) {
        this.body = body;
    }
}
