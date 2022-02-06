/*
 * ESTA ES LA CLASE PRUEBAS
 * Aquí se hacen las pruebas de commits de git
 * También se pueden probar los métodos antes de agregarlos a las clases principales
 * Está aquí para evitar que fallen cosas en las principales y para identificar más facilmente los problemas
 * */

package prueba;

import producto.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) throws Exception {
    	
    	System.out.println("Hola mundo");
    	
        Prueba prueba = new Prueba();
        ArrayList<Producto> menu = prueba.cargarMenu();
        for(int i=0;i<menu.size();i++){
            System.out.println(menu.get(i).getNombre());
        }
    }

    public ArrayList<Producto> cargarMenu() throws Exception {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        File menu = new File("./data/menu.txt");
        BufferedReader br = new BufferedReader(new FileReader(menu));

        String line = br.readLine();
        while (line != null) {
            String[] info = line.split(";");
            Producto producto = new Producto(info[0],Integer.parseInt(info[1]));

            listaProductos.add(producto);
            line = br.readLine();

        }
        return listaProductos;
    }





}
