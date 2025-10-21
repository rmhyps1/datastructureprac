class ShellSortApp {
    private int[] arr;
    private int nElemen;

    public ShellSortApp(int size) {
        arr = new int[size];
        nElemen = 0;
    }

    public void insert(int value) {
        arr[nElemen] = value;
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void ShellSort() {
        int in, out, temp;
        int h = 1;
        while (h <= nElemen / 3) {
            h = 3 * h + 1;  
        }

        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;
                while (in >= h && arr[in - h] > temp) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = temp;
                display(); 
            }
            h = (h - 1) / 3;  
        }
    }

    public static void main(String[] args) {
        ShellSortApp data = new ShellSortApp(8);

        data.insert(23);
        data.insert(12);
        data.insert(1);
        data.insert(8);
        data.insert(34);
        data.insert(54);
        data.insert(2);
        data.insert(3);

        System.out.println("Array sebelum diurutkan:");
        data.display();

        System.out.println("\nProses Shell Sort:");
        data.ShellSort();

        System.out.println("\nArray setelah diurutkan:");
        data.display();
    }
}

