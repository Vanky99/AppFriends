package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        EditText etEmail = (EditText) findViewById(R.id.activity_register_et_email);
        EditText etPassword = (EditText) findViewById(R.id.activity_register_et_password);
        EditText etConfirmPassword = (EditText) findViewById(R.id.activity_register_et_confirmpassword);
        Button btnRegister = (Button) findViewById(R.id.activity_register_btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (password.equals(confirmPassword)) {
                    if (MainActivity.register(email, password)) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Tài khoản đã tồn tại", Toast.LENGTH_LONG);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_LONG);
                }
            }
        });
    }
}