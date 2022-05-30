import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class GraphGeneratorTest {
    private LinkedList<Graph> graphList = new LinkedList<Graph>();
    private GraphGenerator graphGenerator;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10; i++) {
            graphList.add(new Graph(10));
        }
        graphGenerator = new GraphGenerator(20,graphList);
    }

    @Test
    void connectByCircle() {
        graphGenerator.connectByCircle();
        for (Graph graph : graphList){
            assertEquals(10,graph.getEdgesAmount());
            for(int i=1;i<9;i++){
                assertEquals(2,graph.getNeighbours(i).size());
                assertEquals(i+1,graph.getNeighbours(i).get(1).getNumber());
                assertEquals(i-1,graph.getNeighbours(i).get(0).getNumber());
                assertEquals(10,graph.getNeighbours(i).get(1).getEdge());
            }
            assertEquals(1,graph.getNeighbours(0).get(0).getNumber());
            assertEquals(9,graph.getNeighbours(0).get(1).getNumber());
            assertEquals(10,graph.getNeighbours(0).get(0).getEdge());
            assertEquals(8,graph.getNeighbours(9).get(0).getNumber());
            assertEquals(0,graph.getNeighbours(9).get(1).getNumber());
        }
    }
    @Test
    void generateG1(){
        graphGenerator.connectByCircle();
        graphGenerator.generateG1(6);
        for (Graph graph: graphList){
            assertEquals(30,graph.getEdgesAmount());
            System.out.println("Just a line break" +
                    "");
            graph.printG();
        }
    }
    @Test
    void generateG2(){
        LinkedList<Graph> graphList1 = new LinkedList<Graph>();
        for (int i = 0; i < 10; i++) {
            graphList1.add(new Graph(100));
        }
        GraphGenerator graphGenerator1 = new GraphGenerator(20,graphList1);
        graphGenerator1.connectByCircle();

        graphGenerator1.generateG2(20,2,1000);

        for(Graph graph: graphList1){
            System.out.println("Just a line break" + "");
            for (int i =0; i< graph.size();i++){
                System.out.print(" " + graph.getNeighbours(i).size()+" ");
            }
        }

    }

}