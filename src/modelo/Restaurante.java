package modelo;

import procesamiento.Procesamiento;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
    private ArrayList<Ingrediente> ingredientes;
    private ArrayList<ProductoMenu> menuBase;
    private ArrayList<Combo> combos;
    private ArrayList<Pedido> pedidos;
    private int pedidoEnCurso;

    private Procesamiento procesador = new Procesamiento();


    public Restaurante() {
        this.ingredientes = new ArrayList<>();
        this.menuBase = new ArrayList<>();
        this.combos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.pedidoEnCurso = 0;
    }


    public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws Exception {
        cargarMenuBase(archivoMenu);
        cargarCombos(archivoCombos);
        cargaIngredientes(archivoIngredientes);

    }


    private void cargarMenuBase(File archivoMenu) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
        String line = br.readLine();
        String[] info;
        ProductoMenu productoMenu;

        while (line != null) {
            info = line.split(";");
            String nombre = info[0];
            int precio = Integer.parseInt(info[1]);
            productoMenu = new ProductoMenu(nombre, precio);
            menuBase.add(productoMenu);
            line = br.readLine();
        }
        br.close();

    }


    private void cargarCombos(File archivoCombos) throws Exception {

        BufferedReader bufr = new BufferedReader(new FileReader(archivoCombos));
        String linea = bufr.readLine();
        Combo combo;

        while (linea != null) {
            String[] partes = linea.split(";");
            String nombreCombo = partes[0];
            Double descuento = Double.parseDouble(partes[1].replace("%", ""));
            descuento = descuento / 100;
            combo = new Combo(nombreCombo, descuento);
            for (int i = 2; i < partes.length; i++) {
                combo.agregarItemACombo(procesador.buscarProducto(menuBase, partes[i]));
            }
            combos.add(combo);

            linea = bufr.readLine();
        }
        bufr.close();
    }


    private void cargaIngredientes(File archivoIngredientes) throws Exception {


        BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
        String message = " "; //*
        String line = br.readLine();
        String[] ingInfo;
        Ingrediente ingrediente;
        while (line != null) {

            ingInfo = line.split(";");
            String nombre = ingInfo[0];//esto viene siendo el nombre del ingrediente
            int precio = Integer.parseInt(ingInfo[1]);
            ingrediente = new Ingrediente(nombre, precio);
            ingredientes.add(ingrediente); //y el nombre de la 69 es el que se pone aquí

            line = br.readLine();
        }
        br.close();

    }


    int id_actual = 0;

    public void iniciarPedido(String nombreCliente, String direccionCliente) {
        pedidoEnCurso = id_actual;
        boolean continuar = true;
        int cont = 1;
        Pedido pedido = new Pedido(id_actual, 0, nombreCliente, direccionCliente);

        while (continuar) {

            System.out.println("Selecciona una de las opciones que tenemos para tí.");
            System.out.println("Presiona 0 si quieres salir.");
            for (ProductoMenu producto : getMenuBase()) {
                System.out.println(cont + ". " + producto.getNombre() + " : " + producto.getPrecio());
                cont++;
            }
            int seleccionado = Integer.parseInt(input("Selecciona una opcion"));
            if (seleccionado>cont-1){
                System.err.println("\nPor favor selecciona una opción valida.\n");
                continue;
            }
            if (seleccionado == 0) {
                continuar = false;
            } else {
                pedido.agregarProducto(menuBase.get(seleccionado - 1));
                pedidos.add(pedido);
                cont = 1;
            }

        }
    }

    public ArrayList<ProductoMenu> getMenuBase() {
        return this.menuBase;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public ArrayList<Combo> getCombos() {
        return this.combos;
    }

/*
*   Ya veremos dijo el ciego.jpg
    public Pedido getPedidoEnCurso() {

    }

    public Pedido getPedidoPorId(int id) {
    }*/

    public void cerrarYGuardarPedido() throws Exception {
        System.out.println(id_actual);
        Pedido cosa = pedidos.get(id_actual);
        cosa.guardarFactura(new File("./data/facturas/"+id_actual+".txt"));
        pedidoEnCurso=0;
        id_actual++;

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
