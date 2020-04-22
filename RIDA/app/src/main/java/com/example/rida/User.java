package com.example.rida;

public class User {
    private String full_name;
    private String email;
    private String password;
    private String phone_number;


    public User() {
    }



    public User(String full_name, String email, String password, String phone_number)
    {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFull_name(String full_name){
        this.full_name = full_name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
//public User()
