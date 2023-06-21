package com.chapaybinario.gegado.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chapaybinario.gegado.model.Usuario;

public class UsuarioDao extends Conexion implements MetodosDao<Usuario>
{

	String sql;
	Connection con;

	@Override
	public void create(Usuario item)
	{
		con = conectar();
		sql = "INSERT INTO usuarios (nombre,userN,passU) VALUES (?,?,?);";

		try
		{
			escribir(item, con, sql, "");
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public Usuario read(int item)
	{
		Usuario a = null;
		sql = "SELECT * FROM usuarios WHERE idU=?;";
		try
		{
			con = conectar();
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, item);
			ResultSet rs = pt.executeQuery();
			if (rs.next())
			{
				String nombre = rs.getString("nombre");
				String userN = rs.getString("userN");
				String passU = rs.getString("passU");
				a = new Usuario(item, nombre, userN, passU);
				con.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Usuario> read(String campo, String dato)
	{
		List<Usuario> listaUsuario = new ArrayList<>();

		try
		{
			con = conectar();
			PreparedStatement pt = null;
			switch (campo)
			{
				case "idU":
				{
					sql = "SELECT * FROM usuarios WHERE idU=?;";
					int id = Integer.parseInt(dato);
					pt = con.prepareStatement(sql);
					pt.setInt(1, id);
					break;
				}
				case "userN":
				{
					sql = "SELECT * FROM usuarios WHERE userN like ?;";
					pt = con.prepareStatement(sql);
					pt.setString(1, "%" + dato + "%");
					break;
				}
				case "nombre":
				{
					sql = "SELECT * FROM usuarios WHERE nombre LIKE ?;";
					pt = con.prepareStatement(sql);
					pt.setString(1, "%" + dato + "%");
					break;
				}

			}
			ResultSet rs = pt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("idU");
				String nombre = rs.getString("nombre");
				String userN = rs.getString("userN");
				String passU = rs.getString("passU");

				Usuario a = new Usuario(id, nombre, userN, passU);
				listaUsuario.add(a);
			}
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return listaUsuario;
	}

	@Override
	public void update(Usuario item)
	{
		if (item != null)
		{
			sql = "UPDATE usuarios SET nombre=?, userN=?, passU=? WHERE idU=?;";
			try
			{
				Connection con = conectar();
				escribir(item, con, sql, "update");
				con.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int item)
	{
		sql = "DELETE FROM usuarios WHERE idU=?;";
		try
		{
			Connection con = conectar();
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, item);
			pt.executeUpdate();
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void escribir(Usuario a, Connection con, String sql, String opcion) throws SQLException
	{
		PreparedStatement pt = conectar().prepareStatement(sql);
		pt.setString(1, a.getNombre());
		pt.setString(2, a.getUserN());
		pt.setString(3, a.getPassU());

		if (opcion.equals("update"))
		{
			pt.setInt(4, a.getIdU());
		}
		pt.executeUpdate();
	}

	@Override
	public List<Usuario> readAll()
	{
		List<Usuario> listaUsuario = new ArrayList<>();

		sql = "SELECT * FROM usuarios;";

		try
		{
			Connection con = conectar();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
			{
				int id = rs.getInt("idU");
				String nombre = rs.getString("nombre");
				String userN = rs.getString("userN");
				String passU = rs.getString("passU");

				Usuario a = new Usuario(id, nombre, userN, passU);
				listaUsuario.add(a);
			}
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return listaUsuario;
	}

}
