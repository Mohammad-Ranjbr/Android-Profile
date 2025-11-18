package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts);

        ContactsAdapter contactsAdapter = new ContactsAdapter();
        RecyclerView recyclerView = findViewById(R.id.rv_contact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(contactsAdapter);

        EditText fullNameEditText = findViewById(R.id.et_contact_contactFullName);
        ImageView addNewContactButton = findViewById(R.id.iv_add_contact);
        addNewContactButton.setOnClickListener(v -> {
            if (fullNameEditText.length() > 0) {
                contactsAdapter.addNewContact(fullNameEditText.getText().toString());
                recyclerView.scrollToPosition(0); //When we add an item, it is not displayed, we have to scroll.
                fullNameEditText.setText("");
            }
        });

    }
}