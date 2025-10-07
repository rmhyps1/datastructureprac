package M6.Praktikum;

import java.util.*;

class Mahasiswa {
    String nama;
    String nim;

    Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String toString() {
        return String.format("%s (%s)", nama, nim);
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

    public static void mergeByNIM(Mahasiswa[] arr, int left, int mid, int right) {
        Mahasiswa[] temp = new Mahasiswa[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].nim.compareTo(arr[j].nim) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left, k = 0; i <= right; i++, k++) arr[i] = temp[k];
    }

    public static void shellSortNama(Mahasiswa[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Mahasiswa temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap].nama.compareTo(temp.nama) > 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void quickSortNIM(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortNIM(arr, low, pivotIndex - 1);
            quickSortNIM(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(Mahasiswa[] arr, int low, int high) {
        Mahasiswa pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].nim.compareTo(pivot.nim) <= 0) {
                i++;
                Mahasiswa temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Mahasiswa temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(Mahasiswa[] arr) {
        for (Mahasiswa m : arr) {
            System.out.println(m);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Mahasiswa[] data = {
            new Mahasiswa("Hanif", "240605110123"),
            new Mahasiswa("Budi", "240605110010"),
            new Mahasiswa("Sinta", "240605110045"),
            new Mahasiswa("Andi", "240605110003"),
            new Mahasiswa("Putra", "240605110020")
        };

        System.out.println("=== Data Sebelum Sorting ===");
        printArray(data);

        Mahasiswa[] mergeSorted = data.clone();
        mergeSortNIM(mergeSorted, 0, mergeSorted.length - 1);
        System.out.println("=== Setelah Merge Sort (berdasarkan NIM) ===");
        printArray(mergeSorted);

        Mahasiswa[] shellSorted = data.clone();
        shellSortNama(shellSorted);
        System.out.println("=== Setelah Shell Sort (berdasarkan Nama) ===");
        printArray(shellSorted);

        Mahasiswa[] quickSorted = data.clone();
        quickSortNIM(quickSorted, 0, quickSorted.length - 1);
        System.out.println("=== Setelah Quick Sort (berdasarkan NIM) ===");
        printArray(quickSorted);
    }
}