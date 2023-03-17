package org.example;

import java.security.PublicKey;
import java.util.ArrayList;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */


    private ArrayList<TVShow> TVshowsArray = new ArrayList<>();
    public ArrayList<TVShow> getTVshowsArray() {
        return TVshowsArray;
    }
    private ArrayList<Movie> moviesArray = new ArrayList<>();
    public ArrayList<Movie> getMoviesArray() {
        return moviesArray;
    }
    private ArrayList<User> usersArray = new ArrayList<>();
    public ArrayList<User> getUsersArray() {
        return usersArray;
    }
    private ArrayList<String> namesOfUser = new ArrayList<>();
    public ArrayList<String> getNamesOfUser() {
        return namesOfUser;
    }


    public void addToUserArray(User newUser) {
        usersArray.add(newUser);
    }
    public void addTVShow(TVShow tvShow){
        TVshowsArray.add(tvShow);
    }

    public void addMovie(Movie movie){

        moviesArray.add(movie);
    }

    public void createAccount(String username, String password) {
        User newUser = new User(username, password);
        newUser.setUsername(username);
        newUser.setPassword(password);
        usersArray.add(newUser);
        namesOfUser.add(username);
    }

    public boolean login(String username, String password) {
        for (User user : usersArray) {
            if (user.getPassword().equals(password) && user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logout() {
        System.out.println("GoodBye(●'◡'●)");
        System.exit(0);
    }

    public boolean searchByTitle(String title) {
        int j = 1;
        boolean exist = false;
        for (int i = 0; i < TVshowsArray.size(); i++) {
            if (title.equals(TVshowsArray.get(i).getTitle())) {
                exist = true;
                if (j == 1) {
                    System.out.println("This is what we found with title ↪" + title + "↩");
                }
                System.out.println(j + ")");
                System.out.println(TVshowsArray.get(i).getTitle() + " ⇒");
                System.out.println("genre ► " + TVshowsArray.get(i).getGenre());
                System.out.println("release year ► " + TVshowsArray.get(i).getReleaseYear());
                System.out.println("duration ► " + TVshowsArray.get(i).getDuration());
                System.out.println("rating ► " + TVshowsArray.get(i).getRating() + "\n");
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
        for (int i = 0; i < TVshowsArray.size(); i++) {
            if (genre.equals(TVshowsArray.get(i).getGenre())) {
                exist = true;
                if (j == 1) {
                    System.out.println("This is what we found with genre ↪" + genre + "↩");
                }
                System.out.println(j + ")");
                System.out.println(TVshowsArray.get(i).getTitle() + " ⇒");
                System.out.println("genre ► " + TVshowsArray.get(i).getGenre());
                System.out.println("release year ► " + TVshowsArray.get(i).getReleaseYear());
                System.out.println("duration ► " + TVshowsArray.get(i).getDuration());
                System.out.println("rating ► " + TVshowsArray.get(i).getRating() + "\n");
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
        for (int i = 0; i < TVshowsArray.size(); i++) {
            if (year == TVshowsArray.get(i).getReleaseYear()) {
                exist = true;
                if (j == 1) {
                    System.out.println("This is what we found with release year ↪" + year + "↩");
                }
                System.out.println(j + ")");
                System.out.println(TVshowsArray.get(i).getTitle() + " ⇒");
                System.out.println("genre ► " + TVshowsArray.get(i).getGenre());
                System.out.println("release year ► " + TVshowsArray.get(i).getReleaseYear());
                System.out.println("duration ► " + TVshowsArray.get(i).getDuration());
                System.out.println("rating ► " + TVshowsArray.get(i).getRating() + "\n");
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


}

