package com.hji.myfirstandroidapp.exam_thread;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hji.myfirstandroidapp.R;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener {

    private int mCount = 0;
    private TextView mCountTextView;
    private Button mButton;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Main Thread = UI Thread = Foreground Thread
        setContentView(R.layout.activity_thread);

        mCountTextView = (TextView) findViewById(R.id.count_text);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        // 작업 스레드. (worker thread) = background Thread 홈키를 눌러도 돌고있다.
        // Thread 에서 UI 갱신 불가!!!!
        Thread thread = new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    mCount++;

                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // UI Thread 에서 그리는 코드
                            mCountTextView.setText(" " + mCount);
                        }
                    });
                    // UI Thread 에서 그리는 코드
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();

    }

    //  Thread 에서는 5초동안 응답하지 않으면 앱이 죽는다.
    @Override
    public void onClick(View v) {
        mCountTextView.setText(" " + mCount);

    }
}
