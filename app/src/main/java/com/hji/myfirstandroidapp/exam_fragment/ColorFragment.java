package com.hji.myfirstandroidapp.exam_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hji.myfirstandroidapp.R;

public class ColorFragment extends Fragment {

    private ColorDataReceiveListener mListener;
    // callback만들때는 무조건 인터페이스를 사용해서 레퍼런스 참조.
    public interface ColorDataReceiveListener {
        void onDataReceive(String data);
    }


    private ImageView mImageView;

    public ColorFragment() {
        // Required empty public constructor
    }

    public static ColorFragment newInstance(int color) {
        ColorFragment fragment = new ColorFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("color", color);

        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = (ImageView) view.findViewById(R.id.color_image);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int color = bundle.getInt("color");
            mImageView.setBackgroundColor(color);

            // Activity로 callback 발생 시킴
            if (mListener != null) {
                mListener.onDataReceive(String.valueOf(color));
            }
        }
    }
    public void setColor(int color) {
        mImageView.setBackgroundColor(color);


    }

    public void setOnColorDataReceiveListener(ColorDataReceiveListener listener) {
        mListener = listener;

    }
}