package model;

public class Transaccion
{
	private int idT;
	private String nombreT;
	
	public Transaccion()
	{
	}

	public String getNombreT()
	{
		return nombreT;
	}
	
	public int getIdT()
	{
		return idT;
	}

	@Override
	public String toString()
	{
		return "Transaccion [idT=" + idT + ", nombreT=" + nombreT + "]";
	}
}
