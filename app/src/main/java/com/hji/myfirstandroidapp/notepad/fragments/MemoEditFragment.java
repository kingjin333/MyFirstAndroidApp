package com.hji.myfirstandroidapp.notepad.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hji.myfirstandroidapp.R;
import com.hji.myfirstandroidapp.notepad.facade.MemoFacade;

import java.text.SimpleDateFormat;

/**
 * Created by 현 on 2016-03-08.
 */
public class MemoEditFragment extends Fragment {
    private EditText mTitle;
    private EditText mMemo;

    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_memo_edit, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("메모");

        //프래그먼트에서 OptionMenu
        setHasOptionsMenu(true);

        mTitle = (EditText) view.findViewById(R.id.title_memo);
        mMemo = (EditText) view.findViewById(R.id.contents_memo);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.note_main, menu);
    }

    @Override
    public void onPause() {
        super.onPause();

        MemoFacade facade = new MemoFacade(getActivity());
        facade.insertMemo(mTitle.getText().toString(), mMemo.getText().toString());
    }
}

