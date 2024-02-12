package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class MyListIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] values;

    public MyListIterator(E[] values, int arraySize) {
        this.values = Arrays.copyOf(values, arraySize);
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }


}
