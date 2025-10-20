class ArrayNIM {
    private long nim;
    private String nama;

    public ArrayNIM(long nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public void displayNim() {
        System.out.println("NIM: " + nim + ", Nama: " + nama);
    }

    public long getNim() {
        return nim;
    }
}

public class StoringObject {
    private ArrayNIM[] arr;
    private int nElemen;

    public StoringObject(int maxSize) {
        arr = new ArrayNIM[maxSize];
        nElemen = 0;
    }

    public void insert(long nim, String nama) {
        arr[nElemen] = new ArrayNIM(nim, nama);
        nElemen++;
    }

    public void bubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i].getNim() > arr[i + 1].getNim()) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < nElemen; i++) {
            ArrayNIM key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getNim() > key.getNim()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private void swap(int one, int two) {
        ArrayNIM temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            arr[i].displayNim();
        }
    }
}
