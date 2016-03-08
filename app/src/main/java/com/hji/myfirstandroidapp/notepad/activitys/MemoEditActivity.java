package com.hji.myfirstandroidapp.notepad.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hji.myfirstandroidapp.R;
import com.hji.myfirstandroidapp.notepad.fragments.MemoEditFragment;

public class MemoEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_edit);

        getSupportFragmentManager().beginTransaction().replace(R.id.contents2, new MemoEditFragment()
        ).commit();
    }
}
