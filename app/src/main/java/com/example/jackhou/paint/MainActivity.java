package com.example.jackhou.paint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import butterknife.BindArray;
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
    @BindArray(R.array.color_options) String[] colors;
    @BindArray(R.array.stroke_size)String[] strokes;
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
        strokeSize.setAdapter(new strokeAdapter(strokes, this));
        colorOption.setAdapter(new colorAdapter(colors, this));
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
    public void colorSpinnerItemSelected(AdapterView<?> parent, View view, int position, long id){
        currentColor = position;
        presenter.updateColor(currentStrokeSize, currentColor);
    }

    @OnItemSelected(R.id.stroke_spinner)
    public void strokeSpinnerItemSelected(Spinner spinner, int position){
        currentStrokeSize = position+1;
        presenter.updateStroke(currentStrokeSize, currentColor);
    }
}
