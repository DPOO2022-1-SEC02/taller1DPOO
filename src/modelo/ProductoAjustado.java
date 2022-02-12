package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	//private int base;

	ProductoMenu base;

	public ProductoAjustado(ProductoMenu base){
		this.base = base;
	}
	public String getNombre() {

		return base.getNombre();
	}


	public int getPrecio() {
		int precio_inicial = base.getPrecio();
		return base.getPrecio();
	}


	public String generarTextoFactura() {
		return base.generarTextoFactura();
	}
}
