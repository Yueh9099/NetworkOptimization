
import java.util.LinkedList;
import java.util.Stack;

import static java.lang.Math.min;

public class DijOriginMaxBand {
    //unseen is -1
    private int[] status;
    private int[] bw;
    private int start;
    private int end;
    private int n;
    private Graph graph;
    private int[] dad;
    private Stack<Integer> path;

    public DijOriginMaxBand(int vertexSize, int start, int end, Graph graph) {
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
        while (thereAreFringes()) {
            int v = largestFringeBW();
            status[v] = 1; //in tree
            LinkedList<VEPair> vNeighbour = graph.getNeighbours(v);

            for (int i = 0; i < vNeighbour.size(); i++) {
                int w = vNeighbour.get(i).getNumber();
                if (status[w] == -1) {
                    status[w] = 0;
                    bw[w] = min(bw[v], vNeighbour.get(i).getEdge());
                    dad[w] = v;
                } else if (status[w] == 0 && bw[w] < min(bw[v], vNeighbour.get(i).getEdge())) {
                    bw[w] = min(bw[v], vNeighbour.get(i).getEdge());
                    dad[w] = v;
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
            status[w] = 0;// fringe
            dad[w] = start;
            bw[w] = startNeighbour.get(i).getEdge();
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

    private int largestFringeBW() {

        int largestFringeBW = -1;
        boolean first_find = true;
        for (int i = 0; i < n; i++) {
            if (status[i] == 0 && first_find) {
                largestFringeBW = i;
                first_find = false;
            }
            if(status[i] == 0 && bw[i] >= bw[largestFringeBW]){
                largestFringeBW = i;
            }
        }
        return largestFringeBW;
    }

    private boolean thereAreFringes() {
        for (int stat : status) {
            if (stat == 0) {
                return true;
            }
        }
        return false;
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
