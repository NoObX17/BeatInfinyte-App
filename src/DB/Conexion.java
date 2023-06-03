package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
    public static void main(String[] args) {
        Conexion con = new Conexion();
                
    }
    
    //ATRIBUTO
    public static Connection conexion = null;
    
    //CONSTRUCTOR
    public Conexion() {
        this.connect();
    }
    
    //METODO CONEXION DB
    private void connect() {
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
        }   catch (ClassNotFoundException exc) {
            System.out.println("No se ha detectado el driver" + exc);
            }
        
        Conexion.conexion = 
        DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/beatinfinyte", "hugo", "HugoNazi18.");
        System.out.println("Todo correcto");
        }   catch (java.sql.SQLException sqle){
            System.out.println("Error: "+sqle);
            JOptionPane.showMessageDialog(null, "Ha habido un error al conectar con la base de datos"
                    + "\nPrueba de nuevo","Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //METODO CERRAR DB
    public static void closeConnection(){
        if(Conexion.conexion!=null){
            try {
                Conexion.conexion.close();
            } catch (SQLException sqle){
                System.out.println("Error al cerrar la conexion: "+sqle);
            }
        }
    }
    
}


