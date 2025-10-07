package Hash;

import java.util.HashMap;
import java.util.Map;

public class HashMapT {
    public static void main(String[] args) {
        //Deklarasi dan Inisialisasi HashMap
        //Key: String (NIM), Value: String (Nama)
        Map<String, String> studentMap = new HashMap<>();

        //Menambahkan elemen menggunakan method put()
        System.out.println("--- 1. Menambahkan Elemen (put) ---");
        studentMap.put("1801", "Ani Susanti");
        studentMap.put("1802", "Budi Darmawan");
        studentMap.put("1803", "Citra Dewi");
        studentMap.put("1804", "Deni Pratama");
        System.out.println("HashMap setelah penambahan elemen: " + studentMap);

        //mengambil nilai berdasarkan kunci mengggunakan method get()
        System.out.println("\n--- 2. Mengambil Nilai (get) ---");
        String studentName = studentMap.get("1802");
        System.out.println("Nama mahasiswa dengan NIM 1802: " + studentName);

        //Mengubah Nilai (menimpa) untuk kunci yang sudah ada (put)
        System.out.println("\n--- 3. Mengubah Nilai (put) ---");
        studentMap.put("1803", "Citra Kusuma"); // Mengubah nama untuk NIM 1803
        System.out.println("HashMap setelah mengubah elemen: " + studentMap);

        //menghapus pasangan kunci-nilai menggunakan method remove()
        System.out.println("\n--- 4. Menghapus Elemen (remove) ---");
        studentMap.remove("1804"); 
        System.out.println("HashMap setelah menghapus 1804: " + studentMap);

        //mengecek kunci dan nilai menggunakan method containsKey() dan containsValue()
        System.out.println("\n--- 5. Mengecek Kunci dan Nilai (containsKey, containsValue) ---");
        boolean hasKey = studentMap.containsKey("1801");
        System.out.println("Apakah ada NIM 1801? " + hasKey);

        boolean hasValue = studentMap.containsValue("Budi Darmawan");
        System.out.println("Apakah ada nama 'Budi Darmawan'? " + hasValue);

        //Irerasi (perulangan) melalui HashMap menggunakan entrySet()
        System.out.println("\n--- 6. Iterasi Melalui HashMap (entrySet) ---");
        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + ", Nama: " + entry.getValue());
        }

        //Mendapatkan ukuran HashMap
        System.out.println("\n--- 7. Ukuran");
        System.out.println("Jumlah Mahasiswa saat ini: " + studentMap.size());

        //Membersihkan seluruh isi HashMap
        System.out.println("\n--- 8. Membersihkan HashMap (clear) ---");
        studentMap.clear();
        System.out.println("HashMap setelah clear: " + studentMap);
        
    }
}