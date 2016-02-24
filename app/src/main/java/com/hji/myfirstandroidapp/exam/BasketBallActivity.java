package com.hji.myfirstandroidapp.exam;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

public class BasketBallActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mScore1TextView;
    private TextView mScore2TextView;

    private int mScore1 = 0;
    private int mScore2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_ball);

        // ActionBar 에 타이틀 변경
        getSupportActionBar().setTitle("Court Counter");
        // ActionBar 의 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFef6c00));


        findViewById(R.id.point1_btn).setOnClickListener(this);
        findViewById(R.id.point1_btn2).setOnClickListener(this);
        findViewById(R.id.point2_btn).setOnClickListener(this);
        findViewById(R.id.point2_btn2).setOnClickListener(this);
        findViewById(R.id.point3_btn).setOnClickListener(this);
        findViewById(R.id.point3_btn2).setOnClickListener(this);
        findViewById(R.id.reset_btn).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_button) {
            Toast.makeText(this, "액션버튼 이벤트", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {
            mScore1TextView = (TextView) findViewById(R.id.score_text);
            mScore2TextView = (TextView) findViewById(R.id.score_text2);
        switch (v.getId()){

            case R.id.point1_btn :
                mScore1++;
                mScore1TextView.setText("" + mScore1);
                break;

            case R.id.point1_btn2 :
                mScore2++;
                mScore2TextView.setText("" + mScore2);
                break;

            case R.id.point2_btn :
                mScore1 += 2;
                mScore1TextView.setText("" + mScore1);
                break;

            case R.id.point2_btn2 :
                mScore2 += 2;
                mScore2TextView.setText("" + mScore2);
                break;

            case R.id.point3_btn :
                mScore1 += 3;
                mScore1TextView.setText("" + mScore1);
                break;

            case R.id.point3_btn2 :
                mScore2 += 3;
                mScore2TextView.setText("" + mScore2);
                break;

            case R.id.reset_btn :
                mScore1 = 0;
                mScore2 = 0;
                mScore1TextView.setText("" + mScore1);
                mScore2TextView.setText("" + mScore2);
                break;


        }

    }
}
