package com.example.android.eduhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.android.eduhub.MainActivity.loginID;
import static com.example.android.eduhub.Register.validBlank1;
import static com.example.android.eduhub.Register.validBlank2;
import static com.example.android.eduhub.Register.validBlank3;
import static com.example.android.eduhub.Register.validBlank4;
import static com.example.android.eduhub.Register.validBlank5;
import static com.example.android.eduhub.Register.validConfirmPassword;
import static com.example.android.eduhub.Register.validData;
import static com.example.android.eduhub.Register.validEmail;
import static com.example.android.eduhub.Register.validPassword;

public class EditProfilePopUp extends AppCompatActivity {

    public static boolean editProfile = false;

    UserDbHelper userDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_profile_pop_up);
        editProfile = true;
        validData = false;
        final EditText editTextNameEditProfile = findViewById(R.id.editTextNameEditProfile);
        final EditText editTextEmailEditProfile = findViewById(R.id.editTextEmailEditProfile);
        final EditText editTextNewPasswordEditProfile = findViewById(R.id.editTextNewPasswordEditProfile);
        final EditText editTextConfirmPasswordEditProfile = findViewById(R.id.editTextConfirmPasswordEditProfile);
        final EditText editTextCurrentPasswordEditProfile = findViewById(R.id.editTextCurrentPasswordEditProfile);
        final InformationValidation iv = new InformationValidation();
        userDb = new UserDbHelper(this);
        final User user = userDb.getUser(loginID);
        validBlank1 = false;
        validBlank2 = false;
        validBlank3 = false;
        validBlank4 = false;
        validBlank5 = false;
        validEmail = false;
        validPassword = false;
        validConfirmPassword = false;

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        editTextNameEditProfile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    if (iv.validateBlank2(editTextNameEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                        validBlank1 = false;
                    } else {
                        validBlank1 = true;
                    }
                }
            }
        });

        editTextEmailEditProfile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    if (iv.validateBlank2(editTextEmailEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Please enter your e-mail.", Toast.LENGTH_SHORT).show();
                        validBlank2 = false;
                    } else if (iv.validateEmail2(editTextEmailEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Please enter a valid e-mail.", Toast.LENGTH_SHORT).show();
                    } else {
                        validBlank2 = true;
                    }
                }
            }
        });

        editTextCurrentPasswordEditProfile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    if (iv.validateBlank2(editTextCurrentPasswordEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Please enter your current password.", Toast.LENGTH_SHORT).show();
                        validBlank3 = false;
                    } else if (iv.validateConfirmPassword2(editTextCurrentPasswordEditProfile, user.getPassword()) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Your password does not match.", Toast.LENGTH_SHORT).show();
                    } else {
                        validBlank3 = true;
                    }
                }
            }
        });

        editTextNewPasswordEditProfile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    if (iv.validateBlank2(editTextNewPasswordEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Please enter your new password.", Toast.LENGTH_SHORT).show();
                        validBlank4 = false;
                    } else if (iv.validatePasswordLength2(editTextNewPasswordEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Password must have at least 8 characters.", Toast.LENGTH_SHORT).show();
                    } else {
                        validBlank4 = true;
                    }
                }
            }
        });

        editTextConfirmPasswordEditProfile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    if (iv.validateBlank2(editTextConfirmPasswordEditProfile) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Please enter your new password again.", Toast.LENGTH_SHORT).show();
                        validBlank5 = false;
                    } else if (iv.validateConfirmPassword2(editTextConfirmPasswordEditProfile, editTextNewPasswordEditProfile.getText().toString()) == false) {
                        Toast.makeText(EditProfilePopUp.this, "Your password does not match.", Toast.LENGTH_SHORT).show();
                    } else {
                        validBlank5 = true;
                    }
                }
            }
        });

        Button btnConfirmEditProfile = findViewById(R.id.btnConfirmEditProfile);
        btnConfirmEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validBlank1 == true && validBlank2 == true && validBlank3 == true && validBlank4 == true &&
                        validBlank5 == true && validEmail == true && validPassword == true && validConfirmPassword == true) {
                    validData = true;
                } else {
                    Toast.makeText(EditProfilePopUp.this, "There are incomplete or invalid field(s).", Toast.LENGTH_SHORT).show();
                    validData = false;
                }

                if (validData == true) {
                    user.setName(editTextNameEditProfile.getText().toString());
                    user.setEmail(editTextEmailEditProfile.getText().toString());
                    user.setPassword(editTextNewPasswordEditProfile.getText().toString());
                    userDb.updateUser(user);
                    Intent i9 = new Intent(EditProfilePopUp.this, ContentMainActivity.class);
                    startActivity(i9);
                }


            }
        });

        Button btnCancelEditProfile = findViewById(R.id.buttonCancelEditProfile);
        btnCancelEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10 = new Intent(EditProfilePopUp.this, ContentMainActivity.class);
                startActivity(i10);
            }
        });

        getWindow().setLayout((int)(width * 0.7), (int)(height * 0.5));
    }
}
