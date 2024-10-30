package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Retrofit;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText et_username = findViewById(R. id.et_username);
        EditText et_password = findViewById(R. id.et_password);
        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_username.getText().equals("") || et_password.getText().toString().equals("")) {
                    if (et_username.getText().toString().equals("")){
                        et_username.setError("Username harus diisi");
                    }

                    if (et_password.getText().toString().equals("")){
                        et_password.setError("Password harus diisi");
                    }
                }
//                else if (et_username.getText().toString().equals("Admin") && et_password.getText().toString().equals("123")){
//                    // Membuat Intent untuk berpindah dari LoginActivity ke MainActivity
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//
//                    intent.putExtra("username", et_username.getText().toString());
//
//                    startActivity(intent);
//
//                    finish();
//                }
                else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://ap-southeast-1.aws.data.mongodb-api.com/app/application-2024-cyjumrf/endpoint/getPenggunaByUsernamePassword")
                            .build();

//                    Toast.makeText(getApplicationContext(), "Pengguna tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}