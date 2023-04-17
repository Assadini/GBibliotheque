package TestControlers;
import junit.framework.TestCase;

import java.util.ArrayList;
import Utility.GbException;
import control.ExemplaireControl;
import objets_metiers.Exemplaire;
import objets_metiers.Oeuvre;
import objets_metiers.TypeOeuvre;	

public class TestExemplaireControleur extends TestCase{



	    public void testAjouter() {
	    	
	    		Oeuvre oeuvre = new Oeuvre();
	    		  String etatExemplaire = "Neuf";
	    		try {
	        oeuvre.setId(1);
	      
	        
	            ExemplaireControl.ajouter(oeuvre, etatExemplaire);
	            fail("Expected GbException was not thrown");
	        } catch (GbException e) {
	            assertEquals("L'oeuvre n'existe pas", e.getMessage());
	        }
	    		  try {
	     
	        oeuvre.setId(2);
	      
	            ExemplaireControl.ajouter(oeuvre, etatExemplaire);
	        } catch (GbException e) {
	            fail("Unexpected exception: " + e.getMessage());
	        }
	    }

	    public void testFindById() {
	   
	        int id = 1;
	        try {
	            Exemplaire exemplaire = ExemplaireControl.findById(id);
	            assertNotNull(exemplaire);
	            assertEquals(id, exemplaire.getId());
	        } catch (GbException e) {
	            fail("Unexpected exception: " + e.getMessage());
	        }

	        id = 999;
	        try {
	            Exemplaire exemplaire = ExemplaireControl.findById(id);
	            assertNull(exemplaire);
	        } catch (GbException e) {
	            fail("Unexpected exception: " + e.getMessage());
	        }
	    }

	    public void testFindExemplaireDispo() {
	        Oeuvre oeuvre = new Oeuvre();
	        try {
	        oeuvre.setId(1);
	       
	            ArrayList<Exemplaire> exemplaires = ExemplaireControl.findExemplaireDispo(oeuvre);
	            assertNotNull(exemplaires);
	            assertTrue(exemplaires.size() > 0);
	        } catch (GbException e) {
	            fail("Unexpected exception: " + e.getMessage());
	        }
	        try {
	        oeuvre.setId(999);
	        
	            ArrayList<Exemplaire> exemplaires = ExemplaireControl.findExemplaireDispo(oeuvre);
	            assertNull(exemplaires);
	        } catch (GbException e) {
	            fail("Unexpected exception: " + e.getMessage());
	        }
	    }

	}
