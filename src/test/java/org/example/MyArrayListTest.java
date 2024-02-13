package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class MyArrayListTest {
    private MyArrayList<MyObject> myArray;

    @BeforeEach
    public void SetUp() {
        MyObject o1 = new MyObject("a", 4);
        MyObject o2 = new MyObject("c", 3);
        MyObject o3 = new MyObject("b", 2);
        MyObject o4 = new MyObject("d", 1);

        myArray = new MyArrayList<MyObject>(
                new MyObject[]{o1, o2, o3, o4});
    }

    @Test
    public void testAdd(){
        MyObject o5 = new MyObject("a", 0);
        myArray.add(o5);
        Assertions.assertEquals(o5,
                myArray.get(myArray.size() -1));
    }

    @Test
    public void testAddByIndex() {
        MyObject o5 = new MyObject("f", 0);
        myArray.add(o5, 1);
        Assertions.assertEquals(o5,
                myArray.get(1));
    }

    @Test
    public void testGet() {
        MyObject o5 = new MyObject("f", 10);
        myArray.add(o5, 0);
        Assertions.assertEquals(o5, myArray.get(0));
    }


    @Test
    public void testUpdate() {
        MyObject o5 = new MyObject("f", 0);
        myArray.update(2, o5);
        Assertions.assertEquals(o5, myArray.get(2));
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(4, myArray.size());
    }

    @Test
    public void testDelete() {
        String toStr = "[a4][c3][d1]";
        myArray.delete(2);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object e : myArray) {
            stringBuilder.append(e);
        }
        Assertions.assertEquals(toStr, stringBuilder.toString());
    }

    @Test
    public void testClear() {
        int size = 0;
        myArray.clear();
        Assertions.assertEquals(size, myArray.size());
    }

    @Test
    public void testTrimToSize() {

        myArray.trimToSize();
    }

    @Test
    public void testReverse() {
        String array = "[d1][b2][c3][a4]";
        myArray.reverse();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object e : myArray) {
            stringBuilder.append(e);
        }
        Assertions.assertEquals(array, stringBuilder.toString());
    }

    @Test
    public void testIterator() {
        String array = "[a4][c3][b2][d1]";
        Iterator iterator = myArray.iterator();

        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
        }
        Assertions.assertEquals(array, stringBuilder.toString());
    }

    @Test
    public void testSortByComparator() {
        String arraySort = "[a4][b2][c3][d1]";
        MyComparator myC = new MyComparator();
        myArray.sortByComparator(myC);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object e : myArray) {
            stringBuilder.append(e);
        }

        Assertions.assertEquals(arraySort, stringBuilder.toString());
    }

    @Test
    public  void testSortByComparable() {
        String arraySort = "[d1][b2][c3][a4]";
        myArray.sortByComparable();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object e : myArray) {
            stringBuilder.append(e);
        }
        Assertions.assertEquals(arraySort, stringBuilder.toString());
    }

}
