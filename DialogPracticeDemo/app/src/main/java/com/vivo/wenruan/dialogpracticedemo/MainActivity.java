package com.vivo.wenruan.dialogpracticedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout rly = new RelativeLayout(this);
        Button btnOne = new Button(this);
        btnOne.setText("按钮1");
        Button btnTwo = new Button(this);
        btnTwo.setText("按钮2");
        // 为按钮1设置一个id值
        btnOne.setId(R.id.my_view);
        // 设置按钮1的位置,在父容器中居中
        RelativeLayout.LayoutParams rlp1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rlp1.addRule(RelativeLayout.CENTER_IN_PARENT);
        // 设置按钮2的位置,在按钮1的下方,并且对齐父容器右面
        RelativeLayout.LayoutParams rlp2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rlp2.addRule(RelativeLayout.BELOW, R.id.my_view);
        rlp2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        // 将组件添加到外部容器中
        rly.addView(btnTwo, rlp2);
        rly.addView(btnOne, rlp1);
        // 设置当前视图加载的View即rly
        setContentView(rly);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item)
    }
}
