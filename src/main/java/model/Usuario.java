package model;

import services.Validaciones;

public class Usuario implements Validaciones
{
	private int idU;
	private String userN;
	private String passU;
	private String nombre;

//	private static final int TAMIDU = 10;
	private static final int TAMUSERN_ = 10;
	private static final int TAMPASSU = 12;
	private static final int TAMNOMBRE = 50;

	/* Constructores */
	public Usuario()
	{

	}

	public Usuario(String nombre, String userN, String passU)
	{
		setUserN(userN);
		setPassU(passU);
		setNombre(nombre);

	}

	public Usuario(int idU, String nombre, String userN, String passU)
	{
		this.idU = idU;
		setUserN(userN);
		setPassU(passU);
		setNombre(nombre);
	}

	/* getter y setter */

	public int getIdU()
	{
		return idU;
	}

	public void setIdU(int idU)
	{
		this.idU = idU;
	}

	public String getUserN()
	{
		return userN;
	}

	public void setUserN(String userN)
	{
		this.userN = userN.substring(0, Math.min(TAMUSERN_, userN.length()));
	}

	public String getPassU()
	{
		return passU;
	}

	public void setPassU(String passU)
	{
		this.passU = passU.substring(0, Math.min(TAMPASSU, passU.length()));
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = capitalizar(nombre.substring(0, Math.min(TAMNOMBRE, nombre.length())));
	}

	/* to string */
	@Override
	public String toString()
	{
		String pwd = (this.passU == null) ? "(n/a)" : this.passU;
		return "Usuario [idU=" + this.idU + ", userN=" + this.userN + ", passU=" + pwd + "]";
	}

}
