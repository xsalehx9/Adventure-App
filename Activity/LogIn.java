package com.Horizon_Adventure_App.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.com.Horizon_Adventure_App.Activity.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LogIn extends AppCompatActivity {

    TextInputLayout username;
    TextInputEditText eTextUsername;
    TextInputLayout password;
    TextInputEditText eTextPassword;
    Button ButtonLogIn;
    TextView forgotPass;
    TextView createNeAc;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = findViewById(R.id.Susername);
        eTextUsername = findViewById(R.id.eTextUsername);
        password = findViewById(R.id.editTextPassword_log_in);
        eTextPassword = findViewById(R.id.eTextPassword);
        ButtonLogIn = findViewById(R.id.Login_log_in);
        createNeAc = findViewById(R.id.createNeAc);
        forgotPass = findViewById(R.id.forgotPass);
        myDB = new DBHelper(this);

        createNeAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
            }
        });

        //[On Click Listener]
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://autoridetag.weebly.com/forgot-password.html");
            }
        });

        //Log in page [On Click Listener]
        ButtonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getEditText().getText().toString();
                String pass=password.getEditText().getText().toString();
                if (user.equals(""))
                {
                    Toast.makeText(LogIn.this, "Please enter the credentials", Toast.LENGTH_SHORT).show();
                    username.setHelperText("");
                    username.setError("The username cannot be empty"); //error message if username is empty
                }
                else if (pass.equals(""))
                {
                    Toast.makeText(LogIn.this, "Please enter the credentials", Toast.LENGTH_SHORT).show();
                    password.setHelperText("");
                    password.setError("The password cannot be empty"); //error message if password is empty
                }
                else
                {
                    Boolean result= myDB.checkUsernamePassword(user,pass); //to check if the username and password are available from database
                    if(result==true)
                    {
                        Intent intent=new Intent(getApplicationContext(), HomeScreen.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LogIn.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        username.setHelperText("");
                        username.setError("The username or password is incorrect"); //error message if username or password invalid
                    }

                }
            }
        });

        createNeAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
            }
        });
    }

    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void onbutton2Click(View view) {
        // Intent to open Facebook login webpage
        String facebookUrl = "https://www.facebook.com/login"; // Replace with the actual Facebook login URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
        startActivity(intent);
    }

    public void onbuttonClick(View view) {
        // Intent to open Google login webpage
        String googleUrl = "https://accounts.google.com"; // Replace with the actual Google login URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleUrl));
        startActivity(intent);
    }
}