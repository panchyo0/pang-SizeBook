/*
 * Copyright (c) 2017 CMPUT 301. University of Alberta - All rights reserved. You may use,
 * distribute, or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta. You can find a copy of the lisence in this project. Otherwise please
 * contact qpang@ualberta.ca
 */
package com.example.panchy.assignment1;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * This class is the Add to Data base view class of the project. <br> In this class,
 * user can add a new people to record (database) and this new people will become a obj
 * and back to Main Activity.
 *
 * @author pang qi
 * @version 1.1
 * @since 1.0
 */
public class AddToData extends AppCompatActivity {

    private EditText name;
    private EditText date;
    private EditText neck;
    private EditText bust;
    private EditText chest;
    private EditText waist;
    private EditText hip;
    private EditText inseame;
    private EditText comment;
    private Button AddButton;
    private People peopleInformation;

    /**
     * Called when the activity is first created
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_to_data);
        final Calendar c = Calendar.getInstance();

        name = (EditText) findViewById(R.id.AddName);
        date = (EditText) findViewById(R.id.AddData);
        neck = (EditText) findViewById(R.id.AddNeck);
        chest = (EditText) findViewById(R.id.AddChest);
        bust = (EditText) findViewById(R.id.AddBust);
        waist = (EditText) findViewById(R.id.AddWaist);
        hip = (EditText) findViewById(R.id.AddHip);
        inseame = (EditText) findViewById(R.id.AddInseam);
        comment = (EditText) findViewById(R.id.AddComment);

        AddButton = (Button) findViewById(R.id.AddToData);
        AddButton.setOnClickListener(new AddButtonFinal());

        date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog dialog = new DatePickerDialog(AddToData.this, new DatePickerDialog.OnDateSetListener()
                {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        Calendar c = Calendar.getInstance();
                        c.set(year, monthOfYear, dayOfMonth);
                        date.setText(DateFormat.format("yyyy-MM-dd", c));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

    }

    /**
     * this is a override method of addbutton on click listener
     * in this method will get all information from user input
     * and translate it to an people obj. after that will tranfor this
     * obj to main activity.
     */

    class AddButtonFinal implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            setResult(RESULT_OK);

            String nameOfPeople = name.getText().toString();
            String dateOfPeople = date.getText().toString();
            if (dateOfPeople.isEmpty()){dateOfPeople=" ";}
            String neckOfPeople=checkEmpty(neck);
            String chestOfPeople = checkEmpty(chest);
            String bustOfPeople = checkEmpty(bust);
            String waistOfPeople = checkEmpty(waist);
            String hipOfPeople = checkEmpty(hip);
            String inseameOfPeople = checkEmpty(inseame);
            String commentOfPeople = comment.getText().toString();
            if (commentOfPeople.isEmpty()){commentOfPeople=" ";}

            if (nameOfPeople.isEmpty()) {
                Toast.makeText(AddToData.this, "Please enter Name !", Toast.LENGTH_SHORT).show();
            } else {

                peopleInformation = new People(nameOfPeople, dateOfPeople, neckOfPeople, chestOfPeople, bustOfPeople, waistOfPeople, hipOfPeople, inseameOfPeople, commentOfPeople);

                Intent intent = new Intent(AddToData.this, MainActivity.class);
                intent.putExtra("name", new Gson().toJson(peopleInformation));

                setResult(1, intent);

                finish();
            }
        }
    }

    /**
     * check the given edittext is empty or not
     * @param edittext
     * @return
     */

    private String checkEmpty(EditText edittext) {
        if (edittext.getText().toString().isEmpty()) {
            String str = "0";
            return str;
        } else {
            DecimalFormat decimalFormat=new DecimalFormat("0.0");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            float checkDecimal=Float.valueOf(edittext.getText().toString());
            String str=decimalFormat.format(checkDecimal);
            return str;
        }
    }
}