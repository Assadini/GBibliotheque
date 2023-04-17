package control;

import Utility.BibalExceptions;
import dao.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import objets_metiers.Exemplaire;
import objets_metiers.Oeuvre;
import objets_metiers.TypeOeuvre;
/**
 * 
 * @author Aymen Souelmi
 */
public class ExemplaireControl {

   /* public static void ajouter(Oeuvre oeuvre, String etatExemplaire) throws BibalExceptions {
         oeuvre = oeuvre.findById(oeuvre.getId());
        if (null == oeuvre) {
            throw new BibalExceptions("L'oeuvre n'existe pas");
        }
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.ajouter(oeuvre, etatExemplaire);
    }

    public static void modifier(Exemplaire exemplaire) throws BibalExceptions {
        exemplaire.setId(exemplaire.getId());
        exemplaire.setEtat(exemplaire.getEtat());

        exemplaire.modifier(exemplaire);
    }

    public static void supprimer(Exemplaire exemplaire) throws BibalExceptions {
        exemplaire.delete(exemplaire);
    }

    public static Exemplaire findById(int id) throws BibalExceptions {
        Exemplaire exemplaire = new Exemplaire();
        return exemplaire.findById(id);
    }

    public static ArrayList<Exemplaire> findExemplaireDispo(Oeuvre oeuvre) throws BibalExceptions {
        Exemplaire exemplaire = new Exemplaire();
        return exemplaire.findExemplaireDispo(oeuvre);
    }

    public static ArrayList<Exemplaire> find(Oeuvre oeuvre) throws BibalExceptions {
        Exemplaire exemplaire = new Exemplaire();
        return exemplaire.find(oeuvre);
    }*/
    
    public ArrayList<Exemplaire> getAll(){
    	try {
    		ArrayList<Exemplaire> tab=new ArrayList();
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `OeuvreID`, `etat` FROM `exemplaire` WHERE 1");
    		ResultSet rs=st.executeQuery();
    		OeuvreControl o=new OeuvreControl();
    		while(rs.next())
    			tab.add(new Exemplaire(rs.getInt("ID"),rs.getString("etat"),o.getById(rs.getInt("OeuvreID"))));
    		rs.close();
    		st.close();
    		return tab;
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    return null;
    	
    	
    }	
}
