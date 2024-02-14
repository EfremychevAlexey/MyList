package org.example;

/** Вспомогательный класс тестов
 * */

public class MyObject implements Comparable<MyObject>{
    private String str;
    private int number;

    public MyObject(String str, int number) {
        this.str = str;
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "[" + str + number + "]";
    }

    @Override
    public int compareTo(MyObject o) {
        if (this.getNumber() == o.getNumber()) return 0;
        if (this.getNumber() < o.getNumber()) return -1;
        return 1;
    }
}

