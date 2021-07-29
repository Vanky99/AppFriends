package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<User> users = new ArrayList<>();
    private static User user;
    private static List<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        LinearLayout llAddFriend = (LinearLayout) findViewById(R.id.activity_main_ll_add_friend);
        LinearLayout llViewFriend = (LinearLayout) findViewById(R.id.activity_main_ll_view_friend);
        LinearLayout llSetting = (LinearLayout) findViewById(R.id.activity_main_ll_setting);
        LinearLayout llLogout = (LinearLayout) findViewById(R.id.activity_main_ll_logout);
        TextView tvName = (TextView) findViewById(R.id.activity_main_tv_name);

        tvName.setText(user.getEmail());

        llAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddFriendActivity.class);
                startActivity(intent);
            }
        });

        llViewFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FriendListActivity.class);
                startActivity(intent);
            }
        });

        llSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingUserActivity.class);
                startActivity(intent);
            }
        });

        llLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.logout();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public static boolean login(String email, String password) {
        for (int i = 0; i < users.size(); i++)
            if ( email.equals(users.get(i).getEmail()) && password.equals(users.get(i).getPassword()) ) {
                user = users.get(i);
                return true;
            }
        return false;
    }

    public static boolean register(String email, String password) {
        if (login(email, password))
            return false;
        MainActivity.addUser(email, password);
        return true;
    }

    public static void logout() {
        user = null;
    }

    public static void addUser(String email, String password) {
        users.add(new User(email, password));
    }

    public static void addFriend(String name, String dob, boolean gender, String address) {
        if (user != null)
            friends.add(new Friend(user.getId(), name, dob, gender, address));
    }

    public static List<Friend> getUserFriend() {
        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < MainActivity.friends.size(); i++)
            if (MainActivity.friends.get(i).getUserId() == user.getId())
                friends.add(MainActivity.friends.get(i));
        return friends;
    }

    public static boolean changePassword(String oldPassword, String newPassword) {
       if (oldPassword.equals(user.getPassword())) {
           user.setPassword(newPassword);
           return true;
       }
       return false;
    }

    public static boolean deleteFriend(int id) {
        for (int i = 0; i < friends.size(); i++)
            if (friends.get(i).getUserId() == user.getId()) {
                friends.remove(i);
                return true;
            }
        return false;
    }
}