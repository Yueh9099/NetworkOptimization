import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private int size;
    private LinkedList<VEPair>[] vertices;
    private HashSet<Edge> edges;
    private int edgesAmount;

    public Graph(int size) {
        edges = new HashSet<>();
        this.size = size;
        this.vertices = new LinkedList[size];
        for (int i = 0; i<size;i++){
            vertices[i] = new LinkedList<VEPair>();
        }
    }

    // connect the vertex i to the vertex j with weighted edge
    public boolean setEdge(int i, int j, int weight) {
        if(i == j){
            return false;
        }
        if(!edges.add(new Edge(i,j))){

            return false;
        }
        VEPair vePairI = new VEPair(i, weight);
        VEPair vePairJ = new VEPair(j, weight);
        vertices[i].add(vePairJ);
        vertices[j].add(vePairI);
        edgesAmount++;
        return true;
    }
    // just for test
    public HashSet<Edge> getEdges(){
        return edges;
    }

    public int size(){
        return this.size;
    }

    public void printG(){
        for (int i = 0; i< vertices.length; i++){
            System.out.print(i + "|");
            for (VEPair vePair: vertices[i]){
                System.out.print("--> (" + vePair.getNumber()+":" +vePair.getEdge() + ")");
            }
            System.out.println();
        }
    }
    public LinkedList<VEPair> getNeighbours(int i){
        return vertices[i];
    }

    public int getEdgesAmount() {
        return edgesAmount;
    }
}
