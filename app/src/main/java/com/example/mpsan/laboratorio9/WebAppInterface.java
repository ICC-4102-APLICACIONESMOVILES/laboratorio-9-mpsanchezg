package com.example.mpsan.laboratorio9;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by mpsan on 05-06-2018.
 */

public class WebAppInterface {
    Context mContext;

    WebAppInterface(Context c){
        mContext = c;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}
