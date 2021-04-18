package com.tobiasekman;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArtistManager {

    Scanner sc = new Scanner(System.in);
    DatabaseHandler db = new DatabaseHandler();
    List<Artist> artists;

    public void showAllArtists() throws SQLException {
        artists = db.getArtists();

        for (Artist artist : artists) {
            System.out.println(artist);
        }

    }

    public void createArtist() {

        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Last name: ");
        String lastName = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Stage name: ");
        String stageName = sc.nextLine();

        Artist artist = new Artist(firstName, lastName, age, stageName);

        db.Add(artist);

    }

    public void updateArtist() throws SQLException {
        showAllArtists();
        System.out.print("ID to update: ");
        Artist artist = db.findArtistById(sc.nextInt());
        sc.nextLine();
        System.out.print("First name: ");
        artist.setFirstName(sc.nextLine());
        System.out.print("Last name: ");
        artist.setLastName(sc.nextLine());
        System.out.print("Age: ");
        artist.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("Stage name: ");
        artist.setStageName(sc.nextLine());

        db.updateArtist(artist);
    }

    public void deleteArtistById() throws SQLException {
        showAllArtists();
        System.out.print("ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        db.deleteArtist(id);
    }

    public void showArtist() throws SQLException {
        System.out.print("ID: ");
        Artist artist = db.findArtistById(sc.nextInt());
        sc.nextLine();
        System.out.println(artist);
    }

}
