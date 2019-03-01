package by.javatr.task3.util;

import java.util.ArrayList;

public class Basket {
    private final Colors COLOR = Colors.BLUE;

    private ArrayList<Ball> balls;
    private int amountOfBlueBalls;
    private float commonWeight;

    public Basket(){
        balls = new ArrayList<>();
        amountOfBlueBalls = 0;
        commonWeight = 0;
    }

    public void addBall(Ball ball){
        balls.add(ball);
        commonWeight += ball.getWEIGHT();
        amountOfBlueBalls += ball.getCOLOR() == COLOR ? 1 : 0;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public Ball getBallAtIndex(int index) {
        return balls.get(index);
    }

    public int getAmountOfBlueBalls() {
        return amountOfBlueBalls;
    }

    public float getCommonWeight() {
        return commonWeight;
    }

}
