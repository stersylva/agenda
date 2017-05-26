package com.example.ster_lenovo.cadernocamera.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ster_lenovo.cadernocamera.modelo.Assunto;
import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ster-lenovo on 25/05/2017.
 */

public class AssuntoDao extends SQLiteOpenHelper {

    public AssuntoDao(Context context) {
        super(context, "Agenda", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Assuntos (id INTEGER PRIMARY KEY , assunto TEXT NOT NULL, conteudo TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Assuntos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Assunto assunto) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("assunto", assunto.getAssunto());
        dados.put("conteudo", assunto.getConteudo());

        db.insert("Assuntos", null, dados);
    }

    public List<Assunto> buscarAssunto() {
        String sql = "SELECT * FROM Assuntos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Assunto> assuntos = new ArrayList<Assunto>();
        while (c.moveToNext()){
            Assunto assunto = new Assunto();
            assunto.setId(c.getLong(c.getColumnIndex("id")));
            assunto.setAssunto(c.getString(c.getColumnIndex("assunto")));
            assunto.setConteudo(c.getString(c.getColumnIndex("conteudo")));


            assuntos.add(assunto);
        }
        c.close();
        return assuntos;
    }

    public void deleta(Assunto caderno) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {caderno.getId().toString()};
        db.delete("Cadernos", "id = ?", params);

    }
}
