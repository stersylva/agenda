package com.example.ster_lenovo.cadernocamera.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

import java.util.ArrayList;
import java.util.List;

public class CadernoDao extends SQLiteOpenHelper {
    public CadernoDao(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Cadernos (id INTEGER PRIMARY KEY , nome TEXT NOT NULL, instituicao TEXT, orientador TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Cadernos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Caderno caderno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", caderno.getNome());
        dados.put("instituicao", caderno.getInstituicao());
        dados.put("orientador", caderno.getOrientador());

        db.insert("Cadernos", null, dados);
    }

    public List<Caderno> buscarCadernos() {
        String sql = "SELECT * FROM Cadernos;";
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

    public void deleta(Caderno caderno) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {caderno.getId().toString()};
        db.delete("Cadernos", "id = ?", params);
    }
}
