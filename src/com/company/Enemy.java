package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy {

    private int[] positionX = {25,50,75,100,125,150,175,200,225,250,275,
    300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,
    725,750,775,800,825,850};

    private int[] positionY = {75,100,125,150,175,200,225,250,275,300,325,
    350,375,400,425,450,475,500,525,550,575,600,625};

    private ImageIcon enemyImage = new ImageIcon("Images/enemy.png");
    private Random random = new Random();

    private int xPos = random.nextInt(34);
    private int yPos = random.nextInt(23);

    public void shufflePositions(){
        xPos = random.nextInt(34);
        yPos = random.nextInt(23);
    }
    public int getxPos() {
        return positionX[xPos];
    }

    public int getyPos() {
        return positionY[yPos];
    }

    public ImageIcon getEnemyImage() {
        return enemyImage;
    }
}
