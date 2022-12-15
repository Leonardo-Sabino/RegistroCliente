package com.example.registrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Second_Reg extends AppCompatActivity {

    EditText nome, email, password, conf_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_reg);
        nome = findViewById(R.id.digite_nome);
        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.insira_pass_reg);
        conf_password = findViewById(R.id.conf_pass_reg);
    }

    // funcao que da erro se o password tiver menos de 8 charateres
    private void ShowError(EditText password, EditText conf_password, String error) {
        password.setError(error);
        password.requestFocus();
        conf_password.setError(error);
        conf_password.requestFocus();
    }

    //declaração da variavel para passar no intent.putExtra
    public static final String nome_message = "com.example.android.login.extra.Message";

    public void Registrar(View view) {

        final String n = nome.getText().toString();
        final String e = email.getText().toString();
        final String p = password.getText().toString();
        final String c = conf_password.getText().toString();

        User user = new  User(n,e,p);

        // para verficar se os campos estao em branco
        if (TextUtils.isEmpty(n) || TextUtils.isEmpty(e) || TextUtils.isEmpty(p) || TextUtils.isEmpty(c)) {
            Toast.makeText(this, "Os campos não podem ficar vazios!", Toast.LENGTH_LONG).show();
            //para verficar se o nome contem apenas letras
        } else if (!n.matches("^[A-Za-z]+$")) {
            Toast.makeText(this, "Nome não pode conter números ou símbolos!", Toast.LENGTH_LONG).show();
            //para verficar o email
        } else if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) { //para verificar se email esta correto
            Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();
            //para verificar se as passwords sao iguais
        }else if (c.length() < 8 || p.length() < 8) {
                //function para verficar se a password contem pelos menos 8 char
                ShowError(password, conf_password, "Palavra-passe deve conter pelo menos 8 charateres");
        }else if (!p.equals(c)) {
            Toast.makeText(this, "Palavra-passe não correspondem!", Toast.LENGTH_SHORT).show();
            //se elas forem correspondes
        } else {
                if (db.userList.contains(user)) {
                    Toast.makeText(this, "Esse email já foi adicionado", Toast.LENGTH_SHORT).show();
                }
                //para adicionar o nome no array
                else {
                    db.userList.add(user);
                    //mensagem de bemvindo
                    Toast boas = Toast.makeText(getApplicationContext(), "Voce foi registrado com sucesso!", Toast.LENGTH_LONG);
                    boas.show();
                    // para ir para activity Welcome
                    Intent intent = new Intent(Second_Reg.this, MainActivity.class);
                    //para apresentar o nome na activity Welcome
                    intent.putExtra(nome_message, n);
                    //intent para levar o array
                    startActivity(intent);
                }

            }

        }

    }

