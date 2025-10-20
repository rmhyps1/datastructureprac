class Mahasiswa {
    private long nim;
    private String Nama;
    private String Asal;

    public Mahasiswa(long nim, String Nama, String Asal) {
        this.nim = nim;
        this.Nama = Nama;
        this.Asal = Asal;
    }

    public long getNim() {
        return nim;
    }

    public String getNama() {
        return Nama;
    }

    public void display() {
        System.out.println("NIM: " + nim  + ", Nama: " + Nama + ", Asal: " + Asal);
    }
}

public class LexicographicalComparisons {
    private Mahasiswa[] arr;
    private int nElemen;

    public LexicographicalComparisons(int maxSize) {
        arr = new Mahasiswa[maxSize];
        nElemen = 0;
    }

    public void insert(long nim, String Nama, String Asal) {
        arr[nElemen] = new Mahasiswa(nim, Nama, Asal);
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            arr[i].display();
        }
        System.out.println();
    }

    private void swap(int idx1, int idx2) {
        Mahasiswa temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void selectionSortByNIM() {
        int minIndex;
        for (int i = 0; i < nElemen - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (arr[j].getNim() < arr[minIndex].getNim()) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    public void selectionSortByNama() {
        int minIndex;
        for (int i = 0; i < nElemen - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (arr[j].getNama().compareTo(arr[minIndex].getNama()) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
}