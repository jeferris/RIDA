package com.example.rida.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rida.MainActivity;
import com.example.rida.Post;
import com.example.rida.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.Timestamp;
import java.util.ArrayList;

public class HomeFragment extends Fragment {


    DatabaseReference myRef;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Post> newsfeed;
    private DatabaseReference mDatabase;

    /*private void writeNewPost(String author, String contents, String timestamp) {

        //String key = myRef.child("posts").push().getKey();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Post post = new Post(author, contents, ts.toString());
        myRef.push().setValue(post);

    }*/

    /*Need a listener for when a post button is clicked, will call writeNewPost*/


    private Button newPostButton;
    private EditText postContent;

    public EditText getPostContent() {
        return postContent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
       // writeNewPost("author", "hello", "time");

        myRef = FirebaseDatabase.getInstance().getReference().child("newsfeed");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newsfeed = new ArrayList<Post>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Post p = dataSnapshot1.getValue(Post.class);
                    newsfeed.add(0, p);
                }
                adapter = new HomeRecyclerAdapter(newsfeed);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Toast.makeText(HomeFragment.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        //adapter = new HomeRecyclerAdapter();
        //recyclerView.setAdapter(adapter);

        newPostButton = (Button) root.findViewById(R.id.new_post_button);
        postContent = root.findViewById(R.id.newPostText);
        newPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNewPostClick(v);
            }
        });

        //initializePost();
        //set listener for post button

        /*newPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onNewPostClick();
            }
        });*/

        return root;
    }

    /*@Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.new_post_button) {
        //writeNewPost();
            Toast.makeText(getContext(), "newPostButton pressed", Toast.LENGTH_LONG).show();
        //return;
        }
    }*/

    private void initializePost() {

        newPostButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onNewPostClick(v);
            }
        });
    }
    private void onNewPostClick(View v) {
        String post_contents;
        post_contents = postContent.getText().toString();
        if (TextUtils.isEmpty(post_contents)) {
            Toast.makeText(getContext(), "Please type something to post", Toast.LENGTH_LONG).show();
            return;
        }
        int i = v.getId();
        if (i == R.id.new_post_button) {
            //writeNewPost();
            Toast.makeText(getContext(), "newPostButton pressed", Toast.LENGTH_LONG).show();
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            Post p = new Post("me", post_contents, ts.toString());
            myRef.push().setValue(p);
            //return;
        }
    }



}