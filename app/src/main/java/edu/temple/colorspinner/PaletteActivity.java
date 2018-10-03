package edu.temple.colorspinner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PaletteActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        final Spinner spinner = findViewById(R.id.spinner);
        String[] colors = {"Choose a Color","Red","Blue","Green","Black","Gray"};
        ColorAdapter colorAdapter = new ColorAdapter(this,android.R.layout.simple_spinner_dropdown_item,colors);
        colorAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(colorAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString()!="Choose a Color") {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("color", spinner.getSelectedItem().toString());
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class ColorAdapter extends ArrayAdapter<String>{

        String myColors[];

        public ColorAdapter(@NonNull Context context, int resource, String[] myColors) {
            super(context, resource,myColors);
            this.myColors=myColors;

        }
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            TextView textView = (TextView)super.getDropDownView(position,convertView,parent);

            if(position>0){
                textView.setBackgroundColor(Color.parseColor(myColors[position].toString()));
            }
            else{
                textView.setBackgroundColor(Color.WHITE);
            }
            return textView;
        }
    }
}