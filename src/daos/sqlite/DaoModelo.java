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
import model.Marca;
import model.Modelo;
import model.Tipo;

/**
 *
 * @author kevin
 */
public class DaoModelo extends BaseDao<Modelo> {
    
    public DaoModelo(Connection db){
        super(db);
    }
    
    @Override
    protected ArrayList<Modelo> selectAll() {
        String sql = "SELECT mo.id AS mo_id, \n" +
                "mo.nombre AS mo_nombre,\n" +
                "mo.estado AS mo_estado,\n" +
                "t.id AS t_id,\n" +
                "t.nombre AS t_nombre,\n" +
                "t.clase AS t_clase,\n" +
                "t.estado AS t_estado,\n" +
                "c.id AS c_id,\n" +
                "c.nombre AS c_nombre,\n" +
                "c.estado AS c_estado,\n" +
                "ma.id AS ma_id,\n" +
                "ma.nombre AS ma_nombre,\n" +
                "ma.estado AS ma_estado\n" +
                "FROM tbl_modelo mo INNER JOIN\n" +
                "tbl_tipo t ON t.id = mo.tipo  INNER JOIN \n" +
                "tbl_categoria c ON c.id = t.categoria INNER JOIN \n" +
                "tbl_marca ma ON ma.id = mo.marca";
        ArrayList<Modelo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Modelo(
                        rs.getInt("mo_id"),
                        rs.getString("mo_nombre"),
                        rs.getBoolean("mo_estado"),
                        new Tipo(rs.getInt("t_id"),
                                rs.getString("t_nombre"),
                                rs.getBoolean("t_estado"),
                                new Categoria(rs.getInt("c_id"), 
                                        rs.getString("c_nombre"),
                                        rs.getBoolean("c_estado")),
                                rs.getBoolean("t_clase")),
                        new Marca(rs.getInt("ma_id"), 
                                rs.getString("ma_nombre"),
                                rs.getBoolean("ma_estado"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Modelo> selectLight() {
        String sql = "SELECT id, nombre, estado, tipo, marca FROM tbl_modelo";
        
        ArrayList<Modelo> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Modelo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getBoolean("estado"),
                        new Tipo(rs.getInt("tipo")),
                        new Marca(rs.getInt("marca"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Modelo> selectRange(int index, int count) {
        String sql = "SELECT mo.rowid as i,\n" +
                "mo.id AS mo_id, \n" +
                "mo.nombre AS mo_nombre,\n" +
                "mo.estado AS mo_estado,\n" +
                "t.id AS t_id,\n" +
                "t.nombre AS t_nombre,\n" +
                "t.clase AS t_clase,\n" +
                "t.estado AS t_estado,\n" +
                "c.id AS c_id,\n" +
                "c.nombre AS c_nombre,\n" +
                "c.estado AS c_estado,\n" +
                "ma.id AS ma_id,\n" +
                "ma.nombre AS ma_nombre,\n" +
                "ma.estado AS ma_estado\n" +
                "FROM tbl_modelo mo INNER JOIN\n" +
                "tbl_tipo t ON t.id = mo.tipo  INNER JOIN \n" +
                "tbl_categoria c ON c.id = t.categoria INNER JOIN \n" +
                "tbl_marca ma ON ma.id = mo.marca \n" +
                "where i between ? and ?";
        
        ArrayList<Modelo> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Modelo(
                        rs.getInt("mo_id"),
                        rs.getString("mo_nombre"),
                        rs.getBoolean("mo_estado"),
                        new Tipo(rs.getInt("t_id"),
                                rs.getString("t_nombre"),
                                rs.getBoolean("t_estado"),
                                new Categoria(rs.getInt("c_id"), 
                                        rs.getString("c_nombre"),
                                        rs.getBoolean("c_estado")),
                                rs.getBoolean("t_clase")),
                        new Marca(rs.getInt("ma_id"), 
                                rs.getString("ma_nombre"),
                                rs.getBoolean("ma_estado"))));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected Modelo read(Modelo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Modelo create(Modelo obj) {
        String sql = "INSERT INTO tbl_modelo(nombre, estado, tipo, marca) VALUES(?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getNombre());
            pstmt.setBoolean(2, obj.getEstado());
            pstmt.setInt(3, obj.getTipo().getId());
            pstmt.setInt(4, obj.getMarca().getId());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Modelo update(Modelo obj) {
        String sql = "UPDATE tbl_modelo SET nombre = ? , "
                + "estado = ? ,"
                + "tipo = ? ,"
                + "marca = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getNombre());
            pstmt.setBoolean(2, obj.getEstado());
            pstmt.setInt(3, obj.getTipo().getId());
            pstmt.setInt(4, obj.getMarca().getId());
            pstmt.setInt(5, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Modelo delete(Modelo obj) {
        String sql = "DELETE FROM tbl_modelo WHERE id = ?";
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