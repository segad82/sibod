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
import model.OrdenCompra;

/**
 *
 * @author kevin
 */
public class DaoOrdenCompra extends BaseDao<OrdenCompra> {
    
    public DaoOrdenCompra(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<OrdenCompra> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<OrdenCompra> selectLight() {
        String sql = "SELECT id, nombre, estado FROM tbl_orden_compra";
        
        ArrayList<OrdenCompra> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new OrdenCompra(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getBoolean("estado")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<OrdenCompra> selectRange(int index, int count) {
        String sql = "SELECT rowid as i, id, nombre, estado FROM tbl_orden_compra where i between ? and ?";
        
        ArrayList<OrdenCompra> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new OrdenCompra(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getBoolean("estado")));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    @Override
    protected OrdenCompra read(OrdenCompra obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected OrdenCompra create(OrdenCompra obj) {
        String sql = "INSERT INTO tbl_orden_compra(nombre, estado) VALUES(?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getNombre());
            pstmt.setBoolean(2, obj.getEstado());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected OrdenCompra update(OrdenCompra obj) {
        String sql = "UPDATE tbl_orden_compra SET nombre = ? , "
                + "estado = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getNombre());
            pstmt.setBoolean(2, obj.getEstado());
            pstmt.setInt(3, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected OrdenCompra delete(OrdenCompra obj) {
        String sql = "DELETE FROM tbl_orden_compra WHERE id = ?";
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