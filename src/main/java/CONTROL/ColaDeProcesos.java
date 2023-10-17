package CONTROL;

import MODELO.Persona_2;
import MODELO.Proceso;

public class ColaDeProcesos {

    private Proceso cabeza;
    private Proceso cola;
    private int tamaño = 0; // para saber cuántos procesos hay en la cola
    private int NombreMayor = 0; // solo si el tamaño es 0, el último proceso es 0.
    private boolean continuar = true;


    public int getNombreMayor() {
        return NombreMayor;
    }

    public boolean getContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

    public Proceso getCabeza() {
        return cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void agregarProceso(Proceso proceso) {
        if (cabeza == null) {
            cabeza = proceso;
        } else {
            cola.setSiguiente(proceso);
        }
        cola = proceso;
        tamaño++;
        NombreMayor++;

        proceso.setNombre(NombreMayor);

        System.out.println("Se ha agregado el proceso " + proceso.getNombre() + " con " + proceso.getTiempoRestante() + " segundos restantes");
    }

    public void eliminarProceso() {
        if (cabeza != null) {

            int auxNombre = cabeza.getNombre();
            cabeza = cabeza.getSiguiente();
            tamaño--;

            if (auxNombre == NombreMayor) {
                NombreMayor--;
            }

            if(tamaño==0){
                NombreMayor=0;
                this.cola = null;
                this.cabeza = null;
            }
        }
    }

    public void moverAlFinal() {
        if (cabeza != null) {
            cola.setSiguiente(cabeza);
            cabeza = cabeza.getSiguiente();
            cola = cola.getSiguiente();
            cola.setSiguiente(null); // null para que no apunte a nada el último proceso
        }
    }

    public void procesar(int segundosMaxProcesando) {
        if (cabeza != null) {

            int tiempoProcesar;
            if (cabeza.getTiempoRestante() <= segundosMaxProcesando) {
                tiempoProcesar = cabeza.getTiempoRestante();
                cabeza.setTiempoRestante(0);
            } else {
                tiempoProcesar = segundosMaxProcesando;
                cabeza.setTiempoRestante(cabeza.getTiempoRestante() - segundosMaxProcesando);
            }


            if (cabeza.getTiempoRestante() <= 0) {

                try {
                    Thread.sleep(tiempoProcesar * 1000);
                    if (cabeza != null){
                        //System.out.println("El proceso " + cabeza.getNombre() + " ha terminado");
                    } else {
                        //System.out.println("No hay procesos en la cola");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                eliminarProceso();
            } else {

                try {
                    Thread.sleep(tiempoProcesar * 1000);
                    if(cabeza != null) {
                        //System.out.println("Proceso " + cabeza.getNombre() + " movido al final, le quedan " + cabeza.getTiempoRestante() + " segundos");
                    } else {
                        //System.out.println("No hay procesos en la cola");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moverAlFinal();
            }
        } else {
            //System.out.println("No hay procesos en la cola");
        }
    }


    //devolviendo en un arreglo los objetos de la cola en el metodo imprimir
    public Proceso[] imprimir() {
        Proceso[] procesos = new Proceso[tamaño];
        Proceso aux = cabeza;
        for (int i = 0; i < tamaño; i++) {
            procesos[i] = aux;
            aux = aux.getSiguiente();
        }
        return procesos;
    }

    // funcion para apagar o prender el procesado mediante parametro booleano
    public void switchProcesado( int segundos){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {

                do {
                    if (cabeza != null) {
                        procesar(segundos); // dentro de "procesar" hago un sleep segun segundos ingresados
                        //System.out.println(imprimir());
                    } else {
                        //System.out.print("");
                    }

                } while (continuar);

            }
        });
        hilo.start();


        do {
            if (cabeza != null) {
                procesar(segundos); // dentro de "procesar" hago un sleep segun segundos ingresados
                System.out.println(imprimir());
            } else {
                System.out.print("");
            }

        } while (continuar);

    }



}
