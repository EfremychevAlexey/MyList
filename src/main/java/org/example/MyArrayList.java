package org.example;

import java.util.*;

/**
 * Параметризованный класс - список для хранения данных на
 * основе динамического массива.
 *
 * @param <E>
 * @author efremychev_a
 * @version 1.01
 */
public class MyArrayList<E> implements MyListInterface<E> {

    /**
     * Поле идентификатор переменной, для хранения информации о
     * количестве хранящихся элементов
     * во внутреннем динамическом массиве.
     * Будет рассматриваться в данном классе,
     * как значение равное размеру списка.
     */
    private int arraySize = 0;

    /**
     * Поле идентификатор динамического массива
     */
    private Object[] values = new Object[0];

    /**
     * Конструктор класса.
     * Инициализирует оба поля объекта класса
     */
    public MyArrayList() {
    }

    /**
     * Конструктор, принимающий в параметре готовый массив
     * элементов.
     * Инициализирует все поля класса.
     *
     * @param c
     */
    public MyArrayList(Collection<? extends E> c) {
        this.values = c.toArray();
        arraySize = values.length;
    }

    /**
     * Метод принимает в параметре элемент Е,
     * который помещает в конец всего списка.
     * В случае если размер массива не позволяет поместить
     * элемент в конце, создается новый массив
     * размером (х 1.5 + 1) пазмера прежнего массива.
     * Все элементы копируются в новый массив, а переданный
     * в параметрах элемент помещается в конец списка.
     * Размер списка инкрементируется.
     * Метод возвращает логическое значение.
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        if (arraySize == 0) {
            values = arrayExtension();
            values[arraySize++] = e;
            return true;
        }
        if (values.length <= arraySize) {
            Object[] tempArray = arrayExtension();
            System.arraycopy(values, 0, tempArray, 0, values.length);
            tempArray[values.length] = e;
            values = tempArray;
            arraySize++;
            return true;
        }
        if (values.length > arraySize) {
            values[arraySize++] = e;
            return true;
        }
        return false;
    }

    /**
     * Метод принимает в параметре элемент
     * E и числовой индекс.
     * В случае, если индекс равен размеру списка,
     * в целях избежания копирования,
     * элемент передается методу add(E e) для вставки элемента
     * в конец списка.
     * В ином случае, все имеющиеся элементы копируются
     * в новый расширенный массив или копируются со смещением на
     * один индекс начиная с переданного индекса,
     * если размер массива позволяет выполнить данную операцию.
     * Запись ссылки на новый элемент Е в массив производится по заданному индексу.
     * Размер списка инкрементируется.
     * Метод возвращает логическое значение.
     *
     * @param e
     * @param index
     * @return
     */
    @Override
    public boolean add(E e, int index) {
        if (index == arraySize) {
            add(e);
            return true;
        }
        if (index > (arraySize + 1) || index < 0) {
            throw new IndexOutOfBoundsException("Заданный индекс выходит за пределы массива.");
        } else {
            try {
                E[] tempArray = (E[]) new Object[++arraySize - 1];
                System.arraycopy(values, 0, tempArray, 0, arraySize - 1);

                if (values.length < arraySize) {
                    values = arrayExtension();
                }
                System.arraycopy(tempArray, 0, values, 0, index);
                values[index] = e;
                System.arraycopy(tempArray, index, values, index + 1, tempArray.length - index);

                return true;
            } catch (ClassCastException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Метод принимает в качестве параметра числовой индекс.
     * Возвращает элемент Е из массива, хранящийся
     * по заданному индексу.
     * В случае, когда индекс больше размера списка,
     * метод выбрасывает исключение IndexOutOfBoundsException.
     *
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        if (index >= arraySize) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    /**
     * Метод принимает в качестве параметров числовой индекс
     * и элемент Е.
     * Производит запись элемента Е в массив по заданному индексу.
     * Прежнее значение ячейки массива не сохраняется.
     *
     * @param index
     * @param e
     */
    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    /**
     * Метод возвращает количество хранящихся элементов
     * в массиве.
     *
     * @return
     */
    @Override
    public int size() {
        return arraySize;
    }

    /**
     * Метод принимает в качестве параметра числовой индекс.
     * Производит смещение всех элементов, начиная с заданного индекса
     * на -1 значение.
     * элемент, прежде хранящийся в массиве по заданному
     * индексу не сохраняется.
     * В случае, когда индекс больше размера списка,
     * метод выбрасывает исключение IndexOutOfBoundsException.
     *
     * @param index
     */
    @Override
    public void delete(int index) {
        if ((arraySize <= index)) {
            throw new IndexOutOfBoundsException("Значение индексы выходит за пределы массива");
        }
        Object[] tempArray = values;
        System.arraycopy(tempArray, 0, values, 0, index);
        System.arraycopy(tempArray, index + 1, values, index,
                tempArray.length - index - 1);
        arraySize--;
    }

    /**
     * Метод освобождает ссылку на массив данного объекта.
     * В переменную массива записывается ссылся на новый пустой массив.
     * Размеру списка присваивается значение 0.
     * Ссылка на прежний массси не сохраняется.
     */
    @Override
    public void clear() {
        try {
            values = new Object[0];
            arraySize = 0;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод возвращает внутренний массив размером равным размеру листа.
     */
    @Override
    public Object[] toArray() {
        trimToSize();
        return values;
    }

    /**
     * Метод создает новый массив, размером, равным размеру списка
     * и записывает в него все имеющиеся элементы.
     * Переменной массива присваивается ссылка на новый массив.
     */
    @Override
    public void trimToSize() {
        try {
            Object[] tempArray = values;
            values = new Object[arraySize];
            System.arraycopy(tempArray, 0, values, 0, arraySize);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод производит копирование элементов массива в новый массив
     * в обратном порядке.
     * В переменную массива записывается ссылка на новый массив.
     */
    @Override
    public void reverse() {
        trimToSize();
        for (int i = 0; i < values.length / 2; i++) {
            Object temp = values[i];
            values[i] = values[values.length - i - 1];
            values[values.length - i - 1] = temp;
        }
    }

    /**
     * Метод принимает в качестве параметров ссылку
     * на массив экземпляра
     * и числовое значение размера списка.
     * возвращант итератор.
     */
    @Override
    public Iterator iterator() {
        return new MyListIterator<>(values, arraySize);
    }

    /**
     * Вспомогательный метод.
     * производит расширение массива, принадлежащего экземпляру данного класса..
     */
    private Object[] arrayExtension() {
        Object[] values = null;
        try {
            values = new Object[(int) (arraySize * 1.5) + 1];
            return values;
        } catch (ClassCastException ex) {
        }
        return values;
    }
}
