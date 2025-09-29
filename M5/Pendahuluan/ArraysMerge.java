package M5.Pendahuluan;

class Arrays {
    private int arr[];
    private int nElemen;

    public Arrays(int size) {
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

    public void mergeSort() {
        int[] workspace = new int[nElemen];
        recMergeSort(workspace, 0, nElemen - 1);
    }

    public void recMergeSort(int[] workspace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workspace, lowerBound, mid);
            recMergeSort(workspace, mid + 1, upperBound);
            merge(workspace, lowerBound, mid + 1, upperBound);
        }
    }

    public void merge(int [] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex;
        int mid = highIndex - 1;
        int nItem = upperBound - lowerBound + 1;

        while (lowIndex <= mid && highIndex <= upperBound) {
            if ( arr[lowIndex] < arr[highIndex] ) {
                workSpace[j++] = arr[lowIndex++];
            } else {
                workSpace[j++] = arr[highIndex++];
            }
        }

        while (lowIndex <= mid) {
            workSpace[j++] = arr[lowIndex++];
        }

        while (highIndex <= upperBound) {
            workSpace[j++] = arr[highIndex++];
        }

        for (j = 0; j < nItem; j++) {
            arr[lowerBound + j] = workSpace[j];
        }
    }
}

public class ArraysMerge {
    public static void main(String[] args) {
        Arrays arr = new Arrays(10);

        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);

        System.out.print("Data sebelum diurutkan : ");
        arr.display();

        System.out.print("Melakukan pengurutan dengan metode Merge Sort");
        arr.mergeSort();

        System.out.print("\nData setelah diurutkan : ");
        arr.display();
    }
}