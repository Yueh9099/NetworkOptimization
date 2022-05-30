import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    MaxHeap maxHeapTest = new MaxHeap(20);

    @Test
    void testHeapInsertGetMax(){
        assertEquals(0, maxHeapTest.getSize());
        maxHeapTest.insert(9,14);
        maxHeapTest.insert(5, 23);
        maxHeapTest.insert(3,44);
        maxHeapTest.insert(0,33);
        maxHeapTest.insert(1,84);
        maxHeapTest.insert(16,321);
        maxHeapTest.insert(8,32);
        maxHeapTest.insert(12,911);
        System.out.println(Arrays.toString(maxHeapTest.getHeap()));
        assertEquals(8,maxHeapTest.getSize());
        assertEquals(12,maxHeapTest.getMax());
        System.out.println(Arrays.toString(maxHeapTest.getHeap()));
        assertEquals(16,maxHeapTest.getMax());
        assertEquals(1,maxHeapTest.getMax());
        assertEquals(3,maxHeapTest.getMax());
        assertEquals(0,maxHeapTest.getMax());
        assertEquals(8,maxHeapTest.getMax());
        assertEquals(5,maxHeapTest.getMax());
        assertEquals(9,maxHeapTest.getMax());
        assertEquals(0,maxHeapTest.getSize());
    }

    @Test
    void testDeletion(){
        maxHeapTest.insert(9,14);
        maxHeapTest.insert(5, 23);
        maxHeapTest.insert(3,44);
        maxHeapTest.insert(0,33);
        maxHeapTest.insert(1,84);
        maxHeapTest.insert(16,321);
        maxHeapTest.insert(8,32);
        maxHeapTest.insert(12,911);
        System.out.println(Arrays.toString(maxHeapTest.getHeap()));
        assertEquals(12, maxHeapTest.delete(12));
        assertEquals(7, maxHeapTest.getSize());
        System.out.println(Arrays.toString(maxHeapTest.getHeap()));
        maxHeapTest.insert(17,38);
        assertEquals(3, maxHeapTest.delete(3));
        System.out.println(Arrays.toString(maxHeapTest.getHeap()));
    }


}