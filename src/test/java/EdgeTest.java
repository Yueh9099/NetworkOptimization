import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void testEquals() {
        Edge newEdge = new Edge(0, 8);
        assertTrue(newEdge.equals(new Edge(8, 0)));
        assertTrue(newEdge.equals(new Edge(0, 8)));
        assertFalse(newEdge.equals(new Edge(2, 0)));
    }

    void testHash() {
        Edge newEdge = new Edge(0, 8);
        assertTrue(newEdge.equals(new Edge(8, 0)));
        assertTrue(newEdge.equals(new Edge(0, 8)));
        assertFalse(newEdge.equals(new Edge(2, 0)));
        HashSet<Edge> edges = new HashSet<Edge>();
        edges.add(newEdge);
        assertEquals(true, edges.contains(new Edge(8,0)));
        assertFalse(edges.add(new Edge(0,8)));
        assertFalse(edges.add(new Edge(8,0)));
        assertTrue(edges.add(new Edge(2,0)));
    }
}