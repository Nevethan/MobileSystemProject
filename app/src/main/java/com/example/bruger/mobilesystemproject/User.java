package com.example.bruger.mobilesystemproject;

/**
 * Created by Bruger on 20-11-2016.
 */

public class User {

    int id;

    String username, password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}