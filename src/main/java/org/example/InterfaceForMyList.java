package org.example;

import java.util.Comparator;

public interface InterfaceForMyList<E> extends Iterable<E> {
    boolean add(E e);
    boolean add(E e, int index);
    E get(int index);
    void update(int index, E e);
    int size();
    void delete(int index);
    void clear();
    void sort(Comparable<E> comparable);
    void sort(Comparator<E> comparator);
    InterfaceForMyList<E> reverse();
}
