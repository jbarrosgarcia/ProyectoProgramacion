/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlacenaBeltran;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricky_000
 */
public class MetodosDB extends Conexion {

    /**
     * Método que añade datos a la base de datos.
     *
     * @param sql
     * @return
     */
    public boolean insertar(String sql) {
        boolean valor = true;
        connect();
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException ex) {
            valor = false;
            JOptionPane.showMessageDialog(null, "Error insertar" + ex.getMessage());
        } finally {
            try {
                consulta.close();
                connect.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return valor;
    }

    /**
     * Método que lee la bd y devuelve el resultado. Usado para el método
     * "totalPersonas"
     *
     * @param sql
     * @return
     */
    public ResultSet consultar(String sql) {
        connect();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Mensaje:" + ex.getMessage());
            System.out.println("Estado:" + ex.getSQLState());
            System.out.println("Codigo del error:" + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, "Error consulta    " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Método para guardar el producto.
     *
     * @param producto
     */
    public void guardarProducto(Producto producto) {
        insertar("insert into productos values(" + producto.getId()
                + ",'" + producto.getNombre()
                + "','" + producto.getPrecio()
                + "','" + producto.getUnidades() + "')");
    }

    
    /**
     * Método para guardar el usuario.
     * @param usuario 
     */
    public void guardarUsuario(Empleado usuario) {
        insertar("insert into usuarios values(" + usuario.getId()
                + ",'" + usuario.getNombre()
                + "','" + usuario.getPassword()+ "')");
    }

    /**
     * Método para leer producto.
     *
     * @param tableModel
     */
    public void totalProductos(DefaultTableModel tableModel) {
        ResultSet resultado = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "select * from productos";
        try {
            resultado = consultar(sql);
            if (resultado != null) {
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for (int j = 1; j <= numeroColumna; j++) {
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while (resultado.next()) {
                    Object[] objetos = new Object[numeroColumna];
                    for (int i = 1; i <= numeroColumna; i++) {
                        objetos[i - 1] = resultado.getObject(i);
                    }
                    tableModel.addRow(objetos);
                }
            }
        } catch (SQLException ex) {
        } finally {
            try {
                consulta.close();
                connect.close();
                if (resultado != null) {
                    resultado.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Método para leer usuarios.
     *
     * @param tableModel
     */
    public void totalUsuarios(DefaultTableModel tableModel) {
        ResultSet resultado = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "select * from usuarios";
        try {
            resultado = consultar(sql);
            if (resultado != null) {
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for (int j = 1; j <= numeroColumna; j++) {
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while (resultado.next()) {
                    Object[] objetos = new Object[numeroColumna];
                    for (int i = 1; i <= numeroColumna; i++) {
                        objetos[i - 1] = resultado.getObject(i);
                    }
                    tableModel.addRow(objetos);
                }
            }
        } catch (SQLException ex) {
        } finally {
            try {
                consulta.close();
                connect.close();
                if (resultado != null) {
                    resultado.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminar(String idsql) throws SQLException {
        String query = "DELETE FROM productos WHERE id = " + idsql;
        PreparedStatement rs = connect.prepareStatement(query);
        rs.execute();
    }
}
