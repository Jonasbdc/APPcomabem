package com.example.albunsmusicais;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "bancoDados.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) { super(context, name,  null, version); }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table produtos (id integer primary key autoincrement," +
                "nome varchar(50), preco int, quantidade int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        
    }
}
