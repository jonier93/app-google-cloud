package com.example.app_db_google;

public class ModelUser {
    private int identification;
    private String name;
    private String email;

    public ModelUser(int identification, String name, String email) {
        this.identification = identification;
        this.name = name;
        this.email = email;
    }

    public int getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
