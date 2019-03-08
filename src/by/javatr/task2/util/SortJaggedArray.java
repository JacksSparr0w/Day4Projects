package by.javatr.task2.util;

import java.util.Random;

public class SortJaggedArray {
    private final int ROWS = 10;
    private final int ELEMENTS_IN_ROW = 15;
    private final int MAX_VALUE = 50;
    private int[][] jaggedArray;
    private int[] buf;

    public SortJaggedArray(){
        Random random = new Random();
        jaggedArray = new int[random.nextInt(ROWS)+2][];

        for (int i = 0; i < jaggedArray.length; ++i){
            jaggedArray[i] = new int[random.nextInt(ELEMENTS_IN_ROW)+1];
            for (int j = 0; j < jaggedArray[i].length; ++j)
                jaggedArray[i][j] = random.nextInt(MAX_VALUE);
        }
        buf = new int[jaggedArray.length];
    }

    private void bubbleSort(){
        for (int i = buf.length - 1; i > 0; --i){
            for (int j = 0; j < i; ++j){
                if (buf[j] > buf[j+1]){
                    
                    int tmp1 = buf[j];
                    buf[j] = buf[j+1];
                    buf[j+1] = tmp1;
                    
                    int[] tmp2 = jaggedArray[j];
                    jaggedArray[j] = jaggedArray[j+1];
                    jaggedArray[j+1] = tmp2;

                }
            }
        }
    }

    public void sort(TYPE type) {
        clearBuf(type);
        for (int i = 0; i < jaggedArray.length; ++i) {
            for (int el : jaggedArray[i]) {
                switch (type) {
                    case SUM:
                        buf[i] += el;
                        break;
                    case MAX:
                        buf[i] = el > buf[i] ? el : buf[i];
                        break;
                    case MIN:
                        buf[i] = el < buf[i] ? el : buf[i];
                        break;
                }
            }
        }
        bubbleSort();
    }

    private void clearBuf(TYPE type){
        for (int i = 0; i <buf.length; ++i)
            switch (type){
                case SUM:
                    buf[i] = 0;
                    break;
                case MAX:
                case MIN:
                    buf[i] = jaggedArray[i][0];
                    break;
            }
    }

    public int[][] getJaggedArray(){
        return jaggedArray;
    }

    public int[] getBuf(){
        return buf;
    }
}