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
import model.Entrada;
import model.EntradaActivo;

/**
 *
 * @author kevin
 */
public class DaoEntradaActivo extends BaseDao<EntradaActivo> {

    public DaoEntradaActivo(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<EntradaActivo> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<EntradaActivo> selectLight() {
        String sql = "SELECT id, entrega, activo FROM tbl_entrada_activo";
        
        ArrayList<EntradaActivo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new EntradaActivo(
                        rs.getLong("id"),
                        new Entrada(rs.getLong("entrega")),
                        new Activo(rs.getLong("activo"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<EntradaActivo> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntradaActivo read(EntradaActivo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected EntradaActivo create(EntradaActivo obj) {
        String sql = "INSERT INTO tbl_entrada_activo(entrega, activo) VALUES(?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getEntrada().getId());
            pstmt.setLong(2, obj.getActivo().getId());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected EntradaActivo update(EntradaActivo obj) {
        String sql = "UPDATE tbl_entrada_activo SET entrega = ? , "
                + "activo = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setLong(1, obj.getEntrada().getId());
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
    protected EntradaActivo delete(EntradaActivo obj) {
        String sql = "DELETE FROM tbl_entrada_activo WHERE id = ?";
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