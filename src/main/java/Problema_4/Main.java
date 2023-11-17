/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema_4;

import java.util.Scanner;

/**
 *
 * @author Alexis
 */

  import java.util.Scanner;


//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//         Arreglo libro1 = new Arreglo("Gabriel García Márquez", 1967, "Realismo mágico", "Cien años de soledad", "9783161484100");
//        Arreglo libro2 = new Arreglo("J.K. Rowling", 1997, "Fantasía", "Harry Potter y la piedra filosofal", "9780747532696");
//        Arreglo libro3 = new Arreglo("George Orwell", 1949, "Distopía", "1984", "9780452284234");
//        Arreglo libro4 = new Arreglo("Jane Austen", 1813, "Novela romántica", "Orgullo y prejuicio", "9781853260001");
//        Arreglo libro5 = new Arreglo("Harper Lee", 1960, "Novela", "Matar a un ruiseñor", "9780061120084");
//        Arreglo libro6 = new Arreglo("J.R.R. Tolkien", 1954, "Fantasía", "El Señor de los Anillos", "9780618346255");
//        Arreglo libro7 = new Arreglo("Agatha Christie", 1934, "Misterio", "Asesinato en el Orient Express", "9780062073488");
//        Arreglo libro8 = new Arreglo("Leo Tolstoy", 1869, "Novela", "Guerra y paz", "9780192833983");
//        Arreglo libro9 = new Arreglo("F. Scott Fitzgerald", 1925, "Ficción", "El gran Gatsby", "9780743273565");
//        Arreglo libro10 = new Arreglo("Jules Verne", 1873, "Aventura", "La vuelta al mundo en 80 días", "9781853260049");
//
//        ArbolABB arbol = new ArbolABB();
//
//         //Insertar libros en el árbol
//        arbol.insertar(libro1);
//        arbol.insertar(libro2);
//        arbol.insertar(libro3);
//        arbol.insertar(libro4);
//        arbol.insertar(libro5);
//        arbol.insertar(libro6);
//        arbol.insertar(libro7);
//        arbol.insertar(libro8);
//        arbol.insertar(libro9);
//        arbol.insertar(libro10);
//
//         // Mostrar solo los ISBN usando los tres tipos de recorrido
//        System.out.println("Recorrido inorden (solo ISBN):");
//        arbol.inordenSoloISBN();
//
//        System.out.println("Recorrido preorden (solo ISBN):");
//        arbol.preordenSoloISBN();
//
//        System.out.println("Recorrido postorden (solo ISBN):");
//        arbol.postordenSoloISBN();
//
//        // Solicitar al usuario que ingrese el ISBN a buscar
//        System.out.print("Ingrese el ISBN a buscar: ");
//        String isbnBusqueda = scanner.nextLine().replaceAll("-", "");
//
//        // Realizar búsqueda
//        boolean encontrado = arbol.buscar(isbnBusqueda);
//
//        // Mostrar resultados
//        if (encontrado) {
//            System.out.println("Libro encontrado:");
//            imprimirDetallesLibro(arbol.getRaiz(), isbnBusqueda);
//        } else {
//            System.out.println("Libro con ISBN " + isbnBusqueda + " no encontrado.");
//        }
//
//        // Cerrar el scanner
//        scanner.close();
//    }
//
//
//
//    private static void imprimirDetallesLibro(NodoABB raiz, String isbn) {
//        NodoABB nodo = buscarNodoPorISBN(raiz, isbn);
//        if (nodo != null) {
//            System.out.println("Autor: " + nodo.libro.getAutor());
//            System.out.println("Año: " + nodo.libro.getAño());
//            System.out.println("Género: " + nodo.libro.getGenero());
//            System.out.println("Título: " + nodo.libro.getTitulo());
//            System.out.println("ISBN: " + nodo.libro.getIsbn());
//        }
//    }
//
//    private static NodoABB buscarNodoPorISBN(NodoABB raiz, String isbn) {
//        if (raiz == null || raiz.libro.getIsbn().equals(isbn)) {
//            return raiz;
//        }
//
//        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
//            return buscarNodoPorISBN(raiz.izquierda, isbn);
//        } else {
//            return buscarNodoPorISBN(raiz.derecha, isbn);
//        }
//    }
//}
//////////////////////////////////////////////////////////////VERSION 2
public class Main {
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

