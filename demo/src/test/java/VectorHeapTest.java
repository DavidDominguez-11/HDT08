import com.example.VectorHeap;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class VectorHeapTest {
    private VectorHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
        heap.add(10);
        heap.add(30);
        heap.add(20);
        heap.add(5);
        heap.add(15);
    }

    @Test
    public void testAdd() {
        assertEquals(5, heap.size());
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testGetMax() {
        assertEquals(30, (int) heap.getMax());
        assertEquals(20, (int) heap.getMax());
        assertEquals(15, (int) heap.getMax());
        assertEquals(10, (int) heap.getMax());
        assertEquals(5, (int) heap.getMax());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testRemove() {
        assertEquals(30, (int) heap.remove());
        assertEquals(20, (int) heap.remove());
        assertEquals(15, (int) heap.remove());
        assertEquals(10, (int) heap.remove());
        assertEquals(5, (int) heap.remove());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testClear() {
        assertFalse(heap.isEmpty());
        heap.clear();
        assertTrue(heap.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFirstWhenEmpty() {
        heap.clear();
        heap.getFirst();
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveWhenEmpty() {
        heap.clear();
        heap.remove();
    }
}
