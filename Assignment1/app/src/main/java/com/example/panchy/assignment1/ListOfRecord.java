/*
 * Copyright (c) 2017 CMPUT 301. University of Alberta - All rights reserved. You may use,
 * distribute, or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta. You can find a copy of the lisence in this project. Otherwise please
 * contact qpang@ualberta.ca
 */
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

/**
 * This class is the list of record view class of the project. <br> In this class,
 * user can see all exit record information of people. if finish will back
 * to main activity.
 *
 * @author pang qi
 * @version 1.1
 * @since 1.0
 */

public class ListOfRecord extends AppCompatActivity {

    public static final String FILENAME="file.sav";

    private ListView listAll;
    private ArrayList<People> peopleArrayList;
    private ArrayAdapter<People> adapter;

    /**
     * Called when the activity is first created
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listAll=(ListView) findViewById(R.id.ListAll);
    }

    /**
     * when start editixt get all people information from loadfile and
     * update through adapter
     */
    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile();

        adapter = new ArrayAdapter<>(this,
                R.layout.list_item,peopleArrayList);
        listAll.setAdapter(adapter);

    }

    /**
     * Save tweets in file in JSON format.
     * @throws FileNotFoundException if folder doesn't exist
     */

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
