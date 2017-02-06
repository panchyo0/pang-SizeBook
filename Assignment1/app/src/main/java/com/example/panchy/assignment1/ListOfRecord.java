package com.example.panchy.assignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ListOfRecord extends AppCompatActivity {

    public static final String FILENAME="file.sav";

    private ListView listAll;
    private ArrayList<People> peopleArrayList;
    private ArrayAdapter<People> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listAll=(ListView) findViewById(R.id.ListAll);
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile();

        adapter = new ArrayAdapter<>(this,
                R.layout.list_item,peopleArrayList);
        listAll.setAdapter(adapter);

    }

    private void loadFromFile(){
        try{
            FileInputStream fis=openFileInput(FILENAME);
            BufferedReader in=new BufferedReader(new InputStreamReader(fis));

            Gson gson=new Gson();

            peopleArrayList = gson.fromJson(in, new TypeToken<ArrayList<People>>(){}.getType());

            fis.close();
        }catch (FileNotFoundException e){
            peopleArrayList=new ArrayList<>();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

}
