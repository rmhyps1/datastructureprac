package M5.Praktikum;

class MenaraHanoi {

    public void doMenara(int jumlahPiringan, char asal, char tujuan, char bantu) {
        if (jumlahPiringan == 1) {
            System.out.println("Pindahkan piringan 1 dari " + asal + " ke " + tujuan);
        } else {
            doMenara(jumlahPiringan - 1, asal, bantu, tujuan);

            System.out.println("Pindahkan piringan " + jumlahPiringan + " dari " + asal + " ke " + tujuan);

            doMenara(jumlahPiringan - 1, bantu, tujuan, asal);
        }
    }
}

public class HanoiApp {
    public static void main(String[] args) {
        int n = 5;

        MenaraHanoi h = new MenaraHanoi();

        System.out.println("Permainan Menara Hanoi dengan " + n + " piringan:");
        h.doMenara(n, 'A', 'C', 'B');
    }
}
