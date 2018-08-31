package com.example.worldskills.turisapp.sqliteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.turisapp.utilidades.Tablas;

public class ConexionSQLiteOpenHelper extends SQLiteOpenHelper{

    public ConexionSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Tablas.CREAR_TABLA_SITIO);
       /* db.execSQL(Tablas.CREAR_TABLA_HOTEL);
        db.execSQL(Tablas.CREAR_TABLA_RESTAURANTE);

        db.execSQL(Tablas.INSERTAR_SITIO_1);
        db.execSQL(Tablas.INSERTAR_SITIO_2);
        db.execSQL(Tablas.INSERTAR_SITIO_3);
        db.execSQL(Tablas.INSERTAR_SITIO_4);
        db.execSQL(Tablas.INSERTAR_SITIO_5);

        db.execSQL(Tablas.INSERTAR_HOTEL_1);
        db.execSQL(Tablas.INSERTAR_HOTEL_2);
        db.execSQL(Tablas.INSERTAR_HOTEL_3);
        db.execSQL(Tablas.INSERTAR_HOTEL_4);
        db.execSQL(Tablas.INSERTAR_HOTEL_5);

        db.execSQL(Tablas.INSERTAR_RESTAURANTE_1);
        db.execSQL(Tablas.INSERTAR_RESTAURANTE_2);
        db.execSQL(Tablas.INSERTAR_RESTAURANTE_3);
        db.execSQL(Tablas.INSERTAR_RESTAURANTE_4);
        db.execSQL(Tablas.INSERTAR_RESTAURANTE_5);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+Tablas.TABLA_SITIO);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.TABLA_HOTEL);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.TABLA_RESTAURANTE);
        onCreate(db);

    }
}
