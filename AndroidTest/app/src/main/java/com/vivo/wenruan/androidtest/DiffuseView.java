package com.vivo.wenruan.androidtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;

public class DiffuseView extends View {
    private final int REQUEST_RENDER_INTERVAL = 16;
    private final int MSG_REQUEST_RENDER = 0;
    private final int DURATION = 2000;

    private long mStartTime;
    private boolean mIsStart = false;
    private PathInterpolator mInterpolator;

    private int mWidth;
    private int mHeight;
    private Paint mPaint;

    private RefreshHandler mHandler = null;

    public DiffuseView(Context context) {
        super(context);
        init();
    }

    public DiffuseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mInterpolator = new PathInterpolator(0.6f, 0.f, 0.6f, 1.f);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);

        mHandler = new RefreshHandler();
    }

    private void start() {
        mStartTime = System.currentTimeMillis();

        mIsStart = true;
    }

    private void stop() {
        mIsStart = false;
        mHandler.removeMessages(MSG_REQUEST_RENDER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        long currTime = System.currentTimeMillis();
        // progress取值范围为0 ~ 1
        float progress = (float)((currTime - mStartTime) % DURATION) / DURATION;

        float value = mInterpolator.getInterpolation(progress);

        float radius = 100 * value;
        canvas.drawCircle(mWidth >> 1, mHeight >> 1, radius, mPaint);

        // invalidate不要置于draw接口中调用，invalidate本身会比较耗时，置于draw接口中，会加长当前帧的绘制时间
        // invalidate();

        if (mIsStart) {
            mHandler.sendEmptyMessageDelayed(MSG_REQUEST_RENDER, REQUEST_RENDER_INTERVAL);
        }
    }

    public void pause() {
        mHandler.removeMessages(MSG_REQUEST_RENDER);
    }

    private class RefreshHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            invalidate();
            sendEmptyMessageDelayed(MSG_REQUEST_RENDER, REQUEST_RENDER_INTERVAL);
        }
    }
}
