package com.example.albunsmusicais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelKt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private Button btnListar;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        btnListar = findViewById(R.id.btnListar1);

        btnListar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(CadastroActivity.this, Listagem.class);
                startActivity(intent);
            }

        });
    }

    public void inserir(View view){
        EditText etNome = findViewById(R.id.editTextNome);
        String nome = etNome.getText().toString();
        EditText etPreco = findViewById(R.id.editTextpreço);
        String preco = etPreco.toString();
        EditText etQuantidade = findViewById(R.id.editTextQuantidade);
        String quantidade = etQuantidade.toString();
        Produto produto = new Produto(nome, preco, quantidade);
        ProdutoDao dao;
        dao = new ProdutoDao(this);
        Long id = dao.inserir(produto);
        Toast.makeText(this, "Produto inserido com ID: " + id, Toast.LENGTH_SHORT).show();
    }
}