package com.example.ster_lenovo.cadernocamera.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

import java.util.ArrayList;
import java.util.List;


public class CadernoDAO extends SQLiteOpenHelper{
    public CadernoDAO(Context context) {
        super(context, "caderno", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql = "CREATE TABLE Caderno (id INTERGER PRIMARY KEY, nome TEXT NOT NULL, instituicao TEXT NOT NULL, orientado TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Caderno";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere (Caderno caderno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", caderno.getNome());
        dados.put("instituicao", caderno.getInstituicao());
        dados.put("orientador", caderno.getOrientador());

        db.insert("Caderno", null, dados);
    }

    public List<Caderno> buscarCadernos(){
        String sql = "SELECT * FROM Caderno;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Caderno> cadernos = new ArrayList<Caderno>();
        while (c.moveToNext()){
            Caderno caderno = new Caderno();
            caderno.setId(c.getLong(c.getColumnIndex("id")));
            caderno.setNome(c.getString(c.getColumnIndex("nome")));
            caderno.setInstituicao(c.getString(c.getColumnIndex("instituicao")));
            caderno.setOrientador(c.getString(c.getColumnIndex("orientador")));

            cadernos.add(caderno);
        }

        c.close();
        return cadernos;
    }
}
