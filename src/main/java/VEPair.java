//The VEPairs are used to store vertice and edges in adjacency list for undirected graph
public class VEPair {
    private int number;
    private int edge;
    public VEPair(int number, int edge){
        this.number = number;
        this.edge = edge;
    }

    public int getNumber() {
        return number;
    }

    public int getEdge() {
        return edge;
    }
}
