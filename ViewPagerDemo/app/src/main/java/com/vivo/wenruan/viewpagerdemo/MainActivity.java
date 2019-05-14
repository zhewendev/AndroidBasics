package com.vivo.wenruan.viewpagerdemo;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private ViewPager vpager_one;
//    private ArrayList<View> aList;
//    private ArrayList<String> sList;
//    private MyPagerAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_three);
//        vpager_one = (ViewPager) findViewById(R.id.vpager_three);
//
//        aList = new ArrayList<View>();
//        LayoutInflater li = getLayoutInflater();
//        aList.add(li.inflate(R.layout.view_one,null,false));
//        aList.add(li.inflate(R.layout.view_two,null,false));
//        aList.add(li.inflate(R.layout.view_three,null,false));
//        aList.add(li.inflate(R.layout.view_one,null,false));
//        sList = new ArrayList<>();
//        sList.add("橘黄");
//        sList.add("浅棕");
//        sList.add("淡黄");
//        sList.add("橘黄");
//        mAdapter = new MyPagerAdapter(aList,sList);
//        vpager_one.setAdapter(mAdapter);
//    }
private int[] drawableIds = new int[] {R.drawable.a, R.drawable.b, R.drawable.c,
        R.drawable.d, R.drawable.e};
    private List<View> viewList = new ArrayList<>();
    private ViewPager viewPager;
    private List<Integer> drawableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        initData();
        createPageItems();
        viewPager.setAdapter(new MySecondPagerAdapter(viewList, drawableList));
        viewPager.addOnPageChangeListener(new CycleScrollOnPageChangeListener(viewList, viewPager));
        viewPager.setCurrentItem(viewList.size() - 2, false);
        viewPager.setVisibility(View.INVISIBLE);
        viewPager.postDelayed(new Runnable() {

            @Override
            public void run() {
                viewPager.setVisibility(View.VISIBLE);
                // 设置初始 position
                viewPager.setCurrentItem(1, false);
            }
        }, 100);



    }

    private void initData() {
        drawableList = new ArrayList<Integer>();
        drawableList.add(drawableIds[drawableIds.length - 1]);
        for (int id : drawableIds) {
            drawableList.add(id);
        }
        drawableList.add(drawableIds[0]);
    }

    public void createPageItems() {
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < drawableList.size(); i++) {
            View view = inflater.inflate(R.layout.viewpager_item1, null);
            viewList.add(view);
        }
    }


}
