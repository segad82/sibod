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
import model.Consumible;
import model.Entrega;
import model.EntregaConsumible;

/**
 *
 * @author kevin
 */
public class DaoEntregaConsumible extends BaseDao<EntregaConsumible> {

    public DaoEntregaConsumible(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<EntregaConsumible> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<EntregaConsumible> selectLight() {
        String sql = "SELECT id, entrega, consumible, cantidad FROM tbl_entrega_consumible";
        
        ArrayList<EntregaConsumible> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new EntregaConsumible(
                        rs.getLong("id"),
                        new Entrega(rs.getLong("entrega")),
                        new Consumible(rs.getLong("consumible")),
                        rs.getInt("cantidad")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<EntregaConsumible> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntregaConsumible read(EntregaConsumible obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected EntregaConsumible create(EntregaConsumible obj) {
        String sql = "INSERT INTO tbl_entrega_consumible(entrega, consumible, cantidad) VALUES(?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getEntrega().getId());
            pstmt.setLong(2, obj.getConsumible().getId());
            pstmt.setLong(3, obj.getCantidad());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected EntregaConsumible update(EntregaConsumible obj) {
        String sql = "UPDATE tbl_entrega_consumible SET entrega = ? , "
                + "consumible = ? ,"
                + "cantidad = ? "                
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setLong(1, obj.getEntrega().getId());
            pstmt.setLong(2, obj.getConsumible().getId());
            pstmt.setInt(3, obj.getCantidad());
            pstmt.setLong(4, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected EntregaConsumible delete(EntregaConsumible obj) {
        String sql = "DELETE FROM tbl_entrega_consumible WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setLong(1, obj.getId());
            // execute the delete statement
            result = pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }
    
}