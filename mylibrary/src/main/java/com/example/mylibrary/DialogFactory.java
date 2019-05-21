package com.example.mylibrary;

import android.support.annotation.StringRes;

public class DialogFactory {

    private DialogFactory() {
    }

    public static OneButtonDialog makeSuccessDialog(@StringRes int titleId,
                                                    @StringRes int messageId,
                                                    @StringRes int buttonTextId,
                                                    OneButtonDialog.ButtonDialogAction action) {
        return OneButtonDialog.newInstance(titleId,
                messageId,
                buttonTextId,
                R.drawable.ab,

                action);
    }

    static OneButtonDialog makeErrorDialog(@StringRes int titleId,
                                           @StringRes int messageId,
                                           @StringRes int buttonTextId,
                                           OneButtonDialog.ButtonDialogAction action) {
        return OneButtonDialog.newInstance(titleId,
                messageId,
                buttonTextId,
                R.drawable.ab,
                action);
    }

}