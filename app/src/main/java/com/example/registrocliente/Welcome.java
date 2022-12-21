package com.example.registrocliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.PopupMenu;
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Editar_conta:
                return true;
            case R.id.Deletar_conta:
                return true;
            case R.id.LogOut_conta:
                Intent logOut = new Intent(Welcome.this, MainActivity.class);
                startActivity(logOut);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}
