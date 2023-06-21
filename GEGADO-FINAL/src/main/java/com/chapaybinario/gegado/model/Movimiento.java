package com.chapaybinario.gegado.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento
{

	private int id, idU, idC;
	private double importe;
	private String detalles, nombreC, nombreT, fecha;
	private LocalDateTime fechaHora;
	private final int TAMDETALLES = 50; 

	public Movimiento()
	{
	}

	public Movimiento(int id, double importe, String fechaHora, String detalles, int idU, int idC)
	{
		this.id = id;
		setDetalles(detalles);
		this.importe = importe;
		setFechaHora(fechaHora);
		this.idC = idC;
		this.idU = idU;
	}
	
	public Movimiento(double importe, String fechaHora, String detalles, int idU, int idC)
	{
		setDetalles(detalles);
		this.importe = importe;
		setFechaHora(fechaHora);
		this.idC = idC;
		this.idU = idU;
	}
	
	public Movimiento(int id, String detalles, String nombreC, String nombreT, double importe, String fecha)
	{
		this.id = id;
		this.detalles = detalles;
		this.nombreC = nombreC;
		this.nombreT = nombreT;
		this.importe = importe;
		this.fecha = fecha;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDetalles()
	{
		return detalles;
	}

	public void setDetalles(String detalles)
	{
		this.detalles = detalles.substring(0, Math.min(TAMDETALLES, detalles.length()));
	}

	public String getNombreC()
	{
		return nombreC;
	}

	public void setNombreC(String nombreC)
	{
		this.nombreC = nombreC;
	}

	public String getNombreT()
	{
		return nombreT;
	}

	public void setNombreT(String nombreT)
	{
		this.nombreT = nombreT;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public int getIdU()
	{
		return idU;
	}

	public void setIdU(int idU)
	{
		this.idU = idU;
	}

	public int getIdC()
	{
		return idC;
	}

	public void setIdC(int idC)
	{
		this.idC = idC;
	}

	public double getImporte()
	{
		return importe;
	}

	public void setImporte(double importe)
	{
		this.importe = importe;
	}

	public LocalDateTime getFechaHora()
	{
		return fechaHora;
	}

	public void setFechaHora(String fechaHora)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.fechaHora = LocalDateTime.parse(fechaHora, formato);
	}

	@Override
	public String toString()
	{
		return "Movimiento [id=" + id + ", detalles=" + detalles + ", nombreC=" + nombreC + ", nombreT=" + nombreT + ", importe="
				+ importe + ", fecha=" + fecha + "]\n";
	}

	
}
