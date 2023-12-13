package com.example.lab.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Database {

    public abstract void createEntry(String userInfo);
    public abstract String[] getEntryById(int id);

    public abstract List<User> getAllEntries();

    public abstract void updateEntry(int id);

    public abstract void deleteEntryById(int id);
}
