package com.vivo.wenruan.dialogpracticedemo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

public class DialogHelper {

    private String mTitle, mMsg;

    /**
     * 自定义参数
     */
    public void setTitle(String title) {
        mTitle = title;
    }

    public void setmMsg(String msg) {
        mMsg = msg;
    }

    /**
     * 通过配置的参数来建立一个dialog
     */
    public void show(Context context) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(mTitle)
                .setMessage(mMsg)
                .create();

        // .....
        // 通用的配置(例如对话框位置，背景等)
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0xffffffff));
        dialog.show();

    }
}
