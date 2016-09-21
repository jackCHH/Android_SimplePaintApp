package com.example.jackhou.paint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.paint_view) PaintView paintView;
    @BindView(R.id.reset_button) ImageButton reset;
    @BindView(R.id.eraser) ImageButton eraser;
    @BindView(R.id.stroke_spinner) Spinner strokeSize;
    @BindView(R.id.color_spinner) Spinner colorOption;
    private int currentStrokeSize = 1;
    private int currentColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear(currentStrokeSize,currentColor);
            }
        });

        eraser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                paintView.erase();
            }
        });

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
