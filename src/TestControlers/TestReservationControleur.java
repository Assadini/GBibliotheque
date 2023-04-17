package TestControlers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Utility.GbException;
import control.ReservationControl;
import objets_metiers.Oeuvre;
import objets_metiers.Reservation;
import objets_metiers.Usager;

public class TestReservationControleur  {

    @Test
    public void testReserver() throws GbException {
        Usager usager = new Usager();
        usager.setNom("John");
        usager.setPrenom("Doe");
        usager.setEmail("johndoe@example.com");
        usager.setMotDePasse("password");
        usager.creer();
        
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setTitre("Book");
        oeuvre.setAuteur("Author");
        oeuvre.setAnnee(2022);
        oeuvre.setNbResa(0);
        oeuvre.creer();
        
        ReservationControl.reserver(usager.getId(), oeuvre.getTitre());
        
        ArrayList<Reservation> reservations = ReservationControl.findByReservation(oeuvre);
        assertEquals(1, reservations.size());
    }
    
    @Test
    public void testAnnuler() throws GbException {
        Usager usager = new Usager();
        usager.setNom("John");
        usager.setPrenom("Doe");
        usager.setEmail("johndoe@example.com");
        usager.setMotDePasse("password");
        usager.creer();
        
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setTitre("Book");
        oeuvre.setAuteur("Author");
        oeuvre.setAnnee(2022);
        oeuvre.setNbResa(0);
        oeuvre.creer();
        
        Reservation reservation = new Reservation(usager, oeuvre, new Date());
        reservation.creer();
        
        ReservationControl.annuler(usager.getId(), oeuvre.getTitre());
        
        ArrayList<Reservation> reservations = ReservationControl.findByReservation(oeuvre);
        assertEquals(0, reservations.size());
    }
    
    @Test
    public void testReserverWithInvalidUsager() {
        Exception exception = assertThrows(GbException.class, () -> {
            ReservationControl.reserver(0, "Book");
        });
        assertEquals("L'usager n'est pas enregistré", exception.getMessage());
    }
    
    @Test
    public void testReserverWithInvalidOeuvre() {
        Exception exception = assertThrows(GbException.class, () -> {
            ReservationControl.reserver(1, "Invalid Book");
        });
        assertEquals("L'oeuvre n'existe pas", exception.getMessage());
    }
    
    @Test
    public void testAnnulerWithInvalidUsager() {
        Exception exception = assertThrows(GbException.class, () -> {
            ReservationControl.annuler(0, "Book");
        });
        assertEquals("L'usager n'est pas enregistré", exception.getMessage());
    }
    
    @Test
    public void testAnnulerWithInvalidOeuvre() {
        Exception exception = assertThrows(GbException.class, () -> {
            ReservationControl.annuler(1, "Invalid Book");
        });
        assertEquals("L'oeuvre n'existe pas", exception.getMessage());
    }
    
}
