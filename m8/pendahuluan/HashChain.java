package m8.pendahuluan;

class Link {
    public int iData;
    public Link next;

    public Link(int id) {
        iData = id;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.println(iData + " ");
    }
}

class SortedLinkList {
    private Link first;

    public SortedLinkList() {
        first = null;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = theLink;
        } else {
            previous.next = theLink;
        }
        theLink.next = current;
    }

    public void delete (int key) {
        Link previous = null;
        Link current = first;
        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link find (int key) {
        Link current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void DislplayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class HashTable {
    private SortedLinkList[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new SortedLinkList[size];
        for (int j = 0; j < size; j++) {
            hashArray[j] = new SortedLinkList();
        }
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < size; j++) {
            System.out.print(" " + j + ". ");
            hashArray[j].DisplayList();
        }
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int data) {
        Link theLink = new Link(data);
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find (int key) {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}

public class HashChain {
    public static void main(String[] args) {
        HashTable table = new HashTable(15);
        int[] items = {12, 25, 36, 20, 30, 5, 7, 8, 19, 29, 11, 3, 16, 23, 14};
        for (int j : items) {
            table.insert(j);
        }
        table.displayTable();
    }
    
}
