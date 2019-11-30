package com.this_user.myapplication;

public class User {
    private String name;
    private String location;
    private String phone;
    private String password;

    public User(String location, String phone, String password, String name){
        this.location=location;
        this.phone=phone;
        this.password=password;
        this.name=name;
    }

    public User(){
        this.location="";
        this.phone="";
        this.password="";
        this.name="";
    }

    public User(User other) {
        other.name = this.name;
        other.phone = this.phone;
        other.location = this.location;
        other.password = this.password;
    }


    public String getLocation() {
        return location;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
