package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void add() {
        Object [] numbers1 = {3, 13, 23};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object elem1 = 25;
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.add(elem1);
        assertEquals(25, illNew1.toArray()[3]);
        assertEquals(23, illNew1.toArray()[2]);
        assertEquals(4, illNew1.toArray().length);

        ImmutableLinkedList ill2 = new ImmutableLinkedList();
        Object elem2 = 7;
        ImmutableLinkedList illNew2 = (ImmutableLinkedList) ill2.add(elem2);
        assertEquals(1, illNew2.toArray().length);
        assertEquals(7, illNew2.toArray()[0]);

        Object [] numbers3 = {3, 13, 23};
        ImmutableLinkedList ill3 = new ImmutableLinkedList(numbers3);
        Object elem3 = 25;
        ImmutableLinkedList illNew3 = (ImmutableLinkedList) ill3.add(1, elem3);
        assertEquals(25, illNew3.toArray()[1]);
        assertEquals(3, illNew3.toArray()[0]);
        assertEquals(13, illNew3.toArray()[2]);
        assertEquals(4, illNew3.toArray().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithException1() {
        Object [] numbers1 = {3, 13, 23};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object elem1 = 25;
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.add(-1, elem1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithException2() {
        Object [] numbers1 = {3, 13, 23};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object elem1 = 25;
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.add(11, elem1);
    }

    @Test
    public void addAll() {
        Object [] numbers1 = {1, 4, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object [] otherNumbers1 = {2, 3};
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.addAll(1, otherNumbers1);
        Object [] expectedArr1 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr1, illNew1.toArray());

        Object [] numbers2 = {1, 2, 3};
        ImmutableLinkedList ill2 = new ImmutableLinkedList(numbers2);
        Object [] otherNumbers2 = {4, 5};
        ImmutableLinkedList illNew2 = (ImmutableLinkedList) ill2.addAll(otherNumbers2);
        Object [] expectedArr2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr2, illNew2.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAllWithException1() {
        Object [] numbers1 = {1, 4, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object [] otherNumbers1 = {2, 3};
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.addAll(-1, otherNumbers1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAllWithException2() {
        Object [] numbers1 = {1, 4, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object [] otherNumbers1 = {2, 3};
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.addAll(11, otherNumbers1);
    }

    @Test
    public void get() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object got = ill1.get(1);
        assertEquals(2, got);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithException1() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object got = (ImmutableLinkedList) ill1.get(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithException2() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object got = (ImmutableLinkedList) ill1.get(-2);
    }

    @Test
    public void remove() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.remove(2);
        Object [] expectedRes1 = {3, 2};
        assertArrayEquals(expectedRes1, illNew1.toArray());

        Object [] numbers2 = {3, 2, 7};
        ImmutableLinkedList ill2 = new ImmutableLinkedList(numbers2);
        ImmutableLinkedList illNew2 = (ImmutableLinkedList) ill2.remove(1);
        Object [] expectedRes2 = {3, 7};
        assertArrayEquals(expectedRes2, illNew2.toArray());

        Object [] numbers3 = {3, 2, 7};
        ImmutableLinkedList ill3 = new ImmutableLinkedList(numbers3);
        ImmutableLinkedList illNew3 = (ImmutableLinkedList) ill3.remove(0);
        Object [] expectedRes3 = {2, 7};
        assertArrayEquals(expectedRes3, illNew3.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWithException1() {
        Object [] numbers3 = {3, 2, 7};
        ImmutableLinkedList ill3 = new ImmutableLinkedList(numbers3);
        ImmutableLinkedList illNew3 = (ImmutableLinkedList) ill3.remove(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWithException2() {
        Object [] numbers3 = {3, 2, 7};
        ImmutableLinkedList ill3 = new ImmutableLinkedList(numbers3);
        ImmutableLinkedList illNew3 = (ImmutableLinkedList) ill3.remove(31);
    }

    @Test
    public void set() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        ImmutableLinkedList illNew1 = (ImmutableLinkedList) ill1.set(1, 3);
        Object [] expectedRes = {3, 3, 7};
        assertArrayEquals(expectedRes, illNew1.toArray());
    }

    @Test
    public void indexOf() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        int idx1 = ill1.indexOf(3);
        assertEquals(0, idx1);
        int idx2 = ill1.indexOf(7);
        assertEquals(2, idx2);
        int idx3 = ill1.indexOf(4);
        assertEquals(-1, idx3);
    }

    @Test
    public void size() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        assertEquals(3, ill1.size());
    }

    @Test
    public void clear() {
        Object [] numbers1 = {3, 2, 7};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        assertEquals(false, ill1.isEmpty());
        ImmutableLinkedList ill2 = (ImmutableLinkedList) ill1.clear();
        assertEquals(false, ill1.isEmpty());
        assertEquals(true, ill2.isEmpty());

    }

    @Test
    public void isEmpty() {
        Object [] numbers1 = {};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        assertEquals(true, ill1.isEmpty());

        ImmutableLinkedList ill2 = new ImmutableLinkedList();
        assertEquals(true, ill1.isEmpty());
    }

    @Test
    public void addFirst() {
        Object [] numbers1 = {3, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        ImmutableLinkedList illNew1 = ill1.addFirst(1);
        Object [] expectedRes = {1, 3, 5};
        assertArrayEquals(expectedRes, illNew1.toArray());
    }

    @Test
    public void addLast() {
        Object [] numbers1 = {1, 3};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        ImmutableLinkedList illNew1 = ill1.addLast(5);
        Object [] expectedRes = {1, 3, 5};
        assertArrayEquals(expectedRes, illNew1.toArray());
    }

    @Test
    public void getHead() {
    }

    @Test
    public void getTail() {
    }

    @Test
    public void getFirst() {
        Object [] numbers1 = {1, 3, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object first = ill1.getFirst();
        assertEquals(1, first);
    }

    @Test
    public void getLast() {
        Object [] numbers1 = {1, 3, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        Object last = ill1.getLast();
        assertEquals(5, last);
    }

    @Test
    public void removeFirst() {
        Object [] numbers1 = {1, 3, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        ImmutableLinkedList illNew1 = ill1.removeFirst();
        Object [] expectedRes = {3, 5};
        assertArrayEquals(expectedRes, illNew1.toArray());
    }

    @Test
    public void removeLast() {
        Object [] numbers1 = {1, 3, 5};
        ImmutableLinkedList ill1 = new ImmutableLinkedList(numbers1);
        ImmutableLinkedList illNew1 = ill1.removeLast();
        Object [] expectedRes = {1, 3};
        assertArrayEquals(expectedRes, illNew1.toArray());
    }
}
