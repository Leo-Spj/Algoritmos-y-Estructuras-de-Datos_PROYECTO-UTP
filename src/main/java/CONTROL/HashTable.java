package CONTROL;

import MODELO.CLASIFICACION.Novela;

public class HashTable {
    private int size;
    private Novela[] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new Novela[size];
    }

    public int hashFunction(String key) {
        // Método de multiplicación para la función de hash
        double A = 0.618;  // Constante de multiplicación (0 < A < 1)
        double hashValue = key.hashCode() * A;
        return (int) (size * (hashValue - Math.floor(hashValue)));
    }

    private int hashFunctionForAttribute(String attribute) {
        // Método de multiplicación para la función de hash específica para atributos
        double A = 0.618;  // Constante de multiplicación (0 < A < 1)
        double hashValue = attribute.hashCode() * A;
        return (int) (size * (hashValue - Math.floor(hashValue)));
    }

    public void insert(Novela novela) {
        for (String attributeName : novela.getAttributeNames()) {
            String key = novela.getAttributeValue(attributeName);
            int index = hashFunctionForAttribute(key);

            while (table[index] != null) {
                // Manejo de colisiones mediante sondaje lineal
                index = (index + 1) % size;
            }

            table[index] = novela;
        }
    }

    public Novela search(String attributeName, String key) {
        int index = hashFunctionForAttribute(key);

        while (table[index] != null) {
            if (table[index].getAttributeValue(attributeName).equals(key)) {
                return table[index];
            }
            // Manejo de colisiones durante la búsqueda mediante sondaje lineal
            index = (index + 1) % size;
        }

        return null;  // La novela no se encuentra en la tabla hash
    }

    public Novela[] getAllData() {
        return table;
    }
}
