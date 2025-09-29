package M5.Pendahuluan;

class Triangular {

    public int triangleIter(int n) {
        int result = 0;
        for (int i = n; i > 0; i--) {
            result += i;
        }
        return result;
    }

    public int triangleRecur(int n) {
//        return n + triangleRecur(n - 1);
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

        Triangular t = new Triangular();

        System.out.println("Menghitung bilangan segitiga dari " + n);
        System.out.println("Versi Iterasi : " + t.triangleIter(n));
        System.out.println("Versi Rekursi : " + t.triangleRecur(n));
    }
}
