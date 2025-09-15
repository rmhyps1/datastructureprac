public class StoringObjectApp {
    public static void main(String[] args) {
        int maxSize = 20;
        StoringObject arr = new StoringObject(maxSize);

        arr.insert(110125, "Yasir");
        arr.insert(110123, "Hanif");
        arr.display();
        arr.bubbleSort();
        //arr.insertionSort();
        System.out.println("Setelah diurutkan:");
        arr.display();
    }
}