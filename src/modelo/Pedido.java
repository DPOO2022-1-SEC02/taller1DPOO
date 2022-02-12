package modelo;


import java.util.ArrayList;

public class Pedido {
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<ProductoMenu> itemsPedido ;

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
    private int getPrecioPedido(){
        return this.idPedido;
    }

}

