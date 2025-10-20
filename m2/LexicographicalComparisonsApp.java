public class LexicographicalComparisonsApp {
    public static void main(String[] args) {
        int maxSize = 20;
        LexicographicalComparisons arr = new LexicographicalComparisons(maxSize);

        arr.insert(16650270, "Agung", "Madiun");
        arr.insert(16650230, "Sofi", "Semarang");
        arr.insert(16650280, "Arina", "Malang");
        arr.insert(16650260, "Helmi", "Madura");
        arr.insert(16650220, "Ismail", "Banyuwangi");
        arr.insert(16650240, "Dinda", "Bandung");
        arr.insert(16650250, "Rais", "Ambon");
        arr.insert(16650200, "Jundi", "Malang");
        arr.insert(16650210, "Ahmad", "Sidoarjo");

        System.out.println("Data mahasiswa sebelum disorting:");
        arr.display();

        System.out.println("Data mahasiswa setelah disorting NIM:");
        arr.selectionSortByNIM();
        arr.display();

        System.out.println("Data mahasiswa setelah disorting Nama:");
        arr.selectionSortByNama();
        arr.display();

    }
}