       Arreglo libro1 = new Arreglo("Gabriel García Márquez", 1967, "Realismo mágico", "Cien años de soledad", "9783161484100");
        Arreglo libro2 = new Arreglo("J.K. Rowling", 1997, "Fantasía", "Harry Potter y la piedra filosofal", "9780747532696");
        Arreglo libro3 = new Arreglo("George Orwell", 1949, "Distopía", "1984", "9780452284234");
        Arreglo libro4 = new Arreglo("Jane Austen", 1813, "Novela romántica", "Orgullo y prejuicio", "9781853260001");
        Arreglo libro5 = new Arreglo("Harper Lee", 1960, "Novela", "Matar a un ruiseñor", "9780061120084");
        Arreglo libro6 = new Arreglo("J.R.R. Tolkien", 1954, "Fantasía", "El Señor de los Anillos", "9780618346255");
        Arreglo libro7 = new Arreglo("Agatha Christie", 1934, "Misterio", "Asesinato en el Orient Express", "9780062073488");
        Arreglo libro8 = new Arreglo("Leo Tolstoy", 1869, "Novela", "Guerra y paz", "9780192833983");
        Arreglo libro9 = new Arreglo("F. Scott Fitzgerald", 1925, "Ficción", "El gran Gatsby", "9780743273565");
        Arreglo libro10 = new Arreglo("Jules Verne", 1873, "Aventura", "La vuelta al mundo en 80 días", "9781853260049");

        ArbolABB arbol = new ArbolABB();

         //Insertar libros en el árbol
        arbol.insertar(libro1);
        arbol.insertar(libro2);
        arbol.insertar(libro3);
        arbol.insertar(libro4);
        arbol.insertar(libro5);
        arbol.insertar(libro6);
        arbol.insertar(libro7);
        arbol.insertar(libro8);
        arbol.insertar(libro9);
        arbol.insertar(libro10);
        // Mostrar solo los ISBN usando los tres tipos de recorrido
        System.out.println("Recorrido inorden (solo ISBN):");
        arbol.inordenSoloISBN();

        System.out.println("Recorrido preorden (solo ISBN):");
        arbol.preordenSoloISBN();

        System.out.println("Recorrido postorden (solo ISBN):");
        arbol.postordenSoloISBN();

        // Menú para buscar o eliminar un libro
        System.out.println("Seleccione una opción:");
        System.out.println("1. Buscar libro por ISBN");
        System.out.println("2. Eliminar libro por ISBN");
        System.out.print("Ingrese el número de la opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                // Búsqueda de un libro
                buscarLibro(scanner, arbol);
                break;
            case 2:
                // Eliminación de un libro
                eliminarLibro(scanner, arbol);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Método para buscar un libro por ISBN
    private void buscarLibro(Scanner scanner, ArbolABB arbol) {
        System.out.print("Ingrese el ISBN del libro a buscar: ");
        String isbnBuscar = scanner.nextLine().replaceAll("-", "");

        if (arbol.buscar(isbnBuscar)) {
            System.out.println("Libro encontrado:");
            imprimirDetallesLibro(arbol.getRaiz(), isbnBuscar);
        } else {
            System.out.println("Libro con ISBN " + isbnBuscar + " no encontrado en el árbol.");
        }
    }

    // Método para eliminar un libro por ISBN
    private void eliminarLibro(Scanner scanner, ArbolABB arbol) {
        System.out.print("Ingrese el ISBN del libro a eliminar: ");
        String isbnEliminar = scanner.nextLine().replaceAll("-", "");

        if (arbol.buscar(isbnEliminar)) {
            arbol.eliminar(isbnEliminar);
            System.out.println("Libro con ISBN " + isbnEliminar + " eliminado correctamente.");

            // Mostrar los nuevos recorridos después de la eliminación
            System.out.println("Recorrido inorden (solo ISBN) después de eliminar:");
            arbol.inordenSoloISBN();

            System.out.println("Recorrido preorden (solo ISBN) después de eliminar:");
            arbol.preordenSoloISBN();

            System.out.println("Recorrido postorden (solo ISBN) después de eliminar:");
            arbol.postordenSoloISBN();
        } else {
            System.out.println("Libro con ISBN " + isbnEliminar + " no encontrado en el árbol.");
        }
    }

    // Método para imprimir los detalles de un libro
    private void imprimirDetallesLibro(NodoABB raiz, String isbn) {
        NodoABB nodo = buscarNodoPorISBN(raiz, isbn);
        if (nodo != null) {
            System.out.println("Autor: " + nodo.libro.getAutor());
            System.out.println("Año: " + nodo.libro.getAño());
            System.out.println("Género: " + nodo.libro.getGenero());
            System.out.println("Título: " + nodo.libro.getTitulo());
            System.out.println("ISBN: " + nodo.libro.getIsbn());
        }
    }

    // Método para buscar un nodo por ISBN en el árbol
    private NodoABB buscarNodoPorISBN(NodoABB raiz, String isbn) {
        if (raiz == null || raiz.libro.getIsbn().equals(isbn)) {
            return raiz;
        }

        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
            return buscarNodoPorISBN(raiz.izquierda, isbn);
        } else {
            return buscarNodoPorISBN(raiz.derecha, isbn);
        }
    }

    // Método principal que crea una instancia de la clase Main y ejecuta el programa
    public static void main(String[] args) {
        Main programa = new Main();
        programa.ejecutar();
    }
}