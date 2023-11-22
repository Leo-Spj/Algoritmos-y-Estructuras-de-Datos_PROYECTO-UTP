/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APF3.P4;

/**
 *
 * @author Alexis
 */
// Clase que representa los nodos del árbol binario de búsqueda (ABB)
class NodoABB {
    Arreglo libro;  // Instancia de la clase Arreglo que contiene la información del libro
    NodoABB izquierda, derecha;  // Referencias a los nodos izquierdo y derecho en el árbol

    // Constructor que inicializa un nodo con un libro y sin nodos izquierdo y derecho
    public NodoABB(Arreglo libro) {
        this.libro = libro;
        this.izquierda = this.derecha = null;
    }
}
