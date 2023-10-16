/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROL.Persona;


/**
 *
 * @author LAB-USR-PT116-E406
 */

public class Main_pregunta2{
  
    public static void main(String[] args) {
      Persona[] cola = new Persona[8];

        cola[0] = new Persona("Daniel", 7);
        cola[1] = new Persona("Katherine", 3);
        cola[2] = new Persona("Julio", 2);
        cola[3] = new Persona("Maria", 5);
        cola[4] = new Persona("Pepe", 6);
        cola[5] = new Persona("Juan", 1);
        cola[6] = new Persona("Lucas", 1);
        cola[7] = new Persona("Pedro", 1);

        String mensaje = "";
        // Ordenar el array directamente en el método main
        for (int i = 0; i < cola.length - 1; i++) {
            for (int j = 0; j < cola.length - i - 1; j++) {
                if (cola[j].compareTo(cola[j + 1]) > 0) {//
                    // intercambian las posiciones de las persnas utlizando la variable aux temp
                    Persona temp = cola[j];
                    cola[j] = cola[j + 1];
                    cola[j + 1] = temp;
                }
            }
                    System.out.print(mensaje+cola[i].getNombre()+", ");

        }

        for (Persona a : cola) {
            System.out.println(a.getNombre() + " " + a.getTipo());//imprime n   ombre y tipos ddespues de ser cmparado
        }
        boolean colaVacia = esColaVacia(cola);
        System.out.println("¿La cola está vacía? " + colaVacia);//solo para verificar que la cola este vaci
    }
    public static boolean esColaVacia(Persona[] cola) {//verifica si todas las posiciones del arreglo son nulas.
        for (Persona persona : cola) {
            if (persona != null) {
                return false; // La cola no está vacía
            }
        }
        return true;
    }
}
   