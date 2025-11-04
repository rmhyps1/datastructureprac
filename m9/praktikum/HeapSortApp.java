package m9.praktikum;

import java.util.Random;

class Node {
    private int data;

    public Node(int key) {
        data = key;
    }

    public int getKey() {
        return data;
    }

    public void setKey(int id) {
        data = id;
    }
}

class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].getKey() > bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        trickleDown(index, currentSize);
    }
    
    public void trickleDown(int index, int size) {
        int smallerChild;
        Node top = heapArray[index];
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < size && heapArray[leftChild].getKey() > heapArray[rightChild].getKey()) {
                smallerChild = rightChild;
            } else {
                smallerChild = leftChild;
            }

            if (top.getKey() <= heapArray[smallerChild].getKey()) {
                break;
            }

            heapArray[index] = heapArray[smallerChild];
            index = smallerChild;
        }
        heapArray[index] = top;
    }

    public boolean insertAt(int index, int key) {
        if (index < 0 || index >= maxSize) {
            return false;
        }
        heapArray[index] = new Node(key);
        if (index >= currentSize) {
            currentSize = index + 1;
        }
        return true;
    }

    public void displayHeap() {
        System.out.print("Heap array: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println("");
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(" ");
                }
            }

            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    public void HeapSort() {
        int n = currentSize;
        for (int i = n / 2 - 1; i >= 0; i--) {
            trickleDown(i, n);
        }


        for (int i = n - 1; i >= 0; i--) {
            Node max = remove(); 
            heapArray[i] = max;
        }
        currentSize = n;
    }
}

public class HeapSortApp {
    public static void main(String[] args) {
        Heap heap = new Heap(35);

        Random rnd = new Random();

        int inserts = 10; 
        for (int i = 0; i < inserts; i++) {
            int value = rnd.nextInt(100);
            heap.insertAt(i, value);
        }

        System.out.println("Heap Sort sebelum sorting:");
        heap.displayHeap();

        heap.HeapSort();

        System.out.println("\nHeap Sort setelah sorting:");
        heap.displayHeap();
    }
}
