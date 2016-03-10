package com.hji.myfirstandroidapp.notepad.facade;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hji.myfirstandroidapp.notepad.db.MemoContract;
import com.hji.myfirstandroidapp.notepad.db.MemoDbHelper;

import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Memo 테이블에 대한 작업을 편하게 해주는 클래스
 */
public class MemoFacade {

    private MemoDbHelper mHelper;
    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MemoFacade(Context context) {
        mHelper = new MemoDbHelper(context);
    }

    public long insertMemo(String title, String memo) {
        // 쓰기 모드로 db 저장소를 얻기
        SQLiteDatabase db = mHelper.getWritableDatabase();

        // INSERT INTO Memo(title, memo, date) VALUES ('title', 'memo', '2000-10-10');
        // db.execSQL("INSERT INTO Memo(title, memo, date) VALUES ('title', 'memo', '2000-10-10')");

        String date = mSimpleDateFormat.format(new Date());

        ContentValues values = new ContentValues();
        if (title.length() != 0) {
            values.put(MemoContract.MemoEntry.COLUMN_NAME_TITLE, title);
        }
        values.put(MemoContract.MemoEntry.COLUMN_NAME_MEMO, memo);
        values.put(MemoContract.MemoEntry.COLUMN_NAME_DATE, date);

        if (title.length() != 0 || memo.length() != 0) {
            return db.insert(MemoContract.MemoEntry.TABLE_NAME,
                    null,
                    values);
        }

        return -1;
    }
}
