package com.example.mylibrary;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class Pop_UP extends Dialog implements
        View.OnClickListener {

    public Pop_UP(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_up);

    }

    @Override
    public void onClick(View v) {

    }

}
