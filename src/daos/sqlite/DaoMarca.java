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
import model.Marca;

/**
 *
 * @author kevin
 */
public class DaoMarca extends BaseDao<Marca> {
    
    public DaoMarca(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<Marca> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<Marca> selectLight() {
        String sql = "SELECT id, nombre, estado FROM tbl_marca";
        
        ArrayList<Marca> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Marca(
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
    protected ArrayList<Marca> selectRange(int index, int count) {
        String sql = "SELECT rowid as i, id, nombre, estado FROM tbl_marca where i between ? and ?";
        
        ArrayList<Marca> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Marca(
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
    protected Marca read(Marca obj) {
        String sql = "SELECT nombre, estado FROM tbl_marca where id = ?";
        
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
    protected Marca create(Marca obj) {
        String sql = "INSERT INTO tbl_marca(nombre, estado) VALUES(?,?)";
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
    protected Marca update(Marca obj) {
        String sql = "UPDATE tbl_marca SET nombre = ? , "
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
    protected Marca delete(Marca obj) {
        String sql = "DELETE FROM tbl_marca WHERE id = ?";
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