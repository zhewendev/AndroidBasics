package com.vivo.wenruan.activityfragmentlifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Fragment与Activity执行时生命周期的顺序Demo
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate End");
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SecondFragment());
            }
        });
        Log.d(TAG, "onCreate Final End");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.d(TAG, "onAttachFragment Start");
        super.onAttachFragment(fragment);
        Log.d(TAG, "onAttachFragment End");
    }

    @Override
    public void onContentChanged() {
        Log.d(TAG, "onContentChanged Start");
        super.onContentChanged();
        Log.d(TAG, "onContentChanged End");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart Start");
        super.onStart();
        Log.d(TAG, "onStart End");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState Start");
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState End");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onPostCreate Start");
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "onPostCreate End");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume Start");
        super.onResume();
        Log.d(TAG, "onResume End");
    }

    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume Start");
        super.onPostResume();
        Log.d(TAG, "onPostResume End");
    }

    @Override
    public void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow Start");
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow End");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onUserInteraction() {
        Log.d(TAG, "onUserInteraction Start");
        super.onUserInteraction();
        Log.d(TAG, "onUserInteraction End");
    }

    @Override
    protected void onUserLeaveHint() {
        Log.d(TAG, "onUserLeaveHint Start");
        super.onUserLeaveHint();
        Log.d(TAG, "onUserLeaveHint End");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause Start");
        super.onPause();
        Log.d(TAG, "onPause End");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState Start");
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState End");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop Start");
        super.onStop();
        Log.d(TAG, "onStop End");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy Start");
        super.onDestroy();
        Log.d(TAG, "onDestroy End");
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.second_fragment, fragment);
    }
}
