package m5.Pendahuluan;

class Faktorial {

    public int factorialIter(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public int factorialRecur(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecur(n - 1);
        }
    }
}

public class FaktorialNumber {
    public static void main(String[] args) {
        int n = 5;

        Faktorial f = new Faktorial();

        System.out.println("Menghitung faktorial dari " + n);
        System.out.println("Versi Iterasi : " + f.factorialIter(n));
        System.out.println("Versi Rekursi : " + f.factorialRecur(n));
    }
}

