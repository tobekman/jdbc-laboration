package com.tobiasekman;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    static Connection conn;
    static Statement st;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/artist_management", "root", "password");
            st = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Could not connect to database");
        }
    }

    public void Add(Artist artist) throws SQLException {
        PreparedStatement add = conn.prepareStatement("INSERT INTO artist (firstname, lastname, age, stagename) values (?,?,?,?)");

        add.setString(1, artist.getFirstName());
        add.setString(2, artist.getLastName());
        add.setInt(3, artist.getAge());
        add.setString(4, artist.getStageName());

        add.executeUpdate();
        add.close();
    }

    public List<Artist> getArtists() throws SQLException {

        ResultSet rs = st.executeQuery("SELECT * FROM artist");
        List<Artist> artists = new ArrayList<>();
        while (rs.next()) {
            Artist artist = new Artist(rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getInt("age"),
                    rs.getString("stagename"));
            artists.add(artist);
        }

        rs.close();
        return artists;

    }

    public void updateArtist(Artist artist) throws SQLException {

        PreparedStatement update = conn.prepareStatement("UPDATE artist SET firstname = ?, lastname = ?, age = ?, stagename = ? WHERE id = ?");

        update.setString(1, artist.getFirstName());
        update.setString(2, artist.getLastName());
        update.setInt(3, artist.getAge());
        update.setString(4, artist.getStageName());
        update.setInt(5, artist.getId());

        update.executeUpdate();
        update.close();

    }

    public void deleteArtist(int id) throws SQLException {
        PreparedStatement deleteEmployee = conn.prepareStatement("DELETE FROM artist WHERE id=?");

        deleteEmployee.setInt(1, id);

        deleteEmployee.executeUpdate();
        deleteEmployee.close();
    }

    public Artist findArtistById(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM artist WHERE id=" + id);
        Artist artist = new Artist();
        while(rs.next()) {
            artist.setId(rs.getInt("id"));
            artist.setFirstName(rs.getString("firstname"));
            artist.setLastName(rs.getString("lastname"));
            artist.setAge(rs.getInt("age"));
            artist.setStageName(rs.getString("stagename"));
        }
        rs.close();
        return artist;

    }

}
