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
import model.Activo;
import model.Entrega;
import model.EntregaActivo;

/**
 *
 * @author kevin
 */
public class DaoEntregaActivo extends BaseDao<EntregaActivo> {

    public DaoEntregaActivo(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<EntregaActivo> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<EntregaActivo> selectLight() {
        String sql = "SELECT id, entrada, activo FROM tbl_entrega_activo";
        
        ArrayList<EntregaActivo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new EntregaActivo(
                        rs.getLong("id"),
                        new Entrega(rs.getLong("entrega")),
                        new Activo(rs.getLong("activo"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<EntregaActivo> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected EntregaActivo read(EntregaActivo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntregaActivo create(EntregaActivo obj) {
        String sql = "INSERT INTO tbl_entrega_activo(entrada, activo) VALUES(?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getEntrega().getId());
            pstmt.setLong(2, obj.getActivo().getId());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected EntregaActivo update(EntregaActivo obj) {
        String sql = "UPDATE tbl_entrega_activo SET entrada = ? , "
                + "activo = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setLong(1, obj.getEntrega().getId());
            pstmt.setLong(2, obj.getActivo().getId());
            pstmt.setLong(3, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected EntregaActivo delete(EntregaActivo obj) {
        String sql = "DELETE FROM tbl_entrega_activo WHERE id = ?";
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