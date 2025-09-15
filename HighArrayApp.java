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
    
    public void insertionSort() {
        int i, curIn;
        int tahap = 0;
        for (curIn = 1; curIn < nElemen; curIn++) {
            int temp = arr[curIn];
            i = curIn;
            boolean shifted = false;
            while (i > 0 && arr[i - 1] >= temp) {
                arr[i] = arr[i - 1];
                shifted = true;
                if (tahap < 4) {
                    System.out.print("Setelah pergeseran pada tahap ke-" + (curIn) + ": ");
                    display();
                }
                i--;
            }
            arr[i] = temp;
            if (tahap < 4) {
                System.out.print("Setelah penyisipan pada tahap ke-" + (curIn) + ": ");
                display();
            }
            tahap++;
        }
    }
}

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);

        System.out.print("Array sebelum diurutkan: ");
        arr.display();

        arr.insertionSort();

        System.out.print("Array setelah diurutkan: ");
        arr.display();
    }
}