package com.example.myapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        EditText etEmail = (EditText) findViewById(R.id.activity_login_et_email);
        EditText etPassword = (EditText) findViewById(R.id.activity_login_et_password);
        Button btnLogin = (Button) findViewById(R.id.activity_login_btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (MainActivity.login(email, password)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Email hoặc mật khẩu không đúng", Toast.LENGTH_LONG);
                }
            }
        });
    }
}