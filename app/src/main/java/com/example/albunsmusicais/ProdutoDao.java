package com.example.albunsmusicais;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();


    }

    public long inserir(Produto produto){
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("preco", produto.getPreco());
        values.put("quantidade", produto.getQuantidade());
        return banco.insert("produtos", null, values);
    }

    public List<Produto> obterTodos(){

        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produtos", new String[]{"id", "nome", "preco", "categoria"}, null, null, null, null, null);

        while (cursor.moveToNext()){
        Produto a = new Produto();
        a.setId(cursor.getInt(0));
        a.setNome(cursor.getString(1));
        a.setPreco(cursor.getString(2));
        a.setQuantidade(cursor.getString(3));
        produtos.add(a);

        }

        return produtos;
    }
}
