package teori.Sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort implements SortStrategy {
    @Override
    public void sort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    Collections.swap(data, j, j + 1);
                }
            }
        }
    }
    @Override
    public String getName() {
        return "Bubble Sort";
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(50, 10, 90, 30, 70, 40));
        
        SortStrategy sort = new BubbleSort();
        long startTime = System.nanoTime();
        sort.sort(data);
        long endTime = System.nanoTime();

        System.out.println("----------------------------------------");
        System.out.println("Menggunakan Algoritma: " + sort.getName());
        System.out.println("Data awal: [50, 10, 90, 30, 70, 40]");
        System.out.println("Data terurut: " + data);
        System.out.println("Waktu Eksekusi: " + (endTime - startTime) + " ns");
        System.out.println("----------------------------------------");
    }
}
