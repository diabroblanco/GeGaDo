package com.chapaybinario.gegado.controller;

import com.chapaybinario.gegado.services.Encriptar;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.chapaybinario.gegado.model.Movimiento;
//import com.chapaybinario.gegado.services.MovimientosDAO;

//import com.chapaybinario.gegado.model.Categoria;
//import com.chapaybinario.gegado.services.CategoriasDAO;

/*
 *  Esta clase se utiliza para testear el funcionamiento de los diferentes módulos
 */

public class Testing
{

	public static void main(String[] args)
	{
		/********** Test: CategoriasDAO.java **********/

//		CategoriasDAO categoriasDAO = new CategoriasDAO();
//		Categoria categoria;
//		List<Categoria> listaCategorias = new ArrayList<>();

		// Test 1: método readAll() -> OK
//		listaCategorias = categoriasDAO.readAll();
//		Iterator<Categoria> iterador = listaCategorias.iterator();
//		while (iterador.hasNext())
//		{
//			System.out.print(iterador.next());
//		}

		// Test 2: método create() [+ escribir()]-> OK
//		categoria = new Categoria("subvenciones", "icono5", 1);
//		categoriasDAO.create(categoria);

		// Test 3: método read(int) -> OK
//		categoria = categoriasDAO.read(5);
//		System.out.println(categoria);

		// Test 4: método read(String String) -> OK
//		listaCategorias = categoriasDAO.read("nombreC", "impuestos");
//		System.out.println(listaCategorias.get(0).toString());

		// Test 5: método update() [+ escribir()] -> OK
//		categoria = new Categoria(5, "gimnasio", "icono7", 0);
//		categoriasDAO.update(categoria);

		// Test 6: método delete() -> OK
//		categoriasDAO.delete(5);

		// RESULTADO DEL TEST: LAS CLASES Categoria.java y CategoriasDAO.java FUNCIONAN PERFECTAMENTE
		// SI SE DESEA REALIZAR OTRA VEZ EL TEST, DESCOMENTAR LOS 'import' PERTINENTES
		
		
		
		/********** Test: MovimientosDAO.java **********/

//		MovimientosDAO movimientosDAO = new MovimientosDAO();
//		Movimiento movimiento;
//		List<Movimiento> listaMovimientos = new ArrayList<>();

		// Test 1: método readAll() -> OK
//		listaMovimientos = movimientosDAO.readAll(1, 1);
//		Iterator<Movimiento> iterador = listaMovimientos.iterator();
//		while (iterador.hasNext())
//		{
//			System.out.print(iterador.next());
//		}
		
		// Test 2: método create() -> OK
//		movimiento = new Movimiento(1125.32, "2023-06-01 08:12", "horas de mi trabajo", 2, 1);
//		movimientosDAO.create(movimiento);
		
		// Test 3: método delete() -> OK
//		movimientosDAO.delete(2);
		
		// RESULTADO DEL TEST: LAS CLASES Movimiento.java y MovimientosDAO.java FUNCIONAN PERFECTAMENTE
		// SI SE DESEA REALIZAR OTRA VEZ EL TEST, DESCOMENTAR LOS 'import' PERTINENTES
		
		Encriptar nuevaEncriptacion = new Encriptar();
		String clave = nuevaEncriptacion.convertirSHA256("juanito*7");
		System.out.println(clave);
		System.out.println(clave.length());
	}
}
