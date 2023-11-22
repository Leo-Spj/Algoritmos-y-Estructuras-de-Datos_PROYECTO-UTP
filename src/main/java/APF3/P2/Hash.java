package APF3.P2;

import MODELO.CLASIFICACION.Novela;
import java.util.Arrays;
import java.util.Random;

public class Hash {
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
        final long A = 2654435761L; // Cambié A a un número primo impar
        long hashValue = Math.abs((A * isbn) % capacidad);
        System.out.println("Hash de ISBN " + isbn + ": " + hashValue);
        return (int) hashValue;
    }



    // Insertar una novela en la tabla
    public void insert(Novela novela) {
        /*if ((double) tamaño / capacidad > FACTOR_DE_CARGA_MAXIMO) {
            System.out.println("Rehashing...");
            rehash();
        }*/

        long isbn = novela.getISBN();
        int indice = hash(isbn);
        int intento=1;

        while (tabla[indice] != null) {
            System.out.println("Colisión en índice: " + indice);
            indice = colisionSondeoCuadratico(indice,intento);
            intento++;
        }

        System.out.println("Insertando en índice: " + indice);
        tabla[indice] = novela;
        tamaño++;
    }
    /*
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
    }*/

    // Método de manejo de colisiones por sondeo aleatorio
    /*public int colisionVisitaAleatoria(int indice) {
        int j = 0;
        int r = (int)(Math.random() * capacidad);
        while (tabla[(indice + r) % capacidad] != null) {
            r = (int)(Math.random() * capacidad);
        }
        return (indice + r) % capacidad;
    }*/
    // Método de manejo de colisiones por sondeo cuadrático
    public int colisionSondeoCuadratico(int indice, int intento) {
        int r = intento * intento;
        return (indice + r) % capacidad;
    }
    

    // Buscar una novela por ISBN
    public Novela buscar(long isbn) {
        int indice = hash(isbn); 
        int intento = 1;

        while (tabla[indice] != null) {
            System.out.println("Buscando en índice: " + indice);

            if (tabla[indice].getISBN() == isbn) {
                // Se encontró la novela
                System.out.println("Novela encontrada en índice: " + indice);
                return tabla[indice];
            }

            // Manejar la colisión usando sondeo cuadrático
            int nuevaPosicion = colisionSondeoCuadratico(indice, intento);
            System.out.println("Colisión en índice " + indice + ", probando nueva posición: " + nuevaPosicion);

            // Actualizar la posición para el siguiente intento
            indice = nuevaPosicion;
            intento++;

            // Evitar un bucle infinito si no se encuentra la novela
            if (intento > capacidad) {
                break;
            }
        }

        // No se encontró la novela
        System.out.println("No se encontró la novela con ISBN " + isbn);
        return null;
    }

    //Eliminar novela por ISBN
    public boolean eliminar(long isbn) {
        int intento = 1;
        int indice = hash(isbn);

        while (tabla[indice] != null) {
            if (tabla[indice].getISBN() == isbn) {
                tabla[indice] = null;
                tamaño--;
                System.out.println("Novela eliminada con ISBN " + isbn);
                return true;
            }

            // Manejar la colisión usando sondeo cuadrático
            int nuevaPosicion = colisionSondeoCuadratico(indice, intento);
            System.out.println("Colisión en índice " + indice + ", probando nueva posición: " + nuevaPosicion);

            // Actualizar la posición para el siguiente intento
            indice = nuevaPosicion;
            intento++;

            // Evitar un bucle infinito si no se encuentra la novela
            if (intento > capacidad) {
                System.out.println("No se encontró ninguna novela con ISBN " + isbn);
                return false;
            }
        }

        System.out.println("No se encontró ninguna novela con ISBN " + isbn);
        return false;
    }


    //mostrar novela en tabla
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

