/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlacenaBeltran;

/**
 *
 * @author abeltran
 */
public class App {
    public static void main(String[] args){
       // Login log = new Login();
        //log.setVisible(true);
        MenuPrincipal log=new MenuPrincipal();
        log.setVisible(true);
        Conexion con =new Conexion();
        con.connect();
    }
}
