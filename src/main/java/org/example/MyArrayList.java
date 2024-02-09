package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> implements InterfaceForMyList<E> {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
//        String[] str = new String[10];
//        str[0] = "a";
//        str[1] = "b";
//        str[2] = "c";
//        str[3] = "d";



        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");

        System.out.println("Исходный маcсив:");
        for (String s : myArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("Добавление элемента");
        myArrayList.add("N");
        for (String s : myArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("Добавление элемента по индексу 1");
        myArrayList.add("N", 1);
        for (String s : myArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("Удаление последнего элемента:");
        myArrayList.delete(myArrayList.size()-1);

        for (String s : myArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("Реверс");
        myArrayList = myArrayList.reverse();

        for (String s : myArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();


        System.out.println("Очистка");
        myArrayList.clear();
        System.out.print(myArrayList.size());
    }

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
    public void sort(Comparable<E> comparable) {

    }

    @Override
    public void sort(Comparator<E> comparator) {

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
}
