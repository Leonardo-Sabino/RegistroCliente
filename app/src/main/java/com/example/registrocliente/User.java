package com.example.registrocliente;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String pass;

    public  User (String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }
}
