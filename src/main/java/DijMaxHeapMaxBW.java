import java.util.LinkedList;
import java.util.Stack;

import static java.lang.Math.min;

public class DijMaxHeapMaxBW {
    private int[] status;
    private int[] bw;
    private MaxHeap fringes;
    private int start;
    private int end;
    private int n;
    private Graph graph;
    private int[] dad;
    private Stack<Integer> path;

    public DijMaxHeapMaxBW(int vertexSize, int start, int end, Graph graph) {
        this.fringes = new MaxHeap(vertexSize);
        this.status = new int[vertexSize];
        this.bw = new int[vertexSize];
        this.dad = new int[vertexSize];
        this.n = vertexSize;
        this.start = start;
        this.end = end;
        this.graph = graph;
        path = new Stack<>();
    }

    // unseen -1, fringe 0, in-tree 1
    public void maxBandWidth() {
        initialize();
        while (fringes.getSize() > 0) {
            int v = fringes.getMax();
            status[v] = 1; //in tree
            LinkedList<VEPair> vNeighbour = graph.getNeighbours(v);
            for (int i = 0; i < vNeighbour.size(); i++) {
                int w = vNeighbour.get(i).getNumber();
                if (status[w] == -1) {
                    status[w] = 0;
                    bw[w] = min(bw[v], vNeighbour.get(i).getEdge());
                    fringes.insert(w,bw[w]);
                    dad[w] = v;
                } else if (status[w] == 0 && bw[w] < min(bw[v], vNeighbour.get(i).getEdge())) {
                    bw[w] = min(bw[v], vNeighbour.get(i).getEdge());
                    dad[w] = v;
                    fringes.delete(w);
                    fringes.insert(w,bw[w]);
                }
            }
        }
    }

    public void initialize(){
        for (int v = 0; v < n; v++) {
            status[v] = -1;
        }
        status[start] = 1;
        LinkedList<VEPair> startNeighbour = graph.getNeighbours(start);
        for (int i = 0; i < startNeighbour.size(); i++) {
            int w = startNeighbour.get(i).getNumber();

            status[w] = 0;

            dad[w] = start;
            bw[w] = startNeighbour.get(i).getEdge();
            fringes.insert(w,bw[w]);
        }

    }

    public Stack<Integer> getPath() {
        int v = end;
        while(v != start){
            path.push(v);
            v = dad[v];
        }
        path.push(start);
        return path;
    }



    public int[] getStatus() {
        return status;
    }

    public int[] getBw() {
        return bw;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getN() {
        return n;
    }

    public int[] getDad() {
        return dad;
    }
}
