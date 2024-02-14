package org.example;

import java.util.Comparator;

/**
 * Интерфейс описывающий поведение класса - списка,
 * который мы будем использовать для хранения
 * данных обобщенного типа.
 * Имплементирует интерфейс Iterable.
 *
 * @param <E>
 * @author efremychev_a
 * @version 1.0
 */
public interface MyListInterface<E> extends Iterable<E> {

    /**
     * Метод добавления элемента
     *
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * Метод добавления элемента по индексу
     *
     * @param e
     * @param index
     * @return
     */
    boolean add(E e, int index);

    /**
     * Метод получения элемента по индексу
     *
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * Метод обновления элемента по индексу
     *
     * @param index
     * @param e
     */
    void update(int index, E e);

    /**
     * Метод для получения размера списка
     *
     * @return
     */
    int size();

    /**
     * Метод удаления элемента по индексу
     *
     * @param index
     */
    void delete(int index);

    /**
     * Метод для очистки списка
     */
    void clear();

    /**
     * Метод возвращает внутренний массив размером равным размеру листа
     * @return
     */
    Object[] toArray();

    /**
     * Метод для уменьшени размера внутреннего массива до размера списка
     */
    void trimToSize();

    /**
     * Метод для разворота списка
     */
    void reverse();
}
