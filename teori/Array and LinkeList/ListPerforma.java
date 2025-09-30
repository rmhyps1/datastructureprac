package teori.Array and LinkeList;

public class ListPerforma {
    private static final int NUM_ELEMENTS = 100000;
    private static final int NUM_ACESSES = 10000;

    public static void main(String[] args) {
        List<Integer>  arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("- Menguji Performa Penyisipan (Insert at Index 0) -");
        System.out.println("Jumlah elemen: " + NUM_ELEMENTS);

        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            arrayList.add(0, i);
        } 
        long endTime = System.nanoTime();
        long arrayListInsertTime = endTime - startTime;
        System.out.printf("Waktu ArrayList (ms): %.2f\n", arrayListInsertTime / 1000000.0);

        System.out.println("\n - Menguji Performa Akses Acak (Random Access) -");
        System.out.println("Jumlah akses: " + NUM_ACESSES);
        Random random = new Random();

        startTime = System.nanoTime();
        for (int i = 0; i < NUM_ACESSES; i++) {
            arrayList.get(random.nextInt(NUM_ELEMENTS));
        }
        endTime = System.nanoTime();
        long arrayListAccessTime = endTime - startTime;
        System.out.printf("Waktu Akses Acak ArrayList (ms): %.2f\n", arrayListAccessTime / 1000000.0);
    }
}
