package modelo;

import java.util.ArrayList;

public class Combo {
    private double descuento;
    private String nombreCombo;
    private ArrayList<ProductoMenu> productos = new ArrayList<>();

    public Combo( String nombreCombo, double descuento) {
        this.descuento = descuento;
        this.nombreCombo = nombreCombo;
    }

    public void agregarItemACombo(ProductoMenu itemCombo) {
        productos.add(itemCombo);
    }

    public int getPrecio() {
        int totalPrecio=0;
        ProductoMenu actual;
        for (int i=0;i<productos.size();i++){
            actual = productos.get(i);
            totalPrecio+=actual.getPrecio();
        }
        return totalPrecio;
    }

    public String getNombre() {
        return this.nombreCombo;
    }

    public String generarTextoFactura() {
        return "";
    }
}
