/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APF3.P4;

/**
 *
 * @author Alexis
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class Main extends JFrame{
    // Método principal que inicia la ejecución del programa
     ArbolABB arbol = new ArbolABB();

    public void ejecutar() {
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
        JOptionPane.showMessageDialog(null, "Recorrido inorden (solo ISBN):\n" + arbol.obtenerRecorridoInordenSoloISBN());
        JOptionPane.showMessageDialog(null, "Recorrido preorden (solo ISBN):\n" + arbol.obtenerRecorridoPreordenSoloISBN());
        JOptionPane.showMessageDialog(null, "Recorrido postorden (solo ISBN):\n" + arbol.obtenerRecorridoPostordenSoloISBN());

        // Cambia JOptionPane.showMessageDialog a JOptionPane.showInputDialog para obtener la opción del usuario
        String opcionStr = JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                "1. Buscar libro por ISBN\n" +
                "2. Eliminar libro por ISBN");

        // Cambia de String a int para comparar la opción
        int opcion = Integer.parseInt(opcionStr);

        // switch con JOptionPane
        switch (opcion) {
            case 1:
                // Búsqueda de un libro
                buscarLibro(arbol);
                break;
            case 2:
                // Eliminación de un libro
                eliminarLibro(arbol);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
        }


        // No es necesario cerrar el scanner al usar JOptionPane
        // scanner.close();
    }

    // Método para buscar un libro por ISBN
    private void buscarLibro(ArbolABB arbol) {
        String isbnBuscar = JOptionPane.showInputDialog("Ingrese el ISBN del libro a buscar: ").replaceAll("-", "");

        if (arbol.buscar(isbnBuscar)) {
            JOptionPane.showMessageDialog(null, "Libro encontrado:\n" + obtenerDetallesLibro(arbol.getRaiz(), isbnBuscar));
        } else {
            JOptionPane.showMessageDialog(null, "Libro con ISBN " + isbnBuscar + " no encontrado en el árbol.");
        }
    }

    // Método para eliminar un libro por ISBN
    private void eliminarLibro(ArbolABB arbol) {
        String isbnEliminar = JOptionPane.showInputDialog("Ingrese el ISBN del libro a eliminar: ").replaceAll("-", "");

        if (arbol.buscar(isbnEliminar)) {
            arbol.eliminar(isbnEliminar);
            JOptionPane.showMessageDialog(null, "Libro con ISBN " + isbnEliminar + " eliminado correctamente.\n" +
                    "Recorrido inorden (solo ISBN) después de eliminar:\n" + arbol.obtenerRecorridoInordenSoloISBN() +
                    "\nRecorrido preorden (solo ISBN) después de eliminar:\n" + arbol.obtenerRecorridoPreordenSoloISBN() +
                    "\nRecorrido postorden (solo ISBN) después de eliminar:\n" + arbol.obtenerRecorridoPostordenSoloISBN());
        } else {
            JOptionPane.showMessageDialog(null, "Libro con ISBN " + isbnEliminar + " no encontrado en el árbol.");
        }
    }

    // Método para obtener los detalles de un libro
    private String obtenerDetallesLibro(NodoABB raiz, String isbn) {
        NodoABB nodo = buscarNodoPorISBN(raiz, isbn);
        if (nodo != null) {
            return "Autor: " + nodo.libro.getAutor() + "\n" +
                    "Año: " + nodo.libro.getAño() + "\n" +
                    "Género: " + nodo.libro.getGenero() + "\n" +
                    "Título: " + nodo.libro.getTitulo() + "\n" +
                    "ISBN: " + nodo.libro.getIsbn();
        } else {
            return "Libro no encontrado.";
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