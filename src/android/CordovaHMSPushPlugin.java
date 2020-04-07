package com.huawei.cordovahmspushplugin;

import android.text.TextUtils;
import android.util.Log;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

import static com.huawei.cordovahmspushplugin.Constants.TAG;

/**
 * This class implements main native functions of push
 * and extends CordovaPlugin class to serve functionality
 * to JS layer.
 *
 * @author Onur Kenis
 */
public class CordovaHMSPushPlugin extends CordovaPlugin {

    // Notification data as JSON string
    static String notificationData;

    /**
     * Executes the request.
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return                Whether the action was valid.
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        switch (action) {
            case "getToken":
                this.getToken(callbackContext);
                return true;
            default:
                return false;
        }
    }

    /**
     * Gets the client token from
     * HMS Push Kit.
     *
     * @param callbackContext The callback context used when calling back into JavaScript.
     */
    private void getToken(CallbackContext callbackContext) {
        Log.i(TAG, "get token: begin");

        try {
            String appId = AGConnectServicesConfig.fromContext(cordova.getContext()).getString("client/app_id");
            String pushToken = HmsInstanceId.getInstance(cordova.getContext()).getToken(appId, "HCM");
            if (!TextUtils.isEmpty(pushToken)) {
                Log.i(TAG, "get token:" + pushToken);
                callbackContext.success(pushToken);
            }
        } catch (Exception e) {
            Log.e(TAG, "getToken Failed, " + e);
            callbackContext.error("getToken Failed, error : " + e.getMessage());
        }
    }

    /**
     * Gets notification data from intent
     * and returns data with callbackContext.
     *
     * @param callbackContext The callback context used when calling back into JavaScript.
     */
    private void getNotificationData(CallbackContext callbackContext) {
        Log.i(TAG, "getNotificationData: begin");
        Log.i(TAG, notificationData);

        callbackContext.success(notificationData);
    }

}
