package com.example.aaaaaaaaaaaa;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "person";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_Name= "name";
    public static final String COLUMN_Age= "age";
    public static final String COLUMN_Color= "color";
    public static final String COLUMN_Gender= "gender";
    public static final String DATABASE_NAME = "my_persons.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NOTE_CREATE =
            "CREATE TABLE " +TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_Name + " TEXT, " +
                    COLUMN_Age + " TEXT, " +
                    COLUMN_Color + " TEXT, " +
                    COLUMN_Gender + " TEXT " +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_NOTE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

     public void add(String Name, String Age, String Color, String Gender) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_Name, Name);
        cv.put(COLUMN_Age, Age);
        cv.put(COLUMN_Color, Color);
        cv.put(COLUMN_Gender, Gender);

        db.insert(TABLE_NAME, null, cv);

        db.close();
    }

    public void update(Person person) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_Name, person.getName());
        cv.put(COLUMN_Age, person.getAge());
        cv.put(COLUMN_Color, person.getColor());
        cv.put(COLUMN_Gender, person.getWoman());

        String[] whereArg = {person.getID().toString()};
        db.update(TABLE_NAME, cv,COLUMN_ID + " =?", whereArg);

        db.close();
    }

    public void delete(String person) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{person});
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Person> getList() {

        ArrayList<Person> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                COLUMN_ID,
                COLUMN_Name,
                COLUMN_Age,
                COLUMN_Color,
                COLUMN_Gender };

        Cursor c = db.query(TABLE_NAME, projection, null, null, null, null, null);

        while (c.moveToNext()) {
            boolean add = data.add(new Person(c.getString(c.getColumnIndex(COLUMN_ID)), c.getString(c.getColumnIndex(COLUMN_Name)),c.getString(c.getColumnIndex(COLUMN_Age)),c.getString(c.getColumnIndex(COLUMN_Color)),c.getString(c.getColumnIndex(COLUMN_Gender))));

        }

        c.close();
        db.close();

        return data;
    }
}

