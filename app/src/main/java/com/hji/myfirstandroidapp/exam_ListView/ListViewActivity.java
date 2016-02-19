package com.hji.myfirstandroidapp.exam_ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {

    private ListView mListView;
    private GridView mGridView;
    private ArrayAdapter<String> mAraayAdapter;
    private List <String> mArrayData;
    private Spinner mSpinner;
    private SimpleAdapter mSimpleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // View
        mListView = (ListView) findViewById(R.id.list);
        mGridView = (GridView) findViewById(R.id.grid);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        // ArrayData
        mArrayData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mArrayData.add("data" + i);
        }
        //SimpleData
        List<Map<String, String>> mSimpleData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("title" , "title " + i);
            map.put("description" , "description " + i);
            mSimpleData.add(map);
        }


        // ArrayAdapter
        mAraayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mArrayData);

        // SimpleAdapter
        mSimpleAdapter = new SimpleAdapter(this,
                mSimpleData, android.R.layout.simple_list_item_2,
                new String[]{"title", "description"},
                new int[] {android.R.id.text1, android.R.id.text2});

        mListView.setAdapter(mSimpleAdapter);
        mGridView.setAdapter(mAraayAdapter);
        mSpinner.setAdapter(mAraayAdapter);

        // 클릭 이벤트

        mListView.setOnItemClickListener(this);

        // 롱클릭 이벤트

        mListView.setOnItemLongClickListener(this);
        
        mSpinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ListViewActivity.this, "position : " + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ListViewActivity.this, "long click : " + position, Toast.LENGTH_SHORT).show();

        // 데이터 삭제
        mArrayData.remove(position);

        // 화면 갱신 : Adapter 에게 데이터 변경을 알려준다.
        // -> ListView 에 새로운 내용을 반영
        mAraayAdapter.notifyDataSetChanged();

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
