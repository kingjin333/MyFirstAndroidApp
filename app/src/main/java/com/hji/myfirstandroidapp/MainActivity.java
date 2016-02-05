package com.hji.myfirstandroidapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_box);
        // 화면에 layout 표시.표시하고픈 xml명 변경.

        mTextView = (TextView) findViewById(R.id.msg_text_view);
        ((CheckBox) findViewById(R.id.check_box)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(MainActivity.this, "check" + isChecked, Toast.LENGTH_SHORT).show();
        //text뷰에 글자를 변경.
        if (isChecked) {
            mTextView.setText("체크됨");
        } else {
            mTextView.setText("");
        }
    }
}

