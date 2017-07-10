package com.tt.circle.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by O on 2017/7/3.
 */

public class WelComeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
