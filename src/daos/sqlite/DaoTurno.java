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
import model.Turno;

/**
 *
 * @author kevin
 */
public class DaoTurno extends BaseDao<Turno> {

    public DaoTurno(Connection db) {
        super(db);
    }

    @Override
    protected ArrayList<Turno> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<Turno> selectLight() {
        String sql = "SELECT id, nombre, estado FROM tbl_turno";
        
        ArrayList<Turno> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Turno(
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
    protected ArrayList<Turno> selectRange(int index, int count) {
        String sql = "SELECT rowid as i, id, nombre, estado FROM tbl_turno where i between ? and ?";
        
        ArrayList<Turno> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Turno(
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
    protected Turno read(Turno obj) {
        String sql = "SELECT nombre, estado FROM tbl_turno where id = ?";
        
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, obj.getId());
            ResultSet rs = pstmt.executeQuery();
            obj.setNombre(rs.getString("nombre"));
            obj.setEstado(rs.getBoolean("estado"));
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    @Override
    protected Turno create(Turno obj) {
        String sql = "INSERT INTO tbl_turno(nombre, estado) VALUES(?,?)";
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
    protected Turno update(Turno obj) {
        String sql = "UPDATE tbl_turno SET nombre = ? , "
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
    protected Turno delete(Turno obj) {
        String sql = "DELETE FROM tbl_turno WHERE id = ?";
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