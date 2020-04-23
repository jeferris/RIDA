package com.example.rida;

public class User {
    private String full_name;
    private String email;
    private String password;
    private String phone_number;
    private double earnings;
    private double miles;
    private double  expenses;


    public User() {}

    public User(String full_name, String email, String password, String phone_number)
    {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.earnings = 0.0;
        this.expenses = 0.0;
        this.miles = 0.0;
    }

    public void addMiles(double x) { this.miles = this.miles + x; }
    public void addEarnings(double y) { this.earnings = this.earnings + y; }
    public void addExpenses(double z) { this.expenses = this.expenses + z; }

    public void setEmail(String email) { this.email = email; }
    public void setFull_name(String full_name){ this.full_name = full_name; }
    public void setPassword(String password){ this.password = password; }
    public void setPhone_number(String phone_number){ this.phone_number = phone_number; }
    public void setEarnings(double earnings) { this.earnings = earnings; }
    public void setExpenses(double expenses) { this.expenses = expenses; }
    public void setMiles(double miles) { this.miles = miles; }

    public String getEmail() { return email; }
    public String getFull_name() { return full_name; }
    public String getPassword() { return password; }
    public String getPhone_number() { return phone_number; }
    public double getEarnings() { return earnings; }
    public double getExpenses() { return expenses; }
    public double getMiles() { return miles; }
}