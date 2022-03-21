package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Secondactivity extends AppCompatActivity {

    TextView name_data,age_data,bio_data,loc_data;
    String name,age,bio,loc,gen;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        name_data = findViewById(R.id.name_data);
        age_data = findViewById(R.id.age_data);
        bio_data = findViewById(R.id.bio_data);
        loc_data = findViewById(R.id.loc_data);
        imageView=findViewById(R.id.img_Avatar);

        Intent intent = getIntent();
        name=intent.getStringExtra(Value.name);
        age=intent.getStringExtra(Value.age);
        bio=intent.getStringExtra(Value.bio);
        loc=intent.getStringExtra(Value.loc);
        gen=intent.getStringExtra(Value.gen);

        if(gen.equals("Male"))
        {
            imageView.setImageResource(R.drawable.male);
        }
        else
        {
            imageView.setImageResource(R.drawable.female);
        }

        name_data.setText("Name :"+name);
        age_data.setText("Age :"+age);
        bio_data.setText("Bio :"+bio);
        loc_data.setText("Location :"+loc);
    }

    public void onclicklogout(View v)
    {
        Intent intent = new Intent(Secondactivity.this,Firstactivity.class);
        startActivity(intent);
    }
}