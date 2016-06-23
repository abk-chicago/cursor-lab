package org.codeforcoffee.planetssql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mLvPlanet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.createPlanet(1, "Mercury", 1, "pure metal core");
        db.createPlanet(2, "Venus", 2, "very strong electrical field");
        db.createPlanet(3, "Mars", 4, "1 ice cap is water, 1 ice cap is co2");
        db.createPlanet(4, "Jupiter", 5, "insane radiation; no landing on europa");
        db.createPlanet(5, "Uranus", 7, "lopsided tilt; as if it were drunk?");
        db.createPlanet(6, "Earth", 3, "our only fucking shot");
        db.createPlanet(7, "Saturn", 6, "2 moons capable of organic life");
        db.createPlanet(8, "Neptune", 8, "is a big, badass, methane, mofo");

        //Planet firstPlanet = db.getPlanetById(1);



        ArrayList<String> planets = new ArrayList<>();
        planets = db.showPlanetsAll();
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets);
        listView.setAdapter(arrayAdapter);


    };

}
