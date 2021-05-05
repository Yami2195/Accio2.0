package com.example.accio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView registrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associo alle variabili i propri id
        username = findViewById(R.id.attrUsername);
        password = findViewById(R.id.attrPassword);
        login = findViewById(R.id.login);
        registrati = findViewById(R.id.registrati);

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regResult = new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(regResult);


            }
        });
    }
}