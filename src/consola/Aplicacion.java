package consola;

import modelo.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    private Restaurante restaurante = new Restaurante();



    private final File archivoMenu = new File("./data/menu.txt");
    private final File archivoCombos = new File("./data/combos.txt");
    private final File archivoIngredientes = new File("./data/ingredientes.txt");



    public static void main(String[] args) throws Exception {
        Aplicacion aplicacion = new Aplicacion();

        aplicacion.ejecutarOpcion();

    }

    public void ejecutarOpcion() throws Exception {
        int opcion ;
        boolean continuar = true;
        int id;
        restaurante.cargarInformacionRestaurante(archivoIngredientes,archivoMenu,archivoCombos);

        System.out.print("""
                              Bienvenido a El Corral
                              Estas son las opciones que tenemos para ti:
                              """);
        while (continuar) {
            mostrarMenu();
            opcion = Integer.parseInt(input("Por favor selecciona una opción"));
            switch (opcion) {


                case (1) -> mostrarMenuBase();

                case (2) -> {
                    String nombreCliente = input("Escriba el nombre del cliente");
                    String direccionCliente = input("Escriba la dirección del cliente");
                    restaurante.iniciarPedido(nombreCliente, direccionCliente);

                    //mostrarMenuBase();



                }


/*                case (3) -> {
                    id = pedirId();
                    ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
                    for (Ingrediente ingrediente : ingredientes) {
                        System.out.println(ingrediente.getNombre() + " " + ingrediente.getCostoAdicional());
                    }
                    System.out.println("Selecciona un ingrediente: ");
                    Pedido actual = restaurante.getPedidoEnCurso();


                }
                */


                case (4) -> restaurante.cerrarYGuardarPedido();
/*                case (5) -> {
*                    id = pedirId();
*                    restaurante.getPedidoPorId(id);
*                }
*/
                case (6) -> continuar = false;
            }

        }
    }

    public int pedirId() {
        return Integer.parseInt(input("Escribe el id del pedido."));
    }

    public void mostrarMenu() {
        System.out.print("""
                1. Mostrar el menú
                2. Iniciar un nuevo pedido
                3. Agregar un elemento a un pedido
                4. Cerrar un pedido y guardar la factura
                5. Consultar la información de un pedido dado su id
                6. Salir de la aplicación
                """);
    }


    public void mostrarMenuBase(){
        ArrayList<ProductoMenu> menuCompleto = restaurante.getMenuBase();
        ArrayList<Combo> combos = restaurante.getCombos();
        int cont = 1;
        System.out.println("\nMenú El Corral: \n");
        for (ProductoMenu producto : menuCompleto) {
            System.out.println(cont+"."+producto.getNombre() + " " + producto.getPrecio());
            cont++;
        }
        System.out.println("\n");

        System.out.println("Combos:");
        for (Combo combo : combos) {
            System.out.println(cont+". "+combo.getNombre() + " " + combo.getPrecio());
            cont++;
        }
        System.out.println("\n");

    }

    public String input(String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo de la consola");
            e.printStackTrace();
        }
        return null;
    }
}


