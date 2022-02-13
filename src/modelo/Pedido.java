package modelo;


import java.io.*;
import java.util.ArrayList;

public class Pedido {
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<ProductoMenu> itemsPedido;

    public Pedido(int idPedido, int numeroPedidos, String nombreCliente, String direccionCliente) {
        this.numeroPedidos = numeroPedidos;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.itemsPedido = new ArrayList<>();

    }

    public int getIdPedido() {

        return this.idPedido;
    }

    public void agregarProducto(ProductoMenu nuevoItem) {
        itemsPedido.add(nuevoItem);
    }

    private int getPrecioPedido() {
        int precio = 0;
        for (ProductoMenu item : itemsPedido) {
            precio += item.getPrecio();
        }
        return precio;
    }


    private String generarTextoFactura() {
        String textoFactura = "              Factura de compra\n";
        textoFactura += ("Nombre del cliente: " + nombreCliente + "\n");
        textoFactura += ("Dirección del cliente: " + direccionCliente + "\n");
        for (ProductoMenu producto : this.itemsPedido) {
            System.out.println(producto.getNombre());
            textoFactura += (producto.generarTextoFactura() + "\n");
        }
        textoFactura += ("Precio total " + " ".repeat(27) + getPrecioPedido()) + "\n";
        textoFactura += ("Precio total con iva" + " ".repeat(20) + (getPrecioPedido() * 0.19 + getPrecioPedido()));
        return textoFactura;
    }

    public void guardarFactura(File archivo) throws Exception {
        try {

            if (archivo.createNewFile()) {
            } else {
                System.err.println("File already exists");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            String txtFactura = generarTextoFactura();
            bw.write(txtFactura);
            bw.close();
        } catch (Exception i) {
            System.out.println("Hubo un error");
        }
    }
}

