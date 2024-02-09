package org.example;

import java.util.*;

public class MyArrayList<E> implements MyListInterface<E> {
    private E[] values;

    MyArrayList() {
        values = (E[]) new Object[0];
    }

    MyArrayList(E[] values) {
        this.values = values;
    }

    @Override
    public boolean add(E e) {
        try {
            E[]  tempArray = values;
            values = (E[]) new Object[values.length + 1];
            System.arraycopy(tempArray, 0, values, 0, tempArray.length);
            values[values.length - 1] = e;
            return true;
        } catch(ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(E e, int index) {
        try {
            E[] tempArray = values;
            values = (E[]) new Object[values.length + 1];
            System.arraycopy(tempArray, 0, values, 0, index);
            values[index] = e;
            System.arraycopy(tempArray, index, values, index + 1,
                    tempArray.length - index);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void delete(int index) {
        try {
            E[] tempArray = values;
            values = (E[]) new Object[values.length - 1];
            System.arraycopy(tempArray, 0, values, 0, index);
            System.arraycopy(tempArray, index + 1, values, index,
                    tempArray.length - index - 1);
        } catch(ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void clear() {

        try {
            values = (E[]) new Object[0];
        } catch(ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public MyArrayList<E> reverse() {
        for(int i = 0; i < values.length / 2; i++)
        {
            E temp = values[i];
            values[i] = values[values.length - i - 1];
            values[values.length - i - 1] = temp;
        }
        return new MyArrayList<E>(values);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<>(values);
    }

    @Override
    public void sort(Comparator<E> comparator) {
        Arrays.sort(values, comparator); // сортируем его с пом компаратора
    }

    @Override
    public void sort() {
        if (this instanceof Comparable) {
            quickSort(0, values.length - 1);
        }
        else {
            E[] tempArray = (E[]) new Object();
            System.arraycopy(values, 0, tempArray, 0,
                    values.length);
            //values = MyQuickSort.quicksort(tempArray);
        }

    }

    private void quickSort(E[] values) {
    }


    private <E extends Comparable> void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(values, low, high);
            quickSort(values, low, pi - 1);
            quickSort(values, pi + 1, high);
        }
    }

    private <E extends Comparable> int partition(E[] arr, int low, int high) {
        E pivot = arr[high]; // ,
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) == -1) {
                i++;


                E temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        E temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }
}
