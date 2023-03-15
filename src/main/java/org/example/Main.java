package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);

        NetflixService netService = new NetflixService();
        ArrayList<TVShow> listOfTVshows = netService.getTVshowsArray();
        ArrayList<Movie> listOfMovie = netService.getMoviesArray();
        ArrayList<User> listOfUser = netService.getUsersArray();
        ArrayList<String> listOfUsersName = netService.getNamesOfUser();


        ArrayList<User> userArrayList = new ArrayList<>();

        User user1 = new User("user1", "pass0000");
        user1.setUsername("user1");
        user1.setPassword("pass0000");
        listOfUser.add(user1);
        listOfUsersName.add("user1");

        TVShow tvshow1 = new TVShow();
        tvshow1.setTitle("pulp Fiction");
        tvshow1.setGenre("crime");
        tvshow1.setRating(8.9);
        tvshow1.setDuration(154);
        tvshow1.setReleaseYear(1994);
        tvshow1.setCast("John Travolta");
        tvshow1.setCast("Uma Thurman");
        listOfTVshows.add(tvshow1);

        TVShow tvshow2 = new TVShow();
        tvshow2.setTitle("shrinking");
        tvshow2.setGenre("comedy");
        tvshow2.setRating(7.9);
        tvshow2.setDuration(33);
        tvshow2.setReleaseYear(2023);
        tvshow2.setCast(" Jason Segel");
        tvshow2.setCast("Jessica Williams");
        listOfTVshows.add(tvshow2);

        TVShow tvshow3 = new TVShow();
        tvshow3.setTitle("ted lasso");
        tvshow3.setGenre("sport");
        tvshow3.setRating(8.8);
        tvshow3.setDuration(30);
        tvshow3.setReleaseYear(2020);
        tvshow3.setCast("Jason Sudeikis");
        tvshow3.setCast("Brett Goldstein");
        listOfTVshows.add(tvshow3);

        user1.addToFavorites(tvshow1);
        user1.addToFavorites(tvshow2);
        user1.addToFavorites(tvshow3);


        System.out.println("▶NETFLIX◀");
        System.out.println("Do you have an account?\n1.Yes\t2.No");
        int mainCommand = scanner.nextInt();
        switch (mainCommand) {
            case 1:
                System.out.println("Enter your username and password to login");
                String username = scanner.nextLine();
                String password = scanner.nextLine();
                if (listOfUsersName.contains("user1")) {
                    if (netService.login(username, password)) {
                        System.out.println("Welcome " + username);
                        System.out.println("what do you want to do?\n1.search a TV show\t2.view your favorite TV shows");
                        int userCommand = scanner.nextInt();
                        switch (userCommand) {
                            case 1:
                                System.out.println("Do you want to search with :\n1.title\t2.genre\t3.release year");
                                int searchCommand = scanner.nextInt();
                                switch (searchCommand) {
                                    case 1:
                                        System.out.println("Enter the title");
                                        String title = scanner.nextLine();
                                        user1.searchByTitle(title);
                                        break;
                                    case 2:
                                        System.out.println("Enter the genre");
                                        String genre = scanner.nextLine();
                                        user1.searchByGenre(genre);

                                        break;
                                    case 3:
                                        System.out.println("Enter the release year");
                                        int year = scanner.nextInt();

                                        break;
                                    default:
                                        System.out.println("choose 1 to 3");
                                }
                                break;
                            case 2:
                                user1.viewFavorites();

                                break;
                            default:
                                System.out.println("choose 1 or 2");
                        }
                    } else {
                        System.out.println("try again");
                        runMenu();
                    }
                }
                else {
                    System.out.println("username not found!");
                }

                break;
            case 2 :
                System.out.println("Enter a username");
                String newUsername = scanner.nextLine();
                for (int i = 0; i < listOfUsersName.size(); i++) {
                    if (newUsername.equals(listOfUsersName.get(i).toString())){
                        System.out.println("username tooken\ntry again");
                    }
                    else {
                        System.out.println("Enter a password");
                        String newPassword = scanner.nextLine();
                        Pattern patternPassword = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
                        Matcher matcherPassword = patternPassword.matcher(newPassword);
                        if (matcherPassword.find()) {
                            User newUser = new User(newUsername, newPassword);
                            newUser.setUsername(newUsername);
                            newUser.setPassword(newPassword);
                            listOfUser.add(newUser);
                            listOfUsersName.add(newUsername);
                            System.out.println("Account created successfully");
                            System.out.println("What do you want to do?\n1.search a movie\t2.log out");
                            int userCommand = scanner.nextInt();
                            switch (userCommand) {
                                case 1:
                                    System.out.println("search with \n1.title\t2.genre\t3.release year");
                                    int searchCommand = scanner.nextInt();
                                    switch (searchCommand) {
                                        case 1:
                                            System.out.println("Enter the title");
                                            String title = scanner.nextLine();
                                            netService.searchByTitle(title);

                                            break;
                                        case 2:
                                            System.out.println("Enter the genre");
                                            String genre = scanner.nextLine();
                                            netService.searchByGenre(genre);

                                            break;
                                        case 3:
                                            System.out.println("Enter the release year");
                                            int releaseYear = scanner.nextInt();
                                            netService.searchByReleaseYear(releaseYear);

                                            break;
                                        default:
                                            System.out.println("choose 1 to 3");
                                    }
                                    break;
                                case 2:
                                    netService.logout();
                                    break;
                                default:
                                    System.out.println("choose 1 to 3");
                            }
                        }
                        else {
                            System.out.println("Please choose a password which is at least 8 letters and contains both numbers and character");
                        }
                    }

                }
                break;
            default:
                System.out.println("choose 1 or 2");
        }
    }
}
