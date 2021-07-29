package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().hide();

        LinearLayout llAddFriend = (LinearLayout) findViewById(R.id.activity_account_ll_add_friend);
        LinearLayout llViewFriend = (LinearLayout) findViewById(R.id.activity_account_ll_view_friend);
        LinearLayout llSetting = (LinearLayout) findViewById(R.id.activity_account_ll_setting);
        LinearLayout llLogout = (LinearLayout) findViewById(R.id.activity_account_ll_logout);
    }
}