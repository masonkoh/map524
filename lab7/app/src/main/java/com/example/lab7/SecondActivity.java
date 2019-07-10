package com.example.lab7;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final String[] itemNameLeft = intent.getStringArrayExtra("stringNameLeft");
        final String[] itemDeptLeft = intent.getStringArrayExtra("stringDeptLeft");
        final String[] itemYearLeft = intent.getStringArrayExtra("stringYearLeft");
        final String[] itemNameRight = intent.getStringArrayExtra("stringNameRight");
        final String[] itemDeptRight = intent.getStringArrayExtra("stringDeptRight");
        final String[] itemYearRight = intent.getStringArrayExtra("stringYearRight");

        CustomListAdapterLeft adapterLeft = new CustomListAdapterLeft(this, itemNameLeft);
        CustomListAdapterRight adapterRight = new CustomListAdapterRight(this, itemNameRight);

        ListView listView1 = findViewById(R.id.list_view1);
        ListView listView2 = findViewById(R.id.list_view2);

        listView1.setAdapter(adapterLeft);
        listView2.setAdapter(adapterRight);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemNameLeft[i] != null) {
                    Intent intent = new Intent
                            (SecondActivity.this, DetailActivityLeft.class);
                    intent.putExtra("itemname", itemNameLeft[i]);
                    intent.putExtra("itemdept", itemDeptLeft[i]);
                    intent.putExtra("itemyear", itemYearLeft[i].toString());
                    startActivity(intent);
                }
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemNameRight[i] != null) {
                    Intent intent = new Intent
                            (SecondActivity.this, DetailActivityRight.class);
                    intent.putExtra("itemname2", itemNameRight[i]);
                    intent.putExtra("itemdept2", itemDeptRight[i]);
                    intent.putExtra("itemyear2", itemYearRight[i].toString());
                    startActivity(intent);
                }
            }
        });
    }
}

class CustomListAdapterLeft extends ArrayAdapter<String> {
    private Activity context;
    private String[] name;

    CustomListAdapterLeft(Activity context, String[] name_1) {
        super(context, R.layout.textviewitemleft, name_1);
        this.context = context;
        this.name = name_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitemleft, null, true);
        TextView tvName = rowView.findViewById(R.id.text_view);
        tvName.setText(name[position]);
        return rowView;
    }
}

class CustomListAdapterRight extends ArrayAdapter<String> {
    private Activity context;
    private String[] name;

    CustomListAdapterRight (Activity context, String[] name_1) {
        super(context, R.layout.textviewitemright, name_1);
        this.context = context;
        this.name = name_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitemright, null, true);
        TextView tvName = rowView.findViewById(R.id.text_view2);
        tvName.setText(name[position]);
        return rowView;
    }
}