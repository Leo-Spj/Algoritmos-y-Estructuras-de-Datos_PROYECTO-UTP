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


public class Main {
    public static void main(String[] args) {
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

        // Solicitar al usuario que ingrese el ISBN a buscar
       System.out.print("Ingrese el ISBN a buscar: ");
        String isbnBusqueda = scanner.nextLine().replaceAll("-", "");

        // Realizar búsqueda
        boolean encontrado = arbol.buscar(isbnBusqueda);

        // Mostrar resultados
        if (encontrado) {
            System.out.println("Libro encontrado:");
            imprimirDetallesLibro(arbol.getRaiz(), isbnBusqueda);
        } else {
            System.out.println("Libro con ISBN " + isbnBusqueda + " no encontrado.");
        }

        // Mostrar datos usando los tres tipos de recorrido
        System.out.println("Recorrido inorden:");
        arbol.inorden();

        System.out.println("Recorrido preorden:");
        arbol.preorden();

        System.out.println("Recorrido postorden:");
        arbol.postorden();

        // Cerrar el scanner
        scanner.close();
    }

    private static void imprimirDetallesLibro(NodoABB raiz, String isbn) {
        NodoABB nodo = buscarNodoPorISBN(raiz, isbn);
        if (nodo != null) {
            System.out.println("Autor: " + nodo.libro.getAutor());
            System.out.println("Año: " + nodo.libro.getAño());
            System.out.println("Género: " + nodo.libro.getGenero());
            System.out.println("Título: " + nodo.libro.getTitulo());
            System.out.println("ISBN: " + nodo.libro.getIsbn());
        }
    }

    private static NodoABB buscarNodoPorISBN(NodoABB raiz, String isbn) {
        if (raiz == null || raiz.libro.getIsbn().equals(isbn)) {
            return raiz;
        }

        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
            return buscarNodoPorISBN(raiz.izquierda, isbn);
        } else {
            return buscarNodoPorISBN(raiz.derecha, isbn);
        }
    }
}