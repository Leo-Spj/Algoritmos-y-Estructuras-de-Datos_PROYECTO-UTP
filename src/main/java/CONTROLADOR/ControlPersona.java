/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Persona;

/**
 *
 * @author Leo
 */
public class ControlPersona {

    private Persona personas[];
    private int indice = 0;

    public ControlPersona(int n){
        personas = new Persona[n];
    }

    public void agregar(Persona p){
        if(indice == personas.length){
            duplicarLongArreglo();
        }
        personas[indice] = p;
        indice++;
    }

    public void duplicarLongArreglo(){
        Persona aux[] = new Persona[personas.length*2];
        for(int i = 0; i < personas.length; i++){
            aux[i] = personas[i];
        }
        personas = aux;
    }

    public int getIndice(){
        return indice;
    }

    public Persona getPersona(int indice){
        return personas[indice];
    }

    public int[] deBurbuja(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++ ){
                if(array[j+1] < array[j] ){
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        return array;
    }

    // tiempo de compilacion = lexico, semantico y sintatico
    // tiempo de ejecucion = no se detecta en tiempo de compilacion, overflow, underflow, etc

    public int[] porSelección(int[] array){
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
        return array;
    }

    public int busquedaOrdenada(int array[], int valor){

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
