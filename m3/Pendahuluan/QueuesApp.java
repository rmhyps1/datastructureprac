package Pendahuluan;

class Queues {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queues(int size) {
        this.maxSize = size;
        this.queueArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(long item) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = (int) item;
        nItems++;
    }

    public long remove() {
        long temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queueArray[front];
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


public class QueuesApp {
    public static void main(String[] args) {
        Queues theQueue = new Queues(5);
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        while (!theQueue.isEmpty())  {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");            
        }
        System.out.println("");
    }
}