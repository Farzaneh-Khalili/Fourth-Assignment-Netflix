package org.example;

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
        // Implement add movie logic here
        moviesArray.add(movie);
    }

    public void createAccount(String username, String password) {
        // Implement create account logic here
        User newUser = new User(username, password);
        newUser.setUsername(username);
        newUser.setPassword(password);
        usersArray.add(newUser);
        namesOfUser.add(username);
    }

    public boolean login(String username, String password) {
        boolean correct = false;
            for (int i = 0; i < usersArray.size(); i++) {
                if (password.equals(usersArray.get(i).getUsername())) {
                    correct = true;
                } else {
                    System.out.println("password incorrect");
                }
            }
        if (correct) {
            return true;
        }
        else
            return false;
    }

    public void logout() {
        System.out.println("goodBye");
        System.exit(0);
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title logic here
        int j = 1;
        for (int i = 0; i < TVshowsArray.size(); i++) {
            if (title.equals(TVshowsArray.get(i).getTitle())) {
                if (j == 1) {
                    System.out.println("These shows were found with name : " + title + " in your favorite TVshows :");
                }
                System.out.println(j + ")");
                System.out.println(TVshowsArray.get(i).getTitle() + " ⇒\n");
                System.out.println("genre ► " + TVshowsArray.get(i).getGenre());
                System.out.println("\nrelease year ► " + TVshowsArray.get(i).getReleaseYear());
                System.out.println("\nduration ► " + TVshowsArray.get(i).getDuration());
                System.out.println("\nrating ► " + TVshowsArray.get(i).getRating());
                j = j + 1;
            }
            else {
                System.out.println("It seems we don't have any shows that match this title (" + title + ")");
            }
        }
        return null;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        int j = 1;
        for (int i = 0; i < TVshowsArray.size(); i++) {
            if (genre.equals(TVshowsArray.get(i).getGenre())) {
                if (j == 1) {
                    System.out.println("These shows were found with genre : " + genre + " in your favorite TVshows :");
                }
                System.out.println(j + ")");
                System.out.println(TVshowsArray.get(i).getTitle() + " ⇒\n");
                System.out.println("genre ► " + TVshowsArray.get(i).getGenre());
                System.out.println("\nrelease year ► " + TVshowsArray.get(i).getReleaseYear());
                System.out.println("\nduration ► " + TVshowsArray.get(i).getDuration());
                System.out.println("\nrating ► " + TVshowsArray.get(i).getRating());
                j = j + 1;
            }
            else {
                System.out.println("It seems we don't have any shows that match this genre (" + genre + ")");
            }
        }
        return null;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {

        return null;
    }


}

