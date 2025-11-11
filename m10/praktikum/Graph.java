package m10.praktikum;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> theStack;
    private Queue theQueue; // ditambahkan

    public Graph() {
        theStack = new Stack<>();
        theQueue = new Queue(MAX_VERTS); // inisialisasi queue
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        // directed edge: start -> end
        adjMat[start][end] = 1;
    }

    public void display() {
        System.out.println("Adjency: ");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] == 1) {
                    System.out.println(vertexList[row].label + " --> " + vertexList[col].label);
                }
            }
        }
        System.out.println();
    }

    // print adjacency matrix (labels + matrix) and then connectivity table
    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("  ");
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + " ");
        }
        System.out.println();
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // juga tampilkan adjacency list/edges (opsional sesuai contoh)
        display();

        // tampilkan connectivity table
        System.out.println("Connectivity Table:");
        for (int s = 0; s < nVerts; s++) {
            // reset flags
            for (int k = 0; k < nVerts; k++) {
                vertexList[k].wasVisited = false;
            }
            // perform DFS starting at s, record visitation order (excluding start)
            ArrayList<Character> reachable = new ArrayList<>();
            vertexList[s].wasVisited = true;
            theStack.clear();
            theStack.push(s);
            while (!theStack.isEmpty()) {
                int v = getAdjUnvisitedVertex(theStack.peek());
                if (v == -1) {
                    theStack.pop();
                } else {
                    vertexList[v].wasVisited = true;
                    reachable.add(vertexList[v].label);
                    theStack.push(v);
                }
            }
            // print row: startLabel [reachable...]
            System.out.print(vertexList[s].label);
            if (!reachable.isEmpty()) {
                System.out.print(" ");
                for (int i = 0; i < reachable.size(); i++) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(reachable.get(i));
                }
            }
            System.out.println();
        }

        // reset flags after done
        resetFlags();
    }

    public void dfs() {
        System.out.println("Visit by using" + " DFS algorithm: ");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        System.out.println("");
        resetFlags();
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs() {
        System.out.println("Visit by using" + " BFS algorithm: ");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        System.out.println("");
        resetFlags();
    }

    public void mst() {
        System.out.println("Minimum spanning" +
                " tree: ");
        vertexList[0].wasVisited = true;
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                System.out.print(" -- ");
                displayVertex(v);
                System.out.println("");
            }
        }
        resetFlags();
    }

}
