package Utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Connect {

    public static Connection getConnection() throws SQLException, GbException {
        try {
           String url ="jdbc:mysql://localhost:3306/gbiblio";
           String driver ="com.mysql.jdbc.Driver";
           String nomUtilisateur = "root";
           String motDePasse = "";
           return DriverManager.getConnection(url, nomUtilisateur, motDePasse);
        } catch (Exception ex) {
            throw new GbException(ex.getMessage());

        
    }

    }
    }
