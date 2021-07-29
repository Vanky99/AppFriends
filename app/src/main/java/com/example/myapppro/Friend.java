package com.example.myapppro;

public class Friend {
    private static int count = 1;
    private int id;
    private int userId;
    private String name;
    private String dob;
    private boolean gender;
    private String address;

    public Friend(int id, int userId, String name, String dob, boolean gender, String address) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public Friend(int userId, String name, String dob, boolean gender, String address) {
        this.id = count;
        this.userId = userId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
