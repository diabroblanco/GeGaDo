package com.chapaybinario.gegado.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chapaybinario.gegado.model.Categoria;
import com.chapaybinario.gegado.model.Movimiento;
import com.chapaybinario.gegado.model.Usuario;
import com.chapaybinario.gegado.services.CategoriasDAO;
import com.chapaybinario.gegado.services.Encriptar;
import com.chapaybinario.gegado.services.MovimientosDAO;
import com.chapaybinario.gegado.services.UsuarioDao;
import com.chapaybinario.gegado.services.Validaciones;

/*
 * Proyecto de fin de curso: GeGaDo -> Gestión de Gastos Domésticos
 * Por: Adrián, Carlos y Javier
 */

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet implements Validaciones
{
	private static final long serialVersionUID = 1L;

	String msgExito, msgError, opcion = "";
	UsuarioDao miUsuarioDao = new UsuarioDao();
	Usuario a = new Usuario();
	List<Usuario> listaUsuario = new ArrayList<>();
	int id = 0;
	String nombreUsuario = "";
	int idUsuario = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub

		opcion = request.getParameter("opcion");

		System.out.println(opcion);
		switch (opcion)
		{
			case "modificacion":
			case "eliminar":
			{
				id = Integer.parseInt(request.getParameter("id"));
				if (opcion.equals("modificacion"))
				{
//					System.out.println("voy bien");
					modificacion(request, response);
				} else
				{
					eliminar(request, response);
				}
				break;
			}
			case "nuevaTransaccion":
			{
				System.out.println("voy bien");
				nuevaTransacion(request, response);
				break;
			}
			case "agregarM":
			{
				agregarM(request, response);
				break;
			}
			case "eliminarMovimiento":
			{
				eliminarMovimiento(request, response);
				break;
			}
			case "cerrarSesion":
			{
				cerrarSesion(request, response);
				break;
			}
			case "todo", "ingresos", "gastos", "sinEleccion":
			{
				mostrarMovimientos(request, response);
				break;
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		opcion = request.getParameter("opcion");
		System.out.println(opcion);
		if (!opcion.isEmpty())
		{
			try
			{
				switch (opcion)
				{
					case "alta":
					{
						alta(request, response);
						break;
					}
					case "buscar":
					{
						buscar(request, response);
						break;
					}
					case "modificar":
					{
						modificar(request, response);
						break;
					}
				}
			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	protected void alta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		 * definiciones de variables recogo los datos enviados de alta.jsp
		 */

		String userN = request.getParameter("nombreU");
		String nombre = request.getParameter("nombre");
		String passU = request.getParameter("passU");
		boolean acierto = false;

		try
		{
			acierto = (datosVacios(userN) && datosVacios(nombre) && datosVacios(passU));
			if (passU.length() > 12)
			{
				msgError = "Su password excede la longitud";
				request.setAttribute("msgError", msgError);
				request.getRequestDispatcher("alta.jsp").forward(request, response);
			} else 
			{
				if (acierto)
				{
					System.out.println(userN);
					listaUsuario = miUsuarioDao.read("userN", userN);
					if (listaUsuario.size() == 0)
					{
						passU = Encriptar.convertirSHA256(passU);
						a = new Usuario(nombre, userN, passU);
						miUsuarioDao.create(a);
						listaUsuario = miUsuarioDao.read("userN", userN);
						System.out.println(listaUsuario.toString());
						idUsuario = listaUsuario.get(0).getIdU();
						nombreUsuario = userN;
						System.out.println("id usuario :" + idUsuario + "username :" + nombreUsuario);
	
						msgExito = "Usuario creado correctamente";
						request.setAttribute("msgExito", msgExito);
	
						request.setAttribute("idU", idUsuario);
						request.setAttribute("nombreU", nombreUsuario);
						request.getRequestDispatcher("tabla.jsp").forward(request, response);
						// response.sendRedirect("tabla.jsp");
	
					} else
					{
						msgError = "El usuario ya existe.";
						request.setAttribute("msgError", msgError);
						System.out.println(msgError);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} else
				{
					msgError = "Hay campos vacíos";
					request.setAttribute("msgError", msgError);
					System.out.println(msgError);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}

		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String userN = request.getParameter("nombreU");
		String passU = request.getParameter("passU");
		boolean acierto = (datosVacios(userN) && datosVacios(passU));
		if (acierto)
		{
			if (passU.length() > 12)
			{
				msgError = "Su password excede la longitud";
				request.setAttribute("msgError", msgError);
				request.getRequestDispatcher("existe.jsp").forward(request, response);
			} else 
			{
				listaUsuario = miUsuarioDao.read("userN", userN);
				if (listaUsuario.size() > 0)
				{
					passU = Encriptar.convertirSHA256(passU);
					System.out.println(listaUsuario.toString());
					if (listaUsuario.get(0).getPassU().equals(passU))
					{
						idUsuario = listaUsuario.get(0).getIdU();
						nombreUsuario = userN;
	
						List<Movimiento> listaMovimientos = new ArrayList<>();
						MovimientosDAO nuevoMovimientosDAO = new MovimientosDAO();
						listaMovimientos = nuevoMovimientosDAO.readAll(idUsuario);
						request.setAttribute("listaA", listaMovimientos);
						request.setAttribute("idU", idUsuario);
						request.setAttribute("nombreU", nombreUsuario);
						request.getRequestDispatcher("tabla.jsp").forward(request, response);
	//					response.sendRedirect("tabla.jsp");
					} else
					{
						msgError = "Contraseña Incorrecta";
						request.setAttribute("msgError", msgError);
						System.out.println(msgError);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} else
				{
					msgError = "Error No Existe El Usuario";
					request.setAttribute("msgError", msgError);
					System.out.println(msgError);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
		} else
		{
			msgError = "Hay campos vacíos";
			request.setAttribute("msgError", msgError);
			System.out.println(msgError);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void modificacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		a = miUsuarioDao.read(id);
		int idU = a.getIdU();
		String nombre = a.getNombre();
		String nombreU = a.getUserN();
		String passU = a.getPassU();
		System.out.println(a.toString());
		request.setAttribute("idU", idU);
		request.setAttribute("nombre", nombre);
		request.setAttribute("nombreU", nombreU);
		request.setAttribute("passU", passU);

		request.getRequestDispatcher("ModificarU.jsp").forward(request, response);
	}

	protected void modificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String nombre = request.getParameter("nombre");
		String userN = request.getParameter("nombreU");
		String passU = request.getParameter("passU");
		String passU2 = request.getParameter("passU2");
		
		
			passU = Encriptar.convertirSHA256(passU);
			
			List<Usuario> usuarioActual = new ArrayList<>();
			UsuarioDao nuevoUsuarioDao = new UsuarioDao();
			usuarioActual = nuevoUsuarioDao.read("userN", userN);
			String passwordActual = usuarioActual.get(0).getPassU();
			int idU = usuarioActual.get(0).getIdU(); 
			
			if (passwordActual.equals(passU))
			{
				if (passU2.length() > 12)
				{
					msgError = "Su nuevo password excede la longitud";
					request.setAttribute("msgError", msgError);
					request.setAttribute("nombreU", userN);
					request.setAttribute("idU", idU);
					request.setAttribute("nombre", nombre);
					request.setAttribute("passU", passwordActual);
					request.setAttribute("passU2", passU2);
					request.getRequestDispatcher("ModificarU.jsp").forward(request, response);
				} else 
				{
					try
					{
						if (datosVacios(nombre) && datosVacios(userN) && datosVacios(passU) && datosVacios(passU2))
						{
							passU2 = Encriptar.convertirSHA256(passU2);
							passU = passU2;
							a = new Usuario(id, nombre, userN, passU);
							miUsuarioDao.update(a);
			
							msgExito = "Usuario modificado correctamente";
							List<Movimiento> listaMovimientos = new ArrayList<>();
							MovimientosDAO nuevoMovimientosDAO = new MovimientosDAO();
							listaMovimientos = nuevoMovimientosDAO.readAll(idUsuario);
							request.setAttribute("listaA", listaMovimientos);
							request.setAttribute("msgExito", msgExito);
							request.setAttribute("idU", a.getIdU());
							request.setAttribute("userN", a.getUserN());
							request.setAttribute("nombreU", a.getUserN());
						} else
						{
							msgError = "Hay campos vacíos";
							System.out.println(msgError);
							request.setAttribute("msgError", msgError);
							request.setAttribute("nombreU", userN);
							request.setAttribute("idU", idU);
						}
			
					} catch (Exception e)
					{
						e.printStackTrace();
						msgError = "Se ha producido un error";
						request.setAttribute("msgError", msgError);
						request.setAttribute("nombreU", userN);
						request.setAttribute("idU", idU);
					} finally
					{
						request.getRequestDispatcher("tabla.jsp").forward(request, response);
					}
				}
			} else
			{
				msgError = "La contraseña actual no es correcta";
				request.setAttribute("msgError", msgError);
				request.setAttribute("nombreU", userN);
				request.setAttribute("idU", idU);
				request.setAttribute("nombre", nombre);
				request.setAttribute("passU", passwordActual);
				request.getRequestDispatcher("ModificarU.jsp").forward(request, response);
			}
		
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			miUsuarioDao.delete(id);
			msgExito = "Usuario eliminado.";
			request.setAttribute("msgExito", msgExito);

			request.getRequestDispatcher("tabla.jsp").forward(request, response);
		} catch (Exception e)
		{
			// TODO: handle exception
			msgError = "No se ha podido eliminar al usuario";
			request.setAttribute("msgExito", msgExito);
		}
	}

	protected void nuevaTransacion(HttpServletRequest request, HttpServletResponse response)
	{
		idUsuario = Integer.parseInt(request.getParameter("id"));
		String nombreU = request.getParameter("nombreU");
		CategoriasDAO miCategoriasDAO = new CategoriasDAO();
//		Categoria a = new Categoria();
		List<Categoria> listaCategorias = new ArrayList<>();
		try
		{
			listaCategorias = miCategoriasDAO.readAll();
			request.setAttribute("idU", idUsuario);
			request.setAttribute("nombreU", nombreU);
			request.setAttribute("listaC", listaCategorias);
			request.getRequestDispatcher("transaccion.jsp").forward(request, response);
//			response.sendRedirect("transaccion.jsp");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void agregarM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			String nombreU = request.getParameter("nombreU");
			float importe = Float.parseFloat(request.getParameter("importe"));
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
			String fechaHora = now.format(formato);
			String detalles = request.getParameter("detalles");
			int idC = Integer.parseInt(request.getParameter("eleccionC"));
			idUsuario = Integer.parseInt(request.getParameter("id"));
			Movimiento nuevoMovimiento = new Movimiento(importe, fechaHora, detalles, idUsuario, idC);
			MovimientosDAO nuevoMovimientosDAO = new MovimientosDAO();
			nuevoMovimientosDAO.create(nuevoMovimiento);
			List<Movimiento> listaMovimientos = new ArrayList<>();
			listaMovimientos = nuevoMovimientosDAO.readAll(idUsuario);
			msgExito = "Movimiento creado correctamente";
			request.setAttribute("listaA", listaMovimientos);
			request.setAttribute("nombreU", nombreU);
			request.setAttribute("idU", idUsuario);
			request.setAttribute("msgExito", msgExito);
		} catch (Exception e)
		{
			e.printStackTrace();
			msgError = "No se ha podido realizar la transacción";
			request.setAttribute("msgError", msgError);
		} finally 
		{
			request.getRequestDispatcher("tabla.jsp").forward(request, response);
		}
	}
	
	protected void eliminarMovimiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			String nombreU = request.getParameter("nombreU");
			int idU = Integer.parseInt(request.getParameter("idU"));
			int id = Integer.parseInt(request.getParameter("id"));
			MovimientosDAO nuevoMovimientosDAO = new MovimientosDAO();
			nuevoMovimientosDAO.delete(id);
			List<Movimiento> listaMovimientos = new ArrayList<>();
			listaMovimientos = nuevoMovimientosDAO.readAll(idU);
			msgExito = "Movimiento eliminado correctamente";
			request.setAttribute("listaA", listaMovimientos);
			request.setAttribute("nombreU", nombreU);
			request.setAttribute("idU", idU);
			request.setAttribute("msgExito", msgExito);
		} catch (Exception e) {
			e.printStackTrace();
			msgError = "No se ha podido eliminar el movimiento";
			request.setAttribute("msgError", msgError);
		} finally
		{
			request.getRequestDispatcher("tabla.jsp").forward(request, response);
		}
	}
	
	protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		try 
		{
			System.out.println("sesion cerrada");
			msgExito = "Sesión cerrada correctamente";
			request.setAttribute("msgExito", msgExito);
		}catch (Exception e)
		{
			e.printStackTrace();
			msgError = "Error al cerrar sesión";
			request.setAttribute("msgError", msgError);
		} finally 
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	protected void mostrarMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String opcionBusqueda = request.getParameter("opcion");
		List<Movimiento> listaMovimientos = new ArrayList<>();
		MovimientosDAO nuevoMovimientosDAO = new MovimientosDAO();
		String nombreU = request.getParameter("nombreU");
		int idU = Integer.parseInt(request.getParameter("id"));
		switch (opcionBusqueda)
		{
			case "todo", "sinEleccion":
			{
				listaMovimientos = nuevoMovimientosDAO.readAll(idUsuario);
				request.setAttribute("listaA", listaMovimientos);
				request.setAttribute("nombreU", nombreU);
				request.setAttribute("idU", idU);
				request.getRequestDispatcher("tabla.jsp").forward(request, response);
			}
			case "ingresos":
			{
				listaMovimientos = nuevoMovimientosDAO.readAll(1, idUsuario);
				request.setAttribute("listaA", listaMovimientos);
				request.setAttribute("nombreU", nombreU);
				request.setAttribute("idU", idU);
				request.getRequestDispatcher("tabla.jsp").forward(request, response);
			}
			case "gastos":
			{
				listaMovimientos = nuevoMovimientosDAO.readAll(0, idUsuario);
				request.setAttribute("listaA", listaMovimientos);
				request.setAttribute("idU", idU);
				request.setAttribute("nombreU", nombreU);
				request.getRequestDispatcher("tabla.jsp").forward(request, response);
			}
		}
	}
}
