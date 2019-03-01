package by.javatr.task3.runner;

import by.javatr.task3.util.Ball;
import by.javatr.task3.util.Basket;
import by.javatr.task3.util.Colors;

import java.util.Random;

public class Run {

    public static void main(String[] arg){
        Random random = new Random();
        int amount = random.nextInt(9) + 1;
        Basket basket = new Basket();
        Ball ball;
        Colors color;
        float weight;
        for (int i = 0; i < amount; ++i){
            color = Colors.getRandomColor();
            weight = random.nextFloat() * 10;
            ball = new Ball(color, weight);
            basket.addBall(ball);
        }

        System.out.println("In basket now: ");
        for (int i = 0; i < amount; ++i)
            System.out.println(basket.getBallAtIndex(i));

        System.out.println("Amount of blue balls: " + basket.getAmountOfBlueBalls());
        System.out.format("Common weight: %.2f", basket.getCommonWeight());
    }


}
