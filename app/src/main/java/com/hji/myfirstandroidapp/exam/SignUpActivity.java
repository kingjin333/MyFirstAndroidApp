package com.hji.myfirstandroidapp.exam;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPassWordEditText;
    private EditText mEmailEditText;
    private EditText mPassWord2EditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioman;
    private RadioButton mRadiowoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        // 액션 바
        getSupportActionBar().setTitle("SignUpExam");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF304ffe));

        Button button1 = (Button) findViewById(R.id.cho_gi_btn);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.sign_up_btn);
        button2.setOnClickListener(this);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mRadioGroup.setOnClickListener(this);

        mRadioman = (RadioButton) findViewById(R.id.man_radio);
        mRadiowoman = (RadioButton) findViewById(R.id.woman_radio);


        mIdEditText = (EditText) findViewById(R.id.id_edit_text);
        mPassWordEditText = (EditText) findViewById(R.id.password_edit_text);
        mPassWord2EditText = (EditText) findViewById(R.id.password_edit_text2);
        mEmailEditText = (EditText) findViewById(R.id.email_edit_text);

    }

    @Override
    public void onClick(View v) {
        // SignUp2 로 전환하겠다는 intent
        Intent intent = new Intent(this, SignUp2Activity.class);

        // id, password 를 가져와서 intent 에 추가
        intent.putExtra("id", mIdEditText.getText().toString());
        intent.putExtra("password", mPassWordEditText.getText().toString());
        intent.putExtra("email", mEmailEditText.getText().toString());


        if (mRadioGroup.getCheckedRadioButtonId() == R.id.man_radio) {
            intent.putExtra("radio", mRadioman.getText().toString());
        }
        if (mRadioGroup.getCheckedRadioButtonId() == R.id.woman_radio) {
            intent.putExtra("radio", mRadiowoman.getText().toString());

        }

        switch (v.getId()) {

            case R.id.cho_gi_btn:
                mIdEditText.setText(null);
                mPassWordEditText.setText(null);
                mPassWord2EditText.setText(null);
                mEmailEditText.setText(null);
                mRadioGroup.clearCheck();

                break;
            case R.id.sign_up_btn:

                if (!(mPassWordEditText.getText().toString().equals(mPassWord2EditText.getText().toString()))) {

                    Toast.makeText(SignUpActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                }

                if (mIdEditText.length() == 0 | mPassWordEditText.length() == 0 | mEmailEditText.length() == 0
                        | mRadioGroup.getCheckedRadioButtonId() == 0) {
                    Toast.makeText(SignUpActivity.this, "모두 입력해 주셔야 합니다.", Toast.LENGTH_SHORT).show();

                } else {
                    startActivity(intent);
                }

                break;


        }


    }
}
