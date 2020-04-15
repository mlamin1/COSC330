package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=_])(?=\\S+$).{6,}$");
    private TextView textInputEmail;
    private TextView textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);
    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getText().toString().trim();

        if(emailInput.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputEmail.setError("Please enter a valid email address");
            return false;
        }
        else{
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validatePassword(){
        String passwordInput = textInputPassword.getText().toString().trim();
        if(passwordInput.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            textInputPassword.setError("1 Uppercase, 1 special char, 1 number");
            return false;
        }
        else{
            textInputPassword.setError(null);
            return true;
        }
    }
    public void confirmInput(View view){
        if(!validateEmail() | !validatePassword()){
            return;
        }

        if(textInputEmail.getText().toString().equals("nredmond1@gulls.salisbury.edu")){
            Toast.makeText(this, "Welcome back, Nathan!", Toast.LENGTH_LONG).show();
        }
        if(textInputEmail.getText().toString().equals("mlamin1@gulls.salisbury.edu")){
            Toast.makeText(this, "Welcome back, Muniru!", Toast.LENGTH_LONG).show();
        }

        startActivity(new Intent(MainActivity.this, table_of_contents.class));

        String input = "Email: " + textInputEmail.getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getText().toString();

        //Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        d("clicked", input);
    }
}
