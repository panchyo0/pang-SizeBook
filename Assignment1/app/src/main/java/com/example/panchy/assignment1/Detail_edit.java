/*
 * Copyright (c) 2017 CMPUT 301. University of Alberta - All rights reserved. You may use,
 * distribute, or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta. You can find a copy of the lisence in this project. Otherwise please
 * contact qpang@ualberta.ca
 */
package com.example.panchy.assignment1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
 * This class is the edit view class of the project. <br> In this class,
 * user can edit an exit record information of people after edit will back
 * to Detail.
 *
 * @author pang qi
 * @version 1.1
 * @since 1.0
 */
public class Detail_edit extends AppCompatActivity {

    private EditText name;
    private EditText date;
    private EditText neck;
    private EditText bust;
    private EditText chest;
    private EditText waist;
    private EditText hip;
    private EditText inseame;
    private EditText comment;

    private Button editCommit;
    private People peopleInformation;

    /**
     * Called when the activity is first created
     * get all edittext and set information. if click editcommit will back to detail and
     * transform the obj of people after edit
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_view);
        final Calendar c = Calendar.getInstance();

        name=(EditText)findViewById(R.id.editName);
        date=(EditText)findViewById(R.id.editDate);
        neck=(EditText)findViewById(R.id.editNeck);
        chest = (EditText) findViewById(R.id.editChest);
        bust = (EditText) findViewById(R.id.editBust);
        waist = (EditText) findViewById(R.id.editWaist);
        hip = (EditText) findViewById(R.id.editHip);
        inseame = (EditText) findViewById(R.id.editInseam);
        comment = (EditText) findViewById(R.id.editComment);

        String peopleJson = getIntent().getExtras().getString("editObj");
        final People newPeople = new Gson().fromJson(peopleJson, People.class);
        name.setText(newPeople.getName());
        date.setText(newPeople.getDate());
        neck.setText(String.valueOf(newPeople.getNeck()));
        chest.setText(String.valueOf(newPeople.getChest()));
        bust.setText(String.valueOf(newPeople.getBust()));
        waist.setText(String.valueOf(newPeople.getWaist()));
        hip.setText(String.valueOf(newPeople.getHip()));
        inseame.setText(String.valueOf(newPeople.getInseam()));
        comment.setText(String.valueOf(newPeople.getComment()));

        date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog dialog = new DatePickerDialog(Detail_edit.this, new DatePickerDialog.OnDateSetListener()
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


        editCommit=(Button) findViewById(R.id.editCommit);
        editCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);

                String nameOfPeople = name.getText().toString();
                String dateOfPeople=date.getText().toString();
                if (dateOfPeople.isEmpty()){dateOfPeople=" ";}
                String neckOfPeople = checkEmpty(neck);
                String chestOfPeople = checkEmpty(chest);
                String bustOfPeople = checkEmpty(bust);
                String waistOfPeople = checkEmpty(waist);
                String hipOfPeople = checkEmpty(hip);
                String inseameOfPeople = checkEmpty(inseame);
                String commentOfPeople=comment.getText().toString();
                if (commentOfPeople.isEmpty()){commentOfPeople=" ";}


                if (nameOfPeople.isEmpty()) {
                    Toast.makeText(Detail_edit.this, "Please enter Name !", Toast.LENGTH_SHORT).show();
                } else {

                    peopleInformation = new People(nameOfPeople, dateOfPeople, neckOfPeople, chestOfPeople, bustOfPeople, waistOfPeople, hipOfPeople, inseameOfPeople, commentOfPeople);


                    Intent intent = new Intent(Detail_edit.this, Detail.class);
                    intent.putExtra("AfterEdit", new Gson().toJson(peopleInformation));

                    setResult(3, intent);

                    finish();
                }
            }
        });


    }

    /**
     *  check the given edittext is empty or not
     * @param edittext
     * @return string with one decimal place
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
