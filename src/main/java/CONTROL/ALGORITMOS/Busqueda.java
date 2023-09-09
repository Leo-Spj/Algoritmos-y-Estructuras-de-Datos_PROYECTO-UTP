package CONTROL.ALGORITMOS;

public interface Busqueda {

    // Todas las clases que creemos deben ser "default"

    default public int busquedaOrdenada(int array[], int valor){

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
