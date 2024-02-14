package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyQuickSortTest {
    private final MyArrayList<MyObject> myArray = new MyArrayList<>();

    @BeforeEach
    public void SetUp() {
        MyObject o1 = new MyObject("a", 4);
        MyObject o2 = new MyObject("c", 3);
        MyObject o3 = new MyObject("b", 2);
        MyObject o4 = new MyObject("d", 1);
        MyObject o5 = new MyObject("z", 0);
        MyObject o6 = new MyObject("n", 100);

        myArray.add(o1);
        myArray.add(o2);
        myArray.add(o5);
        myArray.add(o4);
        myArray.add(o3);
        myArray.add(o6);
    }

    @Test
    public void testSort() {
        String arraySort = "[a4][b2][c3][d1][n100][z0]";
        MyComparator myC = new MyComparator();
        MyQuickSort.sort(myArray, myC);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object e : myArray) {
            stringBuilder.append(e);
        }
        Assertions.assertEquals(arraySort, stringBuilder.toString());
    }

    @Test
    public  void testSortByComparable(){
        String arraySort = "[z0][d1][b2][c3][a4][n100]";
        MyQuickSort.sort(myArray);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object e : myArray) {
            stringBuilder.append(e);
        }
        Assertions.assertEquals(arraySort, stringBuilder.toString());
    }

}
