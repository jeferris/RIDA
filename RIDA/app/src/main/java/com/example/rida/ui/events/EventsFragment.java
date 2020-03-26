package com.example.rida.ui.events;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;

import com.yuncun.swipeableweekview.CircleView;
import com.yuncun.swipeableweekview.WeekViewAdapter;
import com.yuncun.swipeableweekview.WeekViewSwipeable;

import java.util.Arrays;
import java.util.List;

import com.example.rida.R;

public class EventsFragment extends Fragment {
    Toolbar toolbar;
    TextView introtxt;
    WeekViewSwipeable wvs;
    WeekViewAdapter<Boolean> adapter;
    Context context;
    private EventsViewModel eventsViewModel;
    public EventsFragment(){
        //empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstancesState){


        View v = inflater.inflate(R.layout.fragment_events, container, false);

        toolbar = (Toolbar)v.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        introtxt = (TextView)v.findViewById(R.id.helloworld);
        //Sample data
        List<Boolean> data = Arrays.asList(true, false, true, false, true, true);
        introtxt.setText("Dataset: \n " + Arrays.toString(data.toArray()));
        wvs = (WeekViewSwipeable)v.findViewById(R.id.calendar_component);

        setHasOptionsMenu(true);
        //context = this;


        adapter = new WeekViewAdapter(data) {
            /*@Override
            public int getStrokeColor(final int index){
                //Override this to change circle stroke color
                if ((Boolean) get(index)==true){
                    return ContextCompat.getColor(context, R.color.teal);
                } else {
                    return ContextCompat.getColor(context, R.color.darkgray);
                }
            }

            @Override
            public int getFillColor(final int index){
                //Override to change circle fill color
                if ((Boolean) get(index)==true){
                    return ContextCompat.getColor(context, R.color.teal);
                } else {
                    return ContextCompat.getColor(context, R.color.darkgray);
                }
            }

            @Override
            public TextView getTextView(TextView tv, int index){
                //Gives you access to TextView
                if ((Boolean) get(index)==true){
                    tv.setText("Hit");
                } else {
                    tv.setText("Miss");
                }
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
                dv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Click! on index " + index, Toast.LENGTH_LONG).show();
                    }
                });
                return dv;
            }*/
        };
        wvs.setAdapter(adapter);
        return v;
    }

/*    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        final MenuItem item = menu.findItem(R.id.action_settings);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
/*    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel =
                ViewModelProviders.of(this).get(EventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        eventsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }*/
/*

public class Events extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TextView introtxt = (TextView) findViewById(R.id.helloworld);
        final Context context = this;

        //Sample data
        List<Boolean> data = Arrays.asList(true, false, true, false, true, true);
        introtxt.setText("Dataset: \n " + Arrays.toString(data.toArray()));
        WeekViewSwipeable wvs = (WeekViewSwipeable) findViewById(R.id.calendar_component);

        WeekViewAdapter<Boolean> adapter = new WeekViewAdapter(data) {
            @Override
            public int getStrokeColor(final int index){
                //Override this to change circle stroke color
                if ((Boolean) get(index)==true){
                    return ContextCompat.getColor(context, R.color.teal);
                } else {
                    return ContextCompat.getColor(context, R.color.darkgray);
                }
            }

            @Override
            public int getFillColor(final int index){
                //Override to change circle fill color
                if ((Boolean) get(index)==true){
                    return ContextCompat.getColor(context, R.color.teal);
                } else {
                    return ContextCompat.getColor(context, R.color.darkgray);
                }
            }

            @Override
            public TextView getTextView(TextView tv, int index){
                //Gives you access to TextView
                if ((Boolean) get(index)==true){
                    tv.setText("Hit");
                } else {
                    tv.setText("Miss");
                }
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
                dv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Click! on index " + index, Toast.LENGTH_LONG).show();
                    }
                });
                return dv;
            }
        };
        wvs.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




 */