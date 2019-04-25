package com.vivo.wenruan.dialogpracticedemo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyDialog extends DialogFragment {

    private static final String TAG = "MyDialog";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        // ...
        // 得到各种配置参数
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 返回一个null，让fragment作为一个control
        return null;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 根据得到的参数，建立一个dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("title")
                .setMessage("message")
                .create();
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        //建立好Dialog后，这里可以进行进一步配置操作
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        // ....
        // 可以进行Dialog的findViewById操作
    }
}
