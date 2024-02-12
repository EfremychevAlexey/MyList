package org.example;

import java.util.Comparator;

public interface MyListInterface<E> extends Iterable<E> {
    boolean add(E e);
    boolean add(E e, int index);
    E get(int index);
    void update(int index, E e);
    int size();
    void delete(int index);
    void clear();
    void trimToSize();
    void sort();
    void sort(Comparator<E> comparator);
    void reverse();
}
