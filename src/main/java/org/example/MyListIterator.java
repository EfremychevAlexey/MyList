package org.example;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Параметризованный класс для получения итератора из заданного массива
 * и заданного размера.
 * Имплементирует интерфейс Iterator.
 * @param <E>
 * @author efremychev_a
 * @version 1.0
 */
public class MyListIterator<E> implements Iterator<E> {

    /**
     * Поле идетнификатор счетчика элементов.
     */
    private int index = 0;

    /**
     * Поле идентификатор массива элементов.
     */
    private E[] values;

    /**
     * Конструктор инициализирует нужный масссив заданного размера
     * Копирует в него все требуемые элементы.
     * @param values
     * @param arraySize
     */
    public MyListIterator(E[] values, int arraySize) {
        this.values = Arrays.copyOf(values, arraySize);
    }

    /**
     * Возвращает инф. есть ли еще элементы
     * @return
     */
    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    /**
     * Метод аозвращает следующий элемент.
     * @return
     */
    @Override
    public E next() {
        return values[index++];
    }


}
