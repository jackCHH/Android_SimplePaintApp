package com.example.jackhou.paint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button reset;
    private Spinner strokeSize;
    PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintView = (PaintView) findViewById(R.id.paint_view);

        reset = (Button) findViewById(R.id.reset_button);
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
                paintView.updateStroke(pos+1);
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });


    }


}
