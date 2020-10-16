package com.example.updatedata.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.updatedata.R;
import com.example.updatedata.apputil.MyDiffUtilCallBack;
import com.example.updatedata.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public HomeRecyclerAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.id.setText(Integer.toString(contact.getId()));
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
       if (payloads.isEmpty())
        super.onBindViewHolder(holder, position, payloads);
       else
       {
           Bundle bundle = (Bundle) payloads.get(0);
           for (String key : bundle.keySet())
           {
               if (key.equals("name")){
                   holder.name.setText(bundle.getString("name"));
               }
               if (key.equals("phone")){
                   holder.phone.setText(bundle.getString("phone"));
               }
           }
       }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_id);
            name = itemView.findViewById(R.id.item_name);
            phone = itemView.findViewById(R.id.item_phone);

        }
    }
    public void updateContacts(ArrayList<Contact> newContacts)
    {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtilCallBack(contacts,newContacts));
        diffResult.dispatchUpdatesTo(this);
        contacts.clear();
        contacts.addAll(newContacts);
    }
}
