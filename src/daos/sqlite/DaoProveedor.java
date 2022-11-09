/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Proveedor;

/**
 *
 * @author kevin
 */
public class DaoProveedor extends BaseDao<Proveedor> {

    public DaoProveedor(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<Proveedor> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<Proveedor> selectLight() {
        String sql = "SELECT id, nombre, correo, telefono, estado FROM tbl_proveedor";
        
        ArrayList<Proveedor> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Proveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getBoolean("estado")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Proveedor> selectRange(int index, int count) {
        String sql = "SELECT rowid as i, id, nombre, correo, telefono, estado FROM tbl_proveedor where i between ? and ?";
        
        ArrayList<Proveedor> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Proveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getBoolean("estado")));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    @Override
    protected Proveedor read(Proveedor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Proveedor create(Proveedor obj) {
        String sql = "INSERT INTO tbl_proveedor(nombre, correo, telefono, estado) VALUES(?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getNombre());
            pstmt.setString(2, obj.getCorreo());
            pstmt.setString(3, obj.getTelefono());
            pstmt.setBoolean(4, obj.getEstado());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Proveedor update(Proveedor obj) {
        String sql = "UPDATE tbl_proveedor SET nombre = ? , "
                + "correo = ? ,"
                + "telefono = ? ,"
                + "estado = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getNombre());
            pstmt.setString(2, obj.getCorreo());
            pstmt.setString(3, obj.getTelefono());
            pstmt.setBoolean(4, obj.getEstado());
            pstmt.setInt(5, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Proveedor delete(Proveedor obj) {
        String sql = "DELETE FROM tbl_proveedor WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, obj.getId());
            // execute the delete statement
            result = pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }
    
}