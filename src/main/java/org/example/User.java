package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class User {

    Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
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

    private ArrayList<TVShow> allTVhows = new ArrayList<>();
    public ArrayList<TVShow> getAllTVhows() {
        return allTVhows;
    }
    public ArrayList<TVShow> favoriteShows = new ArrayList<>();
    public ArrayList<TVShow> getFavoriteShows() {
        return favoriteShows;
    }

    private ArrayList<TVShow> watchedTVshows = new ArrayList<>();
    public ArrayList<TVShow> getWatchedTVshows() {
        return watchedTVshows;
    }
    private ArrayList<TVShow> likedTVshows = new ArrayList<>();
    public ArrayList<TVShow> getLikedTVshows() {
        return likedTVshows;
    }


    NetflixService netflixService = new NetflixService();

    public boolean searchByTitle(String title) {
        int j = 1;
        boolean exist = false;
        for (int i = 0; i < favoriteShows.size(); i++) {
            if (title.equals(favoriteShows.get(i).getTitle())) {
                exist = true;
               if (j == 1) {
                   System.out.println("This is what we found with title  ↪" + title + "↩ in your favorite TV shows :");
               }
                System.out.println(j + ")");
                System.out.println(favoriteShows.get(i).getTitle() + " ⇒");
                System.out.println("genre ► " + favoriteShows.get(i).getGenre());
                System.out.println("release year ► " + favoriteShows.get(i).getReleaseYear());
                System.out.println("duration ► " + favoriteShows.get(i).getDuration());
                System.out.println("rating ► " + favoriteShows.get(i).getRating() + "\n");
                System.out.println("\n");
                j = j + 1;
            }
        }
        if (exist) {
            return true;
        }
        else
            return false;
    }

    public boolean searchByGenre(String genre) {
        int j = 1;
        boolean exist = false;
        for (int i = 0; i < favoriteShows.size(); i++) {
            if (genre.equals(favoriteShows.get(i).getGenre())) {
                exist = true;
                if (j == 1) {
                    System.out.println("This is what we found with genre ↪" + genre + "↩ in your favorite TV shows :");
                }
                System.out.println(j + ")");
                System.out.println(favoriteShows.get(i).getTitle() + " ⇒");
                System.out.println("genre ► " + favoriteShows.get(i).getGenre());
                System.out.println("release year ► " + favoriteShows.get(i).getReleaseYear());
                System.out.println("duration ► " + favoriteShows.get(i).getDuration());
                System.out.println("rating ► " + favoriteShows.get(i).getRating() + "\n");
                System.out.println("\n");
                j = j + 1;
            }
        }
        if (exist) {
            return true;
        }
        else
            return false;
    }
    public boolean searchByReleaseYear(int year) {
        int j = 1;
        boolean exist = false;
        for (int i = 0; i < favoriteShows.size(); i++) {
            if (year == favoriteShows.get(i).getReleaseYear()) {
                exist = true;
                if (j == 1) {
                    System.out.println("This is what we found with release year ↪" + year + "↩ in your favorite TV shows :");
                }
                System.out.println(j + ")");
                System.out.println(favoriteShows.get(i).getTitle() + " ⇒");
                System.out.println("genre ► " + favoriteShows.get(i).getGenre());
                System.out.println("release year ► " + favoriteShows.get(i).getReleaseYear());
                System.out.println("duration ► " + favoriteShows.get(i).getDuration());
                System.out.println("rating ► " + favoriteShows.get(i).getRating() + "\n");
                System.out.println("\n");
                j = j + 1;
            }
        }
        if (exist) {
            return true;
        }
        else
            return false;
    }

    public boolean addToWatch(String title) {
        boolean exist = false;
        for (int i = 0; i < allTVhows.size(); i++) {
            if (title.equals(allTVhows.get(i).getTitle())) {
                exist = true;
                watchedTVshows.add(allTVhows.get(i));
            }
        }
        if (exist) {
            return true;
        }
        else {
            return false;
        }
    }
    public void addToWatch(TVShow tvShow) {
        watchedTVshows.add(tvShow);
    }

    public void viewWatchedlist() {
        boolean doesntExist = true;
        for (int i = 0; i < watchedTVshows.size(); i++) {
            System.out.println(watchedTVshows.get(i).toString());
            System.out.println("\n");
            doesntExist = false;
        }
        if (doesntExist) {
            System.out.println("You haven't watch any TV show.");
        }
    }

    public boolean addToFavorites(String title) {
        boolean exist = false;
        for (int i = 0; i < allTVhows.size(); i++) {
            if (title.equals(allTVhows.get(i).getTitle())) {
                exist = true;
                favoriteShows.add(allTVhows.get(i));
            }
        }
        if (exist) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addToFavorites(TVShow tvshow) {
        favoriteShows.add(tvshow);
    }

    public void viewFavorites() {
        boolean doesntExist = true;
        for (int i = 0; i < favoriteShows.size(); i++) {
            System.out.println(favoriteShows.get(i).toString());
            System.out.println("\n");
            doesntExist = false;
        }
        if (doesntExist) {
            System.out.println("You don't have any favorite TV show.");
        }
    }
    public ArrayList<TVShow> getRecommendations() {
        return null;
    }

    public boolean like(String likeTVshow) {
        boolean exist = false;
        for(int i = 0; i < allTVhows.size(); i++) {
            if (likeTVshow.equals(allTVhows.get(i).getTitle())) {
                exist = true;
                if (allTVhows.get(i).getIsLiked()) {
                    System.out.println(likeTVshow + " is already liked.");
                } else {
                    allTVhows.get(i).setIsLiked(true);
                    likedTVshows.add(allTVhows.get(i));
                    System.out.println(likeTVshow + " liked successfully.");
                    break;
                }
            }
        }
        if (exist) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean disLike(String disLikeTVshow) {
        boolean exist = false;
        for(int i = 0; i < allTVhows.size(); i++) {
            if (disLikeTVshow.equals(allTVhows.get(i).getTitle())) {
                exist = true;
                if (!allTVhows.get(i).getIsLiked()) {
                    System.out.println(disLikeTVshow + " is already disliked.");
                } else {
                    allTVhows.get(i).setIsLiked(false);
                    likedTVshows.remove(allTVhows.get(i));
                    System.out.println(disLikeTVshow + " disliked successfully.");
                    break;
                }
            }
        }
        if (exist) {
            return true;
        }
        else {
            return false;
        }
    }
    public void addToLikedTvshow(TVShow tvShow) {
        likedTVshows.add(tvShow);
    }
    public void viewLikedTVshows() {
        boolean doesntExist = true;
        for (int i = 0; i < likedTVshows.size(); i++) {
            System.out.println(likedTVshows.get(i).toString());
            System.out.println("\n");
            doesntExist = false;
        }
        if (doesntExist) {
            System.out.println("You haven't like any TV show.");
        }
    }
}
