/*
 * Copyright (c) 2017 CMPUT 301. University of Alberta - All rights reserved. You may use,
 * distribute, or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta. You can find a copy of the lisence in this project. Otherwise please
 * contact qpang@ualberta.ca
 */
package com.example.panchy.assignment1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;

/**
 * This class is showing the detail view class of the project. <br> In this class,
 * user can see a exit record information of people and can delete an exit record. After finish will
 * back to Main Activity.
 *
 * @author pang qi
 * @version 1.1
 * @since 1.0
 */
public class Detail extends AppCompatActivity {

    private Button deleteButton;
    private Button editButton;

    private TextView neckInf;

    /**
     * Called when the activity is first created
     * get all edittext and set information. if click delete, one exit information will delete
     * if click edit will get the view of detail edit activity.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String peopleJson = getIntent().getExtras().getString("peopleObj");
        final People newPeople = new Gson().fromJson(peopleJson, People.class);
        neckInf = (TextView) findViewById(R.id.detail);
        neckInf.setText(newPeople.toString());

        deleteButton = (Button) findViewById(R.id.Delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int namePosition = getIntent().getIntExtra("position", 0);

                Intent intent = new Intent();
                intent.putExtra("delete", namePosition);
                setResult(2, intent);

                finish();
            }
        });

        editButton = (Button) findViewById(R.id.Edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detail.this, Detail_edit.class);
                intent.putExtra("editObj", new Gson().toJson(newPeople));
                startActivityForResult(intent, 3);
            }
        });
    }

    /**
     * in this method will transfor the edit obj which get from detail edit and it position in
     * people array list to main activity
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 3) {

            String peopleJson = data.getExtras().getString("AfterEdit");
            final People EditPeople = new Gson().fromJson(peopleJson, People.class);
            neckInf.setText(EditPeople.toString());

            int EditPosition = getIntent().getIntExtra("position", 0);
            Intent intent = new Intent(Detail.this, MainActivity.class);
            intent.putExtra("AfterEdit", new Gson().toJson(EditPeople));
            intent.putExtra("EditPosition", EditPosition);
            setResult(4, intent);
            finish();
        }
    }

}


