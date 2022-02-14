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
        int opcion;
        boolean continuar = true;
        int id;
        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);

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

                case (5) -> {
                    id = pedirId();
                    Pedido pedido = restaurante.getPedidoPorId(id);
                    if (pedido == null) {
                        System.out.println("⚠Por favor ingrese un id válido");
                    } else {
                        showInfoPedido(pedido);
                    }
                }
                case (6) -> continuar = false;
            }

        }
    }

    public void showInfoPedido(Pedido pedido) {
        System.out.println("Id del pedido: " + pedido.getIdPedido() + "\n");
        System.out.println(pedido.generarTextoFactura());
    }

    public int pedirId() {
        return Integer.parseInt(input("Escribe el id del pedido"));
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


    public void mostrarAlgo() {
        int opcion = Integer.parseInt(input("""
                1. Producto clásico.
                2. Combos.
                Selecciona una de las opciones
                """));

        if (opcion == 1) {
            mostrarMenuBase();

        } else {
            mostrarCombos();
        }


    }

    public void mostrarCombos() {
        int cont = 0;
        System.out.println("\nCombos: \n");
        for (Combo combo : restaurante.getCombos()) {
            System.out.println(cont + ". " + combo.getNombre() + ":" + combo.getPrecio());
            cont++;
        }
    }

    public void mostrarMenuBase() {
        int cont = 0;
        System.out.println("\nMenú clásico: \n");
        for (ProductoMenu producto : restaurante.getMenuBase()) {
            System.out.println(cont + ". " + producto.getNombre() + " : " + producto.getPrecio());
            cont++;
        }
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


