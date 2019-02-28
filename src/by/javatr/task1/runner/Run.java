package by.javatr.task1.runner;

import by.javatr.scanner.EnterFromConsole;
import by.javatr.task1.util.MyArray;

import java.io.Reader;

public class Run {

    public static void main(String[] arg){
        MyArray myArray;
        System.out.println("1 - Random size and elements");
        System.out.println("2 - Input size, random elements");
        System.out.println("3 - Input elements");
        System.out.println("4 - From file");
        System.out.println("Enter 1 - 4");

        int answer;
        do{
            answer = (int) EnterFromConsole.EnterDouble();
        }
        while (answer > 4 || answer < 1);

        switch (answer){
            case 1:
                randomSizeAndElements();
                break;
            case 2:
                inputSizeRandomElements();
                break;
            case 3:
                inputElements();
                break;
            case 4:
                enterFromFile(file);
                break;
            default:
                    break;

        }


    }

    public static void randomSizeAndElements(){
        myArray = new MyArray();
    }

    public static void inputSizeRandomElements(int size){
        myArray = new MyArray(size);
    }

    public static void inputElements(int[] ar){
        myArray = new MyArray(ar);
    }

    public static void enterFromFile(Reader file){
        myArray = new MyArray(file);
    }
}
