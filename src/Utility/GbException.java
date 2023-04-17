package Utility;

import javax.swing.JOptionPane;


public class GbException extends Exception{

    public GbException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Informations", JOptionPane.PLAIN_MESSAGE);
    }
    
    public GbException(Throwable cause) {
        super(cause);
    }
    
    public GbException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
