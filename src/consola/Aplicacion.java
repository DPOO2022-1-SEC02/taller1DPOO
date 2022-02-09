package consola;

import modelo.Ingrediente;
import modelo.Pedido;
import modelo.ProductoMenu;
import modelo.Restaurante;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    private Restaurante restaurante;
    Aplicacion aplicacion = new Aplicacion();
    Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {


        int opcion;


    }

    public void ejecutarOpcion(int opcion) {
        boolean continuar = true;
        int id;
        while (continuar) {
            aplicacion.mostrarMenu();
            opcion = entrada.nextInt();
            switch (opcion) {
                case (1) -> {
                    ArrayList<ProductoMenu> menuCompleto = restaurante.getMenuBase();
                    for (ProductoMenu producto : menuCompleto) {
                        System.out.println(producto.getNombre() + " " + producto.getPrecio());
                    }
                }
                case (2) -> restaurante.iniciarPedido();
                case (3) -> {
                    id = pedirId();
                    ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
                    for (Ingrediente ingrediente : ingredientes) {
                        System.out.println(ingrediente.getNombre() + " " + ingrediente.getCostoAdicional());
                    }
                    System.out.println("Selecciona un ingrediente: ");
                    Pedido actual = restaurante.getPedidoEnCurso();


                }
                case (4) -> restaurante.cerrarYGuardarPedido();
                case (5) -> {
                    id = pedirId();
                    restaurante.getPedidoPorId(id);
                }
                case (6) -> continuar=false;
            }

        }
    }

    public int pedirId() {
        System.out.print("Escribe el id del pedido: ");
        return entrada.nextInt();
    }

    public void mostrarMenu() {
        System.out.print("""
                1. Mostrar el menú
                2. Iniciar un nuevo pedido
                3. Agregar un elemento a un pedido
                4. Cerrar un pedido y guardar la factura
                5. Consultar la información de un pedido dado su id
                6. Salir de la aplicación
                7. Por favor selecciona una opción:\s""");
    }

}
