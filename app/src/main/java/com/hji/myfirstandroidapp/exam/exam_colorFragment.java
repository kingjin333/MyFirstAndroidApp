package com.hji.myfirstandroidapp.exam;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hji.myfirstandroidapp.R;
import com.hji.myfirstandroidapp.exam_fragment.ColorFragment;

public class exam_colorFragment extends Fragment {

    private ImageView mImageView;

    public exam_colorFragment() {
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
        return inflater.inflate(R.layout.fragment_exam_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageView = (ImageView) view.findViewById(R.id.image_view);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int color = bundle.getInt("color");
            mImageView.setBackgroundColor(color);
        }
    }

    public void setColor(int color) {
        mImageView.setBackgroundColor(color);
    }

}
