package m8.pendahuluan;

class Data {
    private int data;
    
    public Data(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }
}

class HashTable {
    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < size; j++) {
            if (hashArray[j] != null) {
                System.out.println(" | " + j + "\t | " + hashArray[j].getKey());
            }
        }
        System.out.println(" ");
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int data) {
        Data item= new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            hashVal++;
            hashVal %= size;
        }
        hashArray[hashVal] = item;
    }

    public Data delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }

    public Data find (int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }
}

public class HashTable2 {
    public static void main(String[] args) {
        HashTable table = new HashTable(15);
        int[] items = {12, 25, 36, 20, 30, 5, 7, 8, 19, 29};
        for (int i : items) {
            table.insert(i);
        }
        System.out.println("Sebelum penambahan (10 item):");
        table.displayTable();

        int[] menambahkan = {11, 3, 16, 23, 14};
        System.out.println("Menambahkan 5 item baru dan menampilkan posisinya:");
        for (int i : menambahkan) {
            table.insert(i);
            System.out.println("Key " + i + " ditaruh di index " + table.hashFunc(i));
        }

        System.out.println("\nSetelah penambahan (total 15 item):");
        table.displayTable();
    }
    
}
