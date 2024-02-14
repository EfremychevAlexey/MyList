package org.example;

import java.util.Comparator;

/**
 * Класс реализации сортировки QuickSort.
 * @param <E>
 */
public class MyQuickSort<E> {

    /**
     * Метод сортировки массива по Компаратору.
     * В качестве параметра метод получает объект,
     * имплементирующий интерфейс Comparator<E>.
     * Сортировка массива производится по алгоритму QuickSort.
     * @param comparator
     */
    public static <E> void sort(MyArrayList<E> myArrayList, Comparator<E> comparator){
        Object[] values = myArrayList.toArray();
        quickSortByComparator(values, 0, values.length - 1, comparator);
    }

    /**
     * Метод реализует алгоритм QuickSort.
     * Принимает в качестве параметров ссылку на массив, который хранит в себе
     * данные, тип которых имплементирует интерфейс Comparable.
     * @param values
     * @param low
     * @param high
     */
    private static <E> void quickSortByComparator(Object[] values, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pi = partitionByComparator(values, low, high, comparator);
            quickSortByComparator(values, low, pi - 1, comparator);
            quickSortByComparator(values, pi + 1, high, comparator);
        }
    }

    /**
     * Метод возвращает индекс элемента, относительно которого
     * произвел смещение элементов массива
     * @param arr
     * @param low
     * @param high
     * @param comparator
     * @param <E>
     * @return
     */
    private static <E> int partitionByComparator(Object[] arr, int low, int high, Comparator<E> comparator) {
        E pivot = (E)arr[high]; // ,
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare((E)arr[j], pivot) < 0) {
                i++;
                E temp = (E)arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        E temp = (E)arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * Метод сортировки массива для типов данных,
     * класс которых имплементирует интерфейс Comparable.
     * Сортировка массива производится по алгоритму QuickSort.
     */
    public static <E extends Comparable> void sort(MyArrayList<E> list) {
        Object[] values = list.toArray();
        quickSortByComparable(values, 0, values.length - 1);
    }

    /**
     * Метод реализует алгоритм QuickSort.
     * Принимает в качестве параметров ссылку на массив, который хранит в себе
     * данные, тип которых имплементирует интерфейс Comparable.
     * @param values
     * @param low
     * @param high
     */
    private static void quickSortByComparable(Object[] values, int low, int high) {
        if (low < high) {
            int pi = partition(values, low, high);
            quickSortByComparable(values, low, pi - 1);
            quickSortByComparable(values, pi + 1, high);
        }
    }

    /**
     * Метод возвращает индекс элемента, относительно которого
     * произвел смещение элементов массива
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static <E> int partition(Object[] arr, int low, int high) {
        Comparable pivot = (Comparable<E>) arr[high]; // ,
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            Comparable<E> jComparable = (Comparable<E>) arr[j];
            if (jComparable.compareTo((E) pivot) < 0) {
                i++;
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
