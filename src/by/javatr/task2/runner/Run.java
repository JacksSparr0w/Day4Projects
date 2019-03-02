package by.javatr.task2.runner;

import by.javatr.task2.util.SortJaggedArray;
import by.javatr.task2.util.TYPE;

public class Run {
    public static void main(String[] arg){
        TYPE type = TYPE.MAX;
        SortJaggedArray array = new SortJaggedArray();
        array.sort(type);
        int[][] sort = array.getJaggedArray();
        int[] buf = array.getBuf();
        System.out.println(type);
        for (int i = 0; i < sort.length; ++i) {
            System.out.println();
            System.out.print(buf[i] + " --- ");
            for (int el : sort[i])
                System.out.print(el + " ");
        }
    }
}
