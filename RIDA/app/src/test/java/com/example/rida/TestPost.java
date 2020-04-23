package com.example.rida;

import junit.framework.TestCase;
import java.sql.Timestamp;

public class TestPost extends TestCase {
    private Post p;
    private Post pCons = new Post("Author", "Contents", "Time");

    public void setUp(){
        p = new Post();
    }

    public void testCreatePost(){
        assertNotNull(p);
    }

    public void testCreatePostEmpty() {
        assertNull(p.getAuthor());
        assertNull(p.getContents());
        assertNull(p.getTimestamp());
    }

    public void testGetAuthor(){
        assertEquals("Author", pCons.getAuthor());
    }

    public void testGetContents(){
        assertEquals("Contents", pCons.getContents());
    }

    public void testGetTimeStamp(){
        assertEquals("Time", pCons.getTimestamp());
    }

    public void testSetAuthor(){
        //set author to Thomas Jefferson
        p.setAuthor("Thomas Jefferson");
        assertEquals("Thomas Jefferson", p.getAuthor());
    }

    public void testSetContents(){
        //set contents to Roll Tide
        p.setContents("Roll Tide");
        assertEquals("Roll Tide", p.getContents());
    }

    public void testSetTimeStamp(){
        //set contents to current time
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        p.setTimestamp(ts.toString());
        assertEquals(ts.toString(), p.getTimestamp());
    }

    @Override
    public void tearDown(){
        p = null;
    }
}
