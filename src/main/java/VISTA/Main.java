package VISTA;

import CONTROL.Estanteria;
import MODELO.CLASIFICACION.LibroDeTexto;
import MODELO.CLASIFICACION.Novela;

public class Main {
    public static void main(String[] args) {

        // Creando novelas
        Novela novela1 = new Novela("El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía");
        Novela novela2 = new Novela("El código Da Vinci", "Dan Brown", 2003, "Misterio");
        Novela novela3 = new Novela("El alquimista", "Paulo Coelho", 1988, "Aventura");
        Novela novela4 = new Novela("El principito", "Antoine de Saint-Exupéry", 1943, "Infantil");
        Novela novela5 = new Novela("El nombre del viento", "Patrick Rothfuss", 2007, "Fantasía");
        Novela novela6 = new Novela("El retrato de Dorian Gray", "Oscar Wilde", 1890, "Terror");
        // Creando libros de texto
        LibroDeTexto libroDeTexto1 = new LibroDeTexto("Matemáticas", "Rafael Espinoza", 2000, "Matemáticas");
        LibroDeTexto libroDeTexto2 = new LibroDeTexto("Física", "Alberto A", 2018, "Física");
        LibroDeTexto libroDeTexto3 = new LibroDeTexto("Química", "Beto B", 1998, "Química");
        LibroDeTexto libroDeTexto4 = new LibroDeTexto("Biología", "Carlos C", 2010, "Biología");
        LibroDeTexto libroDeTexto5 = new LibroDeTexto("Historia", "Daniel D", 2005, "Historia");
        LibroDeTexto libroDeTexto6 = new LibroDeTexto("Geografía", "Eduardo E", 1994, "Geografía");

        // Creando estanterías
        Estanteria<Novela> estanteriaNovelas = new Estanteria();
        Estanteria<LibroDeTexto> estanteriaLibrosTexto = new Estanteria();

        // Agregando novelas a la estantería
        estanteriaNovelas.agregarLibro(novela1);
        estanteriaNovelas.agregarLibro(novela2);
        estanteriaNovelas.agregarLibro(novela3);
        estanteriaNovelas.agregarLibro(novela4);
        estanteriaNovelas.agregarLibro(novela5);
        estanteriaNovelas.agregarLibro(novela6);

        // Agregando libros de texto a la estantería
        estanteriaLibrosTexto.agregarLibro(libroDeTexto1);
        estanteriaLibrosTexto.agregarLibro(libroDeTexto2);
        estanteriaLibrosTexto.agregarLibro(libroDeTexto3);
        estanteriaLibrosTexto.agregarLibro(libroDeTexto4);
        estanteriaLibrosTexto.agregarLibro(libroDeTexto5);
        estanteriaLibrosTexto.agregarLibro(libroDeTexto6);

        // Elimino un libro de texto
        estanteriaLibrosTexto.removerLibro(libroDeTexto1);

        // Listando novelas
        System.out.println("Novelas:");
        estanteriaNovelas.deBurbuja();
        estanteriaNovelas.listarLibros();

        // Listando libros de texto
        System.out.println("Libros de texto:");
        estanteriaLibrosTexto.listarLibros();

        //simulando venta de libros
        libroDeTexto1.establecerPrecio(50);
        libroDeTexto2.establecerPrecio(50);
        libroDeTexto3.establecerPrecio(30);
        libroDeTexto4.establecerPrecio(40);
        libroDeTexto5.establecerPrecio(50);
        libroDeTexto6.establecerPrecio(60);

        // simulando venta de novelas
        novela1.establecerPrecio(40);
        novela2.establecerPrecio(50);
        novela3.establecerPrecio(30);
        novela4.establecerPrecio(40);
        novela5.establecerPrecio(50);
        novela6.establecerPrecio(60);

        System.out.println(novela1.estaPrestado());
        novela1.prestar();
        System.out.println(novela1.estaPrestado());
        novela1.prestar();
        novela1.devolver();
        System.out.println(novela1.estaPrestado());



    }
}