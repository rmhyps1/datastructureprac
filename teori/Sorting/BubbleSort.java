package Sorting;

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
}
