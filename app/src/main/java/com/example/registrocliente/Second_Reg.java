package com.example.registrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Second_Reg extends AppCompatActivity {
        EditText nome;
        EditText email;
        EditText password;
        EditText conf_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_reg);
    }

    public void Registrar(View view) {
        nome = findViewById(R.id.digite_nome);
        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.insira_pass_reg);
        conf_password = findViewById(R.id.conf_pass_reg);

        final String n = nome.getText().toString();
        final String e = email.getText().toString();
        final String p = password.getText().toString();
        final String c = conf_password.getText().toString();

        if (TextUtils.isEmpty(n) || TextUtils.isEmpty(e) || TextUtils.isEmpty(p) || TextUtils.isEmpty(c)) {
            // msg se os campos ficarem em branco
            AlertDialog.Builder msg = new AlertDialog.Builder(Second_Reg.this);
            msg.setMessage("Os campos não podem ficar vazios, por favor tente novamente!");
            msg.show();
        }
        else{
            Toast boas = Toast.makeText(getApplicationContext(),"Foi registrado com sucessso! Seja Bem-vindo.",Toast.LENGTH_LONG);
            boas.show();

            Intent intent = new Intent(Second_Reg.this,Welcome.class);
            startActivity(intent);


        }
    }
}