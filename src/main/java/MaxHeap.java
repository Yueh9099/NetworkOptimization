public class MaxHeap {
    private int[] heap;
    private int[] dataValue;
    private int[] position;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
        dataValue = new int[maxSize];
        position = new int[maxSize];
    }


    public void insert(int vertex, int weight) {
        heap[size] = vertex;
        dataValue[vertex] = weight;
        position[vertex] = size;


        int current = size;
        while (dataValue[heap[current]] > dataValue[heap[parent(current)]]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int delete(int vertex) {
        int pos = position[vertex];
        if (pos == size -1) {
            size--;
            return heap[pos];
        }
        int temp = heap[pos];
        size--;
        heap[pos] = heap[size];
        position[heap[size]] = pos;

        int current = pos;
        while (dataValue[heap[current]] > dataValue[heap[parent(current)]]) {
            swap(current, parent(current));
            current = parent(current);
        }

        heapify(pos);
        return temp;
    }

    public int getMax() {
        int max = heap[0];
        size--;
        heap[0] = heap[size];
        position[heap[size]] = 0;
        heapify(0);
        return max;
    }

    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return heap;
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos < size) {
            return true;
        }
        return false;
    }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        position[heap[pos2]] = pos1;
        position[temp] = pos2;
        heap[pos2] = temp;
    }

    private void heapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (rightChild(pos)>= size && dataValue[heap[pos]] < dataValue[heap[leftChild(pos)]]){
            swap(pos, leftChild(pos));
            heapify(leftChild(pos));
        }
        if (dataValue[heap[pos]] < dataValue[heap[leftChild(pos)]]
                || dataValue[heap[pos]] < dataValue[heap[rightChild(pos)]]) {

            if (dataValue[heap[leftChild(pos)]]
                    > dataValue[heap[rightChild(pos)]]) {
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }
}
