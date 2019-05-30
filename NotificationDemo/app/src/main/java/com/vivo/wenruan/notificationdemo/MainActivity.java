package com.vivo.wenruan.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mSendNotifi;
    private TextView mCancelNotifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        PendingIntent intent = PendingIntent.getActivity(this, 0, new   Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.mrsorrow.xin")), PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("折叠通知")
                .setContentText("这是折叠通知内容")
                .setAutoCancel(true)
                .setContentIntent(intent)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .build();

        notification.bigContentView = new RemoteViews(getPackageName(), R.layout.notification_mobile_play);

        manager.notify(2, notification);




        mSendNotifi = (TextView) findViewById(R.id.send_notifi);
        mCancelNotifi = (TextView) findViewById(R.id.cancel_notifi);
        mSendNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
        mCancelNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.cancel(1);
            }
        });

    }

    private void sendNotification() {
        final int id = 4;
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.btn_audio_next_normal);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        final Notification.Builder mBuilder = new Notification.Builder(this);
        //设置小图标
        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        //设置大图标
        mBuilder.setLargeIcon(bitmap);
        //设置标题
        mBuilder.setContentTitle("这是标题");
        //设置通知正文
        mBuilder.setContentText("这是正文，当前ID是：" + id);
        //设置摘要
        mBuilder.setSubText("这是摘要");
        //设置是否点击消息后自动clean
        mBuilder.setAutoCancel(true);
        //显示指定文本
        mBuilder.setContentInfo("Info");
        //与setContentInfo类似，但如果设置了setContentInfo则无效果
        //用于当显示了多个相同ID的Notification时，显示消息总数
        mBuilder.setNumber(2);
        //通知在状态栏显示时的文本
        mBuilder.setTicker("在状态栏上显示的文本");
        //设置优先级
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        //自定义消息时间，以毫秒为单位，当前设置为比系统时间少一小时
        mBuilder.setWhen(System.currentTimeMillis() - 3600000);
        //设置为一个正在进行的通知，此时用户无法清除通知
        mBuilder.setOngoing(true);
        //设置消息的提醒方式，震动提醒：DEFAULT_VIBRATE     声音提醒：NotificationCompat.DEFAULT_SOUND
        //三色灯提醒NotificationCompat.DEFAULT_LIGHTS     以上三种方式一起：DEFAULT_ALL
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        //设置震动方式，延迟零秒，震动一秒，延迟一秒、震动一秒
        mBuilder.setVibrate(new long[]{0, 1000, 1000, 1000});

//        Intent intent = new Intent(this, SecondActivity.class);
//        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
//        mBuilder.setContentIntent(pIntent);
        Intent resultIntent = new Intent(this, SecondActivity.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);           //添加为栈顶Activity
        resultIntent.putExtra("what",5);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,5,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//发送pendingIntent
        mBuilder.setContentIntent(resultPendingIntent);



//        Intent resultIntent = new Intent(this, SecondActivity.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(SecondActivity.class);
//        stackBuilder.addNextIntent(resultIntent);
//        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//        mBuilder.setContentIntent(resultPendingIntent);
        // 构建一个 Style
        Notification.BigPictureStyle bigPictureStyle =
                new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.a));
// 设置标题
        bigPictureStyle.setBigContentTitle("ContentTitle");
// 设置副标题，简介文字
        bigPictureStyle.setSummaryText("SummaryText");
