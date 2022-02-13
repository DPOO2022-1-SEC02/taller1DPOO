package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(ProductoMenu base) {
		this.base = base;
		agregados = new ArrayList<Ingrediente>();
		eliminados = new ArrayList<Ingrediente>();
	}
	
	public int getPrecio() {
		int rta = base.getPrecio();
		for (int i=0; i < agregados.size(); i++) {
			rta += agregados.get(i).getCostoAdicional();
		}
		return rta;
	}
	
	public String getNombre() {
		return base.getNombre();
	}

	@Override
	public String generarTextoFactura() {
		return null;
	}

	public String genererarTextoFactura() {
		return base.genererarTextoFactura();
	}
	
	public void agregarAAgregados(Ingrediente ingrediente) {
		agregados.add(ingrediente);
	}
	
}
