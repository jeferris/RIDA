package com.example.rida;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Post {
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
