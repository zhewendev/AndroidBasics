package com.vivo.wenruan.androidtest;

import android.util.Log;

public class Wang implements CalllBack {

    private Li mLi;

    public Wang(Li li) {
        mLi = li;
    }

    public void askLi(final String question) {
        mLi.execute(Wang.this, question);
    }


    @Override
    public void getAnswer(String question) {
        Log.d("Wang", question);
    }
}
