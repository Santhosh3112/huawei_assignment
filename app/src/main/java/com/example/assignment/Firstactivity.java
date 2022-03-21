package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Firstactivity extends AppCompatActivity {

    EditText name_edit, age_edit, bio_edit, loc_edit;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_edit = findViewById(R.id.name);
        age_edit = findViewById(R.id.Age);
        bio_edit = findViewById(R.id.Bio);
        loc_edit = findViewById(R.id.location);
        radioGroup = findViewById(R.id.radiogroup);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> radioButton = (RadioButton) group.findViewById(checkedId));

    }

    public void onclickbuttonMethod(View v)
    {

        String name_data = name_edit.getText().toString();
        String age_data = age_edit.getText().toString();
        String bio_data = bio_edit.getText().toString();
        String loc_data = loc_edit.getText().toString();

        int selectedId = radioGroup.getCheckedRadioButtonId();


        if(TextUtils.isEmpty(name_edit.getText().toString()) ||
                TextUtils.isEmpty(age_edit.getText().toString())
                || TextUtils.isEmpty(loc_edit.getText().toString()) ||
                TextUtils.isEmpty(bio_edit.getText().toString()) || selectedId==-1)
        {
            Toast.makeText(Firstactivity.this,"Enter the Field",Toast.LENGTH_LONG).show();
        }

        else
        {
            radioButton = radioGroup.findViewById(selectedId);
            Intent intent = new Intent(Firstactivity.this, Secondactivity.class);
            intent.putExtra(Value.name, name_data);
            intent.putExtra(Value.age, age_data);
            intent.putExtra(Value.bio, bio_data);
            intent.putExtra(Value.loc, loc_data);
            intent.putExtra(Value.gen,radioButton.getText().toString() );
            startActivity(intent);
        }

    }
}