package com.test.global_test.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.global_test.R;

public class LoginActivity extends AppCompatActivity {

    private TextView forgetpass, user, password;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
//            register = findViewById(R.id.register);
        button = findViewById(R.id.signin);
    }
    private void setupListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();
            }
        });
    }
        void checkUsername() {
            boolean isValid = true;
            if (isEmpty((EditText) user)) {
                user.setError("You must enter username to login!");
                isValid = false;
            } else {
                if (!isEmail((EditText) user)) {
                    user.setError("Enter valid email!");
                    isValid = false;
                }
            }

            if (isEmpty((EditText) password)) {
                password.setError("You must enter password to login!");
                isValid = false;
            } else {
                if (password.getText().toString().length() < 4) {
                    password.setError("Password must be at least 4 chars long!");
                    isValid = false;
                }
            }

            //check email and password
            //IMPORTANT: here should be call to backend or safer function for local check; For example simple check is cool
            //For example simple check is cool
            if (isValid) {
                String usernameValue = user.getText().toString();
                String passwordValue = password.getText().toString();
                if (usernameValue.equals("kj85870@mail.com") && passwordValue.equals("kajal1234")) {
                    //everything checked we open new activity
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                    //we close this activity
                    this.finish();
                } else {
                    Toast t = Toast.makeText(this,"Wrong email or password!",Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        }
            boolean isEmail(EditText text) {
                CharSequence email = text.getText().toString();
                return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            }

            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }
        }

