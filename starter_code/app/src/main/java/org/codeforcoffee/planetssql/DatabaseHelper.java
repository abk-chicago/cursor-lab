package org.codeforcoffee.planetssql;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by codeforcoffee on 6/22/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Planets.db";

    public static final String CREATE_TABLE = "create table planets(id int primary key, name text, position int, fact text);";
    public static final String DROP_TABLE = "drop table if exists planets;";

    public DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        // new SQLiteOpenHelper(ctx, "Planets.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void createPlanet(int id, String name, int position, String fact) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues planet = new ContentValues();
        planet.put("id", id);
        planet.put("name", name);
        planet.put("position", position);
        planet.put("fact", fact);
        db.insert("planets", null, planet);
    }




    public Planet getPlanetById(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = new String[] { "id" , "name", "position", "fact"};
        String selection = " id = ?";
        String[] SelectionArgs = new String[] {Integer.toString(id)};


        Cursor cursor = db.query("planet", projection, selection, SelectionArgs, null, null, null, null);

        cursor.moveToFirst();

        int planetId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
        String planetName = cursor.getString(cursor.getColumnIndex("name"));
        int planetPosition = Integer.parseInt(cursor.getString(cursor.getColumnIndex("position")));
        String planetFact = cursor.getString(cursor.getColumnIndex("fact"));

        Planet planetList = new Planet(planetId, planetName, planetPosition, planetFact);
        return planetList;

    }


    public void getPlanet() {

    }

    public void removePlanet() {

    }


}
