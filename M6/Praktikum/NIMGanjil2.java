class Mahasiswa {
    String nim;
    String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }
}

public class NIMGanjil2 {

    // =============== MERGE SORT (berdasarkan NIM) ===============
    public static void mergeSortByNIM(Mahasiswa[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortByNIM(arr, left, mid);
            mergeSortByNIM(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(Mahasiswa[] arr, int left, int mid, int right) {
        Mahasiswa[] temp = new Mahasiswa[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].nim.compareTo(arr[j].nim) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // =============== SHELL SORT (berdasarkan NAMA) ===============
    public static void shellSortByNama(Mahasiswa[] arr) {
        int n = arr.length;
        int h = 1;
        while (h <= n / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int out = h; out < n; out++) {
                Mahasiswa temp = arr[out];
                int in = out;
                while (in >= h && arr[in - h].nama.compareToIgnoreCase(temp.nama) > 0) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    // =============== QUICK SORT (berdasarkan NIM) ===============
    public static void quickSortByNIM(Mahasiswa[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSortByNIM(arr, left, pivotIndex - 1);
            quickSortByNIM(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(Mahasiswa[] arr, int left, int right) {
        String pivot = arr[right].nim;
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j].nim.compareTo(pivot) < 0) {
                i++;
                Mahasiswa temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Mahasiswa temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    // =============== TAMPIL DATA ===============
    public static void tampil(Mahasiswa[] arr) {
        for (Mahasiswa m : arr) {
            System.out.println(m.nim + " - " + m.nama);
        }
    }

    // =============== MAIN ===============
    public static void main(String[] args) {
        Mahasiswa[] data = {
            new Mahasiswa("230501", "Andi"),
            new Mahasiswa("230509", "Budi"),
            new Mahasiswa("230503", "Citra"),
            new Mahasiswa("230507", "Dewi"),
            new Mahasiswa("230505", "Eka")
        };

        System.out.println("Data Asli:");
        tampil(data);

        System.out.println("\nSetelah diurutkan berdasarkan NIM (Merge Sort):");
        mergeSortByNIM(data, 0, data.length - 1);
        tampil(data);

        System.out.println("\nSetelah diurutkan berdasarkan Nama (Shell Sort):");
        shellSortByNama(data);
        tampil(data);

        System.out.println("\nSetelah diurutkan berdasarkan NIM (Quick Sort):");
        quickSortByNIM(data, 0, data.length - 1);
        tampil(data);
    }
}
