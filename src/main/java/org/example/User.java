package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */

    Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<TVShow> favoriteShows = new ArrayList<>();
    public ArrayList<TVShow> getFavoriteShows() {
        return favoriteShows;
    }
    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title in favorite shows  logic here
        int j = 1;
        System.out.println("first");
        for (int i = 0; i < favoriteShows.size(); i++) {
            System.out.println("secend");
            if (title.equals(favoriteShows.get(i).getTitle())) {
                System.out.println("third");
               if (j == 1) {
                   System.out.println("fourth");
                   System.out.println("These shows were found with name : " + title + " in your favorite TVshows :");
               }
                System.out.println(j + ")");
                System.out.println(favoriteShows.get(i).getTitle() + " ⇒\n");
                System.out.println("genre ► " + favoriteShows.get(i).getGenre());
                System.out.println("\nrelease year ► " + favoriteShows.get(i).getReleaseYear());
                System.out.println("\nduration ► " + favoriteShows.get(i).getDuration());
                System.out.println("\nrating ► " + favoriteShows.get(i).getRating());
                j = j + 1;
            }
            else {
                System.out.println("It seems we don't have any shows that match this title (" + title + ")");
            }
        }

        return null;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {

        int j = 1;
        for (int i = 0; i < favoriteShows.size(); i++) {
            if (genre.equals(favoriteShows.get(i).getGenre())) {
                if (j == 1) {
                    System.out.println("These shows were found with genre : " + genre + " in your favorite TVshows :");
                }
                System.out.println(j + ")");
                System.out.println(favoriteShows.get(i).getTitle() + " ⇒\n");
                System.out.println("genre ► " + favoriteShows.get(i).getGenre());
                System.out.println("\nrelease year ► " + favoriteShows.get(i).getReleaseYear());
                System.out.println("\nduration ► " + favoriteShows.get(i).getDuration());
                System.out.println("\nrating ► " + favoriteShows.get(i).getRating());
                j = j + 1;
            }
            else {
                System.out.println("It seems we don't have any shows that match this genre (" + genre + ")");
            }
        }
        return null;
    }
    /*public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year in favorite shows logic here
        int j = 1;
        for (int i = 0; i < favoriteShows.size(); i++) {
            if (year.equals(favoriteShows.get(i).getGenre())) {
                if (j == 1) {
                    System.out.println("These shows were found with genre : " + year + " in your favorite TVshows :");
                }
                System.out.println(j + ")");
                System.out.println(favoriteShows.get(i).getTitle() + " ⇒\n");
                System.out.println("genre ► " + favoriteShows.get(i).getGenre());
                System.out.println("\nrelease year ► " + favoriteShows.get(i).getReleaseYear());
                System.out.println("\nduration ► " + favoriteShows.get(i).getDuration());
                System.out.println("\nrating ► " + favoriteShows.get(i).getRating());
                j = j + 1;
            }
            else {
                System.out.println("It seems we don't have any shows that match this release year (" + year + ")");
            }
        }
        return null;
    }*/

    public void addToFavorites(TVShow show) {

        favoriteShows.add(show);
    }
    public void viewFavorites() {
        for (int i = 0; i < favoriteShows.size(); i++) {
            System.out.println(favoriteShows.get(i).toString());
        }
    }
    public ArrayList<TVShow> getRecommendations() {
        return null;
    }
}
