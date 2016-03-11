package com.hji.myfirstandroidapp.notepad.fragments;

import android.content.ContentValues;
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
import android.widget.Toast;

import com.hji.myfirstandroidapp.R;
import com.hji.myfirstandroidapp.notepad.db.MemoContract;
import com.hji.myfirstandroidapp.notepad.facade.MemoFacade;

/**
 * Created by 현 on 2016-03-08.
 */
public class MemoEditFragment extends Fragment {
    private EditText mTitleTextView;
    private EditText mMemoTextView;

    private String mTitle = "";
    private String mMemo = "";

    private boolean isEditMode;
    private long mId = -1;
    private MemoFacade mMemoFacade;

    public MemoEditFragment() {
    }

    public static MemoEditFragment newInstance(long id, String title, String memo) {

        MemoEditFragment fragment = new MemoEditFragment();

        Bundle bundle = new Bundle();
        bundle.putLong("id", id);
        bundle.putString("title", title);
        bundle.putString("memo", memo);

        fragment.setArguments(bundle);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMemoFacade = new MemoFacade(getActivity());
        return inflater.inflate(R.layout.fragment_memo_edit, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("메모");

        //프래그먼트에서 OptionMenu
        setHasOptionsMenu(true);

        mTitleTextView = (EditText) view.findViewById(R.id.title_memo);
        mMemoTextView = (EditText) view.findViewById(R.id.contents_memo);

        Bundle bundle = getArguments();
        if (bundle != null) {
            isEditMode = true;

            mId = bundle.getLong("id");
            String title = bundle.getString("title");
            String memo = bundle.getString("memo");

            mTitle = title;
            mMemo = memo;

            mTitleTextView.setText(title);
            mMemoTextView.setText(memo);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.note_main, menu);
    }

    @Override
    public void onPause() {
        super.onPause();

        if (isEditMode) {
            // 수정모드
            String title = mTitleTextView.getText().toString();
            String memo = mMemoTextView.getText().toString();
            if (!(mTitle.equals(title) && mMemo.equals(memo))) {
                ContentValues values = new ContentValues();
                values.put(MemoContract.MemoEntry.COLUMN_NAME_TITLE, title);
                values.put(MemoContract.MemoEntry.COLUMN_NAME_MEMO, memo);

                if (mMemoFacade.updateMemo(values, "_id=" + mId, null) > 0) {
                    Toast.makeText(getActivity(), "수정 되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            // 삽입모드

            long insertId = mMemoFacade.insertMemo(mTitleTextView.getText().toString(), mMemoTextView.getText().toString());
            if (insertId != -1) {
                Toast.makeText(getActivity(), "저장 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

