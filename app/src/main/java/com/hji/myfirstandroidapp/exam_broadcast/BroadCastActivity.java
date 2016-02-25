package com.hji.myfirstandroidapp.exam_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

public class BroadCastActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ACTION_MY = "com.hji.myfirstandroidapp.ACTION_MY";
    private MyReceiver mMyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        findViewById(R.id.broad_btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ACTION_MY);

        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 리시버 등록
        mMyReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_MY);
        registerReceiver(mMyReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // 리시버 해제
        unregisterReceiver(mMyReceiver);
    }

    // 이 Activity 에서만 동작하는 리시버
    // Manyfest 에 작성 안함.
    private static class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_MY)){
                Toast.makeText(context, "잘 받았다", Toast.LENGTH_SHORT).show();
            }
        }
    }
}