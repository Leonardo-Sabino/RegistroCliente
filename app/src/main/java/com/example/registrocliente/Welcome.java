package com.example.registrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String msg_nome = getIntent().getStringExtra(MainActivity.nome_message);
         nome = findViewById(R.id.nome_welcome);
         nome.setText(msg_nome);
    }
}