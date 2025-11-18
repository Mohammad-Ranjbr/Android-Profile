package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_FULLNAME = "fullName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveInformationButton = findViewById(R.id.btn_main_tools);
        saveInformationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ToolsActivity.class);
            startActivity(intent);
        });

        CheckBox androidSkillCheckBox = findViewById(R.id.checkBox_main_android);
        androidSkillCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Android skill is checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Android skill is not checked", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox deepLearningSkillCheckBox = findViewById(R.id.checkBox_main_deepLearning);
        deepLearningSkillCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Deep Learning is checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Deep Learning is not checked", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox uiDesignSkillCheckBox = findViewById(R.id.checkBox_main_uiDesign);
        uiDesignSkillCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Ui Design is checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Ui Design is not checked", Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup_main);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton_main_Tehran) {
                Toast.makeText(MainActivity.this, "Tehran RadioButton is selected", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.radioButton_main_Alborz) {
                Toast.makeText(MainActivity.this, "Alborz RadioButton is selected", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.radioButton_main_Gilan) {
                Toast.makeText(MainActivity.this, "Gilan RadioButton is selected", Toast.LENGTH_SHORT).show();
            }
        });

        Button editProfileButton = findViewById(R.id.btn_main_editProfile);
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditProfileActivity.class); // Explicit Intent -> Specific destination
            //startActivity(intent);
            TextView textView = findViewById(R.id.tv_main_fullName);
            intent.putExtra(EXTRA_KEY_FULLNAME, textView.getText());
            startActivityForResult(intent, 1001);
        });

        Button viewWebsiteButton = findViewById(R.id.btn_main_viewWebSite);
        viewWebsiteButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Mohammad-Ranjbr"));
            startActivity(intent);
        });

        Log.v("M_A", "This is verbose log", new NullPointerException());
        Log.println(Log.ASSERT, "Test", "this is assert log"); //For very catastrophic errors

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK && data != null) {
            String fullName = data.getStringExtra(EXTRA_KEY_FULLNAME);
            TextView textView = findViewById(R.id.tv_main_fullName);
            textView.setText(fullName);
        }
    }

}
