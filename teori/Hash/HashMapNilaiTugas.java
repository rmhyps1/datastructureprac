import java.util.ArrayList;
import java.util.HashMap;

public class HashMapNilaiTugas {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> nilaiTugasMap = new HashMap<>();

        ArrayList<Double> nilaiTugas1 = new ArrayList<>();
        nilaiTugas1.add(85.0);
        nilaiTugas1.add(90.0);
        nilaiTugas1.add(78.0);
        nilaiTugasMap.put("1801", nilaiTugas1);

        ArrayList<Double> nilaiTugas2 = new ArrayList<>();
        nilaiTugas2.add(88.0);
        nilaiTugas2.add(92.0);
        nilaiTugas2.add(80.0);
        nilaiTugasMap.put("1802", nilaiTugas2);

        for (String nim: nilaiTugasMap.keySet()) {
            System.out.println("NIM: " + nim);
            System.out.println("Nilai Tugas: " + nilaiTugasMap.get(nim));
            System.out.println();
        }
    }
}
