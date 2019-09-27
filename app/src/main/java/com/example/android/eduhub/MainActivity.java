package com.example.android.eduhub;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public static int loginStatus = 0;
    public static String loginID;

    UserDbHelper userDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUserNameLogin = findViewById(R.id.editTextUserNameLogin);
        final EditText editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        TextView textViewRegister = findViewById(R.id.textViewRegister);
        String text = "Need an account? Sign up now!";
        SpannableString ss1 = new SpannableString(text);
        Button btnLogin = findViewById(R.id.btnLogin);
        userDb = new UserDbHelper(this);



        ClickableSpan cs1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                startRegisterActivity();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ss1.setSpan(cs1, 17, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textViewRegister.setText(ss1);
        textViewRegister.setMovementMethod(LinkMovementMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserNameLogin.getText().toString().length() == 0) {
                    loginStatus = 0;
                    Intent i6 = new Intent(MainActivity.this, LoginPopUp.class);
                    startActivity(i6);
                } else {
                    try {
                        User user = userDb.getUser(editTextUserNameLogin.getText().toString());
                        if (user.getPassword().equals(editTextPasswordLogin.getText().toString()) == false) {
                            loginStatus = 1;
                            Intent i6 = new Intent(MainActivity.this, LoginPopUp.class);
                            startActivity(i6);
                        } else {
                            loginStatus = 2;
                        }
                    } catch (RuntimeException e1) {
                        loginStatus = 1;
                        Intent i6 = new Intent(MainActivity.this, LoginPopUp.class);
                        startActivity(i6);
                    }
                }

                if (loginStatus == 2) {
                    loginID = editTextUserNameLogin.getText().toString();

                    Intent i5 = new Intent(MainActivity.this, ContentMainActivity.class);
                    startActivity(i5);
                }


            }
        });

    }

    public void startRegisterActivity() {
        Intent i1 = new Intent(this, Register.class);
        startActivity(i1);
    }










}
