package control;

import Utility.BibalExceptions;
import dao.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import objets_metiers.Oeuvre;
import objets_metiers.Usager;
/**
 * 
 * @author Aymen Souelmi
 */
public class UsagerControl {

	
	
    public static void ajouter(Usager usager) throws BibalExceptions {
        //Verifier la validité des informations
        usager.setNom(usager.getNom());
        usager.setPrenom(usager.getPrenom());
        usager.setDateNais(usager.getDateNais());
        usager.setSexe(usager.getSexe());
        usager.setAdresse(usager.getAdresse());
        usager.setTel(usager.getTel());

        usager.ajouter(usager);
    }

    public static void modifier(Usager usager) throws BibalExceptions {
        //Verifier que les informations sont valides
        usager.setNom(usager.getNom());
        usager.setPrenom(usager.getPrenom());
        usager.setDateNais(usager.getDateNais());
        usager.setSexe(usager.getSexe());
        usager.setAdresse(usager.getAdresse());
        usager.setTel(usager.getTel());

        usager.modifier(usager);
    }

    public static void supprimer(Usager usager) throws BibalExceptions {
        usager.delete(usager);
    }

    public static Usager findById(int id) throws BibalExceptions {
        return new Usager().findById(id);
    }

    public static ArrayList<Usager> findByNom(String nom) throws BibalExceptions {
        return new Usager().findByNom(nom);
    }
    
    public static ArrayList<Usager> getListUsagers() throws BibalExceptions {
        return new Usager().getListUsagers();
    }
    public ArrayList<Usager> getAll(){
    	try {
    		String query= "SELECT `ID`, `Nom`, `Prenom`, `DateNais`, `Sexe`, `Adresse`, `Tel` FROM `usager` WHERE 1;";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		ResultSet rs=st.executeQuery();
    		ArrayList<Usager> tab=new ArrayList();
    		while(rs.next())
    		{
    		tab.add(new Usager(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom"),rs.getDate("DateNais"),rs.getString("Sexe"),rs.getString("Adresse"),rs.getString("Tel")));
    		}
    		
    		st.close();
    		rs.close();
    		return tab;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return null;
    }
}
