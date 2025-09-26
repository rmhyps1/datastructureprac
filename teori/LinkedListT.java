package teori;

import java.util.LinkedList;

public class LinkedListT {
    public static void main(String[] args) {
        LinkedList<String> studentList = new LinkedList<>();

        System.out.println("--- Menambahkan elemen ---");
        studentList.add("Dina");
        studentList.add("Andi");
        studentList.add("Budi");
        studentList.add("Citra");
        System.out.println("List saat ini: " + studentList);

        studentList.addFirst("Zaki");
        studentList.addLast("Maya");
        System.out.println("List saat ini: " + studentList);

        System.out.println("\n--- Mengakses elemen ---");
        String firstStudent = studentList.getFirst();
        String lastStudent = studentList.getLast();
        System.out.println("Siswa pertama: " + firstStudent);
        System.out.println("Siswa terakhir: " + lastStudent);

        String thirdStudent = studentList.get(2);
        System.out.println("Siswa di indeks 2: " + thirdStudent);

        System.out.println("\n--- Menghapus elemen ---");
        studentList.removeFirst();
        studentList.removeLast();
        studentList.remove("Andi");
        System.out.println("List setelah menghapus Zaki, Maya, dan Andi: " + studentList);

        System.out.println("\n--- Informasi list ---");
        System.out.println("Ukuran List: " + studentList.size());
        System.out.println("Apakah List berisi 'Dina'? " + studentList.contains("Dina"));

        System.out.println("\n--- Menggunakan Sebagai Queue / Stack ---");
        studentList.push("Hana");
        System.out.println("Setelah push Hana: " + studentList);
        studentList.pop();
        System.out.println("List setelah pop: " + studentList);

        studentList.offer("Putri");
        System.out.println("List setelah offer Putri: " + studentList);
        studentList.poll();
        System.out.println("List setelah poll: " + studentList);

        studentList.clear();
        System.out.println("--- Membersihkan List ---");
        System.out.println("List setelah clear: " + studentList);
    

    }

}
