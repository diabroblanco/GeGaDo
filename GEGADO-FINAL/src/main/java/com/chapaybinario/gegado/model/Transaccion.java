package com.chapaybinario.gegado.model;

/*
 * Esta clase de momento no tiene ninguna utilidad, porque a la tabla transacciones no hay que hacerle nada
 * y se accede a ella desde otros puntos de la aplicación, sin necesidad de esta clase.
 * De momento se queda aquí para usos futuros... si lo hubiera.
 */

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
