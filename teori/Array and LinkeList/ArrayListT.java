
package teori;

import java.util.ArrayList;

public class ArrayListT {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        System.out.println("--- Menambahkan elemen ke ArrayList ---");
        fruits.add("Apel");
        fruits.add("Jeruk");
        fruits.add("Mangga");
        System.out.println("ArrayList saat ini: " + fruits);

        fruits.add(1, "Semangka");
        System.out.println("ArrayList setelah menambahkan 'Semangka' di indeks 1: " + fruits);

        System.out.println("\n--- Mengakses elemen ---");
        String firstFruit = fruits.get(0);
        System.out.println("Buah pertama: " + firstFruit);

        fruits.set(2, "Anggur");
        System.out.println("ArrayList setelah mengubah indeks 2 menjadi 'Anggur': " + fruits);

        fruits.remove("Jeruk");
        System.out.println("--- Menghapus elemen ---");
        System.out.println("ArrayList setelah menghapus 'Jeruk': " + fruits);
        fruits.remove(0);
        System.out.println("ArrayList setelah menghapus elemen di indeks 0: " + fruits);

        int size = fruits.size();
        System.out.println("\n--- Informasi tambahan ---");
        System.out.println("Jumlah elemen dalam ArrayList: " + size);

        boolean isEmpty = fruits.isEmpty();
        System.out.println("Apakah ArrayList kosong? " + isEmpty);

        fruits.clear();
        System.out.println("ArrayList setelah dibersihkan: " + fruits);
        System.out.println("Jumlah elemen setelah dibersihkan: " + fruits.size());
    }
}
