package com.example.rida;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rida.ui.events.EventsFragment;
import com.example.rida.ui.events.EventsRecyclerAdapter;
import com.example.rida.ui.home.HomeRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class addEvent extends AppCompatActivity {

    public static final String Event_Name_Key = "EventName";
    public static final String Event_Location_Key = "EventLocation";
    public static final String TAG = "Event Information";
    DatabaseReference myRef;
    private EditText eventContent;
    ArrayList<Event> events;
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().collection("events").document("event");
    TextView mEventNameTextView;
    TextView mEventLocationTextView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
/*    protected void onStart(){
        super.onStart();
        mDocRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot.exists()){
                    String eventNameText = documentSnapshot.getString(Event_Name_Key);
                    String eventLocationText = documentSnapshot.getString(Event_Name_Key);
                    mEventNameTextView.setText("\""+ eventNameText +"\" --" + eventLocationText);
                }
            }
        });
    }*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent);
    }

    public void addEvent(View view){
        EditText eventNameView = (EditText) findViewById(R.id.event_name);
        EditText eventLocationView = (EditText) findViewById(R.id.event_location);
        final String eventNameText = eventNameView.getText().toString();
        final String eventLocationText = eventLocationView.getText().toString();

        if(eventNameText.isEmpty() || eventLocationText.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter both Name and Location", Toast.LENGTH_LONG).show();
            return;
        }
        Map<String, Object> dataToSave = new HashMap<String, Object>();
        dataToSave.put(Event_Name_Key, eventNameText);
        dataToSave.put(Event_Location_Key, eventLocationText);
        mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Event has been added");
                Toast.makeText(getApplicationContext(), "Event Added", Toast.LENGTH_LONG).show();
                Event p = new Event(eventNameText, eventLocationText);
                myRef.push().setValue(p);
                Intent backEventsIntent = new Intent(getApplicationContext(), EventsFragment.class);
                startActivity(backEventsIntent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Event was not added!", e);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events = new ArrayList<Event>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Event p = dataSnapshot1.getValue(Event.class);
                    events.add(0, p);
                }
                adapter = new EventsRecyclerAdapter(events);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Toast.makeText(HomeFragment.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeUI(){
        ImageButton back_btn_events = findViewById(R.id.back_btn_events);
        back_btn_events.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent backEventsIntent = new Intent(getApplicationContext(), EventsFragment.class);
                startActivity(backEventsIntent);
            }
        });
    }
}
