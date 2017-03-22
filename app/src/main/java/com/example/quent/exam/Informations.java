package com.example.quent.exam;

import java.util.Date;

/**
 * Created by quent on 17/03/2017.
 */

public class Informations {
    private String title;
    private String description;
    private String date;
    private String author;
    private String thumbnail;

    public Informations(String title, String description, String date, String author, String thumbnail)
    {
        this.title = title;
        this.description = description;
        this.date = date;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
    public String getAuthor() { return author; }
    public String  getThumbnail() { return thumbnail; }
}

