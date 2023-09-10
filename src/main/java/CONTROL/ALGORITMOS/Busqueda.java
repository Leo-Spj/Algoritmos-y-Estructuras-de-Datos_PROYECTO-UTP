package CONTROL.ALGORITMOS;

import CONTROL.ControlEstanteria;
import MODELO.Libro;

public class Busqueda extends ControlEstanteria<Libro> {

    // Todas las clases que creemos deben ser "default"


    public static <T extends ControlEstanteria<Libro>> int funSum(int a, int b){
        return a + b;
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

    //busqueda por string abstracta
    //public int busquedaOrdenada_String(String valor, String atributo);

}
