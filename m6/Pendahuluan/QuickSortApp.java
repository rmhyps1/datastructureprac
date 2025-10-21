public class QuickSortApp {
    private int[] arr;
    private int nElemen;

    public QuickSortApp(int size) {
        arr = new int[size];
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

    public void QuickSort() {
        recQuickSort(0, nElemen - 1);
    }

    public void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
            return;
        } else {
            int pivot = arr[batasKanan];
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    public int partitionIt(int batasKiri, int batasKanan, int pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;

        while (true) {
            while (indexKiri < batasKanan && arr[++indexKiri] < pivot);
            while (indexKanan > batasKiri && arr[--indexKanan] > pivot);

            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }

        swap(indexKiri, batasKanan);
        return indexKiri;
    }

    public void swap(int satu, int dua) {
        int temp = arr[satu];
        arr[satu] = arr[dua];
        arr[dua] = temp;
    }

    public static void main(String[] args) {
        QuickSortApp data = new QuickSortApp(8);

        int[] angka = {23, 12, 1, 8, 34, 54, 2, 3};
        for (int a : angka) {
            data.insert(a);
        }

        System.out.println("Data sebelum diurutkan:");
        data.display();

        data.QuickSort();

        System.out.println("Data sesudah diurutkan (Quick Sort):");
        data.display();
    }
}
