package com.example.panchy.assignment1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;


public class Detail extends AppCompatActivity {

    private Button deleteButton;
    private Button editButton;

    private TextView neckInf;


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


