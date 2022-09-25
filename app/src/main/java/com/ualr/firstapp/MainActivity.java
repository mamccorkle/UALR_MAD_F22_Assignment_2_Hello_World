//
//  UALR - MAD - F22 - Assignment 2 - Hello World
//
//  Project: UALR - Mobile Applications Development - Fall 2022 - Assignment 2 - Hello World
//  Created by: Mark McCorkle on 20220924
//  Based on: Code Provided by Dr Ivan Rodriguez-Conde
//
//  IDE:
//     Android Studio Chipmunk | 2021.2.1 Patch 2
//     Build #AI-212.5712.43.2112.8815526, built on July 10, 2022
//     Runtime version: 11.0.12+0-b1504.28-7817840 x86_64
//     VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
//     macOS 11.5.2
//     GC: G1 Young Generation, G1 Old Generation
//     Memory: 2048M
//     Cores: 8
//     Registry: external.system.auto.import.disabled=true
//
package com.ualr.firstapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ualr.firstapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View rootView = mBinding.getRoot();
        setContentView(rootView);
    }

    public void showTextMessage(View view) {
        if (mBinding.userInputET.getText().toString().isEmpty()) {
            // Make user acknowledge that the text has not been entered via an alert dialog box:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
            // Set the Title to the Alert Dialog Box:
            .setTitle(getResources().getString(R.string.alert_dialog_title))

            // Set the Message to the Alert Dialog Box:
            .setMessage(getResources().getText(R.string.alert_dialog_msg))

            // Set the Button Text on the Alert Dialog Box:
            .setPositiveButton(getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Log.d("Button Id", String.valueOf(id));
                    mBinding.userInputET.requestFocus();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        } else {
            // Set the textview label text to the users input:
            mBinding.userMsgTV.setText(mBinding.userInputET.getText().toString());
        }
    }

    public void cleanTextField( View view )
    {
        // Set the userMsgTV to the default message:
        mBinding.userMsgTV.setText(getResources().getString(R.string.default_msg));

        // Clear the input box:
        mBinding.userInputET.getText().clear();
    }
}
