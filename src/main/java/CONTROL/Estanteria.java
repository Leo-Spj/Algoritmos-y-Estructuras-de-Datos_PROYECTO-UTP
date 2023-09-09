package CONTROL;


import CONTROL.ALGORITMOS.Busqueda;
import CONTROL.ALGORITMOS.Ordenamiento;
import MODELO.Libro;

public class Estanteria <L extends Libro> implements Ordenamiento, Busqueda {

    private Libro listaLibros[];

    public Estanteria(){
        listaLibros = new Libro[1];
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

    public void listarLibros(){
        for(Libro libro : listaLibros){
            System.out.println(libro.getTitulo());
        }
    }

    @Override
    public void deBurbuja() {
        //se ordenana por anioPublicacion:
        for (int i = 0; i < listaLibros.length; i++){
            for (int j = 0; j < listaLibros.length-1; j++){
                if (listaLibros[j].getAnioPublicacion() > listaLibros[j+1].getAnioPublicacion()){
                    Libro aux = listaLibros[j];
                    listaLibros[j] = listaLibros[j+1];
                    listaLibros[j+1] = aux;
                }
            }
        }
    }


    @Override
    public int[] porSelección() {
        return new int[0];
    }
}
