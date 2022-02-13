package modelo;

public class ProductoMenu implements Producto {
	
	private String nombre;
	private int precioBase;

	public ProductoMenu (String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
	}

	public String getNombre() {
		return nombre;
	}


	public String generarTextoFactura() {

		return (nombre+" ".repeat(40-nombre.length())+precioBase);
	}

	public int getPrecio() {
		return precioBase;
	}
	
	public String genererarTextoFactura() {
		return nombre + " ...... $" + precioBase;
	}
}
