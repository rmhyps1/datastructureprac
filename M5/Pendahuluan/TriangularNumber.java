class Triangular {

    public int triangleIter(int n) {
        int result = 0;
        for (int i = n; i > 0; i--) {
            result += i;
        }
        return result;
    }

    public int triangleRecur(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangleRecur(n - 1);
        }
    }
}

public class TriangularNumber {
    public static void main(String[] args) {
        int n = 5;
        Triangular triangle = new Triangular();
        
        System.out.println("Menghitung bilangan segitiga dari " + n);
        System.out.println("Versi Iterasi : " + triangle.triangleIter(n));
        System.out.println("Versi Rekursi : " + triangle.triangleRecur(n));
    }
}
