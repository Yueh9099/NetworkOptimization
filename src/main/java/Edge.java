public class Edge {
    private int vertex1;
    private int vertex2;

    public Edge(int vertex1, int vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public int getVertex1() {
        return vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Edge)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Edge edgeObj = (Edge) obj;
        if (edgeObj.getVertex1() == vertex1 && edgeObj.getVertex2() == vertex2) {
            return true;
        }
        if (edgeObj.getVertex1() == vertex2 && edgeObj.getVertex2() == vertex1) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (vertex1 < vertex2){
            return vertex1*31 + vertex2;
        }
        return this.vertex2*31 + vertex1;
    }






}
