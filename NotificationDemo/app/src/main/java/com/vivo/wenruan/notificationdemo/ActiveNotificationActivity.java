package com.vivo.wenruan.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ActiveNotificationActivity extends AppCompatActivity {
    /**
     * 删除通知的请求码
     */
    private static final int REQUEST_DODE = 2323;

    private static final String TAG = "ActiveNotificationsFragment";

    /**
     * 归类的key
     */
    private static final String NOTIFICATION_GROUP =
            "com.example.android.activenotifications.notification_type";

    /**
     *  通知组别的id
     */
    private static final int NOTIFICATION_GROUP_SUMMARY_ID = 1;

    /**
     * 通知管理类
     */
    private NotificationManager mNotificationManager;

    private TextView mNumberOfNotifications;

    /**
     * 这是每一个通知的唯一id，如果不唯一，前一个通知会被后一个通知覆盖
     */
    private static int sNotificationId = NOTIFICATION_GROUP_SUMMARY_ID + 1;

    /**
     * 删除按钮触发的意图
     */
    private PendingIntent mDeletePendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_notification);
        mNotificationManager = (NotificationManager) getSystemService(
                Context.NOTIFICATION_SERVICE);
        mNumberOfNotifications = (TextView) findViewById(R.id.number_of_notifications);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.add_notification: {
                        addNotificationAndUpdateSummaries();
                        break;
                    }
                }
            }
        };
        findViewById(R.id.add_notification).setOnClickListener(onClickListener);

    }

    /**
     * 发送通知到系统。如果设备支持消息的归类功能，则进行消息归类。
     */
    private void addNotificationAndUpdateSummaries() {
        // 创建通知，并发送到状态栏
        final Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("消息的标题")
                .setContentText("消息的内容")
                .setAutoCancel(true) //自动取消
                .setDeleteIntent(mDeletePendingIntent) //设置删除的意图
                .setGroup(NOTIFICATION_GROUP); //设置类组key，说明此条通知归属于哪一个归类

        final Notification notification = builder.build();

        //这里需要为每一个通知创建一个新的id，如果id相同并且上一条通知还没有被用户取消，就会覆盖上一条通知
        mNotificationManager.notify(getNewNotificationId(), notification);

        //如果有必要，增加/更新/移除通知的归类
        updateNotificationSummary();

        //show有多少条通知在状态栏上面
        updateNumberOfNotifications();
    }

    /**
     * 如果有必要，增加/更新/移除通知的归类
     */
    protected void updateNotificationSummary() {
        int numberOfNotifications = getNumberOfNotifications();
        if (numberOfNotifications > 1) { //如果数量>=2,说明有了同样组key的通知，需要归类起来
            //将通知添加/更新归类到同一组下面
            String notificationContent = getString(R.string.notification,
                    numberOfNotifications);
            final NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    //添加富样式到通知的显示样式中，如果当前系统版本不支持，那么将不起作用，依旧用原来的通知样式
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .setSummaryText(notificationContent))
                    .setGroup(NOTIFICATION_GROUP) //设置类组key，说明此条通知归属于哪一个归类
                    .setGroupSummary(true); //这句话必须和上面那句一起调用，否则不起作用
            final Notification notification = builder.build();
            //发送通知到状态栏
            //测试发现，发送归类状态栏也是算一条通知的。所以返回值得时候，需要-1
            mNotificationManager.notify(NOTIFICATION_GROUP_SUMMARY_ID, notification);
        } else {
            //移除归类
            mNotificationManager.cancel(NOTIFICATION_GROUP_SUMMARY_ID);
        }
    }

    /**
     * 显示有多少条通知在状态栏上面
     */
    protected void updateNumberOfNotifications() {
        final int numberOfNotifications = getNumberOfNotifications();
        mNumberOfNotifications.setText("状态栏上面有多少条通知：%1$d" + numberOfNotifications);
    }

    /**
     * 返回一个通知的唯一id
     */
    public int getNewNotificationId() {
        int notificationId = sNotificationId++;
        if (notificationId == NOTIFICATION_GROUP_SUMMARY_ID) {
            notificationId = sNotificationId++;
        }
        return notificationId;
    }

    /**
     * 获取当前状态栏具有统一id的通知的数量
     *
     * @return 数量
     */
    private int getNumberOfNotifications() {
        //查询当前展示的所有通知的状态列表
        if (Build.VERSION.SDK_INT >= 23) {
            final StatusBarNotification[] activeNotifications = mNotificationManager
                    .getActiveNotifications();

            //获取当前通知栏里头，NOTIFICATION_GROUP_SUMMARY_ID归类id的组别
            //因为发送分组的通知也算一条通知，所以需要-1
            for (StatusBarNotification notification : activeNotifications) {
                if (notification.getId() == NOTIFICATION_GROUP_SUMMARY_ID) {
                    //-1是因为
                    return activeNotifications.length - 1;
                }
            }
            return activeNotifications.length;
        } else {
            return 0;
        }

    }



}
