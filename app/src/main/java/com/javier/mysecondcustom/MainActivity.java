package com.javier.mysecondcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;



public class MainActivity extends AppCompatActivity {
    private MySecondCustom myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MySecondCustom) findViewById(R.id.custview);

    }


    public void btnPressed(View view){
        myView.setCircleCol(Color.BLUE);
        myView.setLabelCol(Color.YELLOW  );
        myView.setCircleText("World");
    }

//





}
