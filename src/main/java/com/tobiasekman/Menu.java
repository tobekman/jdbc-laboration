package com.tobiasekman;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    static ArtistManager am = new ArtistManager();

    public static void menu() throws SQLException {
        System.out.println("-Artist management-");
        System.out.println("[1] Show all artists");
        System.out.println("[2] Create artist");
        System.out.println("[3] Update artist");
        System.out.println("[4] Delete artist");
        System.out.println("[5] Show artist");


        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                am.showAllArtists();
                break;
            case 2:
                am.createArtist();
                break;
            case 3:
                am.updateArtist();
                break;
            case 4:
                am.deleteArtistById();
                break;
            case 5:
                am.showArtist();
                break;
            default:
                break;
        }
    }

}
