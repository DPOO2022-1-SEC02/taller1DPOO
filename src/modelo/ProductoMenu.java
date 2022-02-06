package modelo;

public class ProductoMenu {
	ProductoMenu producto;
	private String nombre;
	private int precio;

	public ProductoMenu(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;

	}
	public int getPrecio(){
		return precio;
	}
	public String generarTextoFactura(){
		return "";
	}
}
