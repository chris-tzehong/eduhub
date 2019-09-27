package com.example.android.eduhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.TextView;
import static com.example.android.eduhub.Register.validData;

public class RegisterPopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register_pop_up);

        TextView textViewPopUpRegister = findViewById(R.id.textViewPopUpRegister);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        if (validData == true) {
            textViewPopUpRegister.setText("Congratulations! You have successfully registered. You will now " +
                    "return to the login page.");
        } else {
            textViewPopUpRegister.setText("There are some incomplete or invalid field(s). Please complete" +
                    " it before clicking on the register button.");
        }

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.2));

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        if (validData == true) {
            Intent i4 = new Intent(RegisterPopUp.this, MainActivity.class);
            startActivity(i4);
        }

    }
}
