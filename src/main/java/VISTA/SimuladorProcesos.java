package VISTA;

import CONTROL.ColaDeProcesos;
import MODELO.Proceso;

public class SimuladorProcesos {

        public static void main(String[] args) {


            ColaDeProcesos simulacion = new ColaDeProcesos();

            // modelo de hilo
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {

                    simulacion.switchProcesado( 2); // mi metodo para encender el procesador

                }
            });


            // SIMULACIONES:

            Thread hilo1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        simulacion.agregarProceso(new Proceso((int) (Math.random() * 5) + 1));
                        //System.out.println(simulacion.imprimir());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            // en este hilo pruebo la insercion de procesos durante la marcha, para ver si se insertan bien
            Thread hilo2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        for (int i = 0; i < 2; i++) {

                            try {
                                Thread.sleep(4000); // cada 4 segundos inserto un proceso

                                simulacion.agregarProceso(new Proceso((int) (Math.random() * 6) + 1));
                                //System.out.println("Se ha agregado un proceso");
                                //System.out.println(simulacion.imprimir());

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });


            // en este hilo pruebo la insercion de procesos despues que todos los procesos anteriores hayan terminado
            Thread hilo3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(35000); // en 35 segundos incerto 2 procesos mas
                        for (int i = 0; i < 2; i++) {

                            try {
                                Thread.sleep(500);

                                simulacion.agregarProceso(new Proceso((int) (Math.random() * 10) + 1));
                                //System.out.println("Se ha agregado un proceso");
                                //System.out.println(simulacion.imprimir());

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            hilo.start();
            hilo1.start();
            hilo2.start();
            hilo3.start();

        }
}
