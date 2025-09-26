package teori;

import java.util.Stack;

public class StackT {
    public static void main(String[] args) {
        Stack<String> tumpukanBuku = new Stack<>();
        System.out.println("--- Menambahkan Elemen ke Stack (Push) ---");
        tumpukanBuku.push("Buku A");
        tumpukanBuku.push("Buku B");
        tumpukanBuku.push("Buku C");
        System.out.println("Tumpukan saat ini: " + tumpukanBuku);
        System.out.println("\n--- Melihat Elemen Teratas (Peek) ---");
        String bukuTeratas = tumpukanBuku.peek();
        System.out.println("Buku teratas: " + bukuTeratas);
        System.out.println("Tumpukan setelah peek: " + tumpukanBuku);
        System.out.println("\n--- Mengambil dan Menghapus Elemen (Pop) ---");
        String bukuDiambil = tumpukanBuku.pop();
        System.out.println("Buku yang diambil: " + bukuDiambil);
        System.out.println("Tumpukan setelah pop: " + tumpukanBuku);
        System.out.println("Mengambil buku lagi: " + tumpukanBuku.pop());
        System.out.println("Mengambil buku lagi: " + tumpukanBuku.pop());
        System.out.println("Tumpukan setelah semua di-pop: " + tumpukanBuku);
        System.out.println("\n--- Mengecek Status Stack ---");
        boolean isKosong = tumpukanBuku.empty();
        System.out.println("Apakah tumpukan kosong? " + isKosong);
        tumpukanBuku.push("Buku X");
        tumpukanBuku.push("Buku Y");
        tumpukanBuku.push("Buku Z");
        System.out.println("\n--- Mencari Elemen (Search) ---");
        System.out.println("Tumpukan saat ini: " + tumpukanBuku);
        int posisi = tumpukanBuku.search("Buku X");
        System.out.println("Posisi 'Buku X' dari atas: " + posisi);
    }
}
