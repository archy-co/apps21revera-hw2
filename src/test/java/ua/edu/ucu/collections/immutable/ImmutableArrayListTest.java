package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add() {
        Object [] numbers1 = {3, 13, 23};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object elem1 = 25;
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.add(elem1);
        assertEquals(25, ialNew1.toArray()[3]);
        assertEquals(23, ialNew1.toArray()[2]);
        assertEquals(4, ialNew1.toArray().length);

        ImmutableArrayList ial2 = new ImmutableArrayList();
        Object elem2 = 7;
        ImmutableArrayList ialNew2 = (ImmutableArrayList) ial2.add(elem2);
        assertEquals(1, ialNew2.toArray().length);
        assertEquals(7, ialNew2.toArray()[0]);

        Object [] numbers3 = {3, 13, 23};
        ImmutableArrayList ial3 = new ImmutableArrayList(numbers3);
        Object elem3 = 25;
        ImmutableArrayList ialNew3 = (ImmutableArrayList) ial3.add(1, elem3);
        assertEquals(25, ialNew3.toArray()[1]);
        assertEquals(3, ialNew3.toArray()[0]);
        assertEquals(13, ialNew3.toArray()[2]);
        assertEquals(4, ialNew3.toArray().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithException1() {
        Object [] numbers1 = {3, 13, 23};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object elem1 = 25;
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.add(-1, elem1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithException2() {
        Object [] numbers1 = {3, 13, 23};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object elem1 = 25;
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.add(11, elem1);
    }

    @Test
    public void addAll() {
        Object [] numbers1 = {1, 4, 5};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object [] otherNumbers1 = {2, 3};
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.addAll(1, otherNumbers1);
        Object [] expectedArr1 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr1, ialNew1.toArray());

        Object [] numbers2 = {1, 2, 3};
        ImmutableArrayList ial2 = new ImmutableArrayList(numbers2);
        Object [] otherNumbers2 = {4, 5};
        ImmutableArrayList ialNew2 = (ImmutableArrayList) ial2.addAll(otherNumbers2);
        Object [] expectedArr2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr2, ialNew2.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAllWithException1() {
        Object [] numbers1 = {1, 4, 5};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object [] otherNumbers1 = {2, 3};
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.addAll(-1, otherNumbers1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAllWithException2() {
        Object [] numbers1 = {1, 4, 5};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object [] otherNumbers1 = {2, 3};
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.addAll(11, otherNumbers1);
    }

    @Test
    public void get() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object got = ial1.get(1);
        assertEquals(2, got);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithException1() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object got = (ImmutableArrayList) ial1.get(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithException2() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        Object got = (ImmutableArrayList) ial1.get(-2);
    }

    @Test
    public void remove() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.remove(2);
        Object [] expectedRes1 = {3, 2};
        assertArrayEquals(expectedRes1, ialNew1.toArray());

        Object [] numbers2 = {3, 2, 7};
        ImmutableArrayList ial2 = new ImmutableArrayList(numbers2);
        ImmutableArrayList ialNew2 = (ImmutableArrayList) ial2.remove(1);
        Object [] expectedRes2 = {3, 7};
        assertArrayEquals(expectedRes2, ialNew2.toArray());

        Object [] numbers3 = {3, 2, 7};
        ImmutableArrayList ial3 = new ImmutableArrayList(numbers3);
        ImmutableArrayList ialNew3 = (ImmutableArrayList) ial3.remove(0);
        Object [] expectedRes3 = {2, 7};
        assertArrayEquals(expectedRes3, ialNew3.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWithException1() {
        Object [] numbers3 = {3, 2, 7};
        ImmutableArrayList ial3 = new ImmutableArrayList(numbers3);
        ImmutableArrayList ialNew3 = (ImmutableArrayList) ial3.remove(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWithException2() {
        Object [] numbers3 = {3, 2, 7};
        ImmutableArrayList ial3 = new ImmutableArrayList(numbers3);
        ImmutableArrayList ialNew3 = (ImmutableArrayList) ial3.remove(31);
    }

    @Test
    public void set() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        ImmutableArrayList ialNew1 = (ImmutableArrayList) ial1.set(1, 3);
        Object [] expectedRes = {3, 3, 7};
        assertArrayEquals(expectedRes, ialNew1.toArray());
    }

    @Test
    public void indexOf() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        int idx1 = ial1.indexOf(3);
        assertEquals(0, idx1);
        int idx2 = ial1.indexOf(7);
        assertEquals(2, idx2);
        int idx3 = ial1.indexOf(4);
        assertEquals(-1, idx3);
    }

    @Test
    public void size() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        assertEquals(3, ial1.size());
    }

    @Test
    public void clear() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        assertEquals(false, ial1.isEmpty());
        ImmutableArrayList ial2 = (ImmutableArrayList) ial1.clear();
        assertEquals(false, ial1.isEmpty());
        assertEquals(true, ial2.isEmpty());

    }

    @Test
    public void isEmpty() {
        Object [] numbers1 = {};
        ImmutableArrayList ial1 = new ImmutableArrayList(numbers1);
        assertEquals(true, ial1.isEmpty());

        ImmutableArrayList ial2 = new ImmutableArrayList();
        assertEquals(true, ial1.isEmpty());
    }
}