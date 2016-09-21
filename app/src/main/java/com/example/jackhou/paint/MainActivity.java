package com.example.jackhou.paint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.paint_view) PaintView paintView;
    @BindView(R.id.reset_button) ImageButton reset;
    @BindView(R.id.eraser) ImageButton eraser;
    @BindView(R.id.stroke_spinner) Spinner strokeSize;
    @BindView(R.id.color_spinner) Spinner colorOption;
    private int currentStrokeSize = 1;
    private int currentColor = 0;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(paintView);
        initAdapters();
    }

    public void initAdapters(){
        ArrayAdapter<CharSequence> strokeAdapter = ArrayAdapter.createFromResource(this, R.array.stroke_size, android.R.layout.simple_spinner_item);
        strokeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strokeSize.setAdapter(strokeAdapter);

        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this, R.array.color_options, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorOption.setAdapter(colorAdapter);
    }

    @OnClick(R.id.reset_button)
    public void onResetClick(){
        presenter.clear(currentStrokeSize,currentColor);
    }

    @OnClick(R.id.eraser)
    public void onEraserClick(){
        presenter.erase();
    }

    @OnItemSelected(R.id.color_spinner)
    public void colorSpinnerItemSelected(Spinner spinner, int position){
        currentColor = position;
        presenter.updateColor(currentStrokeSize, currentColor);
    }

    @OnItemSelected(R.id.stroke_spinner)
    public void strokeSpinnerItemSelected(Spinner spinner, int position){
        currentStrokeSize = position+1;
        presenter.updateStroke(currentStrokeSize, currentColor);
    }
}
