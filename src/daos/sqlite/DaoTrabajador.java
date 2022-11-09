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
import model.Trabajador;
import model.Turno;

/**
 *
 * @author kevin
 */
public class DaoTrabajador extends BaseDao<Trabajador> {

    public DaoTrabajador(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<Trabajador> selectAll() {
        String sql = "SELECT tr.rut AS tr_rut, \n" +
                "tr.nombre AS tr_nombre,\n" +
                "tr.fecha_nacimiento AS tr_fecha_nacimiento,\n" +
                "tr.estado AS tr_estado,\n" +
                "tr.talla_camisa AS tr_talla_camisa,\n" +
                "tr.talla_pantalon AS tr_talla_pantalon,\n" +
                "tr.talla_calzado AS tr_talla_calzado,\n" +
                "ar.id AS ar_id,\n" +
                "ar.nombre AS ar_nombre,\n" +
                "ar.estado AS ar_estado,\n" +
                "tu.id AS tu_id,\n" +
                "tu.nombre AS tu_nombre,\n" +
                "tu.estado AS tu_estado\n" +
                "FROM tbl_trabajador tr INNER JOIN\n" +
                "tbl_area ar ON ar.id = tr.area INNER JOIN \n" +
                "tbl_turno tu ON tu.id = tr.turno";
        
        ArrayList<Trabajador> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Trabajador(
                        rs.getString("tr_rut"),
                        rs.getString("tr_nombre"),
                        new Area(rs.getInt("ar_id"),
                                rs.getString("ar_nombre"),
                                rs.getBoolean("ar_estado")),
                        new Turno(rs.getInt("tu_id"),
                                rs.getString("tu_nombre"),
                                rs.getBoolean("tu_estado")),
                        rs.getString("tr_fecha_nacimiento"),
                        rs.getBoolean("tr_estado"),
                        rs.getString("tr_talla_camisa"),
                        rs.getString("tr_talla_pantalon"),
                        rs.getString("tr_talla_calzado")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Trabajador> selectLight() {
        String sql = "SELECT rut, nombre, area, turno, fecha_nacimiento, estado, talla_camisa, talla_pantalon, talla_calzado FROM tbl_trabajador";
        
        ArrayList<Trabajador> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Trabajador(
                        rs.getString("rut"),
                        rs.getString("nombre"),
                        new Area(rs.getInt("area")),
                        new Turno(rs.getInt("turno")),
                        rs.getString("fecha_nacimiento"),
                        rs.getBoolean("estado"),
                        rs.getString("talla_camisa"),
                        rs.getString("talla_pantalon"),
                        rs.getString("talla_calzado")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Trabajador> selectRange(int index, int count) {
        String sql = "SELECT tr.rowid AS i,\n" +
                "tr.rut AS tr_rut, \n" +
                "tr.nombre AS tr_nombre,\n" +
                "tr.fecha_nacimiento AS tr_fecha_nacimiento,\n" +
                "tr.estado AS tr_estado,\n" +
                "tr.talla_camisa AS tr_talla_camisa,\n" +
                "tr.talla_pantalon AS tr_talla_pantalon,\n" +
                "tr.talla_calzado AS tr_talla_calzado,\n" +
                "ar.id AS ar_id,\n" +
                "ar.nombre AS ar_nombre,\n" +
                "ar.estado AS ar_estado,\n" +
                "tu.id AS tu_id,\n" +
                "tu.nombre AS tu_nombre,\n" +
                "tu.estado AS tu_estado\n" +
                "FROM tbl_trabajador tr INNER JOIN\n" +
                "tbl_area ar ON ar.id = tr.area INNER JOIN \n" +
                "tbl_turno tu ON tu.id = tr.turno \n" +
                "where i between ? and ?";
        
        ArrayList<Trabajador> list = new ArrayList<>();
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, count);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Trabajador(
                        rs.getString("tr_rut"),
                        rs.getString("tr_nombre"),
                        new Area(rs.getInt("ar_id"),
                                rs.getString("ar_nombre"),
                                rs.getBoolean("ar_estado")),
                        new Turno(rs.getInt("tu_id"),
                                rs.getString("tu_nombre"),
                                rs.getBoolean("tu_estado")),
                        rs.getString("tr_fecha_nacimiento"),
                        rs.getBoolean("tr_estado"),
                        rs.getString("tr_talla_camisa"),
                        rs.getString("tr_talla_pantalon"),
                        rs.getString("tr_talla_calzado")));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    @Override
    protected Trabajador read(Trabajador obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Trabajador create(Trabajador obj) {
        String sql = "INSERT INTO tbl_trabajador(rut, nombre, area, turno, fecha_nacimiento, estado, talla_camisa, talla_pantalon, talla_calzado) VALUES(?,?,?,?,?,?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getRut());
            pstmt.setString(2, obj.getNombre());
            pstmt.setInt(3, obj.getArea().getId());
            pstmt.setInt(4, obj.getTurno().getId());
            pstmt.setString(5, obj.getFecha_nacimiento());
            pstmt.setBoolean(6, obj.getEstado());
            pstmt.setString(7, obj.getTalla_camisa());
            pstmt.setString(8, obj.getTalla_pantalon());
            pstmt.setString(9, obj.getTalla_calzado());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Trabajador update(Trabajador obj) {
        String sql = "UPDATE tbl_trabajador SET rut = ? , "
                + "nombre = ? ,"
                + "area = ? ,"
                + "turno = ? ,"
                + "fecha_nacimiento = ? ,"
                + "estado = ? ,"
                + "talla_camisa = ? ,"
                + "talla_pantalon = ? ,"
                + "talla_calzado = ? "
                + "WHERE rut = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getRut());
            pstmt.setString(2, obj.getNombre());
            pstmt.setInt(3, obj.getArea().getId());
            pstmt.setInt(4, obj.getTurno().getId());
            pstmt.setString(5, obj.getFecha_nacimiento());
            pstmt.setBoolean(6, obj.getEstado());
            pstmt.setString(7, obj.getTalla_camisa());
            pstmt.setString(8, obj.getTalla_pantalon());
            pstmt.setString(9, obj.getTalla_calzado());
            pstmt.setString(10, obj.getOld_rut());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Trabajador delete(Trabajador obj) {
        String sql = "DELETE FROM tbl_trabajador WHERE rut = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getRut());
            // execute the delete statement
            result = pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }
    
}