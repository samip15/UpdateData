package com.example.updatedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.updatedata.adapter.HomeRecyclerAdapter;
import com.example.updatedata.model.Contact;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HomeRecyclerAdapter recyclerAdapter;
    private Button refreshButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.home_recycler_view);
        refreshButton = findViewById(R.id.bn_refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new HomeRecyclerAdapter(new Contact().getContacts());
        recyclerView.setAdapter(recyclerAdapter);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerAdapter.updateContacts(new Contact().getUpdatedContacts());
            }
        });
    }
}