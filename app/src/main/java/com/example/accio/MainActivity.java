package com.example.accio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox showPass;
    EditText username, password;
    Button login;
    TextView registrati;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associo alle variabili i propri id
        username = findViewById(R.id.attrUsername);
        password = findViewById(R.id.attrPassword);
        login = findViewById(R.id.login);
        registrati = findViewById(R.id.registrati);
        showPass = findViewById(R.id.checkBox);

        showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regResult = new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(regResult);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(MainActivity.this, MainActivity.class);
                if(checkInput()){
                    startActivity(showResult);
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkInput(){
        int errors = 0;

        if(username.getText().toString().equals(persona.getUsername()) && password.getText().toString().equals(persona.getPassword())){
            username.setError(null);
        } else {
            errors++;
            username.setError("Non corrispondono");

        }

        return errors==0;
    }

}