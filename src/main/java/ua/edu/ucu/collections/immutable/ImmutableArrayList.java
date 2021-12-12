package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object [] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public ImmutableArrayList() {
        elements = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        Object [] arrCopy = new Object[this.elements.length+1];
        for (int i = 0; i < this.elements.length; i++) {
            arrCopy[i] = this.elements[i];
        }
        arrCopy[this.elements.length] = e;
        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object [] arrCopy = new Object[elements.length+1];
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int j = 0;
        for (; i <= elements.length; i++) {
            if (i == index) {
                arrCopy[i] = e;
            } else {
                arrCopy[i] = this.elements[j];
                j++;
            }
        }
        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object [] arrCopy = new Object[elements.length + c.length];
        int i = 0;
        for (; i < elements.length; i++) {
            arrCopy[i] = elements[i];
        }
        for (; i < elements.length + c.length; i++){
            arrCopy[i] = c[i-elements.length];
        }
        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object [] arrCopy = new Object[elements.length + c.length];
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int j = 0;
        boolean inserted = false;
        for (; i < elements.length; i++) {
            if (i == index) {
                for (; j < c.length; j++) {
                    arrCopy[i+j] = c[j];
                }
                inserted = true;
            }
            else {
                if (inserted){
                    arrCopy[i+j-1] = elements[i-1];
                }
                arrCopy[i+j] = elements[i];
            }
        }

        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException();
        }
        Object elem = elements[index];
        return elem;
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException();
        }
        Object [] arrCopy = new Object[elements.length-1];

        int j = 0;
        for (int i = 0; i < elements.length; i++, j++) {
            if (i == index) {
                j--;
                continue;
            }
            arrCopy[j] = elements[i];
        }

        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException();
        }
        Object [] arrCopy = new Object[elements.length];

        for (int i = 0; i < elements.length; i++) {
            if (i == index) {
                arrCopy[i] = e;
            }
            else {
                arrCopy[i] = elements[i];
            }
        }

        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        Object [] arrCopy = new Object[0];

        ImmutableArrayList newIAL = new ImmutableArrayList(arrCopy);
        return newIAL;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object [] arrCopy = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arrCopy[i] = elements[i];
        }
        return arrCopy;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Object elem : elements) {
            res.append(elem);
            res.append(" ");
        }
        return res.toString();
    }
}
