package joc2;

import java.util.Random;

public class Food {

    private final int posX;
    private final int posY;

    public Food() {
        posX = generatePos(joc.WIDTH);
        posY = generatePos(joc.HEIGHT);
    }

    private int generatePos(int size) {
        Random random = new Random();
        return random.nextInt(size / joc.patratica) * joc.patratica;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}