package com.test.global_test.Activity;

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

public class RegisterActivity extends AppCompatActivity {
    private TextView Alreadyhaveanaccount;
    private Button Signin, register;
    private EditText name, phone, email, password, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Signin = findViewById(R.id.signup);
        email = findViewById(R.id.registeremail);
        phone = findViewById(R.id.registerphone);
        confirm = findViewById(R.id.confirmpass);
        Alreadyhaveanaccount = findViewById(R.id.haveaccount);
    }

        private void setupListeners() {
            Signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkDataEntered();
                }
            });
            }

            boolean isEmail(EditText text) {
                CharSequence email = text.getText().toString();
                return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            }

            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }

            void checkDataEntered() {
                if (isEmpty(name)) {
                    name.setError("First name is required");

                }
                if (name.equals("") || password.equals("") || email.equals("")) {
                    Toast.makeText(RegisterActivity.this,"Plz fill all the filds",Toast.LENGTH_SHORT).show();


                    if (isEmail(email) == false) {
                        email.setError("Enter valid email!");
                    }

                }
            }}
