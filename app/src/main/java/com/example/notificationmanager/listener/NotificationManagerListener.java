package com.example.notificationmanager.listener;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.example.notificationmanager.db.Notification;
import com.google.gson.Gson;

public class NotificationManagerListener extends NotificationListenerService {
    private static final String TAG = "Notification Manager";
    private final Gson gson = new Gson();

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (sbn == null) {
            return;
        }
        String pkg = sbn.getPackageName();
        if (pkg != null) {
            Log.d(TAG, "Receive new notification from " + pkg);
        }
        String content = gson.toJson(sbn.getNotification());
        Log.d(getPackageName(), gson.toJson(new Notification(pkg, content)));
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
//        super.onNotificationRemoved(sbn);
    }
}
