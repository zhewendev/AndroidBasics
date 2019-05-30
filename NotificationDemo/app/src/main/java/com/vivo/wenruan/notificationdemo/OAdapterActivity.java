package com.vivo.wenruan.notificationdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class OAdapterActivity extends AppCompatActivity {

    private static final String GROUP_KEY_MSG = "com.vivo.wenruan.notificationdemo.CHAT_MSG";
    private static final String KEY_TEXT_REPLY = "key_text_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_adapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "chat";
            String channelName = "聊天消息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);

            channelId = "subscribe";
            channelName = "订阅消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);
        }

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "chat")
                .setContentTitle("收到一条聊天消息")
                .setContentText("今天的天气真不错？")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_alarm_white_48dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_alarm_white_48dp))
                .setAutoCancel(true)
                .setGroup(GROUP_KEY_MSG)
                .build();
        manager.notify(3, notification);
    }


    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setShowBadge(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }

    public void sendChatMsg(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel("chat");
            if (channel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID, channel.getId());
                startActivity(intent);
                Toast.makeText(this, "请手动将通知打开", Toast.LENGTH_SHORT).show();
            }
        }

        Notification notification = new NotificationCompat.Builder(this, "chat")
                .setContentTitle("收到一条聊天消息")
                .setContentText("今天中午吃什么？")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_alarm_white_48dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_alarm_white_48dp))
                .setAutoCancel(true)
                .setGroup(GROUP_KEY_MSG)
                .build();
        manager.notify(1, notification);

        Notification notification1 = new NotificationCompat.Builder(this, "chat")
                .setSmallIcon(R.drawable.ic_alarm_white_48dp)
                .setContentText("Two new message")
                .setContentTitle("聊天信息")
                .setGroup(GROUP_KEY_MSG)
                .setGroupSummary(true)
                .build();
        manager.notify(0,notification1);






    }

    public void sendSubscribeMsg(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "subscribe")
                .setContentTitle("收到一条订阅消息")
                .setContentText("地铁沿线30万商铺抢购中！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_message_black_18dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_message_black_18dp))
                .setAutoCancel(true)
                .setNumber(2)
                .build();
        manager.notify(2, notification);
    }

    public void sendReplyMsg() {
        String replyLabel = getResources().getString(R.string.reply_label);
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .build();
        PendingIntent replyPendingIntent =
                PendingIntent.getBroadcast(getApplicationContext(),
                        conversation.getConversationId(),
                        getMessageReplyIntent(conversation.getConversationId()),
                        PendingIntent.FLAG_UPDATE_CURRENT);

    }
}
