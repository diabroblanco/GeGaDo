package com.chapaybinario.gegado.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chapaybinario.gegado.model.Movimiento;

public class MovimientosDAO extends Conexion
{
	String sql;

	public void create(Movimiento movimiento)
	{
		Connection con = conectar();
        sql = "INSERT INTO movimientos (detalles, importe, fechaHora, idU, idC) VALUES (?,?,?,?,?);";
        
        try
        {
           PreparedStatement pt = con.prepareStatement(sql);
           pt.setString(1, movimiento.getDetalles());
           pt.setDouble(2, movimiento.getImporte());
           String sqlDate = String.valueOf(movimiento.getFechaHora());
           pt.setString(3, sqlDate);
           pt.setInt(4, movimiento.getIdU());
           pt.setInt(5, movimiento.getIdC());

           pt.executeUpdate();
           con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
	}

	public void delete(int id)
	{
		sql = "DELETE FROM movimientos WHERE id=?;";
        try
        {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            pt.executeUpdate();
            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
		
	}

	public List<Movimiento> readAll(int idT, int idU)
	{
		List<Movimiento> listaMovimientos = new ArrayList<>();
        
        sql ="SELECT movimientos.*,categorias.*,transacciones.* FROM ((movimientos INNER JOIN categorias ON movimientos.idc=categorias.idC) INNER JOIN transacciones ON transacciones.idT=categorias.idt) WHERE transacciones.idT=? AND movimientos.idU=?;";
        
        try
        {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, idT);
            pt.setInt(2, idU);
            ResultSet rs = pt.executeQuery();

            while (rs.next())
            {
            	int id = rs.getInt("id");
                String detalles = rs.getString("detalles");
                String nombreC = rs.getString("nombreC");
                String nombreT = rs.getString("nombreT");
                double importe = rs.getDouble("importe");
                String fecha = rs.getString("fechaHora");
                
                Movimiento movimiento = new Movimiento(id, detalles, nombreC, nombreT, importe, fecha);
                listaMovimientos.add(movimiento);
            }
            con.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaMovimientos;
	}
	
	public List<Movimiento> readAll(int idU)
	{
		List<Movimiento> listaMovimientos = new ArrayList<>();
        
        sql ="SELECT movimientos.*,categorias.*,transacciones.* FROM ((movimientos INNER JOIN categorias ON movimientos.idc=categorias.idC) INNER JOIN transacciones ON transacciones.idT=categorias.idt) WHERE movimientos.idU=? ORDER BY movimientos.id;";
        
        try
        {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, idU);
            ResultSet rs = pt.executeQuery();

            while (rs.next())
            {
            	int id = rs.getInt("id");
                String detalles = rs.getString("detalles");
                String nombreC = rs.getString("nombreC");
                String nombreT = rs.getString("nombreT");
                double importe = rs.getDouble("importe");
                String fecha = rs.getString("fechaHora");
                
                Movimiento movimiento = new Movimiento(id, detalles, nombreC, nombreT, importe, fecha);
                listaMovimientos.add(movimiento);
            }
            con.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaMovimientos;
	}
	
}
