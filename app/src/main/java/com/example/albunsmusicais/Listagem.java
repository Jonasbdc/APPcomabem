package com.example.albunsmusicais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listagem extends AppCompatActivity {

    private ListView listView;
    private ProdutoDao dao;
    private List<Produto> produtos;
    private List<Produto> produtosFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        listView = findViewById(R.id.ListaProdutos);
        dao = new ProdutoDao(this);
        produtos = dao.obterTodos();
        produtosFiltrados.addAll(produtos);
        ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);
        listView.setAdapter(adaptador);

    }
}