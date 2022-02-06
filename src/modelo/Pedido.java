package modelo;


import java.util.ArrayList;

public class Pedido {
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<Producto> itemsPedido;

    public Pedido(int idPedido, int numeroPedidos, String nombreCliente, String direccionCliente, ArrayList<Producto> itemsPedido) {
        this.numeroPedidos = numeroPedidos;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.itemsPedido =itemsPedido;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void agregarProducto(Producto nuevoItem) {
        itemsPedido.add(nuevoItem);
    }
    private int getPrecioPedido(){
        return this.idPedido;
    }

}

