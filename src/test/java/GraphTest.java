import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private final Graph graph = new Graph(10);

    @Test
    void emptyEdge() {
//        System.out.println("Print the empty graph:");
        for (int i = 0; i < graph.size(); i++) {
            assertEquals(0, graph.getNeighbours(i).size());
        }
//        graph.printG();
    }

    @Test
    void setEdge() {
//        System.out.println("Add an edge and print");
        int vertex1 = 0;
        int vertex2 = 8;
        int weight = 20;
        graph.setEdge(vertex1, vertex2, weight);
//        assertTrue(graph.setEdge(vertex1, vertex2, weight));
        assertEquals(1,graph.getEdgesAmount());

        HashSet<Edge> edges = graph.getEdges();
        assertTrue(edges.contains(new Edge(0,8)));

        assertEquals(weight, graph.getNeighbours(vertex1).get(0).getEdge());
        assertEquals(weight, graph.getNeighbours(vertex2).get(0).getEdge());
        assertEquals(1, graph.getNeighbours(vertex1).size());
        assertEquals(1, graph.getNeighbours(vertex2).size());

        for (int i = 0; i < graph.size(); i++) {
            if (i != vertex1 && i != vertex2) {
                assertEquals(0, graph.getNeighbours(i).size());
            }
        }
        assertFalse(graph.setEdge(vertex1, vertex2, weight));
        assertFalse(graph.setEdge(vertex2, vertex1, 15));
        assertEquals(1, graph.getNeighbours(0).size());
        assertEquals(1, graph.getNeighbours(8).size());
        assertEquals(1,graph.getEdgesAmount());
        assertTrue(graph.setEdge(2,6,15));
        assertEquals(2,graph.getEdgesAmount());
        assertFalse(graph.setEdge(6,2,10));
        assertFalse(graph.setEdge(2,6,12));
        assertEquals(2,graph.getEdgesAmount());
        assertTrue(graph.setEdge(3,6,15));
        assertEquals(3,graph.getEdgesAmount());
        assertFalse(graph.setEdge(3,6,12));
        assertEquals(2, graph.getNeighbours(6).size());

        assertEquals(3,graph.getEdgesAmount());
        assertTrue(graph.setEdge(3,4,20));
        assertEquals(4,graph.getEdgesAmount());
        assertFalse(graph.setEdge(4, 4, weight));
        assertFalse(graph.setEdge(3, 3, weight));
        assertFalse(graph.setEdge(0, 0, weight));
        assertEquals(2, graph.getNeighbours(3).size());
        assertEquals(1, graph.getNeighbours(4).size());
//        graph.printG();
    }

    @Test
    void size() {
        assertEquals(10, graph.size());

    }

}