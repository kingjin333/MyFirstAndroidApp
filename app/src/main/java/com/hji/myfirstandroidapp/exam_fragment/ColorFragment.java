package com.hji.myfirstandroidapp.exam_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hji.myfirstandroidapp.R;

public class ColorFragment extends Fragment {


    private ImageView mImageView;

    public ColorFragment() {
        // Required empty public constructor
    }

    public static ColorFragment newInstance() {
        return new ColorFragment();
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
        mImageView = (ImageView)view.findViewById(R.id.color_image);
        mImageView.setBackgroundColor(Color.RED);
    }
    public void setColor(int color){
        mImageView.setBackgroundColor(color);

    }

}
