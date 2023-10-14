/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

/**
 *
 * @author LAB-USR-PT116-E406
 */
public class Persona implements Comparable<Persona> {

    private String nombre;
    private int tipo; // 1 joven, 2 niño, 3 adulto mayor

    //constructores,setters y getters
    public Persona(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(Persona o) {
        if (tipo < o.getTipo()) {
            return 1;
        } else if (tipo > o.getTipo()) {
            return -1;
        } else {
            // si los tipos son iguales se compara en base a os nombres
            return nombre.compareTo(o.getNombre());
        }
    }

    public static void sortPersonasByTipo(Persona[] personas) {
        // ordenamiento burbuja ordenando arary por tipo
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {//inicia de 0 a n-1
            for (int j = 0; j < n - i - 1; j++) {
                if (personas[j].compareTo(personas[j + 1]) > 0) {
                    //  intercambian las posiciones de las persnas utlizando la variable aux temp
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }
}