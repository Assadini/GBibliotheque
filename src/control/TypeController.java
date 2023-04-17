package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Connect;
import objets_metiers.TypeOeuvre;

public class TypeController {

public ArrayList<TypeOeuvre> getAll(){
	try {
		ArrayList<TypeOeuvre> tab=new ArrayList();
		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `TypeOeuvre` FROM `typeoeuvre` WHERE 1");
		ResultSet rs=st.executeQuery();
		while(rs.next())
			tab.add(new TypeOeuvre(rs.getInt("ID"),rs.getString("TypeOeuvre")));
		rs.close();
		st.close();
		return tab;
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
return null;
	
	
}	
public TypeOeuvre getById(int id){
	try {
		ArrayList<TypeOeuvre> tab=new ArrayList();
		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `TypeOeuvre` FROM `typeoeuvre` WHERE ID=?");
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return new TypeOeuvre(rs.getInt("ID"),rs.getString("TypeOeuvre"));
		rs.close();
		st.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
return null;
	
	
}	
public TypeOeuvre getByNom(String nom){
	try {
		ArrayList<TypeOeuvre> tab=new ArrayList();
		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `TypeOeuvre` FROM `typeoeuvre` WHERE TypeOeuvre=?");
		st.setString(1, nom);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return new TypeOeuvre(rs.getInt("ID"),rs.getString("TypeOeuvre"));
		rs.close();
		st.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
return null;
	
	
}	
}
