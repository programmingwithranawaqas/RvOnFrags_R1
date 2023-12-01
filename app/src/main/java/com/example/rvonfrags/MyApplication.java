package com.example.rvonfrags;

import android.app.Application;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();
        contacts = new ArrayList<>();

        contacts.add(new Contact("Waqas", "090078601"));
        contacts.add(new Contact("Ali", "090078602"));
        contacts.add(new Contact("Khan", "090078603"));
        contacts.add(new Contact("Saad", "090078604"));
    }
}
