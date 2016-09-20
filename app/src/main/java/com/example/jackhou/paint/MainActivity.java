package com.example.jackhou.paint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private ImageButton reset;
    private Spinner strokeSize;
    private Spinner colorOption;
    PaintView paintView;

    private int currentStrokeSize;
    private int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintView = (PaintView) findViewById(R.id.paint_view);

        reset = (ImageButton) findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear();
            }
        });

        strokeSize = (Spinner) findViewById(R.id.stroke_spinner);
        ArrayAdapter<CharSequence> stroke_adapter = ArrayAdapter.createFromResource(this, R.array.stroke_size, android.R.layout.simple_spinner_item);
        stroke_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strokeSize.setAdapter(stroke_adapter);
        strokeSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                currentStrokeSize = pos+1;
                paintView.updateStroke(currentStrokeSize, currentColor);
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });


        colorOption = (Spinner) findViewById(R.id.color_spinner);
        ArrayAdapter<CharSequence> color_adapter = ArrayAdapter.createFromResource(this, R.array.color_options, android.R.layout.simple_spinner_item);
        color_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorOption.setAdapter(color_adapter);
        colorOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                currentColor = pos;
                paintView.updateColor(currentStrokeSize, currentColor);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });


    }


}
