package by.javatr.task3.util;

public class Ball {

    private final Colors COLOR;
    private final float WEIGHT;

    public Ball(Colors color, float weight){

        COLOR = color;
        WEIGHT = weight;
    }

    public float getWEIGHT() {
        return WEIGHT;
    }

    public Colors getCOLOR(){
        return COLOR;
    }

    @Override
    public String toString() {
        return "Ball (" +
                "COLOR = " + COLOR +
                ", WEIGHT = " + WEIGHT +
                ')';
    }
}
