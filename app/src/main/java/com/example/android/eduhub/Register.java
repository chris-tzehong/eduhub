package com.example.android.eduhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    UserDbHelper userDb;
    ProgressDbHelper progressDb;

    public static boolean validData = false;
    public static boolean validBlank1 = false;
    public static boolean validBlank2 = false;
    public static boolean validBlank3 = false;
    public static boolean validBlank4 = false;
    public static boolean validBlank5 = false;
    public static boolean validEmail = false;
    public static boolean validPassword = false;
    public static boolean validConfirmPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button buttonConfirmRegister = findViewById(R.id.buttonConfirmRegister);
        final EditText editTextNameRegister = findViewById(R.id.editTextNameRegister);
        final EditText editTextUserNameRegister = findViewById(R.id.editTextUserNameRegister);
        final EditText editTextEmailRegister = findViewById(R.id.editTextEmailRegister);
        final EditText editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        final EditText editTextConfirmPasswordRegister = findViewById(R.id.editTextConfirmPasswordRegister);
        final RelativeLayout relativeLayoutNameErrorRegister = findViewById(R.id.relativeLayoutNameErrorRegister);
        final RelativeLayout relativeLayoutUserNameErrorRegister = findViewById(R.id.relativeLayoutUserNameErrorRegister);
        final RelativeLayout relativeLayoutEmailErrorRegister = findViewById(R.id.relativeLayoutEmailErrorRegister);
        final RelativeLayout relativeLayoutPasswordErrorRegister = findViewById(R.id.relativeLayoutPasswordErrorRegister);
        final RelativeLayout relativeLayoutConfirmPasswordErrorRegister = findViewById(R.id.relativeLayoutConfirmPasswordErrorRegister);
        final TextView textViewNameErrorRegister = findViewById(R.id.textViewNameErrorRegister);
        final TextView textViewUserNameErrorRegister = findViewById(R.id.textViewUserNameErrorRegister);
        final TextView textViewEmailErrorRegister = findViewById(R.id.textViewEmailErrorRegister);
        final TextView textViewPasswordErrorRegister = findViewById(R.id.textViewPasswordErrorRegister);
        final TextView textViewConfirmPasswordRegister = findViewById(R.id.textViewConfirmPasswordErrorRegister);
        final InformationValidation iv = new InformationValidation();
        userDb = new UserDbHelper(this);
        progressDb = new ProgressDbHelper(this);
        validData = false;


        relativeLayoutNameErrorRegister.setVisibility(View.INVISIBLE);
        relativeLayoutUserNameErrorRegister.setVisibility(View.INVISIBLE);
        relativeLayoutEmailErrorRegister.setVisibility(View.INVISIBLE);
        relativeLayoutPasswordErrorRegister.setVisibility(View.INVISIBLE);
        relativeLayoutConfirmPasswordErrorRegister.setVisibility(View.INVISIBLE);



        editTextNameRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false){
                    if (iv.validateBlank(editTextNameRegister, textViewNameErrorRegister) == false) {
                        relativeLayoutNameErrorRegister.setVisibility(View.VISIBLE);
                        validBlank1 = false;
                    } else {
                        relativeLayoutNameErrorRegister.setVisibility(View.INVISIBLE);
                        validBlank1 = true;
                    }
                }
            }
        });

        editTextUserNameRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false){
                    if (iv.validateBlank(editTextUserNameRegister, textViewUserNameErrorRegister) == false) {
                        relativeLayoutUserNameErrorRegister.setVisibility(View.VISIBLE);
                        validBlank2 = false;
                    } else {
                        relativeLayoutUserNameErrorRegister.setVisibility(View.INVISIBLE);
                        validBlank2 = true;
                    }
                }
            }
        });

        editTextEmailRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false){
                    if (iv.validateBlank(editTextEmailRegister, textViewEmailErrorRegister) == false) {
                        relativeLayoutEmailErrorRegister.setVisibility(View.VISIBLE);
                        validBlank3 = false;
                    } else if (iv.validateEmail(editTextEmailRegister, textViewEmailErrorRegister) == false) {
                        relativeLayoutEmailErrorRegister.setVisibility(View.VISIBLE);
                    } else {
                        relativeLayoutEmailErrorRegister.setVisibility(View.INVISIBLE);
                        validBlank3 = true;
                    }
                }
            }
        });

        editTextPasswordRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false){
                    if (iv.validateBlank(editTextPasswordRegister, textViewPasswordErrorRegister) == false) {
                        relativeLayoutPasswordErrorRegister.setVisibility(View.VISIBLE);
                        validBlank4 = false;
                    } else if (iv.validatePasswordLength(editTextPasswordRegister, textViewPasswordErrorRegister) == false) {
                        relativeLayoutPasswordErrorRegister.setVisibility(View.VISIBLE);
                    } else {
                        relativeLayoutPasswordErrorRegister.setVisibility(View.INVISIBLE);
                        validBlank4 = true;
                    }
                }
            }
        });

        editTextConfirmPasswordRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    if (iv.validateBlank(editTextConfirmPasswordRegister, textViewConfirmPasswordRegister) == false) {
                        relativeLayoutConfirmPasswordErrorRegister.setVisibility(View.VISIBLE);
                        validBlank5 = false;
                    } else if (iv.validateConfirmPassword(editTextConfirmPasswordRegister, textViewConfirmPasswordRegister,
                            editTextPasswordRegister.getText().toString()) == false) {
                        relativeLayoutConfirmPasswordErrorRegister.setVisibility(View.VISIBLE);
                    } else {
                        relativeLayoutConfirmPasswordErrorRegister.setVisibility(View.INVISIBLE);
                        validBlank5 = true;
                    }
                }
            }
        });

        buttonConfirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validBlank1 == true && validBlank2 == true && validBlank3 == true && validBlank4 == true &&
                        validBlank5 == true && validEmail == true && validPassword == true && validConfirmPassword == true) {
                    validData = true;
                }
                if (validData == true){
                    User user = new User(editTextNameRegister.getText().toString(), editTextUserNameRegister.getText().toString(),
                            editTextEmailRegister.getText().toString(), editTextPasswordRegister.getText().toString());
                    userDb.addUser(user);
                    Progress_Achievement progress = new Progress_Achievement(editTextUserNameRegister.getText().toString(), 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0, 0, 0);
                    progressDb.addProgress(progress);
                }
                Intent i3 = new Intent(Register.this, RegisterPopUp.class);
                startActivity(i3);
            }
        });
    }
}
