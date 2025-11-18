package m10.praktikum;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> theStack;
    private Queue theQueue; 
    private char sortedArray[];

    public Graph() {
        theStack = new Stack<>();
        theQueue = new Queue(MAX_VERTS); 
        sortedArray = new char[MAX_VERTS];
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
        adjMat[start][end] = 1;
    }

    public void display() {
        System.out.println("Adjacency: ");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] == 1) {
                    System.out.println(vertexList[row].label + " --> " + vertexList[col].label);
                }
            }
        }
        System.out.println();
    }

    public void displayMatrix() {
        display();
    }

    public void dfs() {
        System.out.println("Connectivity Table:");
        for (int s = 0; s < nVerts; s++) {
  
            for (int k = 0; k < nVerts; k++) {
                vertexList[k].wasVisited = false;
            }

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

    public void topo() {
        int orig_nVerts = nVerts;
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.print("\nTopologically sorted order: ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println(); 
    }

    private int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }

    public void deleteVertex(int delVertex) {
        if (delVertex != nVerts - 1) {
            for (int j = delVertex; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }
            for (int row = delVertex; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }
            for (int col = delVertex; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }
    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

}
