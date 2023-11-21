package APF3.P1;

import MODELO.CLASIFICACION.Novela;
import MODELO.Libro;

public class Recursividad {

    private int suma = 0;

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String obtainTwoAttributes(Libro[] novelas, int index) {

        String cadena = "";

        if (index >= novelas.length) {
            return cadena;

        } else {

            Novela novela = (Novela) novelas[index];

            cadena += novela.getTitulo() + "\t" + novela.getAnioPublicacion() + "\n";

            cadena += obtainTwoAttributes(novelas, index + 1);

            suma += novela.getAnioPublicacion();
        }
        return cadena;
    }
}
