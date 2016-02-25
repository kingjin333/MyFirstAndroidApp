package com.hji.myfirstandroidapp.exam;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hji.myfirstandroidapp.R;

public class SignUp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        getSupportActionBar().setTitle("SignUpExam");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF304ffe));
    }


}
