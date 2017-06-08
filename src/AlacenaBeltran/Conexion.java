/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlacenaBeltran;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jose Barros
 */
public class Conexion {
    Connection connect;
    Statement consulta;

 public void connect(){
 try {
     connect = DriverManager.getConnection("jdbc:sqlite:baseproductos.db");
     consulta =connect.createStatement();
     if (connect!=null) {
         System.out.println("Conectado");
     }
 }catch (SQLException ex) {
     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
 }
}
 public void close(){
        try {
            consulta.close();
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public String logger(String sql){
      ResultSet resultado = null;
      String res="";
        try {
            resultado = consulta.executeQuery(sql);
            res=resultado.toString();
        } catch (SQLException ex) {
            System.out.println("Mensaje:" + ex.getMessage());
            System.out.println("Estado:" + ex.getSQLState());
            System.out.println("Codigo del error:" + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, "Error consulta    " + ex.getMessage());
        }
        return res;
 }
}
