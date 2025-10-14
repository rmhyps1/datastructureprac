package UTS;

import java.util.*;

public class datadosen implements SortStrategy {

    public void sort(List<String> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j).compareTo(data.get(j + 1)) > 0) {
                    Collections.swap(data, j, j + 1);
                }
            }
        }
    }


    public String getName() {
        return "Bubble Sort";
    }


    public static void main(String[] args) {
        ArrayList<String> dosen = new ArrayList<>();

        System.out.println("Menambahkan data dosen:");
        dosen.add("9203 - Dr. Budi");
        dosen.add("5678 - Dr. Siti");
        dosen.add("3828 - Dr. Andi");
        System.out.println("Data dosen saat ini: " + dosen);

        dosen.set(1, "7898 - Dr. Maia");
        System.out.println("Data dosen setelah update: " + dosen);

        
        SortStrategy sortStrategy = new datadosen();
        sortStrategy.sort(dosen);
        System.out.println("Data dosen setelah diurutkan: " + dosen);
    }
}