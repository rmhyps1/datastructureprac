package M6.Praktikum;

import java.util.*;

class Mahasiswa {
    String nim;
    String nama;
    
    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String toString() {
        return nim + " - " + nama;
    }

}

public class NIMGanjil {
        public static void mergeSortNIM(Mahasiswa[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortNIM(arr, left, mid);
            mergeSortNIM(arr, mid + 1, right);
            mergeByNIM(arr, left, mid, right);
        }
    }

    private static void mergeByNIM(Mahasiswa[] arr, int left, int mid, int right) {
        Mahasiswa[] temp = new Mahasiswa[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].getNim().compareTo(arr[j].getNim()) <= 0) {
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

    public static void shellSortNama(Mahasiswa[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Mahasiswa temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap].getNama().compareTo(temp.getNama()) > 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void quickSortNIM(Mahasiswa[] arr, int left, int right) {
        if (left >= right) return;

        String pivot = arr[right].getNim();
        int partition = partition(arr, left, right, pivot);

        quickSortNIM(arr, left, partition - 1);
        quickSortNIM(arr, partition + 1, right);
    }

    private static int partition(Mahasiswa[] arr, int left, int right, String pivot) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j].getNim().compareTo(pivot) < 0) {
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

    public static void main(String[] args) {
        Mahasiswa[] data = {
            new Mahasiswa("240605110123", "Hanif"),
            new Mahasiswa("240605110024", "Zainab"),
            new Mahasiswa("240605110035", "Salim"),
            new Mahasiswa("240605110135", "Ali"),
            new Mahasiswa("240605110251", "Salah")
        };

        System.out.println("Data Asli:");
        tampil(data);

        Mahasiswa[] mergeData = Arrays.copyOf(data, data.length);
        mergeSortNIM(mergeData, 0, mergeData.length - 1);
        System.out.println("\nHasil Merge Sort (berdasarkan NIM):");
        tampil(mergeData);

        Mahasiswa[] shellData = Arrays.copyOf(data, data.length);
        shellSortNama(shellData);
        System.out.println("\nHasil Shell Sort (berdasarkan Nama):");
        tampil(shellData);

        Mahasiswa[] quickData = Arrays.copyOf(data, data.length);
        quickSortNIM(quickData, 0, quickData.length - 1);
        System.out.println("\nHasil Quick Sort (berdasarkan NIM):");
        tampil(quickData);
    }

    public static void tampil(Mahasiswa[] arr) {
        for (Mahasiswa m : arr) {
            System.out.println(m);
        }
    }
}
