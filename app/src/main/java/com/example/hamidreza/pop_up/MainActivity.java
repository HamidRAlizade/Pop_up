package com.example.hamidreza.pop_up;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mylibrary.DialogFactory;
import com.example.mylibrary.OneButtonDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OneButtonDialog oneButtonDialog =
                DialogFactory.makeSuccessDialog(R.string.app_name,
                        R.string.app_name,
                        R.string.app_name,
                        new OneButtonDialog.ButtonDialogAction() {
                            @Override
                            public void onButtonClicked() {
                                Toast.makeText(getApplicationContext(),
                                        "Success Dialog", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                            }
                        });
        oneButtonDialog.show(getSupportFragmentManager(), OneButtonDialog.TAG);
    }
}
