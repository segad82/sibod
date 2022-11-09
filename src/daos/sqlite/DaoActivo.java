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
import model.Modelo;

/**
 *
 * @author kevin
 */
public class DaoActivo extends BaseDao<Activo> {

    public DaoActivo(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<Activo> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<Activo> selectLight() {
        String sql = "SELECT id, codigo, serie, modelo, estado FROM tbl_activo";
        
        ArrayList<Activo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Activo(
                        rs.getInt("id"), 
                        rs.getString("codigo"), 
                        rs.getString("serie"), 
                        new Modelo(rs.getInt("modelo")),
                        rs.getBoolean("estado")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Activo> selectRange(int index, int count) {
        String sql = "SELECT rowid as i, id, codigo, serie, modelo, estado FROM tbl_activo where i between ? and ?";
        
        ArrayList<Activo> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Activo(
                        rs.getInt("id"), 
                        rs.getString("codigo"), 
                        rs.getString("serie"), 
                        new Modelo(rs.getInt("modelo")),
                        rs.getBoolean("estado")));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected Activo read(Activo obj) {
        String sql = "SELECT codigo, serie, modelo, estado FROM tbl_activo where id = ?";
        
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getId());
            ResultSet rs = pstmt.executeQuery();
            obj.setCodigo(rs.getString("codigo"));
            obj.setSerie(rs.getString("serie"));
            obj.setModelo(new Modelo(rs.getInt("modelo")));
            obj.setEstado(rs.getBoolean("estado"));
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    
    @Override
    protected Activo create(Activo obj) {
        String sql = "INSERT INTO tbl_activo(codigo, serie, modelo, estado) VALUES(?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getCodigo());
            pstmt.setString(2, obj.getSerie());
            pstmt.setInt(3, obj.getModelo().getId());
            pstmt.setBoolean(4, obj.getEstado());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Activo update(Activo obj) {
        String sql = "UPDATE tbl_activo SET codigo = ? , "
                + "serie = ? ,"
                + "modelo = ? ,"
                + "estado = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            pstmt.setString(1, obj.getCodigo());
            pstmt.setString(2, obj.getSerie());
            pstmt.setInt(3, obj.getModelo().getId());
            pstmt.setBoolean(4, obj.getEstado());
            pstmt.setLong(5, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Activo delete(Activo obj) {
        String sql = "DELETE FROM tbl_activo WHERE id = ?";
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
