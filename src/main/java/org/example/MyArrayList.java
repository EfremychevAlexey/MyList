package org.example;

import java.util.*;

/**
 * Параметризованный класс - список для хранения данных на
 * основе динамического массива.
 * @param <E>
 * @author efremychev_a
 * @version 1.0
 *
 */
public class MyArrayList<E> implements MyListInterface<E> {


    /** Поле идентификатор переменной, для хранения информации о
     * количестве хранящихся элементов
     * во внутреннем динамическом массиве.
     * Будет рассматриваться в данном классе,
     * как значение равное размеру списка.
     * */
    private int arraySize;

    /** Поле идентификатор динамического массива
     * */
    private E[] values;

    /** Конструктор класса.
     * Инициализирует оба поля объекта класса
     * */
    MyArrayList() {
        try {
            values = (E[]) new Object[0];
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        arraySize = 0;
    }

    /** Конструктор, принимающий в параметре готовый массив
     * элементов.
     * Инициализирует все поля класса.
     * */
    MyArrayList(E[] values) {
        this.values = values;
        arraySize = values.length;
    }



    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            myList.add(1);
        }
        System.out.println("Массив заполнился за: " + (System.currentTimeMillis() - start));
        System.out.println(myList.size());
    }

    /** Метод принимает в параметре элемент Е,
     * который помещает в конец всего списка.
     * В случае если размер массива не позволяет поместить
     * элемент в конце, создается новый массив
     * размером (х 1.5 + 1) пазмера прежнего массива.
     * Все элементы копируются в новый массив, а переданный
     * в параметрах элемент помещается в конец списка.
     * Размер списка инкрементируется.
     * Метод возвращает логическое значение.
     * */
    @Override
    public boolean add(E e) {
        try {
            E[] tempArray = values;
            if (values.length <= ++arraySize) {
                values = arrayExtension();
                System.arraycopy(tempArray, 0, values, 0, arraySize - 1);
                values[arraySize - 1] = e;
                return true;
            }
            else {
                values[arraySize] = e;
                return true;
            }

        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /** Метод принимает в параметре элемент
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
     * */
    @Override
    public boolean add(E e, int index) {
        if (index <= arraySize){
            add(e);
            return true;
        }
        if (index > arraySize + 1) {
            throw new IndexOutOfBoundsException();
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

    /** Метод принимает в качестве параметра числовой индекс.
     * Возвращает элемент Е из массива, хранящийся
     * по заданному индексу
     * */
    @Override
    public E get(int index) {
        return values[index];
    }

    /** Метод принимает в качестве параметров числовой индекс
     * и элемент Е.
     * Производит запись элемента Е в массив по заданному индексу.
     * Прежнее значение ячейки массива не сохраняется.
     * */
    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    /** Метод возвращает количество хранящихся элементов
     * в массиве.*/
    @Override
    public int size() {
        return arraySize;
    }

    /** Метод принимает в качестве параметра числовой индекс.
     * Производит смещение всех элементов, начиная с заданного индекса
     * на -1 значение.
     * элемент, прежде хранящийся в массиве по заданному
     * индексу не сохраняется.
     */
    @Override
    public void delete(int index) {
        if ((arraySize < index)) {
            throw new IndexOutOfBoundsException();
        }
        E[] tempArray = values;
        System.arraycopy(tempArray, 0, values, 0, index);
        System.arraycopy(tempArray, index + 1, values, index,
                tempArray.length - index - 1);
        arraySize--;
    }

    /** Метод освобождает ссылку на массив данного объекта.
     * В переменную массива записывается ссылся на новый пустой массив.
     * Размеру списка присваивается значение 0.
     * Ссылка на прежний массси не сохраняется.
     * */
    @Override
    public void clear() {
        try {
            values = (E[]) new Object[0];
            arraySize = 0;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /** Метод создает новый массив, размером, равным размеру списка
     * и записывает в него все имеющиеся элементы.
     * Переменной массива присваивается ссылка на новый массив.*/
    @Override
    public void trimToSize() {
        try {
            E[] tempArray = values;
            values = (E[]) new Object[arraySize];
            System.arraycopy(tempArray, 0, values, 0, arraySize);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /** Метод производит копирование элементов массива в новый массив
     * в обратном порядке.
     * В переменную массива записывается ссылка на новый массив.*/
    @Override
    public void reverse() {
        for (int i = 0; i < values.length / 2; i++) {
            E temp = values[i];
            values[i] = values[values.length - i - 1];
            values[values.length - i - 1] = temp;
        }
    }

    /** Метод принимает в качестве параметров ссылку
     * на массив экземпляра
     * и числовое значение размера списка.
     * возвращант итератор.*/
    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<>(values, arraySize);
    }

    /** Метод сортировки массива по Компаратору.
     * В качестве параметра метод получает объект,
     * имплементирующий интерфейс Comparator<E>.
     * Сортировка массива производится по алгоритму QuickSort.
     * */
    @Override
    public void sort(Comparator<E> comparator) {
        Arrays.sort(values, comparator); // сортируем его с пом компаратора
    }

    private <E> void quickSortByComparator(E[] values, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pi = partitionByComparator(values, low, high, comparator);

            quickSortByComparator(values, low, pi - 1, comparator);
            quickSortByComparator(values, pi + 1, high, comparator);
        }
    }

    /** Метод возвращает индекс элемента, относительно которого
     * произвел смещение элементов массива
     * */
    private <E> int partitionByComparator(E[] arr, int low, int high, Comparator<E> comparator) {
        E pivot = arr[high]; // ,
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) == -1) {
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

    /** Метод сортировки массива для типов данных,
     * класс которых имплементирует интерфейс Comparable.
     * Сортировка массива производится по алгоритму QuickSort.
     * */
    @Override
    public void sort() {
        quickSort((Comparable[]) values, 0, values.length - 1);

    }

    /** Метод реализует алгоритм QuickSort.
     * Принимает в качестве параметров ссылку на массив, который хранит в себе
     * данные, тип которых имплементирует интерфейс Comparable.
     * */
    private <E extends Comparable> void quickSort(Comparable[] values, int low, int high) {
        if (low < high) {
            int pi = partition(values, low, high);

            quickSort(values, low, pi - 1);
            quickSort(values, pi + 1, high);
        }
    }

    /** Метод возвращает индекс элемента, относительно которого
     * произвел смещение элементов массива
     * */
    private <E extends Comparable> int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high]; // ,
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) == -1) {
                i++;


                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Comparable temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }

    /** Вспомогательный метод.
     * производит расширение массива, принадлежащего экземпляру данного класса..
     * */
    private E[] arrayExtension(){
        E[] values = null;
        try {
            values = (E[]) new Object[(int) (arraySize * 1.5) + 1];
            return values;
        } catch (ClassCastException ex) {
        }
       return values;
    }

}
