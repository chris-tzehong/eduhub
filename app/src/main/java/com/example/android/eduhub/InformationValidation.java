package com.example.android.eduhub;

import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.android.eduhub.Register.validConfirmPassword;
import static com.example.android.eduhub.Register.validEmail;
import static com.example.android.eduhub.Register.validPassword;

public class InformationValidation {

    public boolean validateBlank(EditText e, TextView t) {
        if (e.getText().toString().length() == 0) {
            t.setText("This field cannot be blank.");
            return false;
        } else {
            return true;
        }
    }

    public boolean validateBlank2(EditText e) {
        if (e.getText().toString().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateEmail(EditText e, TextView t){
        String email = e.getText().toString();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (m.matches() == false) {
            t.setText("This is not a valid email.");
            validEmail = false;
            return false;
        } else {
            validEmail = true;
            return true;
        }
    }

    public boolean validateEmail2(EditText e){
        String email = e.getText().toString();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (m.matches() == false) {
            validEmail = false;
            return false;
        } else {
            validEmail = true;
            return true;
        }
    }

    public boolean validatePasswordLength(EditText e, TextView t){
        String password = e.getText().toString();
        String pPattern = "^.{8,}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pPattern);
        java.util.regex.Matcher m = p.matcher(password);
        if (m.matches() == false) {
            t.setText("Please enter at least 8 characters.");
            validPassword = false;
            return false;
        } else {
            validPassword = true;
            return true;
        }
    }

    public boolean validatePasswordLength2(EditText e){
        String password = e.getText().toString();
        String pPattern = "^.{8,}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pPattern);
        java.util.regex.Matcher m = p.matcher(password);
        if (m.matches() == false) {
            validPassword = false;
            return false;
        } else {
            validPassword = true;
            return true;
        }
    }

//    public boolean validatePasswordCharacter(EditText e, TextView t){
//        String password = e.getText().toString();
//        String pPattern = "^(?=.*[0-9])(?=.*[a-z])$";
//        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pPattern);
//        java.util.regex.Matcher m = p.matcher(password);
//        if (m.matches() == false) {
//            t.setText("Your password must be alphanumeric.");
//            return false;
//        } else {
//            return true;
//        }
//    }

//    public boolean validatePasswordSpace(EditText e, TextView t){
//        String password = e.getText().toString();
//        String pPattern = "^(?=\\\\S+$)$";
//        java.util.regex.Pattern a = java.util.regex.Pattern.compile(pPattern);
//        java.util.regex.Matcher b = a.matcher(password);
//        if (b.matches() == false) {
//            t.setText("Your password must not contain spaces.");
//            return false;
//        } else {
//            return true;
//        }
//    }

    public boolean validateConfirmPassword(EditText e, TextView t, String s) {
        if (e.getText().toString().equals(s) == false) {
            t.setText("Your password does not matches.");
            validConfirmPassword = false;
            return false;
        } else {
            validConfirmPassword = true;
            return true;
        }
    }

    public boolean validateConfirmPassword2(EditText e, String s) {
        if (e.getText().toString().equals(s) == false) {
            validConfirmPassword = false;
            return false;
        } else {
            validConfirmPassword = true;
            return true;
        }
    }
}
