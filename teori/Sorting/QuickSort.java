package teori.Sorting;

import java.util.Collections;
import java.util.List;

public class QuickSort implements SortStrategy {
    @Override
    public void sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    //metode rekursif utama
    private void quickSort(List<Integer> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    //metode partisi (memilih elemen terakhir sebagai pivot)
    private int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                Collections.swap(data, i, j);
            }
        }
        Collections.swap(data, i + 1, high);
        return i + 1;
    }
}