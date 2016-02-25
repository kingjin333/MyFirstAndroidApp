package com.hji.myfirstandroidapp.exam;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.hji.myfirstandroidapp.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText mIdEditText;
    private EditText mPassWordEditText;
    private EditText mEmailEditText;
    private EditText mPassWord2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("SignUpExam");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF304ffe));

        mIdEditText = (EditText) findViewById(R.id.id_edit_text);
        mPassWordEditText = (EditText) findViewById(R.id.password_edit_text);
        mPassWord2EditText = (EditText) findViewById(R.id.password_edit_text2);
        mEmailEditText = (EditText) findViewById(R.id.email_edit_text);
    }

}
