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
        array = new int[random.nextInt(30)];
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

    public boolean binarySearch(int aim){
        int[] sortArray = bubbleSort();
        if (doBinarySearch(sortArray, aim, 0, length()-1) != -1)
            return true;
        else
            return false;
    }

    private int doBinarySearch(int[] ar, int aim, int left, int right){
        if(right >= left){
            int mid = left + (right - left) / 2;
            if (ar[mid] == aim){
                return mid;
            }
            if(ar[mid] > aim) {
                return doBinarySearch(ar, aim, left, mid-1);
            }else{
                return doBinarySearch(ar, aim, mid+1, right);
            }

        }
        return -1;

    }

    public int[] bubbleSort(){
        int[] sortArray = copy();
        for (int i = sortArray.length - 1; i > 0; --i){
            for (int j = 0; j < i; ++j){
                if (sortArray[j] > sortArray[j+1]){
                    int tmp = sortArray[j];
                    sortArray[j] = sortArray[j+1];
                    sortArray[j+1] = tmp;
                }
            }
        }
        return sortArray;
    }

    public int[] selectionSort(){
        int[] sortArray = copy();
        for (int i = 0; i < sortArray.length; ++i){
            int min = sortArray[i];
            int min_i = i;
            for (int j = i +1; j < sortArray.length; ++j){
                if (sortArray[j] < min){
                    min = sortArray[j];
                    min_i = j;
                }
            }

            if (i != min_i){
                int tmp = sortArray[i];
                sortArray[i] = sortArray[min_i];
                sortArray[min_i] = tmp;
            }
        }
        return sortArray;
    }

    public int[] insertionSort() {
        int[] a = copy();
        for (int i = 1; i < a.length; i++) {
            int el = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > el) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = el;
        }
        return a;
    }

    public ArrayList findPrimesNumbers_Simple(){
        buf = new ArrayList();
        for(int i = 0; i < length(); ++i)
            for(int j = 2; j < array[i]; ++j){
                if (array[i] % j == 0)
                    break;
                if((j == array[i]) || (j > Math.sqrt(array[i]))) {
                    //if(!buf.contains(array[i]))
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
