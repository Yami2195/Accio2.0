package com.example.accio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrazioneActivity extends AppCompatActivity {

    EditText user, email, password, confermPassword;
    Button iscriviti;
    public Persona persona;
    public static final String PERSONA_PATH = "com.example.accio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        user = findViewById(R.id.attrUserReg);
        email = findViewById(R.id.attrEmail);
        password = findViewById(R.id.attrPassReg);
        confermPassword = findViewById(R.id.attrPass);
        iscriviti = findViewById(R.id.login);
        persona = new Persona();

        iscriviti.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(RegistrazioneActivity.this, MainActivity.class);
                if (checkInput()) {
                    UpdatePerson();
                    showResult.putExtra(PERSONA_PATH, persona);
                    startActivity(showResult);
                }
            }
        });
    }

    public void UpdatePerson() {
        this.persona.setUsername(this.user.getText().toString());
        this.persona.setEmail(this.email.getText().toString());
        this.persona.setPassword(this.password.getText().toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkInput(){
        int errors = 0;

        //USERNAME
        if(user.getText().toString().length() == 0){
            errors++;
            user.setError("Inserire Username!");
        }
        else user.setError(null);

        //EMAIL
        if(email.getText().toString().length() == 0 || !email.getText().toString().contains("@") || !email.getText().toString().contains(".")){
            errors++;
            email.setError("Inserire formato email corretto");
        } else email.setError(null);

        //PASSWORD
        if(password.getText().toString().length() == 0){
            errors++;
            password.setError("Inserire la Password");
        } else if(password.getText().toString().length() < 8){
            errors++;
            password.setError("La password deve contenere 10 caratteri!");
        } else password.setError(null);

        //CONFERMA PASSWORD
        if(confermPassword.getText().toString().equals(password.getText().toString()) ){
            confermPassword.setError(null);
        } else {
            errors++;
            confermPassword.setError("Le due password non corrispondono!");
        }

        return errors==0;
    }

}