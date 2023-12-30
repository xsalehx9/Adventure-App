package com.Horizon_Adventure_App.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.com.Horizon_Adventure_App.Activity.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity
{
    TextInputLayout username;
    TextInputEditText eTextUsername;
    TextInputLayout password;
    TextInputEditText eTextPassword;
    TextInputLayout repassword;
    TextInputEditText eTextRepassword;
    TextInputLayout Phone;
    TextInputEditText eTextphones;
    RadioGroup Gender;
    CheckBox CBSignUp;
    Button sign_up;
    DBHelper myDB;
    TextView Alredy_Register;


    // Pattern for password to be strong
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //username
        username = findViewById(R.id.Susername);
        eTextUsername = findViewById(R.id.eTextUsername);

        //password
        password = findViewById(R.id.editTextPassword_sign_up);
        eTextPassword = findViewById(R.id.eTextPassword_sign_up);

        //Reset the password
        repassword = findViewById(R.id.editTextRePassword_sign_up);
        eTextRepassword = findViewById(R.id.eTextRePassword_sign_up);

        Phone = findViewById(R.id.Phone);
        eTextphones = findViewById(R.id.eTextphone);

        Gender = findViewById(R.id.Genderr);

        CBSignUp = findViewById(R.id.checkBox_SignUp);
        sign_up = findViewById(R.id.button_sign_up);

        //database connecting
        myDB = new DBHelper(this);
        Alredy_Register = findViewById(R.id.Alredy_Register);



        //on click sign up button
        sign_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String user = username.getEditText().getText().toString();
                String pass = password.getEditText().getText().toString();
                String repass = repassword.getEditText().getText().toString();
                String Phones = Phone.getEditText().getText().toString();
                RadioButton CheckGender = findViewById(Gender.getCheckedRadioButtonId());
                String Gender = CheckGender.getText().toString();


                if(CBSignUp.isChecked()){
                if (user.equals("")) //to check if username is empty
                {
                    Toast.makeText(SignUp.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                    username.setHelperText("");
                    username.setError("please Fill username");
                }
                else if (Phones.equals("") || Phones.length() <8 || Phones.length() > 8) //to check if phone is empty or not equal 8 number
                {
                    Toast.makeText(SignUp.this, "please Fill all the fields", Toast.LENGTH_SHORT).show();
                    Phone.setHelperText("");
                    Phone.setError("please Write your phone number");
                }
                else if (pass.equals("")) //to check if password is empty
                {

                    Toast.makeText(SignUp.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                    password.setHelperText("");
                    password.setError("please Write your password");
                }
                else if (pass.length() <= 8) //if character are less than or equal 8 get massage
                {
                    password.setHelperText("");
                    password.setError("please Enter Minimum 8 Char and enter 1 letter and special character");
                }
                else if (!PASSWORD_PATTERN.matcher(pass).matches()) //if password do not include letter and special character get error message
                {
                    password.setHelperText("");
                    password.setError("Password too weak. please Enter at least 1 letter and 1 special character[@#$%^&+=]");
                }
                else if (repass.equals(""))
                {
                    Toast.makeText(SignUp.this, "please Fill all the fields", Toast.LENGTH_SHORT).show();
                    repassword.setHelperText("");
                    repassword.setError("please Write your password");
                }
                else
                {
                    if (pass.equals(repass))
                    {
                        Boolean usercheckResult = myDB.checkUsername(user);
                        if (usercheckResult == false)
                        {
                            Boolean regResult = myDB.insertData(user, pass, Phones, Gender);
                            if (regResult == true)
                            {
                                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                                startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                username.setHelperText("");
                                username.setError("Failed!!. please check your username");
                                password.setHelperText("");
                                password.setError("Failed!!. please check your password");
                            }
                        }
                        else
                        {
                            Toast.makeText(SignUp.this, "User already exists. \n Please Log In", Toast.LENGTH_SHORT).show();
                            username.setHelperText("");
                            username.setError("User name already exists. please try with another one");
                        }
                    }
                    else
                    {
                        Toast.makeText(SignUp.this, "Password not matching.", Toast.LENGTH_SHORT).show();
                        repassword.setHelperText("");
                        repassword.setError("Password not matching.");
                    }
                }
                }
                else // if the checkbox not checked you will get Toast message
                {
                    Toast.makeText(SignUp.this, "Please Check the box to register", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Alredy_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,LogIn.class);
                startActivity(intent);
            }
        });
    }
}