package M5.Praktikum;

class Pangkat {

    public long powerRecur(int base, int exp) {
        if (exp == 0) {
            return 1;
        } else {
            return base * powerRecur(base, exp - 1);
        }
    }

    public long powerRecurFast(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp % 2 == 0) {
            return powerRecurFast(base * base, exp / 2);
        } else {
            return base * powerRecurFast(base, exp - 1);
        }
    }
}

public class NomorPangkat {
    public static void main(String[] args) {
        Pangkat p = new Pangkat();

        System.out.println("2^10 = " + p.powerRecurFast(2, 10));
        System.out.println("3^5 = " + p.powerRecurFast(3, 5));
        System.out.println("3^16 = " + p.powerRecurFast(3, 16));
    }
}
