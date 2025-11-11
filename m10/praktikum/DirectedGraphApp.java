package m10.praktikum;

public class DirectedGraphApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();

        theGraph.addVertex('A'); // index 0
        theGraph.addVertex('B'); // index 1
        theGraph.addVertex('C'); // index 2
        theGraph.addVertex('D'); // index 3
        theGraph.addVertex('E'); // index 4

        // Menambah directed edges sesuai Gambar 10.8
        theGraph.addEdge(1, 0); // Edge B -> A
        theGraph.addEdge(0, 2); // Edge A -> C
        theGraph.addEdge(1, 4); // Edge B -> E
        theGraph.addEdge(3, 4); // Edge D -> E
        theGraph.addEdge(4, 2); // Edge E -> C

        // Menampilkan matrix
        theGraph.displayMatrix();
    }
}