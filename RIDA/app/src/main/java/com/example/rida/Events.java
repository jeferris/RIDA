package com.example.rida;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yuncun.swipeableweekview.CircleView;
import com.yuncun.swipeableweekview.WeekViewAdapter;
import com.yuncun.swipeableweekview.WeekViewSwipeable;

import java.util.Arrays;
import java.util.List;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        List<Boolean> data = Arrays.asList(true, false); //Example set; use your own List<T> here
        WeekViewSwipeable wvs = (WeekViewSwipeable) findViewById(R.id.calendar_component);
        WeekViewAdapter<Boolean> adapter = new WeekViewAdapter(data) {
            // @Override
//            public int getStrokeColor(final int index){
//                //Override this to change circle stroke color
//            }
//
//            @Override
//            public int getFillColor(final int index){
//                //Override to change circle fill color
//            }

            @Override
            public TextView getTextView(TextView tv, int index){
                //Gives you access to TextView
                return tv;
            }

            @Override
            public CircleView getCircleView(CircleView cv, int index){
                //Gives you access to CircleView
                return cv;
            }

            @Override
            public View getDayLayout(View dv, final int index){
                //Returns entire dayview. This could be useful for setting an onclicklistener, for example
                return dv;
            }
        };
        wvs.setAdapter(adapter);
    }

}

