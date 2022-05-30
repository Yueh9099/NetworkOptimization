// With a graph list where graphs have empty edges, use this GraphGenerator
// to connect vertices in each graph

import java.util.LinkedList;
import java.util.Random;

public class GraphGenerator {
    private LinkedList<Graph> graphList;
    private int size;
    private int maxEdgeWeight;

    public GraphGenerator(int maxEdgeWeight, LinkedList<Graph> graphList) {
        this.size = graphList.size();
        this.graphList = graphList;
        this.maxEdgeWeight = maxEdgeWeight;
    }

    public void generateG1(int averageDegree) {
        for (Graph graph : graphList) {
            while (graph.getEdgesAmount() != (averageDegree * graph.size() / 2)) {
                Random rand = new Random();
                int vertex1 = rand.nextInt(graph.size());
                int vertex2 = rand.nextInt(graph.size());
                int weight = rand.nextInt(maxEdgeWeight) + 1;
                graph.setEdge(vertex1, vertex2, weight);
            }
        }

    }

    public void generateG2(int neighbourBase, int neighbourVar, int maxEdgeAmount) {
        Random rand = new Random();
        for (Graph graph : graphList) {
            int[] neighbourAmount = new int[graph.size()];
            for (int i = 0; i < graph.size(); i++){
                neighbourAmount[i] = rand.nextInt(neighbourVar) + neighbourBase;
            }

            while(graph.getEdgesAmount() <maxEdgeAmount){
                int vertexI = rand.nextInt(graph.size());
                int vertexJ = rand.nextInt(graph.size());
                if(graph.getNeighbours(vertexI).size()>neighbourBase + neighbourVar){
                    continue;
                }
                if(graph.getNeighbours(vertexJ).size()>neighbourBase + neighbourVar){
                    continue;
                }
                int weight = rand.nextInt(maxEdgeWeight) + 1;
                graph.setEdge(vertexI, vertexJ, weight);

            }
        }
    }

    public void connectByCircle() {
        for (Graph graph : graphList) {
            for (int i = 0; i < graph.size() - 1; i++) {
                graph.setEdge(i, i + 1, maxEdgeWeight / 2);

            }
            graph.setEdge(0, graph.size() - 1, maxEdgeWeight / 2);
        }

    }
}
