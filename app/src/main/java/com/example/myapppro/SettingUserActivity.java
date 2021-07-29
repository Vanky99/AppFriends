package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_user);
        getSupportActionBar().hide();

        EditText etOldPassword = (EditText) findViewById(R.id.activity_setting_user_et_old_password);
        EditText etPassword = (EditText) findViewById(R.id.activity_setting_user_et_password);
        EditText etConfirmPassword = (EditText) findViewById(R.id.activity_setting_user_et_confirmpassword);
        Button btnSave = (Button) findViewById(R.id.activity_setting_user_btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = etOldPassword.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                if (password.equals(confirmPassword)) {
                    if (MainActivity.changePassword(oldPassword, password)) {
                        Toast.makeText(getApplicationContext(), "Đổi thành công", Toast.LENGTH_SHORT);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Mật khẩu cũ chưa đúng", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(), "Mật khẩu và nhập lại mật khẩu chưa khớp", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}