package TestControlers;

import java.util.Date;

import Utility.GbException;
import control.EmpruntControl;
import junit.framework.TestCase;
import objets_metiers.Emprunt;
import objets_metiers.Exemplaire;
import objets_metiers.Oeuvre;
import objets_metiers.Usager;

public class TestEmpruntControleur extends TestCase {

    public void testEmprunter() {
       
        try {
            int id = 1;
            String titre = "Test Oeuvre";
            EmpruntControl.emprunter(id, titre);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

     
        try {
            int id = 999;
            String titre = "Test Oeuvre";
            EmpruntControl.emprunter(id, titre);
            fail("Expected GbException not thrown");
        } catch (Exception e) {
            assertEquals("L'usager n'est pas enregistré", e.getMessage());
        }

        
        try {
            int id = 1;
            String titre = "Invalid Test Oeuvre";
            EmpruntControl.emprunter(id, titre);
            fail("Expected GbException not thrown");
        } catch (Exception e) {
            assertEquals("L'oeuvre n'existe pas", e.getMessage());
        }

     
        try {
            int id = 1;
            String titre = "No available exemplaire";
            EmpruntControl.emprunter(id, titre);
            fail("Expected GbException not thrown");
        } catch (Exception e) {
            assertEquals("Aucun exemplaire de l'oeuvre 'No available exemplaire' n'est disponible\n", e.getMessage());
        }
    }

    public void testRendre() {
      
        Usager usager = new Usager();
        try {
			usager.setId(1);
		
        usager.setNom("Test Usager");
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setId(1);
        oeuvre.setTitre("Test Oeuvre");
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(1);
        exemplaire.setOeuvresExamplaire(oeuvre);


            Emprunt emprunt = new Emprunt();
            emprunt.emprunter(usager, oeuvre, exemplaire, new Date("2023-04-14"));
            EmpruntControl.rendre(emprunt);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        try {
            EmpruntControl.rendre(new Emprunt());
            fail("Expected GbException not thrown");
        } catch (Exception e) {
            assertEquals("L'emprunt n'existe pas", e.getMessage());
        }
    }

    public void testFindEmprunts() {
    	
        try {
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setId(1);
        oeuvre.setTitre("Test Oeuvre");

       
            EmpruntControl.findEmprunts(oeuvre);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    public void testSupprimer() {
    	 try {
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(1);
        
       
          
            EmpruntControl.supprimer(exemplaire);
            
            
            assertNull(exemplaire.find(exemplaire.getOeuvresExamplaire(), exemplaire.getId()));
        } catch (GbException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}