// 设置大图标
//        bigPictureStyle.bigLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.a));

        mBuilder.setStyle(bigPictureStyle);


        final NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int progress = 0; progress <= 100; progress += 5) {
//                    mBuilder.setProgress(100, progress, true);
//                    mNotificationManager.notify(id,mBuilder.build());
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                mBuilder.setContentText("下载完成").setProgress(0, 0, false);
//                mNotificationManager.notify(id, mBuilder.build());
//            }
//        }).start();

        mNotificationManager.notify(id, mBuilder.build());
    }


    private RemoteViews getRemoteViews() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_mobile_play);
        // 设置 点击通知栏的上一首按钮时要执行的意图
        remoteViews.setOnClickPendingIntent(R.id.btn_pre, getActivityPendingIntent(11));
        // 设置 点击通知栏的下一首按钮时要执行的意图
        remoteViews.setOnClickPendingIntent(R.id.btn_next, getActivityPendingIntent(12));
        // 设置 点击通知栏的播放暂停按钮时要执行的意图
        remoteViews.setOnClickPendingIntent(R.id.btn_start, getActivityPendingIntent(13));
        // 设置 点击通知栏的根容器时要执行的意图
        remoteViews.setOnClickPendingIntent(R.id.ll_root, getActivityPendingIntent(14));
        remoteViews.setTextViewText(R.id.tv_title, "标题");     // 设置通知栏上标题
        remoteViews.setTextColor(R.id.tv_title,getNotificationColor(this));
        remoteViews.setTextViewText(R.id.tv_artist, "艺术家");   // 设置通知栏上艺术家
        remoteViews.setTextColor(R.id.tv_artist, getNotificationColor(this));
        return remoteViews;
    }


    /** 获取一个Activity类型的PendingIntent对象 */
    private PendingIntent getActivityPendingIntent(int what) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);           //添加为栈顶Activity
        intent.putExtra("what", what);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, what, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }






    private static final String NOTIFICATION_TITLE = "notification_title";
    public static final int INVALID_COLOR = -1; // 无效颜色
    private static int notificationTitleColor = INVALID_COLOR; // 获取到的颜色缓存
    /**
     * 获取系统通知栏主标题颜色，根据Activity继承自AppCompatActivity或FragmentActivity采取不同策略。
     *
     * @param context 上下文环境
     * @return 系统主标题颜色
     */
    public static int getNotificationColor(Context context) {
        try {
            if (notificationTitleColor == INVALID_COLOR) {
                if (context instanceof AppCompatActivity) {
                    notificationTitleColor = getNotificationColorCompat(context);
                } else {
                    notificationTitleColor = getNotificationColorInternal(context);
                }
            }
        } catch (Exception ignored) {
        }
        return notificationTitleColor;
    }
    /**
     * 通过一个空的Notification拿到Notification.contentView，通过{@link RemoteViews#apply(Context, ViewGroup)}方法返回通知栏消息根布局实例。
     *
     * @param context 上下文
     * @return 系统主标题颜色
     */
    private static int getNotificationColorInternal(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(NOTIFICATION_TITLE);
        Notification notification = builder.build();
        try {
            ViewGroup root = (ViewGroup) notification.contentView.apply(context, new FrameLayout(context));
            TextView titleView = (TextView) root.findViewById(android.R.id.title);
            if (null == titleView) {
                iteratorView(root, new Filter() {
                    @Override
                    public void filter(View view) {
                        if (view instanceof TextView) {
                            TextView textView = (TextView) view;
                            if (NOTIFICATION_TITLE.equals(textView.getText().toString())) {
                                notificationTitleColor = textView.getCurrentTextColor();
                            }
                        }
                    }
                });
                return notificationTitleColor;
            } else {
                return titleView.getCurrentTextColor();
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return getNotificationColorCompat(context);
        }
    }
    /**
     * 使用getNotificationColorInternal()方法，Activity不能继承自AppCompatActivity（实测5.0以下机型可以，5.0及以上机型不行），
     * 大致的原因是默认通知布局文件中的ImageView（largeIcon和smallIcon）被替换成了AppCompatImageView，
     * 而在5.0及以上系统中，AppCompatImageView的setBackgroundResource(int)未被标记为RemotableViewMethod，导致apply时抛异常。
     *
     * @param context 上下文
     * @return 系统主标题颜色
     */
    private static int getNotificationColorCompat(Context context) {
        try {
            Notification.Builder builder = new Notification.Builder(context);
            Notification notification = builder.build();
            int layoutId = notification.contentView.getLayoutId();
            ViewGroup root = (ViewGroup) LayoutInflater.from(context).inflate(layoutId, null);
            TextView titleView = (TextView) root.findViewById(android.R.id.title);
            if (null == titleView) {
                return getTitleColorIteratorCompat(root);
            } else {
                return titleView.getCurrentTextColor();
            }
        } catch (Exception e) {
        }
        return INVALID_COLOR;
    }
    private static void iteratorView(View view, Filter filter) {
        if (view == null || filter == null) {
            return;
        }
        filter.filter(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                iteratorView(child, filter);
            }
        }
    }
    private static int getTitleColorIteratorCompat(View view) {
        if (view == null) {
            return INVALID_COLOR;
        }
        List<TextView> textViews = getAllTextViews(view);
        int maxTextSizeIndex = findMaxTextSizeIndex(textViews);
        if (maxTextSizeIndex != Integer.MIN_VALUE) {
            return textViews.get(maxTextSizeIndex).getCurrentTextColor();
        }
        return INVALID_COLOR;
    }
    private static int findMaxTextSizeIndex(List<TextView> textViews) {
        float max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int index = 0;
        for (TextView textView : textViews) {
            if (max < textView.getTextSize()) {
                // 找到字号最大的字体，默认把它设置为主标题字号大小
                max = textView.getTextSize();
                maxIndex = index;
            }
            index++;
        }
        return maxIndex;
    }
    /**
     * 实现遍历View树中的TextView，返回包含TextView的集合。
     *
     * @param root 根节点
     * @return 包含TextView的集合
     */
    private static List<TextView> getAllTextViews(View root) {
        final List<TextView> textViews = new ArrayList<>();
        iteratorView(root, new Filter() {
            @Override
            public void filter(View view) {
                if (view instanceof TextView) {
                    textViews.add((TextView) view);
                }
            }
        });
        return textViews;
    }

    private interface Filter {
        void filter(View view);
    }
}
