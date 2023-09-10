package VISTA;

import CONTROL.ControlEstanteria;
import MODELO.CLASIFICACION.LibroDeTexto;
import MODELO.CLASIFICACION.Novela;

public class Main {
    public static void main(String[] args) {

        // Creando estanterías
        ControlEstanteria<Novela> estanteriaNovelas = new ControlEstanteria();

        // Creando novelas
        Novela novela1 = new Novela("El señor de los anillos", "J.R.R. Tolkien", 1954, 234345263, "Fantasía");
        Novela novela2 = new Novela("El código Da Vinci", "Dan Brown", 2003, 3298745, "Misterio");
        Novela novela3 = new Novela("El alquimista", "Paulo Coelho", 1988, 234875, "Aventura");
        Novela novela4 = new Novela("El principito", "Antoine de Saint-Exupéry", 1943, 2348745,"Infantil");
        Novela novela5 = new Novela("El nombre del viento", "Patrick Rothfuss", 2007, 9872163, "Fantasía");
        Novela novela6 = new Novela("El retrato de Dorian Gray", "Oscar Wilde", 1890, 283740, "Terror");

        // Agregando novelas a la estantería
        estanteriaNovelas.agregarLibro(novela1);
        estanteriaNovelas.agregarLibro(novela2);
        estanteriaNovelas.agregarLibro(novela3);
        estanteriaNovelas.agregarLibro(novela4);
        estanteriaNovelas.agregarLibro(novela5);
        estanteriaNovelas.agregarLibro(novela6);


        // Listando novelas
        System.out.println("Novelas:");
        // Ordeno las novelas por año de publicación
        estanteriaNovelas.deBurbuja("anioPublicacion");
        estanteriaNovelas.listarLibros();

    }
}