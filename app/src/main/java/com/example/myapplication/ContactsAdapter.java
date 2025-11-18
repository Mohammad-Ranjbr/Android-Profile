package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private final List<String> contacts = new ArrayList<>();

    public ContactsAdapter() {
        List<String> contactsName = List.of("Ruthann Trustrie", "Peadar Dawtrey", "Felipe Bradtke"
                , "Claude Crissil", "Jacky Girardeau", "Rubia Dominguez", "Michaela Churchley"
                , "Harvey Pentelow", "Neilla Langton", "Marco Greaves", "Liz Batchley", "Lamond Littlepage", "Malina Weir"
                , "Tomlin Lenchenko", "Hy Pavelin", "Jenelle Palin", "Damon Knewstubb", "Alex Ivanusyev", "Hamil Callery", "Karol Syer");
        contacts.addAll(contactsName);
    }

    public void addNewContact(String fullName){
        contacts.add(0, fullName);
        notifyItemInserted(0); // For RecyclerView to understand
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final TextView fullNameTv;
        private final TextView firstCharacterTv;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            firstCharacterTv = itemView.findViewById(R.id.tv_contact_firstCharacter);
            fullNameTv = itemView.findViewById(R.id.tv_contact_fullname);
        }

        public void bindContact(String fullName) {
            fullNameTv.setText(fullName);
            firstCharacterTv.setText(fullName.substring(0, 1));
            itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), fullName, Toast.LENGTH_SHORT).show());
        }

    }
}
