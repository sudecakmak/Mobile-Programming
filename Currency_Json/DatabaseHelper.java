package com.example.weather;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "money";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_Currency= "city";
    public static final String COLUMN_ForexSelling= "sell";
    public static final String COLUMN_ForexBuying= "buy";
    public static final String COLUMN_Date= "date";
    public static final String DATABASE_NAME = "money.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NOTE_CREATE =
            "CREATE TABLE " +TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_Currency + " TEXT, " +
                    COLUMN_ForexSelling + " TEXT, " +
                    COLUMN_ForexBuying + " TEXT, " +
                    COLUMN_Date+ " TEXT " +
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

     public void add(String currency, String sell, String buy, String date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_Currency, currency);
        cv.put(COLUMN_ForexSelling, sell);
        cv.put(COLUMN_ForexBuying, buy);
        cv.put(COLUMN_Date, date);

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public void update(Money m) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_Currency, m.getCurrencyName());
        cv.put(COLUMN_ForexSelling, m.getForexSelling());
        cv.put(COLUMN_ForexBuying, m.getForexBuying());
        cv.put(COLUMN_Date, m.getDate());

        String[] whereArg = {m.getID().toString()};
        db.update(TABLE_NAME, cv,COLUMN_ID + " =?", whereArg);

        db.close();
    }

    public void delete(String weather) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{weather});
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Money> getList() {

        ArrayList<Money> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                COLUMN_ID,
                COLUMN_Currency,
                COLUMN_ForexSelling,
                COLUMN_ForexBuying,
                COLUMN_Date };

        Cursor c = db.query(TABLE_NAME, projection, null, null, null, null, null);

        while (c.moveToNext()) {
            boolean add = data.add(new Money(c.getString(c.getColumnIndex(COLUMN_ID)), c.getString(c.getColumnIndex(COLUMN_Currency)),
                    c.getString(c.getColumnIndex(COLUMN_ForexSelling)),c.getString(c.getColumnIndex(COLUMN_ForexBuying)),
                    c.getString(c.getColumnIndex(COLUMN_Date))));
        }

        c.close();
        db.close();

        return data;
    }
}

