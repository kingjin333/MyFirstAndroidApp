package com.hji.myfirstandroidapp.exam_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

public class BroadCastActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ACTION_MY = "com.hji.myfirstandroidapp.ACTION_MY";
    private MyReceiver mMyReceiver;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        mMessageEditText = (EditText) findViewById(R.id.message_edit);

        findViewById(R.id.broad_btn).setOnClickListener(this);
        findViewById(R.id.kakao_send_btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.broad_btn :
                Intent intent = new Intent(ACTION_MY);
                // 브로드캐스트 발송
                sendBroadcast(intent);
                break;
            case R.id.kakao_send_btn :
                Intent kakaointent = new Intent(Intent.ACTION_SEND);
                kakaointent.setPackage("com.kakao.talk");
                kakaointent.setType("text/plain");
                kakaointent.putExtra(Intent.EXTRA_TEXT, mMessageEditText.getText().toString());
                if (kakaointent.resolveActivity(getPackageManager()) != null) {
                    startActivity(kakaointent);
                }else {
                    Toast.makeText(BroadCastActivity.this, "카카오톡이 없음", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
        //특정 앱 설치 화면으로 이동
    private void install(){
        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse
                ("https://play.google.com/store/apps/details?id=com.google.android.gms&hl=ko"));
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
    // Manifest 에 작성 안함.
    private static class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_MY)){
                Toast.makeText(context, "잘 받았다", Toast.LENGTH_SHORT).show();
            }
        }
    }
}