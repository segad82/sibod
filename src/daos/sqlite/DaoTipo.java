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
import model.Categoria;
import model.Tipo;

/**
 *
 * @author kevin
 */
public class DaoTipo extends BaseDao<Tipo> {

    public DaoTipo(Connection db){
        super(db);
    }
    
    @Override
    protected ArrayList<Tipo> selectAll() {
        String sql = "SELECT t.id AS t_id,\n" +
                "t.nombre AS t_nombre,\n" +
                "t.clase AS t_clase,\n" +
                "t.estado AS t_estado,\n" +
                "c.id AS c_id,\n" +
                "c.nombre AS c_nombre,\n" +
                "c.estado AS c_estado\n" +
                "FROM tbl_tipo t INNER JOIN \n" +
                "tbl_categoria c ON c.id = t.categoria";
        
        ArrayList<Tipo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Tipo(rs.getInt("t_id"),
                        rs.getString("t_nombre"),
                        rs.getBoolean("t_estado"),
                        new Categoria(rs.getInt("c_id"),
                                rs.getString("c_nombre"),
                                rs.getBoolean("c_estado")),
                        rs.getBoolean("t_clase")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Tipo> selectLight() {
        String sql = "SELECT id, nombre, estado, categoria, clase FROM tbl_tipo";
        
        ArrayList<Tipo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Tipo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getBoolean("estado"),
                        new Categoria(rs.getInt("categoria")),
                        rs.getBoolean("clase")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Tipo> selectRange(int index, int count) {
        String sql = "SELECT t.rowid as i,\n" +
                "t.id AS t_id,\n" +
                "t.nombre AS t_nombre,\n" +
                "t.clase AS t_clase,\n" +
                "t.estado AS t_estado,\n" +
                "c.id AS c_id,\n" +
                "c.nombre AS c_nombre,\n" +
                "c.estado AS c_estado\n" +
                "FROM tbl_tipo t INNER JOIN \n" +
                "tbl_categoria c ON c.id = t.categoria \n" +
                "where i between ? and ?";
        
        ArrayList<Tipo> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Tipo(rs.getInt("t_id"),
                        rs.getString("t_nombre"),
                        rs.getBoolean("t_estado"),
                        new Categoria(rs.getInt("c_id"),
                                rs.getString("c_nombre"),
                                rs.getBoolean("c_estado")),
                        rs.getBoolean("t_clase")));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected Tipo read(Tipo obj) {
        String sql = "SELECT nombre, estado, categoria, clase FROM tbl_tipo where id = ?";
        
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, obj.getId());
            ResultSet rs = pstmt.executeQuery();
            obj.setNombre(rs.getString("nombre"));
            obj.setEstado(rs.getBoolean("estado"));
            obj.setCategoria(new Categoria(rs.getInt("categoria")));
            obj.setClase(rs.getBoolean("clase"));
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    
    @Override
    protected Tipo create(Tipo obj) {
        String sql = "INSERT INTO tbl_tipo(nombre, estado, categoria, clase) VALUES(?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getNombre());
            pstmt.setBoolean(2, obj.getEstado());
            pstmt.setInt(3, obj.getCategoria().getId());
            pstmt.setBoolean(4, obj.getClase());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Tipo update(Tipo obj) {
        String sql = "UPDATE tbl_tipo SET nombre = ? , "
                + "estado = ? ,"
                + "categoria = ? ,"
                + "clase = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getNombre());
            pstmt.setBoolean(2, obj.getEstado());
            pstmt.setInt(3, obj.getCategoria().getId());
            pstmt.setBoolean(4, obj.getClase());
            pstmt.setInt(5, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Tipo delete(Tipo obj) {
        String sql = "DELETE FROM tbl_tipo WHERE id = ?";
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