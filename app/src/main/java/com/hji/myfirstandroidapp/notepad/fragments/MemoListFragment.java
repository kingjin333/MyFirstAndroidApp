package com.hji.myfirstandroidapp.notepad.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hji.myfirstandroidapp.R;
import com.hji.myfirstandroidapp.notepad.adapters.MemoAdapter;
import com.hji.myfirstandroidapp.notepad.models.Memo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 현 on 2016-03-09.
 */
public class MemoListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_memo_fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("메모 리스트");

        ListView listView = (ListView) view.findViewById(R.id.list);

        List<Memo> list = new ArrayList<>();
        list.add(new Memo("타이틀", "ㅁㄴ아ㅓㄹㅁㅣㄴ얼미ㅏ넝ㄹㅣ마ㅓㄴ이럼ㅣㄴ어ㅏㄹㅁㅁㄴ아ㅓㄹㅁㅣㄴ얼미ㅏ넝ㄹㅣ마ㅓㄴ이럼ㅣㄴ어ㅏㄹㅁㅁㄴ아ㅓㄹㅁㅣㄴ얼미ㅏ넝ㄹㅣ마ㅓㄴ이럼ㅣㄴ어ㅏㄹㅁㅁㄴ아ㅓㄹㅁㅣㄴ얼미ㅏ넝ㄹㅣ마ㅓㄴ이럼ㅣㄴ어ㅏㄹㅁㅁㄴ아ㅓㄹㅁㅣㄴ얼미ㅏ넝ㄹㅣ마ㅓㄴ이럼ㅣㄴ어ㅏㄹㅁ", "2016-3-8"));

        MemoAdapter adapter = new MemoAdapter(getActivity(), list);

        listView.setAdapter(adapter);
    }
}
