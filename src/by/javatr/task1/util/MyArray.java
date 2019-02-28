package by.javatr.task1.util;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyArray {
    private int[] array;
    private Random random = new Random();
    private ArrayList buf;


    //random size, random elements
    public MyArray(){
        array = new int[random.nextInt(10)];
        for (int i = 0; i < array.length; ++i){
            array[i] = random.nextInt();
        }

    }
    //array is enter from console
    public MyArray(int ... array){
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }
    //array is reading from file
    public MyArray(Reader file){
        //
    }

    //random elements
    public MyArray(int size){
        array = new int[size];
        for (int i = 0; i < size; ++i)
            array[i] = random.nextInt();
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

    public int doBinarySearch(int aim){
        return binarySearch(copy(), aim, 0, length());
    }

    private int binarySearch(int[] ar, int aim, int left, int right){
        if(right >= left){
            //int mid = (right - left) / 2;
            int mid = left + (right - left) / 2;
            if (ar[mid] == aim){
                return mid;
            }
            if(ar[mid] < aim) {
                return binarySearch(ar, aim, left, mid);
            }else{
                return binarySearch(ar, aim, mid+1, right);
            }

        }
        return -1;

    }

    public int[] bubbleSort(){
        int[] sortArray = new int[length()];
        System.arraycopy(array, 0, sortArray, 0, length());
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
        int[] sortArray = new int[length()];
        System.arraycopy(array, 0, sortArray, 0, length());
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

    public int[] doQuickSort(){
        int[] a = copy();
        quickSort(a, 0, length());
        return a;
    }

    private void quickSort(int[] ar, int left, int right){
        if (ar.length == 0)
            return;
        if(left >=right)
            return;

        int midIndex = left + (right - left) / 2;
        int middle = array[midIndex];

        int i = left;
        int j = right;
        while(i <= j) {
            while(ar[i] < middle) {
                i++;
            }

            while(ar[j] > middle){
                j--;
            }

            if ( i<= j) {
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
                j--;
            }
        }

        if(left < j)
            quickSort(ar, left, j);
        if(right > i)
            quickSort(ar, i, right);
    }

    public ArrayList findPrimesNumbers(){
        buf = new ArrayList();
        Primes primes = new Primes(max());
        for (int x : array)
            if(primes.check(x)){
                buf.add(x);
            }
        return buf;
    }

    private class Primes {

        private boolean[] primes;

        public Primes(int number){
            primes = new boolean[number+1];
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;
            for(int i = 2;i*i < number;i++){
                if(primes[i]){
                    for(int j=i*i;j < number;j+=i){
                        primes[j] = false;
                    }
                }
            }

        }

        public boolean check(int number){
            return primes[number];
        }

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
            if (x > 99 && x < 1000) {
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
        return "MyArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
