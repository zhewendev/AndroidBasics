package com.baiheng.statusbardemo;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout.LayoutParams mLayoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView= (ImageView) findViewById(R.id.image);
        ImageView imageView1 = (ImageView) findViewById(R.id.vehical);
        TextView textView = (TextView) findViewById(R.id.text_view);
        imageView.setVisibility(View.GONE);
        mLayoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        mLayoutParams.addRule(RelativeLayout.ALIGN_END);
        mLayoutParams.setMarginEnd(120);
        textView.setLayoutParams(mLayoutParams);
        String headReminderString = "宝宝你最棒";
        String highlightString = "你最棒";
        SpannableString repayDate = fontStyle(this,headReminderString, highlightString,
                0xFFFF5550, Typeface.BOLD, 0, 0);
        textView.setText(repayDate);
    }

    public static SpannableString fontStyle(Context context, String text, String target,
                                            int color, int style, int start, int end) {

        SpannableString spannableString = new SpannableString(text);
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            BackgroundColorSpan spanColor = new BackgroundColorSpan(color);
            spannableString.setSpan(spanColor, matcher.start() - start, matcher.end() + end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            StyleSpan span = new StyleSpan(style);
//            spannableString.setSpan(span, matcher.start() - start, matcher.end() + end,
//                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return  spannableString;
    }
}
