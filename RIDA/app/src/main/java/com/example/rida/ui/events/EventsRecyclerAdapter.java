package com.example.rida.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.rida.R;

import org.w3c.dom.Text;

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.ViewHolder> {

    /*private void onCreate() {

    }

    private View onCreateView(Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate();
    }*/

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
    private String[] eventinfo = {
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

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eventName;
        public TextView eventInfo;

        public ViewHolder(View post) {
            super(post);
            eventName = (TextView) post.findViewById(R.id.event_name);
            eventInfo = (TextView) post.findViewById(R.id.event_info);
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
        viewHolder.eventInfo.setText(eventinfo[i]);
    }

    @Override
    public int getItemCount() {
        return eventnames.length;
    }

}