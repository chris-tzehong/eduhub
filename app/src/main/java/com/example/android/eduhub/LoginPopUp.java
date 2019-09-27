package com.example.android.eduhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.TextView;

import static com.example.android.eduhub.MainActivity.loginStatus;

public class LoginPopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_pop_up);

        TextView textViewPopUpLogin = findViewById(R.id.textViewPopUpLogin);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        if (loginStatus == 0) {
            textViewPopUpLogin.setText("Please fill in both username and password to login.");
        } else if (loginStatus == 1){
            textViewPopUpLogin.setText("Your username or password is incorrect. Please try again.");
        } else {
            textViewPopUpLogin.setText("You have successfully logged in.");
        }

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.2));
    }
}
