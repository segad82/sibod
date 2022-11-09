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
import model.ActivoNota;

/**
 *
 * @author kevin
 */
public class DaoActivoNota extends BaseDao<ActivoNota> {

    public DaoActivoNota(Connection db){
        super(db);
    }
    
    @Override
    protected ArrayList<ActivoNota> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<ActivoNota> selectLight() {
        String sql = "SELECT id, activo, fecha, nota FROM tbl_activo_nota";
        
        ArrayList<ActivoNota> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new ActivoNota(
                        rs.getLong("id"),
                        new Activo(rs.getLong("activo")),
                        rs.getDate("fecha"),
                        rs.getString("nota")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<ActivoNota> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ActivoNota read(ActivoNota obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected ActivoNota create(ActivoNota obj) {
        String sql = "INSERT INTO tbl_activo_nota(activo, fecha, nota) VALUES(?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getActivo().getId());
            pstmt.setDate(2, obj.getFecha());
            pstmt.setString(3, obj.getNota());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected ActivoNota update(ActivoNota obj) {
        String sql = "UPDATE tbl_activo_nota SET activo = ? , "
                + "fecha = ? ,"
                + "nota = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setLong(1, obj.getActivo().getId());
            pstmt.setDate(2, obj.getFecha());
            pstmt.setString(3, obj.getNota());
            pstmt.setLong(5, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected ActivoNota delete(ActivoNota obj) {
        String sql = "DELETE FROM tbl_activo_nota WHERE id = ?";
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