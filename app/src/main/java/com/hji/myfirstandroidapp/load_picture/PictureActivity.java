package com.hji.myfirstandroidapp.load_picture;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hji.myfirstandroidapp.MainActivity;
import com.hji.myfirstandroidapp.R;
import com.suwonsmartapp.abl.AsyncBitmapLoader;

public class PictureActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private PictureCursorAdapter mAdapter;
    private PictureRecyclerViewAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        ListView listView = (ListView) findViewById(R.id.list);
        mAdapter = new PictureCursorAdapter(this, null);
        listView.setAdapter(mAdapter);
        RecyclerView recyclerView =  (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerAdapter = new PictureRecyclerViewAdapter(this, null);
        recyclerView.setAdapter(mRecyclerAdapter);


        // 화면의 방향을 알 수 있는 방법
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 첫번째
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            // 두번째
            GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(layoutManager);
        }

        // 세번째
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(PictureActivity.this,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
        mRecyclerAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
    private static class PictureRecyclerViewAdapter extends RecyclerView.Adapter<PictureRecyclerViewAdapter.MyViewHolder> {

        private Cursor mCursor;
        private AsyncBitmapLoader mAsyncBitmapLoader;

        public PictureRecyclerViewAdapter(Context context, Cursor cursor) {
            mCursor = cursor;
            mAsyncBitmapLoader = new AsyncBitmapLoader(context);
            mAsyncBitmapLoader.setBitmapLoadListener(new AsyncBitmapLoader.BitmapLoadListener() {
                @Override
                public Bitmap getBitmap(String key) {
                    // Background Thread

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;   // 2의 배수, 큰 값일 수록 이미지 크기가 작아짐

                    return BitmapFactory.decodeFile(key, options);
                }
            });
        }

        static class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.image);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_list, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            mCursor.moveToPosition(position);
            Cursor cursor = mCursor;
            mAsyncBitmapLoader.loadBitmap(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)), holder.imageView);
        }


        @Override
        public int getItemCount() {
            if (mCursor == null) {
                return 0;
            }
            return mCursor.getCount();
        }

        public void swapCursor(Cursor cursor) {
            mCursor = cursor;
            notifyDataSetChanged();
        }
    }


    private static class PictureCursorAdapter extends CursorAdapter {

        private final LayoutInflater inflator;
        private AsyncBitmapLoader mAsyncBitmapLoader;

        public PictureCursorAdapter(Context context, Cursor c) {
            super(context, c, false);
            inflator = LayoutInflater.from(context);
            mAsyncBitmapLoader = new AsyncBitmapLoader(context);
            mAsyncBitmapLoader.setBitmapLoadListener(new AsyncBitmapLoader.BitmapLoadListener() {
                @Override
                public Bitmap getBitmap(String key) {
                    // Background Thread

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;   // 2의 배수, 큰 값일 수록 이미지 크기가 작아짐

                    return BitmapFactory.decodeFile(key, options);
                }
            });
        }


        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            ViewHolder holder = new ViewHolder();
            View view = inflator.inflate(R.layout.item_image_list, parent, false);
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ViewHolder holder = (ViewHolder) view.getTag();
            mAsyncBitmapLoader.loadBitmap(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)),
                    holder.imageView);
        }

        static class ViewHolder {
            ImageView imageView;
        }
    }

    /**
     * Created by 현 on 2016-02-05.
     */
    public static class SecondActivity extends AppCompatActivity implements View.OnClickListener {
        private TextView mAgeTextView;
        private TextView mNameTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            mNameTextView = (TextView) findViewById(R.id.name_text_view);
            mAgeTextView = (TextView) findViewById(R.id.age_text_view);

            findViewById(R.id.exit_button).setOnClickListener(this);


            //나를 호출한 Intent 를 얻는다
            Intent intent = getIntent();
            if (intent != null) {
                // 이름 나이를 세팅
                String name = intent.getStringExtra("name");
                String age = intent.getStringExtra("age");

                mNameTextView.setText(mNameTextView.getText().toString() + name);
                mAgeTextView.setText(mAgeTextView.getText().toString() + age);
            }
        }

        @Override
        public void onClick(View v) {
            // 현재 Activity 종료, back key 누른 것과 동일.
    //        Toast.makeText(SecondActivity.this, "종료합니다", Toast.LENGTH_SHORT).show();
    //        finish();
            Intent intent = new Intent();
            intent.putExtra("result", mNameTextView.getText().toString() + ", " +
                    mAgeTextView.getText().toString());

            setResult(MainActivity.RESULT_OK, intent);
        }
    }
}
