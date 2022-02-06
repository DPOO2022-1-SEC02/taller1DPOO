/*
* ESTA ES LA CLASE PRUEBAS
* Aquí se hacen las pruebas de commits de git
* También se pueden probar los métodos antes de agregarlos a las clases principales
* Está aquí para evitar que fallen cosas en las principales y para identificar más facilmente los problemas
* */

package prueba;

import java.io.*;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) throws Exception {

        Prueba prueba = new Prueba();
        prueba.mostrarMenu();
    }

    public void mostrarMenu() throws Exception {
        int actualPos = 1;
        int repeticiones;
        File menu = new File("./data/menu.txt");
        BufferedReader br = new BufferedReader(new FileReader(menu));


        String line=br.readLine();
        System.out.println("|"+" ".repeat(14)+"Producto"+" ".repeat(13)+"|  Precio |");
        System.out.println("-".repeat(48));

        while(line!=null){

            String[] info = line.split(";");
            //Se determina la cantidad de repeticiones para que se pueda ver el menú con un estilo de tabla.
            //Se resta 1 si es mayor a diez, porque se corre un caracter cuando se muestran los números a la izquierda
            repeticiones=35-info[0].length();
            if (actualPos>=10) repeticiones-=1;

            System.out.print("| "+actualPos+". "+info[0]+" ".repeat(repeticiones-5)+" |  ");
            System.out.println(info[1]+" ".repeat(7-info[1].length())+"|");


            line=br.readLine();
            actualPos++;
        }
    }


}
