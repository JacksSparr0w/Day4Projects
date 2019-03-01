package by.javatr.task1.util;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private int[] array;
    private Random random = new Random();
    private ArrayList buf;


    //random size, random elements
    public MyArray(){
        array = new int[random.nextInt(29) + 1];
        for (int i = 0; i < array.length; ++i){
            array[i] = random.nextInt(255);
        }

    }
    //array is enter from console
    public MyArray(int ... array){
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }
    //array is reading from file
    public MyArray(String fileName){
        /*FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        scan.*/
    }

    //random elements
    public MyArray(int size){
        array = new int[size];
        for (int i = 0; i < size; ++i)
            array[i] = random.nextInt(255);
    }

    public int length(){
        return array.length;
    }

    public int[] getArray(){
        return array;
    }

    public int getElementAt(int index){
        return array[index];
    }

    public boolean setArray(int ... array){
        if (length() == array.length){
            System.arraycopy(array, 0, this.array, 0, array.length);
            return true;
        }
        return false;
    }

    public void setElementAt(int index, int element){
        if (index >= 0 && index < length())
            array[index] = element;
    }

    public int max(){
        int max = array[0];
        for (int x : array){
            if (max < x){
                max = x;
            }
        }
        return max;
    }

    public int min(){
        int min = array[0];
        for (int x : array){
            if (min >= x){
                min = x;
            }
        }
        return min;
    }

    public boolean contain(int element){
        for(int x : array)
            if(x == element)
                return true;
        return false;
    }

    private int[] copy(){
        int[] sortArray = new int[length()];
        System.arraycopy(array, 0, sortArray, 0, length());
        return sortArray;
    }

    public int binarySearch(int aim){
        return doBinarySearch(aim, 0, length()-1);
    }

    private int doBinarySearch(int aim, int left, int right){
        if(right >= left){
            int mid = left + (right - left) / 2;
            if (array[mid] == aim){
                return mid;
            }
            if(array[mid] > aim) {
                return doBinarySearch(aim, left, mid-1);
            }else{
                return doBinarySearch(aim, mid+1, right);
            }

        }
        return -1;

    }

    public void bubbleSort(){
        for (int i = array.length - 1; i > 0; --i){
            for (int j = 0; j < i; ++j){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public void selectionSort(){
        for (int i = 0; i < array.length; ++i){
            int min = array[i];
            int min_i = i;
            for (int j = i +1; j < array.length; ++j){
                if (array[j] < min){
                    min = array[j];
                    min_i = j;
                }
            }

            if (i != min_i){
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i <array.length; i++) {
            int el =array[i];
            int j = i - 1;
            while (j >= 0 &&array[j] > el) {
               array[j + 1] =array[j];
                j--;
            }
           array[j + 1] = el;
        }
    }

    public ArrayList findPrimesNumbers(){
        buf = new ArrayList();
        for(int i = 0; i < length(); ++i)
            for(int j = 2; j < array[i]; ++j){
                if (array[i] % j == 0)
                    break;
                if((j == array[i]) || (j > Math.sqrt(array[i]))) {
                    buf.add(array[i]);
                    break;
                }
            }
        return buf;
    }

    public ArrayList findFibonachi(){
        buf = new ArrayList();
        int n0 = 1;
        int n1 = 1;
        if (contain(n1))
            buf.add(n1);
        int n2;
        for(int i = 3; i<=max(); ++i){
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
            if(contain(n2))
                buf.add(n2);
        }
        return buf;
    }

    public ArrayList findThreeNumericNumbers(){
        buf = new ArrayList();
        for (int x : array) {
            if (Math.abs(x) > 99 && Math.abs(x) < 1000) {
                int a = x / 100;
                int b = (x / 10) % 10;
                int c = x % 10;
                if (a != b && a != c && b != c)
                    buf.add(x);
            }
        }
        return buf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArray myArray = (MyArray) o;
        return Arrays.equals(array, myArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "MyArray@[" +
                "" + Arrays.toString(array) +
                ']';
    }
}
