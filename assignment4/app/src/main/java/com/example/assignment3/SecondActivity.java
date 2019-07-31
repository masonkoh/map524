package com.example.assignment3;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;


public class SecondActivity extends AppCompatActivity {


    String string1;
    String imgDecodableString;
    public static String stringDataName64_string;
    Boolean bool_spinner = true;
    ImageView image;
    byte[] imageArray = null;
    EditText city_editText;
    EditText name_editText;
    EditText sport_editText;
    EditText mvp_editText;
    Button submit_btn;
    Button exit_btn;
    Button update_btn;
    Button delete_btn;
    LinearLayout upper_linearlayout;
    LinearLayout lower_linearlayout;
    Spinner spinner1;
    TextView textviewSpinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("mklog", "hellooooo SecondActivity.java started!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        city_editText = findViewById(R.id.city_editText);
        name_editText = findViewById(R.id.name_editText);
        sport_editText = findViewById(R.id.sport_editText);
        mvp_editText = findViewById(R.id.mvp_editText);
//        final EditText stadium_editText = findViewById(R.id.stadium_editText);
        submit_btn = findViewById(R.id.submit_btn);
        exit_btn = findViewById(R.id.exit_btn);
        update_btn = findViewById(R.id.update_btn);
        delete_btn = findViewById(R.id.delete_btn);
        upper_linearlayout = findViewById(R.id.upper_linearlayout);
        lower_linearlayout = findViewById(R.id.lower_linearlayout);

        //assignment4 code
        spinner1 = findViewById(R.id.sport_spinner);
        textviewSpinner1 = findViewById(R.id.textSpinner);
        bool_spinner = false; // looks stupid but i will put this here

        List<String> spinList = Arrays.asList("", "Baseball", "Basketball", "Football", "Hockey");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinList);
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                string1 = parent.getItemAtPosition(position).toString();
                if (bool_spinner) {
                    textviewSpinner1.setText(string1);
                }
                bool_spinner = true;
                if (string1.length() > 2) {
                    textviewSpinner1.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // assignment 4 code
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler delete_DatabaseHandler = new DatabaseHandler(getApplicationContext());
                delete_DatabaseHandler.deleteItem(city_editText.getText().toString());
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                Log.d("mklog...:", "right before executing 'startActivity' in delete_btn!!");
                startActivity(intent);
            }
        });
        // assignment 4 code
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler update_DatabaseHandler = new DatabaseHandler(getApplicationContext());
                String item0 = city_editText.getText().toString();
                String item1 = name_editText.getText().toString();
                String item2 = string1;
                String item3 = mvp_editText.getText().toString();

                Bitmap bitmap2 = ((BitmapDrawable) image.getDrawable()).getBitmap();
                ByteArrayOutputStream update_byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG, 20, update_byteArrayOutputStream);
                imageArray = update_byteArrayOutputStream.toByteArray();
                String base64_string = Base64.encodeToString(imageArray, Base64.DEFAULT);

                if (item0.length() > 0) {
                    update_DatabaseHandler.deleteItem(item0);
                    update_DatabaseHandler.insertItem(item0, item1, item2, item3, base64_string);
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        });

        image = findViewById(R.id.userImage_imageview);
        Button uploadimage_btn = findViewById(R.id.uploadimage_btn);
        uploadimage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 100);
            }
        });


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler databaseHandler2 = new DatabaseHandler(getApplicationContext());
                String item0 = city_editText.getText().toString();
                String item1 = name_editText.getText().toString();
//                String item2 = sport_editText.getText().toString();
                String item2 = string1;
                String item3 = mvp_editText.getText().toString();
//                String item4 = stadium_editText.getText().toString();

                Bitmap bitmap2 = ((BitmapDrawable) image.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream1);
                imageArray = byteArrayOutputStream1.toByteArray();
                String base64_string = Base64.encodeToString(imageArray, Base64.DEFAULT);


//                if (item0.length() != 0 && item1.length() != 0) {
                if (item0.length() != 0) {
                    databaseHandler2.insertItem(item0, item1, item2, item3, base64_string);
                    city_editText.setText("");
                    name_editText.setText("");
                    sport_editText.setText("");
                    mvp_editText.setText("");
//                    stadium_editText.setText("");
                    spinner1.setVisibility(View.VISIBLE);
                    spinner1.setSelection(0);
                    textviewSpinner1.setText("");

                    Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.notfound);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
                    imageArray = byteArrayOutputStream.toByteArray();
                    image.setImageBitmap(BitmapFactory.decodeByteArray(SecondActivity.this.imageArray, 0, SecondActivity.this.imageArray.length));


                } else if (item0.length() == 0 || item1.length() == 0) {
                    Toast.makeText(getApplicationContext(), "City and Name are required", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // setting, getting intent from MainActivity.java
        Intent intent = getIntent();
        String stringData0 = intent.getStringExtra("itemname0");
        String stringData1 = intent.getStringExtra("itemname1");
        String stringData2 = intent.getStringExtra("itemname2");
        String stringData3 = intent.getStringExtra("itemname3");
        String stringData4 = intent.getStringExtra("itemname4");
        String stringDataCommand = intent.getStringExtra("command");
        TextView textView0 = findViewById(R.id.city_editText);
        TextView textView1 = findViewById(R.id.name_editText);
        TextView textView2 = findViewById(R.id.sport_editText);
        TextView textView3 = findViewById(R.id.mvp_editText);
//        TextView textView4 = findViewById(R.id.stadium_editText);
        textView0.setText(stringData0);
        textView1.setText(stringData1);
        textView2.setText(stringData2);
        textView3.setText(stringData3);
//        textView4.setText(stringData4);

        if (stringDataCommand.equals("add")) {
            delete_btn.setVisibility(View.GONE);
            update_btn.setVisibility(View.GONE);
            submit_btn.setVisibility(View.VISIBLE);

            // setting default image START!
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.notfound);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap1.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
            imageArray = byteArrayOutputStream.toByteArray();
            image.setImageBitmap(BitmapFactory.decodeByteArray(imageArray, 0, imageArray.length));
            // setting default image END!
        }
        if (stringDataCommand.equals("update")) {
            submit_btn.setVisibility(View.GONE);
//            delete_btn.setEnabled(false);
//            update_btn.setEnabled(false);
            update_btn.setVisibility(View.VISIBLE);
            delete_btn.setVisibility(View.VISIBLE);
            upper_linearlayout.setBackgroundColor(Color.parseColor("#FF423D"));
            lower_linearlayout.setBackgroundColor(Color.parseColor("#0098CE"));
            byte[] decodedString = Base64.decode(stringDataName64_string, Base64.DEFAULT);
            Bitmap bitmap64 = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            image.setImageBitmap(bitmap64);

        }


    }

    @Override
    protected void onActivityResult(int requeestCode, int resultCode, Intent data) {
        super.onActivityResult(requeestCode, resultCode, data);
        try {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            ImageView image1 = findViewById(R.id.userImage_imageview);
            image1.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
        } catch (Exception e) {
        }
    }
}
