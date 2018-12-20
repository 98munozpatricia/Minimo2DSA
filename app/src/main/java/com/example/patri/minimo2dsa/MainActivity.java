package com.example.patri.minimo2dsa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private APIRest myapirest;
    private String token;
    private String message;
    ProgressDialog progressDialog;
    ImageView ivImageFromUrl;
    TextView textViewFollowing;
    TextView textViewRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
