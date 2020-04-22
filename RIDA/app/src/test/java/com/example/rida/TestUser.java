package com.example.rida;

import junit.framework.TestCase;

public class TestUser extends TestCase {
    private User u;
    private User uCons = new User("full_name", "email", "password", "phone_number");

    public void setUp(){
        u = new User();
    }

    public void testCreateUser(){
        assertNotNull(u);
    }

    public void testCreateUserEmpty() {
        assertNull(u.getFull_name());
        assertNull(u.getEmail());
        assertNull(u.getPassword());
        assertNull(u.getPhone_number());
    }

    public void testGetFull_name(){
        assertEquals("full_name", uCons.getFull_name());
    }

    public void testGetEmail(){
        assertEquals("email", uCons.getEmail());
    }

    public void testGetPassword(){
        assertEquals("password", uCons.getPassword());
    }

    public void testGetPhone_number(){
        assertEquals("phone_number", uCons.getPhone_number());
    }

    public void testSetEmail(){
        //set email to test@email.com
        u.setEmail("test@email.com");
        assertEquals("test@email.com", u.getEmail());
    }

    public void testSetFull_name(){
        //set full_name to Nick Saban
        u.setFull_name("Nick Saban");
        assertEquals("Nick Saban", u.getFull_name());
    }

    public void testSetPassword(){
        //set password to password
        u.setPassword("password");
        assertEquals("password", u.getPassword());
    }

    public void testSetPhone_number(){
        //set phone_number to 1234567890
        u.setPhone_number("1234567890");
        assertEquals("1234567890", u.getPhone_number());
    }

    public void tearDown(){
        u = null;
    }
}
