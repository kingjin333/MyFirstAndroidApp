package com.hji.myfirstandroidapp.notepad.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.hji.myfirstandroidapp.notepad.db.MemoContract;
import com.hji.myfirstandroidapp.notepad.db.MemoDbHelper;

public class MyMemoProvider extends ContentProvider {
    // 프로바이더 이름
    private static final String AUTHORITY = "com.hji.myfirstandroidapp.provider";

    // content://com.hji.myfirstandroidapp.provider/Memo
    // com.hji.myfirstandroidapp.provider/Memo 프로바이더의 Memo 테이블
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/"
            + MemoContract.MemoEntry.TABLE_NAME);

    // 1개의 아이템 요청 MINE type
    public static final String CONTENT_TYPE = "vnd.android.cursor.item/vnd.com.hji.myfirstandroidapp.provider."
            + MemoContract.MemoEntry.TABLE_NAME;
    // 여러개의아이템 요청 MINE type
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.dir/vnd.com.hji.myfirstandroidapp.provider."
            + MemoContract.MemoEntry.TABLE_NAME;
    private MemoDbHelper mMemoDbHelper;

    public static final int ALL = 1;
    public static final int ITEM = 2;

    private static UriMatcher sUriMatcher;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // content://com.hji.myfirstandroidapp.provider/Memo (1번 패턴)
        sUriMatcher.addURI(AUTHORITY, MemoContract.MemoEntry.TABLE_NAME, ALL);
        // content://com.hji.myfirstandroidapp.provider/Memo/#3 (2번 패턴)
        sUriMatcher.addURI(AUTHORITY, MemoContract.MemoEntry.TABLE_NAME + "/#", ITEM);

    }

    public MyMemoProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (sUriMatcher.match(uri)){

            case ALL:
                break;
            case ITEM:
                // uri의 #뒤에 숫자 (_id)만 뽑아서 조건문을 완성
                selection = "_id=" + ContentUris.parseId(uri);
                selectionArgs = null;
                break;

            case UriMatcher.NO_MATCH:
                return 0;
        }

        SQLiteDatabase db = mMemoDbHelper.getWritableDatabase();
        int delete = db.delete(MemoContract.MemoEntry.TABLE_NAME,
                selection,
                selectionArgs);
        if (delete > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return delete;
    }


    @Override
    public String getType(Uri uri) {
        // 이 프로바이더가 처리 할 수 있는 패턴인지 검사
        switch (sUriMatcher.match(uri)) {
            case ALL:
                return CONTENT_TYPE;
            case ITEM:
                return CONTENT_ITEM_TYPE;
        }
        throw new IllegalArgumentException("UnKnown URI" + uri);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch (sUriMatcher.match(uri)){

            case ALL:
               long id = mMemoDbHelper.getWritableDatabase().insert(MemoContract.MemoEntry.TABLE_NAME,
                        null,
                        values);
                if (id > 0){

                    // content://com.hji.myfirstandroidapp.provider/Memo/#10
                    Uri returnUri = ContentUris.withAppendedId(CONTENT_URI, id);


                    // 변경을 통지해 준다
                    getContext().getContentResolver().notifyChange(returnUri, null);

                    return returnUri;
                }
                break;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        mMemoDbHelper = new MemoDbHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        // 이 스위치문은 외부에서 사용하는거때문에 있는것.
        // 내부에서만 사용할거면 안써도 됨.
        switch (sUriMatcher.match(uri)){

            case ALL:
                break;
            case ITEM:
                // uri의 #뒤에 숫자 (_id)만 뽑아서 조건문을 완성
                selection = "_id=" + ContentUris.parseId(uri);
                selectionArgs = null;
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("UnKnown URI" + uri);
        }
        SQLiteDatabase db = mMemoDbHelper.getReadableDatabase();

        // select * from memo;
        Cursor cursor = db.query(MemoContract.MemoEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
       // 커서를 감시대상으로 설정
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        switch (sUriMatcher.match(uri)){

            case ALL:
                break;
            case ITEM:
                // uri의 #뒤에 숫자 (_id)만 뽑아서 조건문을 완성
                selection = "_id=" + ContentUris.parseId(uri);
                selectionArgs = null;
                break;

            case UriMatcher.NO_MATCH:
                return 0;
        }
        SQLiteDatabase db = mMemoDbHelper.getWritableDatabase();

        int update = db.update(MemoContract.MemoEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        if (update > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return update;

    }
}
