package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento
{

	private int id, idU, idC;
	private double importe;
	private LocalDateTime fechaHora;
	private String detalles;

	private static final int TAMDETALLES = 50;

	/* Constructor */
	public Movimiento()
	{
	}

	public Movimiento(int id, double importe, String fechaHora, String detalles, int idU, int idC)
	{
		this.id = id;
		this.importe = importe;
		setFechaHora(fechaHora);
		setDetalles(detalles);
		this.idC = idC;
		this.idU = idU;
	}
	
	public Movimiento(double importe, String fechaHora, String detalles, int idU, int idC)
	{
		this.importe = importe;
		setFechaHora(fechaHora);
		setDetalles(detalles);
		this.idC = idC;
		this.idU = idU;
	}

	/* getter y setter */

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public String getDetalles()
	{
		return detalles;
	}

	public void setDetalles(String detalles)
	{
		this.detalles = detalles.substring(0, Math.min(TAMDETALLES, detalles.length()));
	}

	@Override
	public String toString()
	{
		return "Movimiento [id=" + id + ", importe=" + importe + ", fechaHora=" + fechaHora + ", detalles=" + detalles
				+ ", idU=" + idU + ", idC=" + idC + "]";
	}
}
