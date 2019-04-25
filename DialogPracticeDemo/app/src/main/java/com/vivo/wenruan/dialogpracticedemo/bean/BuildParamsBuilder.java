package com.vivo.wenruan.dialogpracticedemo.bean;

import android.support.v7.app.AlertController;
import android.widget.PopupWindow;

public class BuildParamsBuilder {
    private int mIconId;
    private int mThemeResId;
    // ... 省略部分参数
    public BuildParamsBuilder setIconId(int iconId) {
        mIconId = iconId;
        return this;
    }
    public BuildParamsBuilder setThemeResId(int themeResId) {
        mThemeResId = themeResId;
        return this;
    }
    // ... 省略部分代码
    public BuildParams build() {
        return new BuildParams(mIconId, mThemeResId, mTitle, mMessage, mPositiveText, mNeutralText, mNegativeText, mItems, mCheckedItems,
                mIsMultiChoice, mIsSingleChoice, mCheckedItem);
    }

    AlertController.AlertParams
    PopupWindow.showAtLocation()
}
