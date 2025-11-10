class HashNode {
    int key;
    String value;
    
    public HashNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ": " + value + ")";
    }
}

class HashTable {
    
    private final int TABLE_SIZE = 11; 
    private final int C = 7; 
    
    private HashNode[] table; 
    
    private final HashNode DELETED = new HashNode(-1, "DELETED"); 

    public HashTable() {
        table = new HashNode[TABLE_SIZE];
    }
    
    private int hashFunc1(int key) {
        return key % TABLE_SIZE;
    }
 
    private int hashFunc2(int key) {
        return C - (key % C);
    }
    
    private int hashProbing(int key, int i) {
        int h1 = hashFunc1(key);
        int h2 = hashFunc2(key);
        return (h1 + i * h2) % TABLE_SIZE;
    }

    public void insert(int key, String value) {
        int i = 0; 
        int index;

        while (i < TABLE_SIZE) {
            index = hashProbing(key, i);
            
            if (table[index] == null || table[index] == DELETED) {
                // Membuat objek HashNode baru
                table[index] = new HashNode(key, value); 
                System.out.printf("  [Insert] Kunci %d dimasukkan di index %d (Upaya ke-%d)\n", key, index, i);
                return;
            }
                       
            if (table[index].key == key) {
                table[index].value = value;
                System.out.printf("  [Update] Kunci %d di index %d diperbarui.\n", key, index);
                return;
            }

            i++;
        }
        System.out.printf("  [Insert GAGAL] Kunci %d: Tabel penuh atau probing gagal.\n", key);
    }

    public String search(int key) {
        int i = 0;
        int index;

        while (i < TABLE_SIZE) {
            index = hashProbing(key, i);
                                
            if (table[index] == null) {
                return null; 
            }
                           
            if (table[index] != DELETED && table[index].key == key) {
                return table[index].value;
            }

            i++;
        }
        return null;
    }
    
    public void delete(int key) {
        int i = 0;
        int index;

        while (i < TABLE_SIZE) {
            index = hashProbing(key, i);

            if (table[index] == null) {
                System.out.printf("  [Delete] Kunci %d tidak ditemukan.\n", key);
                return;
            }
            
            if (table[index] != DELETED && table[index].key == key) {
                table[index] = DELETED; 
                System.out.printf("  [Delete] Kunci %d berhasil dihapus di index %d.\n", key, index);
                return;
            }

            i++;
        }
        System.out.printf("  [Delete] Kunci %d tidak ditemukan.\n", key);
    }

    public void display() {
        System.out.println("\n--- TAMPILAN HASH TABLE (Ukuran: " + TABLE_SIZE + ") ---");
        for (int i = 0; i < TABLE_SIZE; i++) {
            String status;
            if (table[i] == null) {
                status = "NULL";
            } else if (table[i] == DELETED) {
                status = "DELETED";
            } else {
                status = table[i].toString();
            }
            System.out.printf("Index %-3d: %s\n", i, status);
        }
        System.out.println("----------------------------------------------");
    }
}

public class MainApp {
    public static void main(String[] args) {
        System.out.println("NIM Ganjil - Double Hashing Implementation");
        System.out.println("=========================================");
        
        HashTable myHashTable = new HashTable(); 

        System.out.println("\n[A] OPERASI INSERT:");
        myHashTable.insert(33, "Apel"); 
        myHashTable.insert(22, "Pisang"); 
        myHashTable.insert(1, "Ceri"); 
        myHashTable.insert(12, "Durian"); 
        myHashTable.insert(4, "Anggur"); 
        
        myHashTable.display();
        
        System.out.println("\n[B] ANALISIS KOLISI:");
        System.out.println("  - Kunci 33 -> hash(33) = 0. Masuk index 0.");
        System.out.println("  - Kunci 22 -> hash(22) = 0. Kolisi! h2(22) = 6. Cek index (0 + 1*6) % 11 = 6. Masuk index 6.");
        System.out.println("  - Kunci 1  -> hash(1)  = 1. Masuk index 1.");
        System.out.println("  - Kunci 12 -> hash(12) = 1. Kolisi! h2(12) = 2. Cek index (1 + 1*2) % 11 = 3. Masuk index 3.");
        System.out.println("  - Kunci 4  -> hash(4)  = 4. Masuk index 4.");


        System.out.println("\n[C] OPERASI SEARCH:");
        System.out.println("  Search 33 (Apel): " + myHashTable.search(33));
        System.out.println("  Search 22 (Pisang): " + myHashTable.search(22));
        System.out.println("  Search 12 (Durian): " + myHashTable.search(12));
        System.out.println("  Search 99 (Tidak Ada): " + myHashTable.search(99));
        
        System.out.println("\n[D] OPERASI DELETE:");
        myHashTable.delete(33);
        myHashTable.delete(12);
        myHashTable.delete(99);

        myHashTable.display();
    }
}