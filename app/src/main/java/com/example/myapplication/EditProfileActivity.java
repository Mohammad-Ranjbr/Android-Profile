package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);

        String fullName = getIntent().getStringExtra(MainActivity.EXTRA_KEY_FULLNAME);

        EditText editText = findViewById(R.id.et_editProfile);
        editText.setText(fullName);
        Button doneButton = findViewById(R.id.btn_editProfile_done);
        doneButton.setOnClickListener(v -> {
            String editedFullName = editText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(MainActivity.EXTRA_KEY_FULLNAME, editedFullName);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }

}