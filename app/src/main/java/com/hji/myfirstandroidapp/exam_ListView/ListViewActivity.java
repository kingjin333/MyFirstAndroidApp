package com.hji.myfirstandroidapp.exam_ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // View
        mListView = (ListView) findViewById(R.id.list);
        // Data
        List<String>data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("data" + i);
        }

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,data);

        mListView.setAdapter(adapter);

        // 클릭 이벤트

        mListView.setOnItemClickListener(this);

        // 롱클릭 이벤트

        mListView.setOnItemLongClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ListViewActivity.this, "position : " + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ListViewActivity.this, "long click : " + position, Toast.LENGTH_SHORT).show();
        return true;
    }
}
