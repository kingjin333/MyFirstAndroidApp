package com.hji.myfirstandroidapp.exam;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hji.myfirstandroidapp.R;

public class SignUp2Activity extends AppCompatActivity {


    private TextView mIdTextView;
    private TextView mPasswordTextView;
    private TextView mEmailTextView;
    private TextView mRadioTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        mIdTextView = (TextView) findViewById(R.id.id_text);
        mPasswordTextView = (TextView) findViewById(R.id.password_text);
        mEmailTextView = (TextView) findViewById(R.id.email_text);
        mRadioTextView = (TextView) findViewById(R.id.male_text);

        // 나를 호출한 Intent 를 얻는다
        Intent intent = getIntent();

        if (intent != null) {
            // id, password 를 셋팅
            String id = intent.getStringExtra("id");
            String passWord = intent.getStringExtra("password");
            String email = intent.getStringExtra("email");
            String radio = intent.getStringExtra("radio");

            mIdTextView.setText(mIdTextView.getText().toString() + id);
            mPasswordTextView.setText(mPasswordTextView.getText().toString() + passWord);
            mEmailTextView.setText(mEmailTextView.getText().toString() + email);
            mRadioTextView.setText(mRadioTextView.getText().toString() + radio);

        }


        getSupportActionBar().setTitle("SignUpExam");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF304ffe));
    }


}
