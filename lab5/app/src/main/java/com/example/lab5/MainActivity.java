package com.example.lab5;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // arrays for LEFTSIDE LISTVIEW
    String[] arrayTextLeft1 = {"santa", "rain", "picket", "space", "foreign", "flower", "snow", "skull", "flower",
            "libra", "teddy", "diamond"};
    String[] arrayTextLeft2 = {"claus", "umbrella", "fence", "ship", "passport", "icon", "man", "bones", "pot", "scale", "bear", "ring"};
    Integer[] arrayImgLeft = {R.drawable.santa, R.drawable.umbrella, R.drawable.fence, R.drawable.spaceship, R.drawable.passport, R.drawable.flower,
            R.drawable.snowman, R.drawable.skull, R.drawable.flower2, R.drawable.scale, R.drawable.bear, R.drawable.diamond};

    // arrays for RIGHTSIDE LISTVIEW
    String[] arrayTextRight1 = {"cigarette", "house", "desk", "magic", "light", "hand", "acoustic", "smocking", "hair", "snoopy", "stop", "floppy"};
    String[] arrayTextRight2 = {
            "lighter", "home", "lamp", "man", "bulb", "cuffs", "guitar", "gun", "dryer", "dog", "watch", "disk"};
    String[] arrayTextRight3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    Integer[] arrayImgRight = {R.drawable.cigarette, R.drawable.house, R.drawable.desk, R.drawable.magic, R.drawable.light, R.drawable.hand,
            R.drawable.acoustic, R.drawable.smocking, R.drawable.hair, R.drawable.dog, R.drawable.stop, R.drawable.floppy};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview_left = findViewById(R.id.listview_left);
        ListView listview_right = findViewById(R.id.listview_right);

        CustomListAdapter1 adapter1 = new CustomListAdapter1(this, arrayTextLeft1, arrayTextLeft2, arrayImgLeft);
        CustomListAdapter2 adapter2 = new CustomListAdapter2(this, arrayTextRight1, arrayTextRight2, arrayTextRight3, arrayImgRight);
        listview_left.setAdapter(adapter1);
        listview_right.setAdapter(adapter2);

        listview_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity1.class);
                intent.putExtra("itemname1", arrayTextLeft1[position]);
                intent.putExtra("itemname2", arrayTextLeft2[position]);
                intent.putExtra("imgid", arrayImgLeft[position].toString());
                startActivity(intent);
            }
        });


        listview_right.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity2.class);
                intent.putExtra("itemname1", arrayTextRight1[position]);
                intent.putExtra("itemname2", arrayTextRight2[position]);
                intent.putExtra("itemname3", arrayTextRight3[position]);
                intent.putExtra("imgid", arrayImgRight[position]);
                startActivity(intent);
            }
        });
    }
}/**/


class CustomListAdapter1 extends ArrayAdapter<String> {
    private Activity context;
    private String[] name1;
    private String[] name2;
    private Integer[] image;

    CustomListAdapter1(Activity context, String[] name_1, String[] name_2, Integer[] image_1) {
        super(context, R.layout.textviewitem1, name_1);
        this.context = context;
        this.name1 = name_1;
        this.name2 = name_2;
        this.image = image_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitem1, null, true);
        TextView textview1_leftside = rowView.findViewById(R.id.textview1_leftside);
        TextView textview2_leftside = rowView.findViewById(R.id.textview2_leftside);
        ImageView imageview1_leftside = rowView.findViewById(R.id.imageview_leftside);

        textview1_leftside.setText(name1[position]);
        textview2_leftside.setText(name2[position]);
        imageview1_leftside.setImageResource(image[position]);

        return rowView;
    }
}

class CustomListAdapter2 extends ArrayAdapter<String> {
    private Activity context;
    private String[] name1;
    private String[] name2;
    private String[] name3;
    private Integer[] image;

    CustomListAdapter2(Activity context, String[] name_1, String[] name_2, String[] name_3, Integer[] image_1) {
        super(context, R.layout.textviewitem1, name_1);
        this.context = context;
        this.name1 = name_1;
        this.name2 = name_2;
        this.name3 = name_3;
        this.image = image_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitem2, null, true);
        TextView textview1_rightside = rowView.findViewById(R.id.textview1_rightside);
        TextView textview2_rightside = rowView.findViewById(R.id.textview2_rightside);
        TextView textview3_rightside = rowView.findViewById(R.id.textview3_rightside);
        ImageView imageview_rightside = rowView.findViewById(R.id.imageview_rightside);

        textview1_rightside.setText(name1[position]);
        textview2_rightside.setText(name2[position]);
        textview3_rightside.setText(name3[position]);
        imageview_rightside.setImageResource(image[position]);

        return rowView;
    }
}