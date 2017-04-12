package com.abdo.gestionetu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 06/03/2016.
 */
public class EtudiantBDD {

    private MaBase MyDbSql;
    private SQLiteDatabase db;
    private ContentValues values;

    public void insertEtudiant(Etudiant m, Context context)
    {

        values.put("NOM", m.getNom());
        values.put("EMAIL", m.getEmail());
        values.put("AGE", m.getAge());
        db.insert("STUDENT", null, values);
        Toast.makeText(context, m.toString() + " a été ajouté.", Toast.LENGTH_SHORT).show();
    }
    public void updateMovie(Etudiant m, String id, Context context)
    {
        String[] s = {String.valueOf(id)};
        values.put("NOM", m.getNom());
        values.put("EMAIL", m.getEmail());
        values.put("AGE", m.getAge());
        db.update("STUDENT", values, "ID=?", s);

        Toast.makeText(context, "L'étudiant a été modifié !", Toast.LENGTH_SHORT).show();
    }

    public void removeMovie(int id, Context context)
    {
        String[] s = {String.valueOf(id)};
        db.delete("STUDENT", "ID=?", s);
        Toast.makeText(context, "L'étudiant a été supprimé .", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Etudiant> getListEtudiant(){
        ArrayList<Etudiant> lm = new ArrayList<Etudiant>();
        Cursor c = db.query("STUDENT", null, null, null, null, null, null);

        Etudiant e;
        while (c.moveToNext()){
            e = new Etudiant(c.getInt(c.getColumnIndex("ID")), c.getString(c.getColumnIndex("NOM")), c.getString(c.getColumnIndex("EMAIL")));
            lm.add(e);
        }
        c.close();
        return lm;
    }

    public Etudiant getEtudiantById(String id)
    {
        String[] s = {String.valueOf(id)};
        Cursor c = db.query("STUDENT", null, "ID=?", s, null, null, null);
        c.moveToNext();
        return new Etudiant(c.getString(c.getColumnIndex("NOM")), c.getString(c.getColumnIndex("EMAIL")),c.getInt(c.getColumnIndex("AGE")));
    }


    public EtudiantBDD(Context context) {
        values = new ContentValues();
        MyDbSql = new MaBase(context);
        db = MyDbSql.getWritableDatabase();
    }
}
