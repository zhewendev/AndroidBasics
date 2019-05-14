package com.vivo.wenruan.activityfragmentlifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.d(TAG, "onInflate Start");
        super.onInflate(context, attrs, savedInstanceState);
        Log.d(TAG, "onInflate End");
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG,"onAttach Start");
        super.onAttach(context);
        Log.d(TAG,"onAttach End");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate Start");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate End");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView Start");
        View view = inflater.inflate(R.layout.first_fragment_layout, container,false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreateView End");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated Start");
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated End");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated Start");
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated End");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewStateRestored Start");
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored End");
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart Start");
        super.onStart();
        Log.d(TAG, "onStart End");
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume Start");
        super.onResume();
        Log.d(TAG, "onResume End");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d(TAG, "onCreateOptionsMenu Start");
        super.onCreateOptionsMenu(menu, inflater);
        Log.d(TAG, "onCreateOptionsMenu End");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "onPrepareOptionsMenu Start");
        super.onPrepareOptionsMenu(menu);
        Log.d(TAG, "onPrepareOptionsMenu End");
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause Start");
        super.onPause();
        Log.d(TAG, "onPause End");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState Start");
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState End");
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop Start");
        super.onStop();
        Log.d(TAG, "onStop End");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView Start");
        super.onDestroyView();
        Log.d(TAG, "onDestroyView End");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy Start");
        super.onDestroy();
        Log.d(TAG, "onDestroy End");
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach Start");
        super.onDetach();
        Log.d(TAG, "onDetach End");
    }
}
