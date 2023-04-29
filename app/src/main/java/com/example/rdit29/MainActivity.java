package com.example.rdit29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    ImageButton ibtnLogin, ibtnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );

        String un;
        String pass;

        SharedPreferences sPref = getSharedPreferences("USERSFILE", MODE_PRIVATE);
        un = sPref.getString("un", "");
        pass = sPref.getString("pass", "");



        init();

        ibtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                boolean flag = false;

                if(username.isEmpty())
                {
                    etUsername.setError("Please enter username");
                    flag = true;
                }

                if(password.isEmpty())
                {
                    etPassword.setError("Please enter password");
                    flag = true;
                }


                if(flag==false)
                {
                    if(un.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Create Account First", Toast.LENGTH_SHORT).show();
                    }

                    if(username.equalsIgnoreCase(un) && password.equals(pass)) {
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        intent.putExtra("un", un);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Userame or password incorrect", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });

        ibtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this, Signup.class));
                 finish();
            }
        });


    }

    public void init()
    {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        ibtnLogin = findViewById(R.id.ibtnLogin);
        ibtnSignup = findViewById(R.id.ibtnSignup);
    }
}