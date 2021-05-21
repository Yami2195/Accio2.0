package com.example.accio;

import java.io.Serializable;

public class Persona implements Serializable{

    private String user;
    private String email;
    private String password;

    public Persona(){
        this.user = "";
        this.email = "";
        this.password = "";
    }

    public Persona(String username, String email, String password){
        this.user = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername(){
        return user;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.user = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
