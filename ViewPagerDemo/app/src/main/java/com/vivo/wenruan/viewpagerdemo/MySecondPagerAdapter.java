package com.vivo.wenruan.viewpagerdemo;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MySecondPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<Integer> drawableList;

    public MySecondPagerAdapter() {

    }
    public MySecondPagerAdapter(List<View> viewList, List<Integer> drawableList) {
        this.viewList = viewList;
        this.drawableList = drawableList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = viewList.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        imageView.setImageResource(drawableList.get(position));
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(String.valueOf(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }
}
