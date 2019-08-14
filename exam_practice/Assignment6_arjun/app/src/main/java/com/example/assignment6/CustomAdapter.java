package com.example.assignment6;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

class CustomListAdapter extends ArrayAdapter<String> {
    Activity context;
    List<String> list_;

    public CustomListAdapter(Activity activity, List<String> list) {
        super(activity, R.layout.quake_item, list);
        this.context = activity;
        this.list_ = list;
    }

    @NonNull
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        View rowView = this.context.getLayoutInflater().inflate(R.layout.quake_item, null, true);
        StringTokenizer tokens = new StringTokenizer((String) this.list_.get(position), "@@");
        String titleToken = tokens.nextToken();
        String timeToken = tokens.nextToken();
        String urlToken = tokens.nextToken();
        String latitudeToken = tokens.nextToken();
        String longitudeToken = tokens.nextToken();
        String magnitudeToken = tokens.nextToken();

        TextView textInfo = rowView.findViewById(R.id.textViewDate);
        textInfo.setText(new Date(Long.parseLong(timeToken)).toString());
        TextView textViewTitle = rowView.findViewById(R.id.textViewTitle);
        textViewTitle.setText(titleToken);
        TextView textViewURL = rowView.findViewById(R.id.textViewURL);
        textViewURL.setText(urlToken);

        Double magDouble = Double.valueOf(Double.parseDouble(magnitudeToken));
        if (magDouble.doubleValue() >= 7.5d) {
            textInfo.setBackgroundColor(Color.parseColor("#ff5f56"));
            textViewTitle.setBackgroundColor(Color.parseColor("#ff5f56"));
        }

        ((TextView) rowView.findViewById(R.id.textViewLatitude)).setText(latitudeToken);
        ((TextView) rowView.findViewById(R.id.textViewLongitude)).setText(longitudeToken);
        return rowView;
    }
}
