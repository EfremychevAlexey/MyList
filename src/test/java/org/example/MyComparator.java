package org.example;

import java.util.Comparator;

public class MyComparator implements Comparator<MyObject> {
    @Override
    public int compare(MyObject myObject1, MyObject myObject2) {
        return myObject1.getStr().compareTo(myObject2.getStr());
    }
}
