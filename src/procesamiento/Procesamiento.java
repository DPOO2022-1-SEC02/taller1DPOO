package procesamiento;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Producto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class Procesamiento {

    private HashMap<String, Producto> cargarMenuBase() throws Exception {
        HashMap<String, Producto> menuBase = new HashMap<>();
        File menu = new File("./data/menu.txt");
        BufferedReader br = new BufferedReader(new FileReader(menu));
        String line = br.readLine();
        String[] info;
        Producto producto;

        while (line != null) {
            info = line.split(";");
            String nombre = info[0];
            int precio = Integer.parseInt(info[1]);
            producto = new Producto(nombre, precio);
            menuBase.put(nombre, producto);
            line = br.readLine();
        }
        br.close();
        return menuBase;
    }


    private void cargarCombos() throws Exception {
        HashMap<String, Combo> menuCombos = new HashMap<>();
        File menu_combo = new File("./data/combos.txt");
        BufferedReader bufr = new BufferedReader(new FileReader(menu_combo));
        String linea = bufr.readLine();
        Combo combo;

        while (linea != null) {
            String[] partes = linea.split(";");
            String nombreCombo = partes[0];
            Double descuento = Double.parseDouble(partes[1].replace("%", ""));
            descuento = descuento / 100;

            combo = new Combo(nombreCombo, descuento);
            menuCombos.put(nombreCombo, combo);

            linea = bufr.readLine();
        }
        bufr.close();
    }


    private Map<String, Ingrediente> cargaIngredientes() throws Exception {
        HashMap<String, Ingrediente> menuIng = new HashMap<>();

        FileReader archivoIngredientes = new FileReader("./data/ingredientes.txt");
        BufferedReader br = new BufferedReader(archivoIngredientes);
        String message = " "; //*
        String line = br.readLine();
        String[] ingInfo;
        Ingrediente ingredientes;

        while (line != null) {

            ingInfo = line.split(";");
            String ingrediente = ingInfo[0];//esto viene siendo el nombre del ingrediente
            int precio = Integer.parseInt(ingInfo[1]);
            ingredientes = new Ingrediente(ingrediente, precio); //aquí el error viene de que no hemos hecho la clase ingrediente
            menuIng.put(ingrediente, ingredientes); //y el nombre de la 69 es el que se pone aquí

            line = br.readLine();
        }
        br.close();
        return menuIng;
    }

    // String[] producto = []
    // Arraylist <String> = new ArrayList<> ();

}
