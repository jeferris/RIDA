package com.example.rida;

import junit.framework.TestCase;

import java.sql.Timestamp;

public class TestPost extends TestCase {
    private Post p;
    public void setUp(){
        p = new Post();
    }
    public void testCreatePost(){
        assertNotNull(p);
    }

    public void testSetGetAuthor(){
        //set author to Thomas Jefferson
        p.setAuthor("Thomas Jefferson");
        assertEquals("Thomas Jefferson", p.getAuthor());
    }

    public void testSetGetContents(){
        //set contents to Roll Tide
        p.setContents("Roll Tide");
        assertEquals("Roll Tide", p.getContents());
    }

    public void testSetGetTimeStamp(){
        //set contents to current time
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        p.setTimestamp(ts.toString());
        assertEquals(ts.toString(), p.getTimestamp());
    }
}
