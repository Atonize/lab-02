package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static MainActivity Instance;
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<City> cities;
    ArrayList<String> namesList;

    public static MainActivity getInstance() {
        return Instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Instance = this;

        cityList = findViewById(R.id.city_list);

        //Initial cities
        addCity("Edmonton");
        addCity("Vancouver");
        addCity("Moscow");
        //addCity("Sydney");
        //addCity("Berlin");
        //addCity("Vienna");
        //addCity("Tokyo");
        //addCity("Beijing");
        //addCity("Osaka");
        //addCity("New Delhi");

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCity("City");
            }
        });
    }

    public void addCity(String cityName)
    {
        if (cities == null)
        {
            cities = new ArrayList<City>();
        }

        if (namesList == null)
        {
            namesList = new ArrayList<>();
        }
        City city = new City(cityName);
        cities.add(city);
        namesList.add(cityName);

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, namesList);
        cityList.setAdapter(cityAdapter);
    }
}