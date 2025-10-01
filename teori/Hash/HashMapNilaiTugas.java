package Hash;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;

public class HashMapNilaiTugas {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> nilaiTugasMap = new HashMap<>();
        HashMap<String, ArrayList<Double>> NilaiUTSMap = new HashMap<>();
        HashMap<String, ArrayList<Double>> NilaiUASMap = new HashMap<>();
        HashMap<String, ArrayList<Double>> NilaiMataKuliahMap = new HashMap<>();

        //Tugas
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

        //UTS
        ArrayList<Double> nilaiUTS1 = new ArrayList<>();
        nilaiUTS1.add(80.0);
        NilaiUTSMap.put("1801", nilaiUTS1);
        ArrayList<Double> nilaiUTS2 = new ArrayList<>();
        nilaiUTS2.add(85.0);
        NilaiUTSMap.put("1802", nilaiUTS2);

        //UAS
        ArrayList<Double> nilaiUAS1 = new ArrayList<>();
        nilaiUAS1.add(90.0);
        NilaiUASMap.put("1801", nilaiUAS1);
        ArrayList<Double> nilaiUAS2 = new ArrayList<>();
        nilaiUAS2.add(88.0);
        NilaiUASMap.put("1802", nilaiUAS2);

        //Mata Kuliah
        ArrayList<Double> nilaiMataKuliah1 = new ArrayList<>();
        nilaiMataKuliah1.add(85.0);
        nilaiMataKuliah1.add(80.0);
        nilaiMataKuliah1.add(90.0);
        NilaiMataKuliahMap.put("1801", nilaiMataKuliah1);
        ArrayList<Double> nilaiMataKuliah2 = new ArrayList<>();
        nilaiMataKuliah2.add(88.0);
        nilaiMataKuliah2.add(85.0);
        nilaiMataKuliah2.add(88.0);
        NilaiMataKuliahMap.put("1802", nilaiMataKuliah2);

        // Menampilkan semua data untuk setiap mahasiswa
        System.out.println("=== DATA NILAI MAHASISWA ===\n");
        
        for (String nim: nilaiTugasMap.keySet()) {
            System.out.println("==================");
            System.out.println("NIM: " + nim);
            
            // Nilai Tugas
            ArrayList<Double> nilaiTugas = nilaiTugasMap.get(nim);
            System.out.println("Nilai Tugas: " + nilaiTugas);
            
            //rata rata tugas
            double totalTugas = 0;
            for (double nilai : nilaiTugas) {
                totalTugas += nilai;
            }
            double rataRataTugas = totalTugas / nilaiTugas.size();
            System.out.println("Rata-rata Nilai Tugas: " + String.format("%.2f", rataRataTugas));
            
            //UTS
            ArrayList<Double> nilaiUTS = NilaiUTSMap.get(nim);
            System.out.println("Nilai UTS: " + nilaiUTS);
            
            //UAS
            ArrayList<Double> nilaiUAS = NilaiUASMap.get(nim);
            System.out.println("Nilai UAS: " + nilaiUAS);
            
            //nilai matkul
            ArrayList<Double> nilaiMataKuliah = NilaiMataKuliahMap.get(nim);
            System.out.println("Nilai Mata Kuliah: " + nilaiMataKuliah);
            System.out.println("==================");
            System.out.println();
        }
    }
}
