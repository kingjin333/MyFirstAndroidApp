package com.hji.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView;
    private EditText mNameEditText;
    private EditText mAgeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 화면에 layout 표시.표시하고픈 xml명 변경.
        findViewById(R.id.next_activity_button).setOnClickListener(this);

        mNameEditText = (EditText) findViewById(R.id.name_edit_text);
        mAgeEditText = (EditText) findViewById(R.id.age_edit_text);
        // 이름 나이
        findViewById(R.id.next_activity_button).setOnClickListener(this);
        //이벤트
    }


    @Override
    public void onClick(View v) {

        Toast.makeText(MainActivity.this, mNameEditText.getText().toString(), Toast.LENGTH_SHORT);
        // 이름 나이 가져오기
        Intent intent = new Intent(this, SecondActivity.class);
        // SecondActivity 로 전환하겠다는 intent
        intent.putExtra("name", mNameEditText.getText().toString());
        intent.putExtra("age", mAgeEditText.getText().toString());
        // 이름 나이 가져와서 intent에 추가
        startActivity(intent);
        // intent의 정보를 토대로 다른 Activity를 시작
    }
}

