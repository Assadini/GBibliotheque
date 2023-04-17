package control;

import Utility.BibalExceptions;
import dao.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import objets_metiers.Oeuvre;
/**
 * 
 * @author Aymen Souelmi
 */
public class OeuvreControl {

    public static void ajouter(Oeuvre oeuvre) throws BibalExceptions {
        //Verifier la validité des informations
        oeuvre.setTitre(oeuvre.getTitre());
        oeuvre.setAuteur(oeuvre.getAuteur());
        oeuvre.setCategorie(oeuvre.getCategorie());

        oeuvre.ajouter(oeuvre);
    }

    public static void modifier(Oeuvre oeuvre) throws BibalExceptions {
        oeuvre.setId(oeuvre.getId());
        oeuvre.setTitre(oeuvre.getTitre());
        oeuvre.setAuteur(oeuvre.getAuteur());
        oeuvre.setCategorie(oeuvre.getCategorie());
        oeuvre.setNbResa(oeuvre.getNbResa());

        oeuvre.modifier(oeuvre);
    }
/*
    public static void supprimer(Oeuvre oeuvre) throws BibalExceptions {
        oeuvre.delete(oeuvre);
    }
    public static Oeuvre findById(int id) throws BibalExceptions {
        Oeuvre oeuvre = new Oeuvre();
        return oeuvre.findById(id);
    }

    public static ArrayList<Oeuvre> findByTitre(String titre) throws BibalExceptions {
        //Oeuvre oeuvre = new Oeuvre();
        return new Oeuvre().findByTitre(titre);
    }
    public static ArrayList<Oeuvre> getListOeuvres() throws BibalExceptions {
        return new Oeuvre().getListOeuvres();
    }
    
    */
    public ArrayList<Oeuvre> getAll(){
    	try {
    		String query= "SELECT o.ID As ID, `Titre`, `Auteur`, `Categorie`, `NbResa`, `Lending`,typeOeuvre as Type,"
    				+ "COUNT(e.oeuvreID) AS nbExemplaire FROM oeuvre o LEFT JOIN exemplaire e ON o.id = e.oeuvreID\n"
    				+ "GROUP BY o.id \n"
    				+ "ORDER BY o.id Asc;";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		ResultSet rs=st.executeQuery();
    		ArrayList<Oeuvre> tab=new ArrayList();
    		TypeController tc=new TypeController();
    		while(rs.next())
    		{
    			tab.add(new Oeuvre(rs.getInt("ID"),rs.getString("Titre"),rs.getString("Auteur"),rs.getString("Categorie"),rs.getInt("Nbresa"),rs.getInt("nbExemplaire"),rs.getInt("Lending"),tc.getById(rs.getInt("Type"))));
    		}
    		st.close();
    		rs.close();
    		return tab;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return null;
    }
    public Oeuvre getById(int id){
    	try {
    		String query= "SELECT o.ID As ID, `Titre`, `Auteur`, `Categorie`, `NbResa`, `Lending`,typeOeuvre as Type,\n"
    				+ "COUNT(e.oeuvreID) AS nbExemplaire FROM oeuvre o LEFT JOIN exemplaire e ON o.id = e.oeuvreID where  o.ID=27\n"
    				+ "GROUP BY o.id \n"
    				+ "ORDER BY o.id Asc;";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		ResultSet rs=st.executeQuery();
    		TypeController tc=new TypeController();
    		if(rs.next())
    		{
    		return new Oeuvre(rs.getInt("ID"),rs.getString("Titre"),rs.getString("Auteur"),rs.getString("Categorie"),rs.getInt("Nbresa"),rs.getInt("nbExemplaire"),rs.getInt("Lending"),tc.getById(rs.getInt("Type")));
    		}
    		st.close();
    		rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return null;
    }
    public boolean insert(Oeuvre o){
    	try {
    		String query= "INSERT INTO `oeuvre`(`Titre`, `Auteur`, `Categorie`, `NbResa`, `Lending`, `typeoeuvre`) VALUES (?,?,?,?,?,?)";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setString(1, o.getTitre());
    		st.setString(2, o.getAuteur());
    		st.setString(3, o.getCategorie());
    		st.setInt(4, o.getNbResa());
    		st.setInt(5, o.getLending());
    		st.setInt(6, o.getType().getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
    public boolean modify(Oeuvre o){
    	try {
    		String query= "UPDATE `oeuvre` SET `Titre`=?,`Auteur`=?,`Categorie`=?,`NbResa`=?,`Lending`=?,`typeoeuvre`=? WHERE ID=?";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setString(1, o.getTitre());
    		st.setString(2, o.getAuteur());
    		st.setString(3, o.getCategorie());
    		st.setInt(4, o.getNbResa());
    		st.setInt(5, o.getLending());
    		st.setInt(6, o.getType().getId());
    		st.setInt(7, o.getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
    public boolean delete(Oeuvre o){
    	try {
    		String query= "DELETE FROM `oeuvre` WHERE ID=?";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1, o.getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
}
