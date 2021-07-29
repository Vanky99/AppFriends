package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class FriendListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        getSupportActionBar().hide();

        ListView lvList = (ListView) findViewById(R.id.activity_friend_list_lv_list);

        List<Friend> friends = MainActivity.getUserFriend();

        FriendListAdapter adapter = new FriendListAdapter(this, friends);

        lvList.setAdapter(adapter);
    }
}