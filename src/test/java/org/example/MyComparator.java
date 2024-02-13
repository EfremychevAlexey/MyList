package org.example;

import java.util.Comparator;

/** Вспомогательный класс, созданный для тестирования сортировки по Компаратору
 * */
public class MyComparator implements Comparator<MyObject> {
    @Override
    public int compare(MyObject myObject1, MyObject myObject2) {
        return myObject1.getStr().compareTo(myObject2.getStr());
    }
}
