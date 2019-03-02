package by.javatr.task3.util;

import java.util.Random;

public enum Colors {

    BLUE,
    RED,
    GREEN,
    YELLOW;

    public static Colors getRandomColor(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 0:
                return BLUE;
            case 1:
                return RED;
            case 2:
                return GREEN;
            case 3:
                return YELLOW;
            default:
                return null;
        }
    }
}
