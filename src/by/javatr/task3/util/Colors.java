package by.javatr.task3.util;

import java.util.Random;

public enum Colors {

    BLUE,
    RED,
    GREEN;

    public static Colors getRandomColor(){
        Random random = new Random();
        switch (random.nextInt(2)){
            case 0:
                return BLUE;
            case 1:
                return RED;
            case 2:
                return GREEN;
            default:
                return null;
        }
    }
}
