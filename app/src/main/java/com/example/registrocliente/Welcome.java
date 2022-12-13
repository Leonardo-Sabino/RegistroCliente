package com.example.registrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String msg_email = getIntent().getStringExtra(MainActivity.email_message);
        String msg_nome = getIntent().getStringExtra(Second_Reg.nome_message);
    }
}