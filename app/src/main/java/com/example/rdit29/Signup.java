package com.example.rdit29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText etUsername, etPassword, etCPassword;
    ImageButton ibtnLogin, ibtnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();

        ibtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String cpassword = etCPassword.getText().toString().trim();

                boolean flag = true;

                if(username.isEmpty())
                {
                    etUsername.setError(getString(R.string.username_can_t_be_empty));
                    flag = false;
                }
                if(password.isEmpty())
                {
                    etPassword.setError(getString(R.string.password_can_t_be_empty));
                    flag = false;
                }
                if(cpassword.isEmpty())
                {
                    etCPassword.setError(getString(R.string.confirm_password_can_t_be_empty));
                    flag = false;
                }

                if(flag)
                {
                    if(!password.equals(cpassword))
                    {
                        etCPassword.setError(getString(R.string.password_mis_matched));
                    }
                    else
                    {
                        SharedPreferences sPreferences = getSharedPreferences("USERSFILE",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sPreferences.edit();
                        editor.putString("un", username);
                        editor.putString("pass", password);
                        editor.commit();
                        Toast.makeText(Signup.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                        reDirect();
                    }
                }

            }
        });

        ibtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reDirect();
            }
        });


    }

    public void reDirect()
    {
        Intent i = new Intent(Signup.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void init()
    {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etCPassword = findViewById(R.id.etCPassword);
        ibtnLogin = findViewById(R.id.ibtnLogin);
        ibtnSignup = findViewById(R.id.ibtnSignup);



    }
}