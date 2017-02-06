package com.example.panchy.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView myText;
    private Button RecordButton;
    private Button AddButton;

    private ListView listView;
    private List<People> peopleList;
    private PeopleAdapter adapter;

    private ArrayList<People> peopleArrayList;
    public static final String FILENAME="file.sav";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView) findViewById(R.id.MyTitle);
        RecordButton = (Button) findViewById(R.id.RecordButton);
        AddButton =(Button) findViewById(R.id.AddButton);
        listView=(ListView) findViewById(R.id.listName);


        myText.setTextSize(30);

        RecordButton.setText(R.string.Records);
        AddButton.setText(R.string.Add);

        peopleList=new ArrayList<>();




        adapter=new PeopleAdapter(getApplicationContext(),peopleList);
        listView.setAdapter(adapter);

        loadFromFile();
        peopleList.addAll(peopleArrayList);
        myText.setText("Dimensions of "+peopleArrayList.size()+" customers");
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Detail.class);
                intent.putExtra("position",position);

                intent.putExtra("peopleObj",new Gson().toJson(peopleArrayList.get(position)));
                startActivityForResult(intent,2);
            }
        });

    }


    public void AddNew(View view){

        startActivityForResult(new Intent(MainActivity.this,AddToData.class),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==1) {
            loadFromFile();
            if (data == null) {
                Toast.makeText(MainActivity.this, "Please add new people!", Toast.LENGTH_SHORT).show();

            } else {
                String peopleJson = data.getExtras().getString("name");
                People newPeople = new Gson().fromJson(peopleJson, People.class);
                peopleArrayList.add(newPeople);

                peopleList.add(newPeople);
                myText.setText("Dimensions of "+peopleArrayList.size()+" customers");
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        }
        if (resultCode==2) {

            loadFromFile();
            int message = data.getExtras().getInt("delete");

            peopleArrayList.remove(message);
            peopleList.remove(message);
            myText.setText("Dimensions of "+peopleArrayList.size()+" customers");
            adapter.notifyDataSetChanged();
            saveInFile();

        }
        if (resultCode==4){
            loadFromFile();
            int AfterEditPosition=data.getExtras().getInt("EditPosition");
            String peopleJson = data.getExtras().getString("AfterEdit");
            People newPeople = new Gson().fromJson(peopleJson, People.class);
            peopleArrayList.set(AfterEditPosition,newPeople);
            peopleList.set(AfterEditPosition,newPeople);
            myText.setText("Dimensions of "+peopleArrayList.size()+" customers");
            adapter.notifyDataSetChanged();
            saveInFile();

        }

    }

    public void ListAll(View view){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,ListOfRecord.class);
        MainActivity.this.startActivity(intent);


    }


    private void saveInFile(){
        try{
            FileOutputStream fos= openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();

            gson.toJson(peopleArrayList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException();
        }catch (IOException e){
            throw new RuntimeException();
        }
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
