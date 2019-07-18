package com.example.assignment3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list;
        Button add_btn = findViewById(R.id.add_btn);
        Button exit_btn = findViewById(R.id.exit_btn);
        LinearLayout list_linearLayout = findViewById(R.id.list_linearLayout);
        DatabaseHandler databaseHandler1 = new DatabaseHandler(getApplicationContext());

        List<String> listItem_listString0 = databaseHandler1.getAllItems0();
        final String[] listItem_stringArray0 = listItem_listString0.toArray(new String[0]);
        final List<String> listItem_listString1 = databaseHandler1.getAllItems1();
        final String[] listItem_stringArray1 = listItem_listString1.toArray(new String[0]);
        final List<String> listItem_listString2 = databaseHandler1.getAllItems2();
        final String[] listItem_stringArray2 = listItem_listString2.toArray(new String[0]);
        List<String> listItem_listString3 = databaseHandler1.getAllItems3();
        final String[] listItem_stringArray3 = listItem_listString3.toArray(new String[0]);
        List<String> listItem_listString4 = databaseHandler1.getAllItems4();
        final String[] listItem_stringArray4 = listItem_listString4.toArray(new String[0]);

        CustomListAdapter adapter = new CustomListAdapter(this, listItem_stringArray0, listItem_stringArray1, listItem_stringArray2, listItem_stringArray3, listItem_stringArray4);
        list = findViewById(R.id.list1_listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("itemname0", listItem_stringArray0[position]);
                intent.putExtra("itemname1", listItem_stringArray1[position]);
                intent.putExtra("itemname2", listItem_stringArray2[position]);
                intent.putExtra("itemname3", listItem_stringArray3[position]);
                intent.putExtra("itemname4", listItem_stringArray4[position]);
                intent.putExtra("command", "ud");
                startActivity(intent);
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("itemname0", "");
                intent.putExtra("itemname1", "");
                intent.putExtra("itemname2", "");
                intent.putExtra("itemname3", "");
                intent.putExtra("itemname4", "");
                intent.putExtra("command", "add");
                startActivity(intent);

            }
        });

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


    }


    class CustomListAdapter extends ArrayAdapter<String> {
        Activity context;
        String[] itemname0;
        String[] itemname1;
        String[] itemname2;
        String[] itemname3;
        String[] itemname4;

        public CustomListAdapter(Activity _context, String[] _itemname0, String[] _itemname1, String[] _itemname2, String[] _itemname3, String[] _itemname4) {
            super(_context, R.layout.listitem, _itemname0);
            context = _context;
            itemname0 = _itemname0;
            itemname1 = _itemname1;
            itemname2 = _itemname2;
            itemname3 = _itemname3;
            itemname4 = _itemname4;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            TextView textView = rowView.findViewById(R.id.text1_textview);
            textView.setText(itemname0[position]);
            TextView textView2 = rowView.findViewById(R.id.text2_textview);
            textView2.setText(itemname1[position]);

            return rowView;

        }

    }
}

