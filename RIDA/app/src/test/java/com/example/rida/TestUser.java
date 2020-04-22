package com.example.rida;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TestUser extends TestCase {
    private User u;
    public void setUp(){
        u = new User();
    }
    public void testCreateUser(){
        assertNotNull(u);
    }

    public void testSetGetEmail(){
        //set email to test@email.com
        u.setEmail("test@email.com");
        assertEquals("test@email.com", u.getEmail());
    }

    public void testSetGetFull_name(){
        //set full_name to Nick Saban
        u.setFull_name("Nick Saban");
        assertEquals("Nick Saban", u.getFull_name());
    }

    public void testSetGetPassword(){
        //set password to password
        u.setPassword("password");
        assertEquals("password", u.getPassword());
    }

    public void testSetGetPhone_number(){
        //set phone_number to 1234567890
        u.setPhone_number("1234567890");
        assertEquals("1234567890", u.getPhone_number());
    }
}
