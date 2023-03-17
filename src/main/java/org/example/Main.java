package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
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
        ArrayList<TVShow> userAllTVshow = user1.getAllTVhows();
        ArrayList<TVShow> userWatchedTVshows = user1.getWatchedTVshows();

        TVShow tvshow1 = new TVShow();
        tvshow1.setTitle("office");
        tvshow1.setGenre("comedy");
        tvshow1.setRating(9.0);
        tvshow1.setDuration(22);
        tvshow1.setReleaseYear(2005);
        tvshow1.setCast("Steve Carell");
        tvshow1.setCast(" Jenna Fischer");
        listOfTVshows.add(tvshow1);
        userAllTVshow.add(tvshow1);

        TVShow tvshow2 = new TVShow();
        tvshow2.setTitle("shrinking");
        tvshow2.setGenre("comedy");
        tvshow2.setRating(7.9);
        tvshow2.setDuration(33);
        tvshow2.setReleaseYear(2023);
        tvshow2.setCast(" Jason Segel");
        tvshow2.setCast("Jessica Williams");
        listOfTVshows.add(tvshow2);
        userAllTVshow.add(tvshow2);

        TVShow tvshow3 = new TVShow();
        tvshow3.setTitle("wednesday");
        tvshow3.setGenre("fantasy");
        tvshow3.setRating(8.1);
        tvshow3.setDuration(45);
        tvshow3.setReleaseYear(2022);
        tvshow3.setCast("Jenna Ortega");
        tvshow3.setCast("Hunter Doohan");
        listOfTVshows.add(tvshow3);
        userAllTVshow.add(tvshow3);

        TVShow tvshow4 = new TVShow();
        tvshow4.setTitle("friends");
        tvshow4.setGenre("comedy");
        tvshow4.setRating(8.9);
        tvshow4.setDuration(22);
        tvshow4.setReleaseYear(1994);
        tvshow4.setCast("Jennifer Aniston");
        tvshow4.setCast("Courteney Cox");
        tvshow4.setCast("Matt LeBlanc");
        listOfTVshows.add(tvshow4);
        userAllTVshow.add(tvshow4);

        TVShow tvshow5 = new TVShow();
        tvshow5.setTitle("bones");
        tvshow5.setGenre("drama");
        tvshow5.setRating(7.8);
        tvshow5.setDuration(40);
        tvshow5.setReleaseYear(2005);
        tvshow5.setCast("Emily Deschanel");
        tvshow5.setCast("David Boreanaz");
        tvshow5.setCast("Michaela Conlin");
        listOfTVshows.add(tvshow5);
        userAllTVshow.add(tvshow5);

        TVShow tvshow6 = new TVShow();
        tvshow6.setTitle("ghosts");
        tvshow6.setGenre("fantasy");
        tvshow6.setRating(7.9);
        tvshow6.setDuration(50);
        tvshow6.setReleaseYear(2021);
        tvshow6.setCast("Rose McIve");
        tvshow6.setCast("Utkarsh Ambudkar");
        listOfTVshows.add(tvshow6);
        userAllTVshow.add(tvshow5);

        TVShow tvshow7 = new TVShow();
        tvshow7.setTitle("simpsons");
        tvshow7.setGenre("animation");
        tvshow7.setRating(8.7);
        tvshow7.setDuration(22);
        tvshow7.setReleaseYear(1989);
        tvshow7.setCast("Dan Castellaneta");
        tvshow7.setCast("Nancy Cartwright");
        listOfTVshows.add(tvshow7);
        userAllTVshow.add(tvshow7);

        user1.addToFavorites(tvshow1);
        user1.addToFavorites(tvshow2);
        user1.addToFavorites(tvshow3);
        user1.addToFavorites(tvshow6);

        user1.addToWatch(tvshow4);
        user1.addToWatch(tvshow2);
        user1.addToWatch(tvshow1);
        user1.addToWatch(tvshow7);

        user1.addToLikedTvshow(tvshow1);
        user1.addToLikedTvshow(tvshow2);
        user1.addToLikedTvshow(tvshow3);
        user1.addToLikedTvshow(tvshow6);


        System.out.println("▶NETFLIX◀");
        System.out.println("Do you have an account?\n1.Yes\t2.No");
        int mainCommand = scanner.nextInt();
        switch (mainCommand) {
            case 1:
                System.out.println("Enter your username and password to login");
                String username = scanner.next();
                String password = scanner.next();
                if (listOfUsersName.contains("user1")) {
                    if (netService.login(username, password)) {
                        System.out.println("Welcome ◇" + username + "◇");
                        userMenu();

                    } else {
                        System.out.println("try again");
                        runMenu();
                    }
                } else {
                    System.out.println("username not found!");
                    runMenu();
                }

                break;
            case 2:
                System.out.println("Enter a username");
                String newUsername = scanner.next();
                for (int i = 0; i < listOfUsersName.size(); i++) {
                    if (newUsername.equals(listOfUsersName.get(i).toString())) {
                        System.out.println("username tooken\ntry again");
                    } else {
                        System.out.println("Enter a password");
                        String newPassword = scanner.next();
                        Pattern patternPassword = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
                        Matcher matcherPassword = patternPassword.matcher(newPassword);
                        if (matcherPassword.find()) {
                            User newUser = new User(newUsername, newPassword);
                            newUser.setUsername(newUsername);
                            newUser.setPassword(newPassword);
                            listOfUser.add(newUser);
                            listOfUsersName.add(newUsername);
                            System.out.println("Account created successfully");
                            newUserMenu();

                        } else {
                            System.out.println("Please choose a password which is at least 8 letters and contains both numbers and character");
                            runMenu();
                        }
                    }

                }
                break;
            default:
                System.out.println("choose 1 or 2");
        }

    }

    public static void userMenu() {

        NetflixService netService = new NetflixService();
        ArrayList<TVShow> listOfTVshows = netService.getTVshowsArray();
        ArrayList<Movie> listOfMovie = netService.getMoviesArray();
        ArrayList<User> listOfUser = netService.getUsersArray();
        ArrayList<String> listOfUsersName = netService.getNamesOfUser();

        User user1 = new User("user1", "pass0000");
        user1.setUsername("user1");
        user1.setPassword("pass0000");
        listOfUser.add(user1);
        listOfUsersName.add("user1");
        ArrayList<TVShow> userAllTVshow = user1.getAllTVhows();

        TVShow tvshow1 = new TVShow();
        tvshow1.setTitle("office");
        tvshow1.setGenre("comedy");
        tvshow1.setRating(9.0);
        tvshow1.setDuration(22);
        tvshow1.setReleaseYear(2005);
        tvshow1.setCast("Steve Carell");
        tvshow1.setCast(" Jenna Fischer");
        listOfTVshows.add(tvshow1);
        userAllTVshow.add(tvshow1);

        TVShow tvshow2 = new TVShow();
        tvshow2.setTitle("shrinking");
        tvshow2.setGenre("comedy");
        tvshow2.setRating(7.9);
        tvshow2.setDuration(33);
        tvshow2.setReleaseYear(2023);
        tvshow2.setCast(" Jason Segel");
        tvshow2.setCast("Jessica Williams");
        listOfTVshows.add(tvshow2);
        userAllTVshow.add(tvshow2);

        TVShow tvshow3 = new TVShow();
        tvshow3.setTitle("wednesday");
        tvshow3.setGenre("fantasy");
        tvshow3.setRating(8.1);
        tvshow3.setDuration(45);
        tvshow3.setReleaseYear(2022);
        tvshow3.setCast("Jenna Ortega");
        tvshow3.setCast("Hunter Doohan");
        listOfTVshows.add(tvshow3);
        userAllTVshow.add(tvshow3);

        TVShow tvshow4 = new TVShow();
        tvshow4.setTitle("friends");
        tvshow4.setGenre("comedy");
        tvshow4.setRating(8.9);
        tvshow4.setDuration(22);
        tvshow4.setReleaseYear(1994);
        tvshow4.setCast("Jennifer Aniston");
        tvshow4.setCast("Courteney Cox");
        tvshow4.setCast("Matt LeBlanc");
        listOfTVshows.add(tvshow4);
        userAllTVshow.add(tvshow4);

        TVShow tvshow5 = new TVShow();
        tvshow5.setTitle("bones");
        tvshow5.setGenre("drama");
        tvshow5.setRating(7.8);
        tvshow5.setDuration(40);
        tvshow5.setReleaseYear(2005);
        tvshow5.setCast("Emily Deschanel");
        tvshow5.setCast("David Boreanaz");
        tvshow5.setCast("Michaela Conlin");
        listOfTVshows.add(tvshow5);
        userAllTVshow.add(tvshow5);

        TVShow tvshow6 = new TVShow();
        tvshow6.setTitle("ghosts");
        tvshow6.setGenre("fantasy");
        tvshow6.setRating(7.9);
        tvshow6.setDuration(50);
        tvshow6.setReleaseYear(2021);
        tvshow6.setCast("Rose McIve");
        tvshow6.setCast("Utkarsh Ambudkar");
        listOfTVshows.add(tvshow6);
        userAllTVshow.add(tvshow6);

        TVShow tvshow7 = new TVShow();
        tvshow7.setTitle("simpsons");
        tvshow7.setGenre("animation");
        tvshow7.setRating(8.7);
        tvshow7.setDuration(22);
        tvshow7.setReleaseYear(1989);
        tvshow7.setCast("Dan Castellaneta");
        tvshow7.setCast("Nancy Cartwright");
        listOfTVshows.add(tvshow7);
        userAllTVshow.add(tvshow7);

        user1.addToFavorites(tvshow1);
        user1.addToFavorites(tvshow2);
        user1.addToFavorites(tvshow3);
        user1.addToFavorites(tvshow6);

        user1.addToWatch(tvshow4);
        user1.addToWatch(tvshow2);
        user1.addToWatch(tvshow1);
        user1.addToWatch(tvshow7);

        user1.addToLikedTvshow(tvshow1);
        user1.addToLikedTvshow(tvshow2);
        user1.addToLikedTvshow(tvshow3);
        user1.addToLikedTvshow(tvshow6);

        Scanner scanner = new Scanner(System.in);

        System.out.println("what do you want to do?\n1.search a TV show\t2.view your favorite TV shows\t3.add a TV show to your favorite TV shows\n4.watch a TV show\t5.view your watched TV show\t6.like a TV show\n7.dislike a TV show\t8.view your liked TV show\t9.log out");
        int userCommand = scanner.nextInt();
        switch (userCommand) {
            case 1:
                System.out.println("Do you want to search among... :\n1.your favorite TV shows\t2.all TV shows");
                int amongCommand = scanner.nextInt();
                switch (amongCommand) {
                    case 1: // search among favorite TV shows

                        System.out.println("Do you want to search with :\n1.title\t2.genre\t3.release year");
                        int searchCommand = scanner.nextInt();
                        switch (searchCommand) {
                            case 1:
                                System.out.println("Enter the title");
                                String title = scanner.next();
                                if (user1.searchByTitle(title)) {
                                    user1.searchByTitle(title);
                                }
                                //handle the situation when the given title doesn't exist
                                else {
                                    System.out.println("There isn't any TV show with name ↦ " + title + "in your favorite TV shows");
                                }
                                userMenu();
                                break;
                            case 2:
                                System.out.println("Enter the genre");
                                String genre = scanner.next();
                                if (user1.searchByGenre(genre)) {
                                    user1.searchByGenre(genre);
                                }
                                //handle the situation when the given genre doesn't exist
                                else {
                                    System.out.println("There isn't any TV show in genre ↦ " + genre + "in your favorite TV shows");
                                }
                                userMenu();
                                break;
                            case 3:
                                System.out.println("Enter the release year");
                                int year = scanner.nextInt();
                                if (user1.searchByReleaseYear(year)) {
                                    user1.searchByReleaseYear(year);
                                }
                                //handle the situation when the given release year doesn't exist
                                else {
                                    System.out.println("There isn't any TV show with release year ↦ " + year + "in your favorite TV shows");
                                }
                                userMenu();
                                break;
                            default:
                                System.out.println("choose 1 to 3");
                                userMenu();
                        }
                        break;

                    case 2: //search among all TV shows

                        System.out.println("Do you want to search with :\n1.title\t2.genre\t3.release year");
                        int searchCommand2 = scanner.nextInt();
                        switch (searchCommand2) {
                            case 1:
                                System.out.println("Enter the title");
                                String title = scanner.next();
                                if (netService.searchByTitle(title)) {
                                    netService.searchByTitle(title);
                                }
                                //handle the situation when the given title doesn't exist
                                else {
                                    System.out.println("There isn't any TV show with name ↦ "+ title);
                                }
                                userMenu();
                                break;
                            case 2:
                                System.out.println("Enter the genre");
                                String genre = scanner.next();
                                if (netService.searchByGenre(genre)) {
                                    netService.searchByGenre(genre);
                                }
                                //handle the situation when the given genre doesn't exist
                                else {
                                    System.out.println("There isn't any TV show in genre ↦ " + genre);
                                }
                                userMenu();
                                break;

                            case 3:
                                System.out.println("Enter the release year");
                                int year = scanner.nextInt();
                                if (netService.searchByReleaseYear(year)) {
                                    netService.searchByReleaseYear(year);
                                }
                                //handle the situation when the given release year doesn't exist
                                else {
                                    System.out.println("There isn't any TV show with release year ↦ " + year);
                                }
                                userMenu();
                                break;
                            default:
                                System.out.println("choose 1 to 3");
                                userMenu();
                                break;
                        }
                        break;

                    default:
                        System.out.println("choose 1 or 2");
                }
            case 2:
                user1.viewFavorites();
                userMenu();
                break;

            case 3 :
                System.out.println("Enter name of the TV show you want to add to your favorites ones");
                String newFavorite = scanner.next();
                if (user1.addToFavorites(newFavorite)) {
                    user1.addToFavorites(newFavorite);
                    System.out.println(newFavorite + " added successfully.");
                    userMenu();
                }
                else {
                    System.out.println("There isn't any TV show with tile ↪" + newFavorite + "↩");
                    userMenu();
                }

                break;

            case 4 :
                System.out.println("Enter name of the TV show you want to watch");
                String newWatch = scanner.next();
                if (user1.addToFavorites(newWatch)) {
                    user1.addToFavorites(newWatch);
                    System.out.println(newWatch + " added to watched list.");
                    userMenu();
                }
                else {
                    System.out.println("There isn't any TV show with tile ↪" + newWatch + "↩");
                    userMenu();
                }
                break;

            case 5 :
                user1.viewWatchedlist();
                userMenu();
                break;

            case 6 :
                System.out.println("Enter name of the TV show you want to like :");
                String nameOfTVshow = scanner.next();
                if (user1.like(nameOfTVshow)) {
                    user1.like(nameOfTVshow);
                    userMenu();
                }
                else {
                    System.out.println("There isn't any TV show with title ↪" + nameOfTVshow + "↩");
                    userMenu();
                }
                break;

            case 7 :
                System.out.println("Enter name of the TV show you want to dislike :");
                String nameOfTVshow2 = scanner.next();
                if (user1.disLike(nameOfTVshow2)) {
                    user1.disLike(nameOfTVshow2);
                    userMenu();
                }
                else {
                    System.out.println("There isn't any TV show with title ↪" + nameOfTVshow2 + "↩");
                    userMenu();
                }
                break;

            case 8 :
                user1.viewLikedTVshows();
                userMenu();
                break;

            case 9 :
                netService.logout();
                break;
            default:
            System.out.println("choose  a number from 1 to 8");
            userMenu();
        }
    }

    public static void newUserMenu() {

        NetflixService netService = new NetflixService();
        ArrayList<TVShow> listOfTVshows = netService.getTVshowsArray();
        ArrayList<Movie> listOfMovie = netService.getMoviesArray();
        ArrayList<User> listOfUser = netService.getUsersArray();
        ArrayList<String> listOfUsersName = netService.getNamesOfUser();

        User newUser = new User();
        ArrayList<TVShow> userAllTVshow = newUser.getAllTVhows();

        TVShow tvshow1 = new TVShow();
        tvshow1.setTitle("office");
        tvshow1.setGenre("comedy");
        tvshow1.setRating(9.0);
        tvshow1.setDuration(22);
        tvshow1.setReleaseYear(2005);
        tvshow1.setCast("Steve Carell");
        tvshow1.setCast(" Jenna Fischer");
        listOfTVshows.add(tvshow1);
        userAllTVshow.add(tvshow1);

        TVShow tvshow2 = new TVShow();
        tvshow2.setTitle("shrinking");
        tvshow2.setGenre("comedy");
        tvshow2.setRating(7.9);
        tvshow2.setDuration(33);
        tvshow2.setReleaseYear(2023);
        tvshow2.setCast(" Jason Segel");
        tvshow2.setCast("Jessica Williams");
        listOfTVshows.add(tvshow2);
        userAllTVshow.add(tvshow2);

        TVShow tvshow3 = new TVShow();
        tvshow3.setTitle("wednesday");
        tvshow3.setGenre("fantasy");
        tvshow3.setRating(8.1);
        tvshow3.setDuration(45);
        tvshow3.setReleaseYear(2022);
        tvshow3.setCast("Jenna Ortega");
        tvshow3.setCast("Hunter Doohan");
        listOfTVshows.add(tvshow3);
        userAllTVshow.add(tvshow3);

        TVShow tvshow4 = new TVShow();
        tvshow4.setTitle("friends");
        tvshow4.setGenre("comedy");
        tvshow4.setRating(8.9);
        tvshow4.setDuration(22);
        tvshow4.setReleaseYear(1994);
        tvshow4.setCast("Jennifer Aniston");
        tvshow4.setCast("Courteney Cox");
        tvshow4.setCast("Matt LeBlanc");
        listOfTVshows.add(tvshow4);
        userAllTVshow.add(tvshow4);

        TVShow tvshow5 = new TVShow();
        tvshow5.setTitle("bones");
        tvshow5.setGenre("drama");
        tvshow5.setRating(7.8);
        tvshow5.setDuration(40);
        tvshow5.setReleaseYear(2005);
        tvshow5.setCast("Emily Deschanel");
        tvshow5.setCast("David Boreanaz");
        tvshow5.setCast("Michaela Conlin");
        listOfTVshows.add(tvshow5);
        userAllTVshow.add(tvshow5);

        TVShow tvshow6 = new TVShow();
        tvshow6.setTitle("ghosts");
        tvshow6.setGenre("fantasy");
        tvshow6.setRating(7.9);
        tvshow6.setDuration(50);
        tvshow6.setReleaseYear(2021);
        tvshow6.setCast("Rose McIve");
        tvshow6.setCast("Utkarsh Ambudkar");
        listOfTVshows.add(tvshow6);
        userAllTVshow.add(tvshow6);

        TVShow tvshow7 = new TVShow();
        tvshow7.setTitle("simpsons");
        tvshow7.setGenre("animation");
        tvshow7.setRating(8.7);
        tvshow7.setDuration(22);
        tvshow7.setReleaseYear(1989);
        tvshow7.setCast("Dan Castellaneta");
        tvshow7.setCast("Nancy Cartwright");
        listOfTVshows.add(tvshow7);
        userAllTVshow.add(tvshow7);

        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?\n1.search a movie\t2.add a TV show to your favorite TV shows\t3.view your favorite TV shows\n4.watch a TV show\t5.view your watched TV shows\t6.like a TV show\n7.dislike a TV show\t8.log out");
        int userCommand = scanner.nextInt();
        switch (userCommand) {
            case 1:
                System.out.println("Do you want to search with :\n1.title\t2.genre\t3.release year");
                int searchCommand2 = scanner.nextInt();
                switch (searchCommand2) {
                    case 1:
                        System.out.println("Enter the title");
                        String title = scanner.next();
                        if (netService.searchByTitle(title)) {
                            netService.searchByTitle(title);
                        }
                        //handle the situation when the given title doesn't exist
                        else {
                            System.out.println("There isn't any TV show with name ↦ "+ title);
                        }
                        newUserMenu();
                        break;
                    case 2:
                        System.out.println("Enter the genre");
                        String genre = scanner.next();
                        if (netService.searchByGenre(genre)) {
                            netService.searchByGenre(genre);
                        }
                        //handle the situation when the given genre doesn't exist
                        else {
                            System.out.println("There isn't any TV show in genre ↦ " + genre);
                        }
                        newUserMenu();
                        break;

                    case 3:
                        System.out.println("Enter the release year");
                        int year = scanner.nextInt();
                        if (netService.searchByReleaseYear(year)) {
                            netService.searchByReleaseYear(year);
                        }
                        //handle the situation when the given release year doesn't exist
                        else {
                            System.out.println("There isn't any TV show with release year ↦ " + year);
                        }
                        newUserMenu();
                        break;
                    default:
                        System.out.println("choose 1 to 3");
                        newUserMenu();
                        break;
                }
                break;

            case 2:
                System.out.println("Enter name of the TV show you want to add to your favorites ones");
                String newFavorite = scanner.next();
                if (newUser.addToFavorites(newFavorite)) {
                    newUser.addToFavorites(newFavorite);
                    System.out.println(newFavorite + " added successfully.");
                    newUserMenu();
                }
                else {
                    System.out.println("There isn't any TV show with tile ↪" + newFavorite + "↩");
                    newUserMenu();
                }
                break;

            case 3 :
                newUser.viewFavorites();
                newUserMenu();
                break;

            case 4 :
                System.out.println("Enter name of the TV show you want to watch");
                String newWatch = scanner.next();
                if (newUser.addToFavorites(newWatch)) {
                    newUser.addToFavorites(newWatch);
                    System.out.println(newWatch + " added to watched list.");
                    newUserMenu();
                }
                else {
                    System.out.println("There isn't any TV show with tile ↪" + newWatch + "↩");
                    newUserMenu();
                }
                  break;
            case 5 :
                newUser.viewWatchedlist();
                newUserMenu();
                break;

            case 6 :
                System.out.println("Enter name of the TV show you want to like or dislike :");
                String nameOfTVshow = scanner.next();
                if (newUser.like(nameOfTVshow)) {
                    newUser.like(nameOfTVshow);
                    newUserMenu();
                }
                else {
                    System.out.println("There isn't any TV show with title ↪" + nameOfTVshow + "↩");
                    newUserMenu();
                }
                break;

            case 7 :
                System.out.println("Enter name of the TV show you want to like :");
                String nameOfTVshow2 = scanner.next();
                if (newUser.disLike(nameOfTVshow2)) {
                    newUser.disLike(nameOfTVshow2);
                    newUserMenu();
                }
                else {
                    System.out.println("There isn't any TV show with title ↪" + nameOfTVshow2 + "↩");
                    newUserMenu();
                }
                break;

            case 8 :
                netService.logout();
                break;

            default:
                System.out.println("choose a number from 1 to 7");
                newUserMenu();
        }

    }
}
