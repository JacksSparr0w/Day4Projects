package by.javatr.task1.runner;

import by.javatr.scanner.EnterFromConsole;
import by.javatr.task1.util.MyArray;

import java.io.Reader;

public class Run {
    private static MyArray myArray;

    public static void main(String[] arg){

        System.out.println("1 - Random size and elements");
        System.out.println("2 - Input size, random elements");
        System.out.println("3 - Input elements");
        System.out.println("4 - From file");

        int answer;
        do{
            System.out.print("Enter 1 - 4: ");
            answer = (int) EnterFromConsole.EnterDouble();
        }
        while (answer > 4 || answer < 1);

        switch (answer){
            case 1:
                myArray = randomSizeAndElements();
                break;
            case 2:
                myArray = inputSizeRandomElements();
                break;
            case 3:
                myArray = inputElements();
                break;
            case 4:
                //myArray = enterFromFile();
                break;
            default:
                    break;
        }
        print("Массив: ", myArray.getArray());

        myArray.bubbleSort();
        print("Отсортированный массив: ", myArray.getArray());

        System.out.println("Простые числа: " + myArray.findPrimesNumbers());
        System.out.println("Трехзначные числа: " + myArray.findThreeNumericNumbers());
        System.out.println("Числа из последовательности Фибоначчи: " + myArray.findFibonachi());
        int number = 32;
        int index = myArray.binarySearch(number);
        if (index == -1){
            System.out.println("Число " + number + " не содержится в массиве.");
        } else{
            System.out.println("Число " + number + " есть в массиве (отсортированном) под индексом " + index);
        }



    }

    public static void print(String description, int[] a){
        System.out.print(description);
        for(int x : a)
            System.out.print(x + " ");
        System.out.println();

    }

    public static MyArray randomSizeAndElements(){
        return new MyArray();
    }

    public static MyArray inputSizeRandomElements(){
        int size;
        do{
            size = (int) EnterFromConsole.EnterDouble();

        }
        while(size < 1);
        return new MyArray(size);
    }

    public static MyArray inputElements(){
        int size;
        do{
            System.out.print("Enter size of array (>0): ");
            size = (int) EnterFromConsole.EnterDouble();
        }
        while(size < 1);
        int[] a = new int[size];
        System.out.println("Enter array.");
        for (int i = 0; i < size; ++i)
            a[i] = (int) EnterFromConsole.EnterDouble();
        return new MyArray(a);
    }

    /*public static MyArray enterFromFile(){
        return new MyArray(file);
    }*/
}
