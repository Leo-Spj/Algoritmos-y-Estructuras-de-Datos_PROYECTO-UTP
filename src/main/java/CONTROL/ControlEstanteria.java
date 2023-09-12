package CONTROL;


import MODELO.CLASIFICACION.Novela;
import MODELO.Libro;

public class ControlEstanteria<L extends Libro> {


    public Libro listaLibros[] = new Libro[1];

    public L obtenerUnLibro(long isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN() == isbn) {
                return (L) libro;
            }
        }
        return null;
    }

    public Libro[] getListaLibros() { //obtener libros en modo array de objetos, usar para mostrar en JTable
        return listaLibros;
    }

    public void listarLibros() { // Este listado es para mostrar en consola, no usar, solo pruebas
        for (Libro libro : listaLibros) {
            System.out.println(libro.getTitulo());
        }
    }

    public void agregarLibro(L libro) {
        if (listaLibros[listaLibros.length - 1] == null) {
            listaLibros[listaLibros.length - 1] = libro;
        } else {
            Libro listaLibrosAux[] = new Libro[listaLibros.length + 1];
            for (int i = 0; i < listaLibros.length; i++) {
                listaLibrosAux[i] = listaLibros[i];
            }
            listaLibros = listaLibrosAux;
            listaLibros[listaLibros.length - 1] = libro;
        }
    }

    public void removerLibro(L libro) {
        for (int i = 0; i < listaLibros.length; i++) {
            if (listaLibros[i] == libro) {
                listaLibros[i] = null;

                Libro AuxIzquierda[] = new Libro[i];
                Libro AuxDerecha[] = new Libro[listaLibros.length - i - 1];

                for (int j = 0; j < AuxIzquierda.length; j++) {
                    AuxIzquierda[j] = listaLibros[j];
                }
                for (int j = 0; j < AuxDerecha.length; j++) {
                    AuxDerecha[j] = listaLibros[j + i + 1];
                }

                listaLibros = new Libro[listaLibros.length - 1];

                for (int j = 0; j < AuxIzquierda.length; j++) {
                    listaLibros[j] = AuxIzquierda[j];
                }
                for (int j = 0; j < AuxDerecha.length; j++) {
                    listaLibros[j + AuxIzquierda.length] = AuxDerecha[j];
                }

                break;
            }
        }
    }


    // ------------------ Métodos de ordenamiento : ------------------

    public void deBurbuja(String atributo) {
        //se ordenana por anioPublicacion:
        for (int i = 0; i < listaLibros.length; i++) {
            for (int j = 0; j < listaLibros.length - 1; j++) {
                if (atributo.equals("anioPublicacion")) {
                    if (listaLibros[j].getAnioPublicacion() > listaLibros[j + 1].getAnioPublicacion()) {
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j + 1];
                        listaLibros[j + 1] = aux;
                    }
                } else if (atributo.equals("ISBN")) {
                    if (listaLibros[j].getISBN() > listaLibros[j + 1].getISBN()) {
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j + 1];
                        listaLibros[j + 1] = aux;
                    }
                }
                if (atributo.equals("titulo")) {
                    if (listaLibros[j].getTitulo().compareToIgnoreCase(listaLibros[j + 1].getTitulo()) > 0) {
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j + 1];
                        listaLibros[j + 1] = aux;
                    }
                } else if (atributo.equals("autor")) {
                    if (listaLibros[j].getAutor().compareToIgnoreCase(listaLibros[j + 1].getAutor()) > 0) {
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j + 1];
                        listaLibros[j + 1] = aux;
                    }
                } else if (atributo.equals("genero")) {
                    if ( ((Novela) listaLibros[j]).getGenero().compareToIgnoreCase(((Novela) listaLibros[j + 1]).getGenero()) > 0) {
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j + 1];
                        listaLibros[j + 1] = aux;
                    }
                }
            }
        }
    }

    public void porSeleccion_String(String atributo) {
        int indice;
        for (int i = 0; i < listaLibros.length - 1; i++) {
            indice = i;

            for (int j = i + 1; j < listaLibros.length; j++) {
                if (compararLibrosPorAtributo(listaLibros[j], listaLibros[indice], atributo) < 0) {
                    indice = j;
                }
            }

            // Intercambiar los libros en las posiciones i e indice
            Libro auxLibro = listaLibros[i];
            listaLibros[i] = listaLibros[indice];
            listaLibros[indice] = auxLibro;
        }
    }

    private int compararLibrosPorAtributo(Libro libro1, Libro libro2, String atributo) {
        switch (atributo) {
            case "Año":
                return Integer.compare(libro1.getAnioPublicacion(), libro2.getAnioPublicacion());
            case "ISBN":
                return Long.compare(libro1.getISBN(), libro2.getISBN());
            case "titulo":
                return libro1.getTitulo().compareToIgnoreCase(libro2.getTitulo());
            case "autor":
                return libro1.getAutor().compareToIgnoreCase(libro2.getAutor());
            default:
                throw new IllegalArgumentException("Atributo desconocido: " + atributo);
        }
    }


    public void ordenarNovelaPorGeneroYAnioPublicacion() {

        // Tipo de ordenamiento: Burbuja - Orden Ascendente
        deBurbuja("genero");

        Novela[] listaNovelas = new Novela[listaLibros.length];
        int contador = 0;
        for (int i = 0; i < listaLibros.length; i++) {
            if (listaLibros[i] instanceof Novela) {
                listaNovelas[contador] = (Novela) listaLibros[i];
                contador++;
            }
        }

        // Tipo de ordenamiento: Selección - Orden Descendente
        int indice;
        Novela auxLibro;
        for (int i = 0; i < listaNovelas.length - 1; i++) {
            indice = i;

            for (int j = i + 1; j < listaNovelas.length; j++) {
                if (listaNovelas[j].getGenero().equals(listaNovelas[i].getGenero())) {
                    if (listaNovelas[j].getAnioPublicacion() < listaNovelas[indice].getAnioPublicacion()) {
                        indice = j;
                    }
                }
            }

            if (indice != i) {
                auxLibro = listaNovelas[i];
                listaNovelas[i] = listaNovelas[indice];
                listaNovelas[indice] = auxLibro;
            }
        }


        listaLibros = listaNovelas;
    }


    // ------------------ Métodos de búsqueda : ------------------

    public int busquedaOrdenada(int array[], int valor) {

        //Busqueda secuencial
        int indMayor = array.length - 1;
        int ind = 0;
        while (ind < indMayor && valor != array[ind]) {
            ind++;
        }
        if (valor == array[ind]) {
            return ind;
        } else {
            return -1;
        }
    }

    public Libro[] busquedaSecuencial(String atributo, String buscar) {
        Libro[] resultados = new Libro[0];
        for (int i = 0; i < listaLibros.length; i++) {
            if (atributo.equals("Titulo")) {
                if (listaLibros[i].getTitulo().toLowerCase().indexOf(buscar.toLowerCase()) != -1) {
                    Libro[] aux = new Libro[resultados.length + 1];
                    for (int j = 0; j < resultados.length; j++) {
                        aux[j] = resultados[j];
                    }
                    aux[resultados.length] = listaLibros[i];
                    resultados = aux;
                }
            } else if (atributo.equals("ISBN")) {
                if (String.valueOf(listaLibros[i].getISBN()).startsWith(buscar)) {
                    Libro[] aux = new Libro[resultados.length + 1];
                    for (int j = 0; j < resultados.length; j++) {
                        aux[j] = resultados[j];
                    }
                    aux[resultados.length] = listaLibros[i];
                    resultados = aux;
                }
            } else if (atributo.equals("Autor")) {
                if (listaLibros[i].getAutor().toLowerCase().indexOf(buscar.toLowerCase()) != -1) {
                    Libro[] aux = new Libro[resultados.length + 1];
                    for (int j = 0; j < resultados.length; j++) {
                        aux[j] = resultados[j];
                    }
                    aux[resultados.length] = listaLibros[i];
                    resultados = aux;
                }
                // para genero
            } else if (atributo.equals("Genero")) {
                if (listaLibros[i] instanceof Novela) {
                    if (((Novela) listaLibros[i]).getGenero().toLowerCase().indexOf(buscar.toLowerCase()) != -1) {
                        Libro[] aux = new Libro[resultados.length + 1];
                        for (int j = 0; j < resultados.length; j++) {
                            aux[j] = resultados[j];
                        }
                        aux[resultados.length] = listaLibros[i];
                        resultados = aux;
                    }
                }
                // año
            } else if (atributo.equals("Año")) {
                if (String.valueOf(listaLibros[i].getAnioPublicacion()).startsWith(buscar)) {
                    Libro[] aux = new Libro[resultados.length + 1];
                    for (int j = 0; j < resultados.length; j++) {
                        aux[j] = resultados[j];
                    }
                    aux[resultados.length] = listaLibros[i];
                    resultados = aux;
                }
            }
        }
        return resultados;
    }

    public Libro[] busquedaBinariaSeleccion(String atributo, String valor) {
        porSeleccion_String(atributo);

        int central, bajo, alto;
        long valorCentral;
        bajo = 0;
        alto = listaLibros.length - 1;

        Libro[] librosEncontrados = new Libro[listaLibros.length]; // Crear un arreglo para almacenar los libros encontrados
        int contador = 0; // Un contador para rastrear la cantidad de libros encontrados

        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            valorCentral = obtenerValorPorAtributo(listaLibros[central], atributo);

            long comparacion;
            if (atributo.equals("titulo") || atributo.equals("autor")) {
                comparacion = valor.compareToIgnoreCase(String.valueOf(valorCentral));
            } else {
                comparacion = Long.parseLong(valor) - valorCentral;
            }

            if (comparacion == 0) {
                librosEncontrados[contador] = listaLibros[central];
                contador++; // Incrementar el contador y seguir buscando más coincidencias
            }

            if (comparacion < 0) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        // Crear un nuevo arreglo con el tamaño correcto para almacenar solo los libros encontrados
        Libro[] resultado = new Libro[contador];
        System.arraycopy(librosEncontrados, 0, resultado, 0, contador);
        return resultado;
    }


    private long obtenerValorPorAtributo(Libro libro, String atributo) {
        switch (atributo) {
            case "Año":
                return libro.getAnioPublicacion();
            case "ISBN":
                return libro.getISBN();
            case "titulo":
                return libro.getTitulo().hashCode();
            case "autor":
                return libro.getAutor().hashCode();
            default:
                throw new IllegalArgumentException("Atributo desconocido: " + atributo);
        }
    }

}
