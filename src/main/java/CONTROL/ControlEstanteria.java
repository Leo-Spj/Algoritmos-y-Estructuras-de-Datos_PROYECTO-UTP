package CONTROL;


import MODELO.Libro;

public class ControlEstanteria<L extends Libro>  {

    private Libro listaLibros[] = new Libro[1] ;

    public Libro obtenerUnLibro(int posicion){
        return listaLibros[posicion];
    }

    public Libro[] getListaLibros() { //obtener libros en modo array de objetos, usar para mostrar en JTable
        return listaLibros;
    }

    public void listarLibros(){ // Este listado es para mostrar en consola, no usar, solo pruebas
        for(Libro libro : listaLibros){
            System.out.println(libro.getTitulo());
        }
    }

    public void agregarLibro(L libro){
        if(listaLibros[listaLibros.length-1] == null){
            listaLibros[listaLibros.length-1] = libro;
        } else {
            Libro listaLibrosAux[] = new Libro[listaLibros.length + 1];
            for (int i = 0; i < listaLibros.length; i++) {
                listaLibrosAux[i] = listaLibros[i];
            }
            listaLibros = listaLibrosAux;
            listaLibros[listaLibros.length - 1] = libro;
        }
    }

    public void removerLibro(L libro){
        for(int i = 0; i < listaLibros.length; i++){
            if(listaLibros[i] == libro){
                listaLibros[i] = null;

                Libro AuxIzquierda[] = new Libro[i];
                Libro AuxDerecha[] = new Libro[listaLibros.length - i - 1];

                for(int j = 0; j < AuxIzquierda.length; j++){
                    AuxIzquierda[j] = listaLibros[j];
                }
                for(int j = 0; j < AuxDerecha.length; j++){
                    AuxDerecha[j] = listaLibros[j + i + 1];
                }

                listaLibros = new Libro[listaLibros.length - 1];

                for(int j = 0; j < AuxIzquierda.length; j++){
                    listaLibros[j] = AuxIzquierda[j];
                }
                for(int j = 0; j < AuxDerecha.length; j++){
                    listaLibros[j + AuxIzquierda.length] = AuxDerecha[j];
                }

                break;
            }
        }
    }


    // ------------------ Métodos de ordenamiento : ------------------
    public void deBurbuja(String atributo) {
        //se ordenana por anioPublicacion:
        for (int i = 0; i < listaLibros.length; i++){
            for (int j = 0; j < listaLibros.length-1; j++){
                if (atributo.equals("anioPublicacion")){
                    if (listaLibros[j].getAnioPublicacion() > listaLibros[j+1].getAnioPublicacion()){
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j+1];
                        listaLibros[j+1] = aux;
                    }
                } else if (atributo.equals("ISBN")){
                    if (listaLibros[j].getISBN() > listaLibros[j+1].getISBN()){
                        Libro aux = listaLibros[j];
                        listaLibros[j] = listaLibros[j+1];
                        listaLibros[j+1] = aux;
                    }
                }
            }
        }
    }



    public int[] porSelección() {
        return new int[0];
    }




    // ------------------ Métodos de búsqueda : ------------------

    public int busquedaOrdenada_String(String valor, String atributo) {
        return 0;
    }

    public int busquedaOrdenada(int array[], int valor){

        //ordenamiento por seleccion
        int aux;
        int indice;
        for (int i = 0; i < array.length; i++){
            indice = i;
            int pequeño = array[i];
            for (int j = i; j < array.length; j++){
                if (array[j] < pequeño){
                    pequeño = array[j];
                    indice = j;
                }
            }
            aux = array[i];
            array[i] = array[indice];
            array[indice] = aux;
        }

        //Busqueda binaria
        int indMayor = array.length-1;
        int ind = 0;
        while(ind<indMayor && valor != array[ind]) {
            ind++;
        }
        if(valor == array[ind]){
            return ind;
        }else{
            return -1;
        }
    }
}
