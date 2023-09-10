package CONTROL;


import CONTROL.ALGORITMOS.Busqueda;
import CONTROL.ALGORITMOS.Ordenamiento;
import MODELO.Libro;

public class ControlEstanteria<L extends Libro>  {

    private Libro listaLibros[] = new Libro[1] ;

//    public Ordenamiento ordenamiento = new Ordenamiento(this.listaLibros);


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

                listaLibros = new Libro[AuxIzquierda.length + AuxDerecha.length];

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

    public L obtenerUnLibro(int posicion){
        return (L) listaLibros[posicion];
    }

    public void listarLibros(){ // Este listado es para mostrar en consola, no usar, solo pruebas
        for(Libro libro : listaLibros){
            System.out.println(libro.getTitulo());
        }
    }


    public Libro[] getListaLibros() { //obtener libros en modo array de objetos, usar para mostrar en JTable
        return listaLibros;
    }


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


    public int busquedaOrdenada_String(String valor, String atributo) {
        return 0;
    }
}
