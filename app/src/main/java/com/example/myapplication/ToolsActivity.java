package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tools);

        Button imageButton = findViewById(R.id.btn_tools_image);
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ToolsActivity.this, ImageActivity.class);
            startActivity(intent);
        });

        Button contactsButton = findViewById(R.id.btn_tools_contacts);
        contactsButton.setOnClickListener(v -> {
            Intent intent = new Intent(ToolsActivity.this, ContactsActivity.class);
            startActivity(intent);
        });

    }
}