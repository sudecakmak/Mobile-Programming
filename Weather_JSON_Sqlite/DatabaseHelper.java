package com.example.weather;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "weather";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_City= "city";
    public static final String COLUMN_WeatherImg= "weather_img";
    public static final String COLUMN_Temperature= "temperature";
    public static final String COLUMN_Weather= "weather";
    public static final String COLUMN_Date= "date";
    public static final String DATABASE_NAME = "weather.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NOTE_CREATE =
            "CREATE TABLE " +TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_City + " TEXT, " +
                    COLUMN_WeatherImg + " TEXT, " +
                    COLUMN_Weather + " TEXT, " +
                    COLUMN_Date+ " TEXT, " +
                    COLUMN_Temperature + " TEXT " +
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

     public void add(String city, String weatherImg, String temperature, String weather, String date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_City, city);
        cv.put(COLUMN_Weather, weather);
        cv.put(COLUMN_Temperature, temperature);
        cv.put(COLUMN_WeatherImg, weatherImg);
        cv.put(COLUMN_Date, date);

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public void update(Weather w) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_City, w.getCity());
        cv.put(COLUMN_WeatherImg, w.getWeatherImg());
        cv.put(COLUMN_Weather, w.getWeather());
        cv.put(COLUMN_Temperature, w.getTemperature());
        cv.put(COLUMN_Date, w.getDate());

        String[] whereArg = {w.getID().toString()};
        db.update(TABLE_NAME, cv,COLUMN_ID + " =?", whereArg);

        db.close();
    }

    public void delete(String weather) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{weather});
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Weather> getList() {

        ArrayList<Weather> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                COLUMN_ID,
                COLUMN_City,
                COLUMN_WeatherImg,
                COLUMN_Weather,
                COLUMN_Temperature,
                COLUMN_Date };

        Cursor c = db.query(TABLE_NAME, projection, null, null, null, null, null);

        while (c.moveToNext()) {
            boolean add = data.add(new Weather(c.getString(c.getColumnIndex(COLUMN_ID)), c.getString(c.getColumnIndex(COLUMN_City)),
                    c.getString(c.getColumnIndex(COLUMN_WeatherImg)),c.getString(c.getColumnIndex(COLUMN_Weather)),
                    c.getString(c.getColumnIndex(COLUMN_Temperature)),c.getString(c.getColumnIndex(COLUMN_Date))));
        }

        c.close();
        db.close();

        return data;
    }
}

