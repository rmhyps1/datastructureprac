class HashTable {
    private int[] table;
    private int size;
    private int prime;   
    private int count;    

    public HashTable(int s) {
        size = s;
        table = new int[size];
        prime = 5;
        count = 0;
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    private int hashFunc1(int key) {
        return key % size;
    }

    private int hashFunc2(int key) {
        return prime - (key % prime);
    }

    public void insert(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (table[hashVal] != -1) {
            hashVal += stepSize;
            hashVal %= size;
        }
        table[hashVal] = key;
        count++;
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int i = 0; i < size; i++) {
            if (table[i] != -1) {
                System.out.println(i + ": " + table[i]);
            } else {
                System.out.println(i + ": ");
            }
        }
    }
}

public class DoubleHashingApp {
    public static void main(String[] args) {
        HashTable table = new HashTable(15);
        int[] items = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16, 55};
        for (int item : items) {
            table.insert(item);
        }
        table.displayTable();
    }
}
