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
import model.Entrega;
import model.Trabajador;

/**
 *
 * @author kevin
 */
public class DaoEntrega extends BaseDao<Entrega> {

    public DaoEntrega(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<Entrega> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<Entrega> selectLight() {
        String sql = "SELECT id, numero_documento, fecha, entrega, recibe, observacion FROM tbl_entrega";
        
        ArrayList<Entrega> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Entrega(
                        rs.getLong("id"),
                        rs.getString("numero_documento"),
                        rs.getDate("fecha"),
                        new Trabajador(rs.getString("entrega")),
                        new Trabajador(rs.getString("recibe")),
                        rs.getString("observacion")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Entrega> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Entrega read(Entrega obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Entrega create(Entrega obj) {
        String sql = "INSERT INTO tbl_entrega(numero_documento, fecha, entrega, recibe, observacion) VALUES(?,?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getNumero_documento());
            pstmt.setDate(2, obj.getFecha());
            pstmt.setString(3, obj.getPersona_entrega().getRut());
            pstmt.setString(4, obj.getPersona_recibe().getRut());
            pstmt.setString(5, obj.getObservacion());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Entrega update(Entrega obj) {
        String sql = "UPDATE tbl_entrega SET numero_documento = ? , "
                + "fecha = ? ,"
                + "entrega = ? ,"
                + "recibe = ? ,"
                + "observacion = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getNumero_documento());
            pstmt.setDate(2, obj.getFecha());
            pstmt.setString(3, obj.getPersona_entrega().getRut());
            pstmt.setString(4, obj.getPersona_recibe().getRut());
            pstmt.setString(5, obj.getObservacion());
            pstmt.setLong(6, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Entrega delete(Entrega obj) {
        String sql = "DELETE FROM tbl_entrega WHERE id = ?";
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