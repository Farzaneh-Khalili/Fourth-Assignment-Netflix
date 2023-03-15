package org.example;

import java.util.ArrayList;

class TVShow {

    private String title;
    private String genre;
    private int releaseYear;
    private int duration;
    private double rating;


    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public void setGenre(String newGenre) {
        genre = newGenre;
    }

    public void setReleaseYear(int newReleaseYear) {
        releaseYear = newReleaseYear;
    }

    public void setDuration(int newDuration) {
        duration = newDuration;
    }

    public void setRating(double newRating) {
        rating = newRating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    public String toString()
    {
        return "name:" + title + "\ngenre:" + genre + "\trating:" + rating + "\tduration:"
                + duration + "\treleas year:" + releaseYear;
    }
    private ArrayList<String> cast = new ArrayList<>();
    public void setCast(String nameOfCast) {
        cast.add(nameOfCast);
    }
    public ArrayList<String> getCast() {
        return cast;
    }
}
