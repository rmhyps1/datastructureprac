class HighArray {
    private int[] arr;
    private int nElemen;

    public HighArray(int max) {
        arr = new int[max];
        nElemen = 0;
    }

    public void insert(int value) {
        arr[nElemen] = value;
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class ArrayInsert {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);

        arr.insert(15);
        arr.insert(30);
        arr.insert(45);
        arr.insert(53);
        arr.insert(77);
        arr.insert(79);
        arr.insert(81);

        System.out.print("Array sebelum penyisipan: ");
        arr.display();

        arr.insert(66);

        System.out.print("Array setelah penyisipan: ");
        arr.display();
    }
}