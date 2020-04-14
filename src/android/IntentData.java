package com.huawei.cordovahmspushplugin;

import android.os.Bundle;

/**
 * Class to store the push notification data.
 *
 * @author Onur Kenis
 */
class IntentData {

    private boolean isNotification;
    private String title;
    private String body;
    private String image;

    IntentData(Bundle extras) {

        if (extras != null) {
            this.isNotification = Boolean
                .parseBoolean(extras.getString("isNotification", "false"));

            this.title = extras.getString(Constants.TITLE);
            this.body = extras.getString(Constants.BODY);
            this.image = extras.getString(Constants.IMAGE);
        }

    }

    boolean isNotification() {
        return isNotification;
    }

    void setNotification(boolean notification) {
        this.isNotification = notification;
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

    String getImage() {
        return image;
    }

    void setImage(String image) {
        this.image = image;
    }
}
