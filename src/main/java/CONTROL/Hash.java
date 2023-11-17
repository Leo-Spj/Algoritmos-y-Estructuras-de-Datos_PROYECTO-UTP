package CONTROL;

import MODELO.CLASIFICACION.Novela;
import java.util.Arrays;
import java.util.Random;

public class Hash {
    private double FACTOR_DE_CARGA_MAXIMO = 0.6;
    private Novela[] tabla;
    private int capacidad;
    private int tamaño;
    

    public Hash(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.tamaño = 0;
        this.tabla = new Novela[capacidad];
    }

    // Función hash de multiplicacion, se usa constante que ayuda a distribuir uniformemente las claves
    private int hash(long isbn) {
        final int A = 265443576;
        int hashValue = Math.abs((int) ((A * isbn) % capacidad));
        System.out.println("Hash de ISBN " + isbn + ": " + hashValue);
        return hashValue;
    }



    // Insertar una novela en la tabla
    public void insert(Novela novela) {
        if ((double) tamaño / capacidad > FACTOR_DE_CARGA_MAXIMO) {
            System.out.println("Rehashing...");
            rehash();
        }

        long isbn = novela.getISBN();
        int indice = hash(isbn);
        

        while (tabla[indice] != null) {
            System.out.println("Colisión en índice: " + indice);
            indice = colisionVisitaAleatoria(indice);
            
        }

        System.out.println("Insertando en índice: " + indice);
        tabla[indice] = novela;
        tamaño++;
    }

    private void rehash() {
        int nuevaCapacidad = capacidad * 2; 
        Novela[] nuevaTabla = new Novela[nuevaCapacidad];

        // Volver a insertar todos los elementos en la nueva tabla
        for (Novela novela : tabla) {
            if (novela != null) {
                int nuevoIndice = hash(novela.getISBN());
                int intento=1;

                while (nuevaTabla[nuevoIndice] != null) {
                    System.out.println("Colisión en rehash, índice: " + nuevoIndice);
                    intento++;
                    //incremento intento para rastrear el numero de intentos
                    nuevoIndice = colisionSondeoCuadratico(nuevoIndice, intento);
                }


                System.out.println("Reinsertando en rehash, índice: " + nuevoIndice);
                nuevaTabla[nuevoIndice] = novela;
            }
        }

        // Actualizar la tabla y la capacidad
        tabla = nuevaTabla;
        capacidad = nuevaCapacidad;
    }

    // Método de manejo de colisiones por sondeo aleatorio
    public int colisionVisitaAleatoria(int indice) {
        int j = 0;
        int r = (int)(Math.random() * capacidad);
        while (tabla[(indice + r) % capacidad] != null) {
            r = (int)(Math.random() * capacidad);
        }
        return (indice + r) % capacidad;
    }
    public int colisionSondeoCuadratico(int indice, int intento) {
        int r = intento * intento;
        return (indice + r) % capacidad;
    }
    

    // Buscar una novela por ISBN
    public Novela buscar(String atributo, String valor) {
        switch (atributo.toLowerCase()) {
            case "titulo":
                return buscarPorTitulo(valor);
            case "autor":
                return buscarPorAutor(valor);
            case "genero":
                return buscarPorGenero(valor);
            default:
                System.out.println("Atributo no válido");
                return null;
        }
    }

    private Novela buscarPorTitulo(String titulo) {
        for (Novela novela : tabla) {
            if (novela != null && novela.getTitulo().equalsIgnoreCase(titulo)) {
                return novela;
            }
        }
        return null;
    }

    private Novela buscarPorAutor(String autor) {
        for (Novela novela : tabla) {
            if (novela != null && novela.getAutor().equalsIgnoreCase(autor)) {
                return novela;
            }
        }
        return null;
    }

    private Novela buscarPorGenero(String genero) {
        for (Novela novela : tabla) {
            if (novela != null && novela.getGenero().equalsIgnoreCase(genero)) {
                return novela;
            }
        }
        return null;
    }

    // Mostrar todos los datos del arreglo
    /*(public void mostrarDatos() {
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                System.out.println(tabla[i]);
            }
        }
    }*/
    public Novela[] mostrarDatos() {
        Novela[] novelas = new Novela[capacidad];
        int count = 0;

        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                novelas[count++] = tabla[i];
            }
        }

        // Ajusta el tamaño del array si no está completamente lleno
        return Arrays.copyOf(novelas, count);
    }
}

