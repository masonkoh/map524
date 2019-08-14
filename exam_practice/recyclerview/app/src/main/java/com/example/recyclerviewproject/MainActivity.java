package com.example.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "example from MainAct...Line11", "example from MainAct...Line12" ));
        exampleList.add(new ExampleItem(R.drawable.ic_gavel, "example from MainAct...Line21", "example from MainAct...Line22"));
        exampleList.add(new ExampleItem(R.drawable.ic_bell, "example from MainAct...Line31", "example from MainAct...Line32"));


    }
}
