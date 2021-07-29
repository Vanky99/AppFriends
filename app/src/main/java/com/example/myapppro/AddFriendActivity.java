package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        getSupportActionBar().hide();

        EditText etName = (EditText) findViewById(R.id.activity_add_friend_et_name);
        EditText etDob = (EditText) findViewById(R.id.activity_add_friend_et_dob);
        RadioButton rbMale = (RadioButton) findViewById(R.id.activity_add_friend_rb_male);
        RadioButton rbFemale = (RadioButton) findViewById(R.id.activity_add_friend_rb_female);
        EditText etAddress = (EditText) findViewById(R.id.activity_add_friend_et_address);
        Button btnAdd = (Button) findViewById(R.id.activity_add_friend_btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String dob = etDob.getText().toString();
                boolean gender = rbMale.isChecked() ? false : true;
                String address = etAddress.getText().toString();
                if (!name.isEmpty() && !dob.isEmpty() && !address.isEmpty()) {
                    MainActivity.addFriend(name, dob, gender, address);
                    Intent intent = new Intent(getApplicationContext(), FriendListActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}