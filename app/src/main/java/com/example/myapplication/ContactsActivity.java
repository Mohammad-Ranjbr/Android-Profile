package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsActivity extends AppCompatActivity implements ContactsAdapter.ContactItemEventListener {

    private EditText fullNameEditText;
    private int editingItemPosition = -1;
    private ImageView addNewContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts);

        ContactsAdapter contactsAdapter = new ContactsAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.rv_contact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(contactsAdapter);

        fullNameEditText = findViewById(R.id.et_contact_contactFullName);
        addNewContactButton = findViewById(R.id.iv_add_contact);
        addNewContactButton.setOnClickListener(v -> {
            if (fullNameEditText.length() > 0) {
                if(editingItemPosition > -1){
                    contactsAdapter.updateContact(fullNameEditText.getText().toString(), editingItemPosition);
                    editingItemPosition = -1;
                    addNewContactButton.setImageResource(R.drawable.ic_add_white_24dp);
                } else {
                    contactsAdapter.addNewContact(fullNameEditText.getText().toString());
                    recyclerView.scrollToPosition(0); //When we add an item, it is not displayed, we have to scroll.
                }
                fullNameEditText.setText("");
            }
        });
    }

    @Override
    public void onItemClick(String fullName, int position) {
        this.editingItemPosition = position;
        fullNameEditText.setText(fullName);
        addNewContactButton.setImageResource(R.drawable.ic_done_white_24dp);
    }

}