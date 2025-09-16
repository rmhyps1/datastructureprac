package Praktikum;

import java.util.Scanner;

class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;
    }

    public void push(long item) {
        stackArray[++top] = (int) item;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

class Pembalik {
    private String input;
    private String output;

    public Pembalik(String in) {
        this.input = in;
    }

    public String balikkata() {
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        output = "";
        while (!theStack.isEmpty()) {
            char ch = (char) theStack.pop();
            output = output + ch;
        }
        return output;
    }
}

public class AppPembalik {
     public static void main(String[] args) {

        String kata = "kasur";
        Pembalik pembalikKata = new Pembalik(kata);

        String hasil = pembalikKata.balikkata();

        System.out.println(">> katanyaa..... ");
        System.out.println("         " + kata);
        System.out.println(">> dibalik jadi ");
        System.out.println("         " + hasil);


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan sebuah kata: ");
        String input = scanner.nextLine();

        Pembalik pembalik = new Pembalik(input);
        String output = pembalik.balikkata();

        System.out.println("Kata setelah dibalik: " + output);
        scanner.close();
     }
}
