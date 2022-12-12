package com.example.registrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Second_Reg extends AppCompatActivity {
    EditText nome;
    EditText email;
    EditText password;
    EditText conf_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_reg);
        nome = findViewById(R.id.digite_nome);
        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.insira_pass_reg);
        conf_password = findViewById(R.id.conf_pass_reg);
    }

    public void Registrar(View view) {

        final String n = nome.getText().toString();
        final String e = email.getText().toString();
        final String p = password.getText().toString();
        final String c = conf_password.getText().toString();

        // para verficar se os campos estao em branco
        if (TextUtils.isEmpty(n) || TextUtils.isEmpty(e) || TextUtils.isEmpty(p) || TextUtils.isEmpty(c)) {
            Toast.makeText(this, "Os campos não podem ficar vazios!", Toast.LENGTH_LONG).show();
            //para verficar se o nome contem apenas letras
        } else if (!n.matches("^[A-Za-z]+$")) {
            Toast.makeText(this, "Nome não pode conter números ou símbolos!", Toast.LENGTH_LONG).show();
            //para verficar o email
        } else if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) { //para verificar se email esta correto
            Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();
        } else {
            if (!p.equals(c)) {
                //para verificar se as passwords sao iguais
                Toast.makeText(this, "Palavra-passe não correspondem!", Toast.LENGTH_SHORT).show();
                //se elas forem correspondes
            } else {
                //mensagem de bemvindo
                Toast boas = Toast.makeText(getApplicationContext(), "Foi registrado com sucessso! Seja Bem-vindo.", Toast.LENGTH_LONG);
                boas.show();
                // para ir para activity Welcome
                Intent intent = new Intent(Second_Reg.this, Welcome.class);
                startActivity(intent);
            }
        }
    }
}
