package com.hji.myfirstandroidapp.utils;

import android.content.Intent;
import android.provider.MediaStore;

/**
 * Created by 현 on 2016-03-22.
 */
public class IntentUtil {
    /**
     * 메모리에 저장 된 이미지를 선택하는 Intent
     * @return
     */
    public static Intent getPickImageIntent() {
        return new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

}
    /**
     * 카메라 기동 Intent
     *
     * <pre>
     * 받는 방법
     * Bitmap thumbnail = data.getParcelableExtra("data");
     * </pre>
     *
     * @return
     */
    public static Intent getCameraIntent() {
        return new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    }


    public static Intent sendMessageIntent(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        return intent;
    }

}

