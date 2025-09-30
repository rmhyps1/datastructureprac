package Praktikum;

class Barang {
    int id;
    String nama;

    public Barang(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "{" + id + ", " + nama + "}";
    }
}

class StackNode {
    Barang data;
    StackNode next;

    public StackNode(Barang data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    private StackNode top;

    public StackLinkedList() {
        this.top = null;
    }

    public void push(Barang item) {
        StackNode newNode = new StackNode(item);
        newNode.next = top;
        top = newNode;
    }

    public Barang pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong, gak bisa pop!");
            return null;
        }
        Barang popped = top.data;
        top = top.next;
        return popped;
    }

    public Barang peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void display() {
        System.out.println("Stack(top-- > bottom):");
        if (isEmpty()) {
            System.out.println("(kosong)");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
}

public class StackAppLinkedList {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();


        stack.push(new Barang(2, "TV"));
        stack.push(new Barang(1, "VCD"));
        stack.display();


        stack.push(new Barang(6, "dispenser"));
        stack.push(new Barang(5, "rice cooker"));
        stack.push(new Barang(4, "PC"));
        stack.push(new Barang(3, "kulkas"));
        stack.display();

        stack.pop();
        stack.display();
    }
}
