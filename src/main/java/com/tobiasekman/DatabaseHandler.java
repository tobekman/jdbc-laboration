package com.tobiasekman;

import javax.persistence.*;
import java.util.List;

public class DatabaseHandler {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public DatabaseHandler() {

        this.entityManagerFactory = Persistence.createEntityManagerFactory("artist_management");
        this.entityManager = entityManagerFactory.createEntityManager();

    }


    public void Add(Artist artist) {

        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();

    }

    public List<Artist> getArtists() {

        return entityManager.createQuery("SELECT a FROM Artist a").getResultList();

    }

    public void updateArtist(Artist artist) {

        entityManager.getTransaction().begin();
        Artist updatedArtist = entityManager.find(Artist.class, artist.getId());
        updatedArtist.setFirstName(artist.getFirstName());
        updatedArtist.setLastName(artist.getLastName());
        updatedArtist.setAge(artist.getAge());
        updatedArtist.setStageName(artist.getStageName());
        entityManager.getTransaction().commit();

    }

    public void deleteArtist(int id) {

        entityManager.getTransaction().begin();
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.remove(artist);
        entityManager.getTransaction().commit();

    }

    public Artist findArtistById(int id) {

        return entityManager.find(Artist.class, id);

    }

}
