package com.vivo.wenruan.horizontalscrollviewdemo;

import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private LinearLayout mGallery;
//    private int[] mImgIds;
//    private LayoutInflater mInflater;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
//        mInflater = LayoutInflater.from(this);
//        initData();
//        initView();
//    }

//    private void initData() {
//        mImgIds = new int[] { R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d,
//                R.drawable.e,R.drawable.f,R.drawable.g
//        };
//    }
//
//    private void initView() {
//        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
//
//        for (int i = 0; i < mImgIds.length; i++) {
//            View view = mInflater.inflate(R.layout.activity_index_gallery_item,
//                    mGallery, false);
//            ImageView img = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
//            img.setImageResource(mImgIds[i]);
//            TextView txt = (TextView) view.findViewById(R.id.id_index_gallery_item_text);
//            txt.setText("some info");
//            txt.setTextColor(Color.BLACK);
//            mGallery.addView(view);
//        }
//    }

    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private ImageView mImage;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
            R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d,
                R.drawable.e,R.drawable.f,R.drawable.g));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mImage = (ImageView) findViewById(R.id.id_content);

        mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
        mHorizontalScrollView.setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener() {
            @Override
            public void onCurrentImgChanged(int position, View viewIndicator) {
                mImage.setImageResource(mDatas.get(position));
                viewIndicator.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener() {
            @Override
            public void onClick(View view, int pos) {
                mImage.setImageResource(mDatas.get(pos));
                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });
        mHorizontalScrollView.initDatas(mAdapter);
    }
}
