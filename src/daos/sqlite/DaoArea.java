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
import model.Area;

/**
 *
 * @author kevin
 */
public class DaoArea extends BaseDao<Area> {

    public DaoArea(Connection db) {
        super(db);
    }
    
    @Override
    protected ArrayList<Area> selectAll() {
        return this.selectLight();
    }
    
    @Override
    protected ArrayList<Area> selectLight() {
        String sql = "SELECT id, nombre, estado FROM tbl_area";
        
        ArrayList<Area> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Area(
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
    protected ArrayList<Area> selectRange(int index, int count) {
        String sql = "SELECT rowid as i, id, nombre, estado FROM tbl_area where i between ? and ?";
        
        ArrayList<Area> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Area(
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
    protected Area read(Area obj) {
        String sql = "SELECT nombre, estado FROM tbl_area where id = ?";
        
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
    protected Area create(Area obj) {
        String sql = "INSERT INTO tbl_area(nombre, estado) VALUES(?,?)";
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
    protected Area update(Area obj) {
        String sql = "UPDATE tbl_area SET nombre = ? , "
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
    protected Area delete(Area obj) {
        String sql = "DELETE FROM tbl_area WHERE id = ?";
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