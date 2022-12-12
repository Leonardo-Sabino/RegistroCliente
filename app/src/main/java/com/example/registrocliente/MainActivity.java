package com.example.registrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variaveis para receber os id's

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // para buscar o campo do email e password
        email = findViewById(R.id.insira_seu_email);
        password = findViewById(R.id.insira_pass);
    }

    public void sign_up(View view) {
        Intent intent = new Intent(MainActivity.this, Second_Reg.class);
        startActivity(intent);
    }

    public void login(View view) {

        //para converter para String

        final String mail = email.getText().toString();
        final String pass = password.getText().toString();

        //para verificar se os campos estão em branco

        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)) {
            // msg se os campos ficarem em branco
            Toast.makeText(this, "Os campos não podem ficar vazios, por favor tente novamente!", Toast.LENGTH_LONG).show();
            /*AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
            msg.setMessage("Os campos não podem ficar vazios, por favor tente novamente!");
            msg.show();*/
        }else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) { //para verificar se email esta correto
            Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();

        }else{
            Intent intent = new Intent(MainActivity.this,Welcome.class);
            startActivity(intent);
        }
    }
}
