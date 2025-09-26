package Praktikum;

class Queue {
    private String[] data;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.maxSize = size;
        this.data = new String[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
        for (int i = 0; i < maxSize; i++) {
            data[i] = "";
        }
    }

    public void insert(String nama) {
        if (isFull()) {
            System.out.println("Maaf " + nama + ", antrian masih penuh");
        } else {
            rear = (rear + 1) % maxSize;
            data[rear] = nama;
            nItems++;
            System.out.println(nama + " masuk antrian");
        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong");
        } else {
            String keluar = data[front];
            data[front] = "Kosong";
            front = (front + 1) % maxSize;
            nItems--;
            System.out.println(keluar + " keluar dari antrian");
        }
    }

    public void tampil() {
        System.out.println("" );
        for (int i = 0; i < maxSize; i++) {
            if (!data[i].equals("")) {
                System.out.print(data[i] + " ");
            }
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}

public class AppQueue {
    public static void main(String[] args) {
        System.out.println(">> Beberapa mulai mengantri");

    Queue antrian = new Queue(4);
    antrian.insert("Andi");
    antrian.insert("Ahmad");
    antrian.insert("Satrio");
    antrian.insert("Afrizal");
    antrian.insert("Sukran");
    antrian.insert("Mahmud");

        System.out.print("\n>> isi antrian");
        antrian.tampil();

        System.out.println("\n>> satu persatu keluar antrian");
        while (!antrian.isEmpty()) {
            antrian.remove();
            antrian.tampil();
        }

        System.out.println("antrian kosong");
        System.out.println(antrian.size() + " Person");
    }
    
}
