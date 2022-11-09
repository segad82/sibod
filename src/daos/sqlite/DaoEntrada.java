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
import model.Entrada;
import model.OrdenCompra;
import model.Proveedor;

/**
 *
 * @author kevin
 */
public class DaoEntrada extends BaseDao<Entrada> {
    
    public DaoEntrada(Connection db){
        super(db);
    }

    @Override
    protected ArrayList<Entrada> selectAll() {
        return this.selectLight();
    }

    @Override
    protected ArrayList<Entrada> selectLight() {
        String sql = "SELECT id, numero_documento, fecha, proveedor, orden_compra, valor, url_activo, observacion FROM tbl_entrada";
        
        ArrayList<Entrada> list = new ArrayList<>();
        try (Statement stmt  = this.DB.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(new Entrada(
                        rs.getLong("id"),
                        rs.getString("numero_documento"),
                        rs.getDate("fecha"),
                        new Proveedor(rs.getInt("proveedor")),
                        new OrdenCompra(rs.getInt("orden_compra")),
                        rs.getInt("valor"),
                        rs.getString("url_archivo"),
                        rs.getString("observacion")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    protected ArrayList<Entrada> selectRange(int index, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Entrada read(Entrada obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Entrada create(Entrada obj) {
        String sql = "INSERT INTO tbl_entrada(numero_documento, fecha, proveedor, orden_compra, valor, url_activo, observacion) VALUES(?,?,?,?,?,?,?)";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {
            pstmt.setString(1, obj.getNumero_documento());
            pstmt.setDate(2, obj.getFecha());
            pstmt.setInt(3, obj.getProveedor().getId());
            pstmt.setInt(4, obj.getOrden_compra().getId());
            pstmt.setInt(5, obj.getValor());
            pstmt.setString(6, obj.getUrl_archivo());
            pstmt.setString(7, obj.getObservacion());
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Entrada update(Entrada obj) {
        String sql = "UPDATE tbl_entrada SET numero_documento = ? , "
                + "fecha = ? ,"
                + "proveedor = ? ,"
                + "orden_compra = ? ,"
                + "valor = ? ,"
                + "url_archivo = ? ,"
                + "observacion = ? "
                + "WHERE id = ?";
        boolean result = false;
        try (PreparedStatement pstmt = this.DB.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, obj.getNumero_documento());
            pstmt.setDate(2, obj.getFecha());
            pstmt.setInt(3, obj.getProveedor().getId());
            pstmt.setInt(4, obj.getOrden_compra().getId());
            pstmt.setInt(5, obj.getValor());
            pstmt.setString(6, obj.getUrl_archivo());
            pstmt.setString(7, obj.getObservacion());
            pstmt.setLong(8, obj.getId());
            // update 
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result ? obj : null;
    }

    @Override
    protected Entrada delete(Entrada obj) {
        String sql = "DELETE FROM tbl_entrada WHERE id = ?";
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