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
import model.Consumible;
import model.Marca;
import model.Modelo;
import model.Tipo;

/**
 *
 * @author kevin
 */
public class DaoConsumible extends BaseDao<Consumible> {
    
    public DaoConsumible(Connection db){
        super(db);
    }
    
    @Override
    protected ArrayList<Consumible> selectAll() {
        String sql = "SELECT co.id AS co_id,\n" +
                "co.cantidad AS co_cantidad, \n" +
                "co.cantidad_minima AS co_cantidad_minima, \n" +
                "co.estado AS co_estado,\n" +
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
                "FROM tbl_consumible co INNER JOIN\n" +
                "tbl_modelo mo ON mo.id = co.modelo INNER JOIN\n" +
                "tbl_tipo t ON t.id = mo.tipo  INNER JOIN \n" +
                "tbl_categoria c ON c.id = t.categoria INNER JOIN \n" +
                "tbl_marca ma ON ma.id = mo.marca";
        
        ArrayList<Consumible> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Consumible(
                        rs.getLong("co_id"),
                        rs.getInt("co_cantidad"),
                        rs.getInt("co_cantidad_minima"),
                        rs.getBoolean("co_estado"),
                        new Modelo(rs.getInt("mo_id"),
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
                                        rs.getBoolean("ma_estado")))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Consumible> selectLight() {
        String sql = "SELECT id, cantidad, cantidad_minima, estado, modelo FROM tbl_consumible";
        
        ArrayList<Consumible> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Consumible(
                        rs.getLong("id"),
                        rs.getInt("cantidad"),
                        rs.getInt("cantidad_minima"),
                        rs.getBoolean("estado"),
                        new Modelo(rs.getInt("modelo"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Consumible> selectRange(int index, int count) {
        String sql = "SELECT co.rowid as i,\n" +
                "co.id AS co_id,\n" +
                "co.cantidad AS co_cantidad, \n" +
                "co.cantidad_minima AS co_cantidad_minima, \n" +
                "co.estado AS co_estado,\n" +
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
                "FROM tbl_consumible co INNER JOIN\n" +
                "tbl_modelo mo ON mo.id = co.modelo INNER JOIN\n" +
                "tbl_tipo t ON t.id = mo.tipo  INNER JOIN \n" +
                "tbl_categoria c ON c.id = t.categoria INNER JOIN \n" +
                "tbl_marca ma ON ma.id = mo.marca \n" +
                "where i between ? and ?";
        
        ArrayList<Consumible> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Consumible(
                        rs.getLong("co_id"),
                        rs.getInt("co_cantidad"),
                        rs.getInt("co_cantidad_minima"),
                        rs.getBoolean("co_estado"),
                        new Modelo(rs.getInt("mo_id"),
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
                                        rs.getBoolean("ma_estado")))));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected Consumible read(Consumible obj) {
        String sql = "SELECT cantidad, cantidad_minima, estado, modelo FROM tbl_consumible where id = ?";
        
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getId());
            ResultSet rs = pstmt.executeQuery();
            obj.setCantidad(rs.getInt("cantidad"));
            obj.setCantidad_minima(rs.getInt("cantidad_minima"));
            obj.setEstado(rs.getBoolean("estado"));
            obj.setModelo(new Modelo(rs.getInt("modelo")));
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    
    @Override
    protected Consumible create(Consumible obj) {
        String sql = "INSERT INTO tbl_consumible(cantidad, cantidad_minima, estado, modelo) VALUES(?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, obj.getCantidad());
            pstmt.setInt(2, obj.getCantidad_minima());
            pstmt.setBoolean(3, obj.getEstado());
            pstmt.setInt(4, obj.getModelo().getId());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Consumible update(Consumible obj) {
        String sql = "UPDATE tbl_consumible SET cantidad = ? ,"
                + "cantidad_minima = ? ,"
                + "estado = ? ,"
                + "modelo = ?"
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, obj.getCantidad());
            pstmt.setInt(2, obj.getCantidad_minima());
            pstmt.setBoolean(3, obj.getEstado());
            pstmt.setInt(4, obj.getModelo().getId());
            pstmt.setLong(5, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Consumible delete(Consumible obj) {
        String sql = "DELETE FROM tbl_consumible WHERE id = ?";
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