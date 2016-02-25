package com.hji.myfirstandroidapp.exam_broadcast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hji.myfirstandroidapp.R;

public class BroadCastActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        findViewById(R.id.broad_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(Intent.ACTION_BATTERY_CHANGED);
    }
}
