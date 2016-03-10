package com.hji.myfirstandroidapp.exam_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

public class FragmentExamActivity extends AppCompatActivity implements View.OnClickListener, ColorFragment.ColorDataReceiveListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_frag);

        ColorFragment frag1 = (ColorFragment) getSupportFragmentManager().findFragmentById(
                R.id.frag1);
        frag1.setColor(Color.BLUE);
        Button button1 = (Button) findViewById(R.id.first_btn);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.second_btn);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.third_btn);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 랜덤한 색상
        int randomColor = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));

        // 프래그먼트를 코드로 추가
        ColorFragment fragment = ColorFragment.newInstance(randomColor);
        fragment.setOnColorDataReceiveListener(this);

        int contentsId = R.id.frag1;
        switch (v.getId()) {
            case R.id.first_btn:
                contentsId = R.id.frag1;
                break;
            case R.id.second_btn:
                contentsId = R.id.frag2;
                break;
            case R.id.third_btn:
                contentsId = R.id.frag3;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(contentsId, fragment)
                .commit();
    }

    @Override
    public void onDataReceive(String data) {
        Toast.makeText(FragmentExamActivity.this, data, Toast.LENGTH_SHORT).show();
    }
}
