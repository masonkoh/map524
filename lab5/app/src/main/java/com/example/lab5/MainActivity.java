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

    String[] arrayTextLeft1 = {"santa", "rain", "picket", "space", "foreign", "flower", "snow", "skull", "flower",
            "libra", "teddy", "diamond"};
    String[] arrayTextLeft2 = {"claus", "umbrella", "fence", "ship", "passport", "icon", "man", "bones", "pot", "scale", "bear", "ring"};
    Integer[] arrayImgLeft = {R.drawable.santa, R.drawable.umbrella, R.drawable.fence, R.drawable.spaceship, R.drawable.passport, R.drawable.flower,
            R.drawable.snowman, R.drawable.skull, R.drawable.flower2, R.drawable.scale, R.drawable.bear, R.drawable.diamond};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview_left = findViewById(R.id.listview_left);
        ListView listview_right = findViewById(R.id.listview_right);

        CustomListAdapter1 adapter1 = new CustomListAdapter1(this, arrayTextLeft1, arrayImgLeft);
        listview_left.setAdapter(adapter1);

        listview_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("itemname", arrayTextLeft1[position]);
                intent.putExtra("imgid", arrayImgLeft[position]);
                startActivity(intent);
            }
        });
    }
}


class CustomListAdapter1 extends ArrayAdapter<String> {
    private Activity context;
    private String[] name;
    private Integer[] image;

    CustomListAdapter1(Activity context, String[] name_1, Integer[] image_1) {
        super(context, R.layout.textviewitem, name_1);
        this.context = context;
        this.name = name_1;
        this.image = image_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitem, null, true);
        TextView tvName = rowView.findViewById(R.id.text_view1);
        ImageView imageView = rowView.findViewById(R.id.image_view);
        tvName.setText(name[position]);
        imageView.setImageResource(image[position]);
        return rowView;
    }
}