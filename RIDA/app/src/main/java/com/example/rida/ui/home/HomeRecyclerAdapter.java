package com.example.rida.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.rida.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;



public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private class Post {
        private String author;
        private String contents;
        private String timestamp;

        public Post() {
            this.author = "Author";
            this.contents = "Content";
            this.timestamp = "Date and Time";
        }

        public Post(String author, String contents, String timestamp) {
            this.author = author;
            this.contents = contents;
            this.timestamp = timestamp;

        }

        public String getAuthor() {
            return author;
        }

        public String getContents() {
            return contents;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }

    /*private class Feed {

    }*/
   /* private void onCreate() {


    }

    /*private View onCreateView(Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate();
    }*/

    private String[] names = {
            "Person 1",
            "Person 2",
            "Person 3",
            "Person 4",
            "Person 5",
            "Person 6",
            "Person 7",
            "Person 8",
            "Person 9",
            "Person 10",
    };
    private String[] contents = {
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

        public TextView postName;
        public TextView postContent;

        public ViewHolder(View post) {
            super(post);
            postName = (TextView) post.findViewById(R.id.post_name);
            postContent = (TextView) post.findViewById(R.id.post_content);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        myRef = database.getReference("newsfeed");
        Post p = new Post("charlie", "hey friends", "yesterday");
        myRef.push().setValue(p);

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_posts, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.postName.setText(names[i]);
        viewHolder.postContent.setText(contents[i]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

}
