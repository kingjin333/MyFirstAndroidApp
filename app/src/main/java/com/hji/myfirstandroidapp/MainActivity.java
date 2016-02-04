package com.hji.myfirstandroidapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.button);
        // 화면에 layout 표시.
    }

    //activity_main.xml 에 연결됨.
    public void onClick(View view) {
        Log.d(TAG, "클릭 잘 됨");
    }
}
