package Praktikum;

class Mahasiswa {
    String nim;
    String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nim + " " + nama;
    }
}

class Node {
    Mahasiswa data;
    Node next;

    public Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }
}

class QueueLinkedList {
    private Node front;
    private Node rear;
    private int nItems;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
        this.nItems = 0;
    }

    public void insert(Mahasiswa mhs) {
        Node newNode = new Node(mhs);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        nItems++;
    }

    public Mahasiswa remove() {
        if (isEmpty()) {
            System.out.println("Queue kosong, gak bisa remove!");
            return null;
        }
        Mahasiswa temp = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void display() {
        System.out.println("Queue (front-->rear):");
        if (isEmpty()) {
            System.out.println("(kosong)");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
}

public class QueueAppLinkedList {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.insert(new Mahasiswa("1665100", "Dee"));
        queue.insert(new Mahasiswa("1665200", "Deaja"));
        queue.display();

        queue.insert(new Mahasiswa("1665300", "Ami"));
        queue.insert(new Mahasiswa("1665400", "Haya"));
        queue.insert(new Mahasiswa("1665500", "Yati"));
        queue.display();

        queue.remove();
        queue.remove();
        queue.display();
    }
}
