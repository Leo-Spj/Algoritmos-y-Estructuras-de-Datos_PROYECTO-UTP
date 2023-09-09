package CONTROL;


import CONTROL.ALGORITMOS.Busqueda;
import CONTROL.ALGORITMOS.Ordenamiento;
import MODELO.Libro;

public class Estanteria <L extends Libro> implements Ordenamiento, Busqueda {

    private Libro listaLibros[];

    public Estanteria(int cantidadLibros){
        listaLibros = new Libro[cantidadLibros];
    }


    public void agregarLibro(L libro){
        for(int i = 0; i < listaLibros.length; i++){
            if(listaLibros[i] == null){
                listaLibros[i] = libro;
                break;
            }
        }
    }

    public void removerLibro(L libro){
        for(int i = 0; i < listaLibros.length; i++){
            if(listaLibros[i] == libro){
                listaLibros[i] = null;
                break;
            }
        }
    }

    public void listarLibros(){
        for(Libro libro : listaLibros){
            if(libro != null){
                System.out.println(libro.getTitulo());
            }
        }
    }

}
