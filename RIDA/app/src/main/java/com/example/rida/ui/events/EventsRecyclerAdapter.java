package com.example.rida.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rida.Events;
import com.example.rida.Post;
import com.example.rida.R;
import com.google.firebase.database.core.Context;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.ViewHolder> {

    /*private void onCreate() {

    }

    private View onCreateView(Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate();
    }*/

    Context context;
    ArrayList<Events> events;
    public EventsRecyclerAdapter(ArrayList<Events> n)
    {
        events = n;
    }

    private String[] eventnames = {
            "Event 1",
            "Event 2",
            "Event 3",
            "Event 4",
            "Event 5",
            "Event 6",
            "Event 7",
            "Event 8",
            "Event 9",
            "Event 10",
    };
    private String[] eventlocation = {
            "content 1",
            "content 2",
            "content 3",
            "content 4",
            "content 5",
            "content 6",
            "content 7",
            "content 8",
            "content 9",
            "content 10",
    };
    private String[] eventdate = {
            "date 1",
            "date 2",
            "date 3",
            "date 4",
            "date 5",
            "date 6",
            "date 7",
            "date 8",
            "date 9",
            "date 10",
    };

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eventName;
        public TextView eventLocation;
        public TextView eventDate;

        public ViewHolder(View post) {
            super(post);
            eventName = (TextView) post.findViewById(R.id.event_name);
            eventLocation = (TextView) post.findViewById(R.id.event_location);
            eventDate = (TextView) post.findViewById(R.id.event_date);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_events_info, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.eventName.setText(eventnames[i]);
        viewHolder.eventLocation.setText(eventlocation[i]);
        viewHolder.eventDate.setText(eventdate[i]);
    }

    @Override
    public int getItemCount() {
        return eventnames.length;
    }

}