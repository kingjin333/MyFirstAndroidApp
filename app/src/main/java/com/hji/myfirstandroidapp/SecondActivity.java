package com.hji.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 현 on 2016-02-05.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mAgeTextView;
    private TextView mNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mNameTextView = (TextView) findViewById(R.id.name_text_view);
        mAgeTextView = (TextView) findViewById(R.id.age_text_view);

        findViewById(R.id.exit_button).setOnClickListener(this);


        //나를 호출한 Intent 를 얻는다
        Intent intent = getIntent();
        if (intent != null) {
            // 이름 나이를 세팅
            String name = intent.getStringExtra("name");
            String age = intent.getStringExtra("age");

            mNameTextView.setText(mNameTextView.getText().toString() + name);
            mAgeTextView.setText(mAgeTextView.getText().toString() + age);
        }
    }

    @Override
    public void onClick(View v) {
        // 현재 Activity 종료, back key 누른 것과 동일.
//        Toast.makeText(SecondActivity.this, "종료합니다", Toast.LENGTH_SHORT).show();
//        finish();
        Intent intent = new Intent();
        intent.putExtra("result", mNameTextView.getText().toString() + ", " +
                mAgeTextView.getText().toString());

        setResult(MainActivity.RESULT_OK, intent);
    }
}
