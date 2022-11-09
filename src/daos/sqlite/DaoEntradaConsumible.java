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
import model.Entrada;
import model.EntradaConsumible;

/**
 *
 * @author kevin
 */
public class DaoEntradaConsumible extends BaseDao<EntradaConsumible> {

    public DaoEntradaConsumible(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<EntradaConsumible> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<EntradaConsumible> selectLight() {
        String sql = "SELECT id, entrada, consumible, cantidad FROM tbl_entrada_consumible";
        
        ArrayList<EntradaConsumible> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new EntradaConsumible(
                        rs.getLong("id"),
                        new Entrada(rs.getLong("entrada")),
                        new Consumible(rs.getLong("consumible")),
                        rs.getInt("cantidad")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<EntradaConsumible> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntradaConsumible read(EntradaConsumible obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected EntradaConsumible create(EntradaConsumible obj) {
        String sql = "INSERT INTO tbl_entrada_consumible(entrada, consumible, cantidad) VALUES(?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getEntrada().getId());
            pstmt.setLong(2, obj.getConsumible().getId());
            pstmt.setLong(3, obj.getCantidad());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected EntradaConsumible update(EntradaConsumible obj) {
        String sql = "UPDATE tbl_entrada_consumible SET entrada = ? , "
                + "consumible = ? ,"
                + "cantidad = ? "                
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setLong(1, obj.getEntrada().getId());
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
    protected EntradaConsumible delete(EntradaConsumible obj) {
        String sql = "DELETE FROM tbl_entrada_consumible WHERE id = ?";
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