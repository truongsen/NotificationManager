package com.example.notificationmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;

import com.example.notificationmanager.listener.NotificationManagerListener;
import com.example.notificationmanager.utils.PermissionUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!PermissionUtils.isNotificationServiceEnabled(getApplicationContext())){
            showPermissionDialog();
        } else {
            Intent intent = new Intent(this, NotificationManagerListener.class);
            startService(intent);
        }
    }

    private void showPermissionDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_permission_title)
                .setMessage(R.string.dialog_permission_content)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}