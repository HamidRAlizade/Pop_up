package com.example.mylibrary;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class OneButtonDialog extends DialogFragment {
    public static final String TAG = "OneButtonDialogTag";

    protected static final String ARG_BUTTON_TEXT = "ARG_BUTTON_TEXT";
    protected static final String ARG_COLOR_RESOURCE_ID = "ARG_COLOR_RESOURCE_ID";
    protected static final String ARG_TITLE = "ARG_TITLE";
    protected static final String ARG_MESSAGE = "ARG_MESSAGE";
    protected static final String ARG_IMAGE_RESOURCE_ID = "ARG_IMAGE_RESOURCE_ID";
    private ButtonDialogAction buttonDialogAction;
    private static final double DIALOG_WINDOW_WIDTH = 0.85;
    private int getContentView() {
        return R.layout.pop_up;

    }

    public static OneButtonDialog newInstance(@StringRes int titleRes,
                                              @StringRes int messageRes,
                                              @StringRes int buttonTextRes,
                                              @DrawableRes int imageResId,
                                              ButtonDialogAction buttonDialogAction) {
        OneButtonDialog oneButtonDialog = new OneButtonDialog();
        oneButtonDialog.buttonDialogAction = buttonDialogAction;

        Bundle args = new Bundle();
        args.putInt(ARG_TITLE, titleRes);
        args.putInt(ARG_MESSAGE, messageRes);
        args.putInt(ARG_BUTTON_TEXT, buttonTextRes);
        args.putInt(ARG_IMAGE_RESOURCE_ID, imageResId);
//        args.putInt(ARG_COLOR_RESOURCE_ID, colorResId);
        oneButtonDialog.setArguments(args);

        return oneButtonDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getContentView(), container, false);
        TextView butoon =view.findViewById(R.id.finishe);
        butoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setDialogWindowWidth(DIALOG_WINDOW_WIDTH);
    }
    private void setDialogWindowWidth(double width) {
        Window window = getDialog().getWindow();
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().setCancelable(false);

        Point size = new Point();
        Display display;
//        if (window != null) {
//            display = window.getWindowManager().getDefaultDisplay();
//            display.getSize(size);
//            int maxWidth = size.x;
//            window.setLayout((int) (maxWidth* width), WindowManager.LayoutParams.WRAP_CONTENT);
//            window.setGravity(Gravity.CENTER);
//        }



    }

    public void closeDialog() {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
        }
    }
    public void onButtonClicked() {
        closeDialog();
        if(buttonDialogAction != null) {
            buttonDialogAction.onButtonClicked();
        }
    }
    public interface ButtonDialogAction {
        void onButtonClicked();
    }
}
