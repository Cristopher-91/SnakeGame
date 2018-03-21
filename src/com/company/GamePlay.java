package com.company;

import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {

    //Snake Configuration
    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private boolean left = false;
    private boolean rigth = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rigthmouth;
    private ImageIcon lefthmouth;
    private ImageIcon upmouth;
    private ImageIcon downhmouth;

    private ImageIcon snakeImage;

    private Timer timer;
    private int delay = 100;

    //Gameplay panel configuration

    private ImageIcon titleImage;
    public GamePlay() {
    }

    public void paint(Graphics graphics){

        //draw title image border
        graphics.setColor(Color.white);
        graphics.drawRect(15,11,851,55);

        //draw the title image
        titleImage = new ImageIcon("Images/snaketitle.jpg");
        titleImage.paintIcon(this, graphics, 16,12);

        //draw gameplay border
        graphics.setColor(Color.white);
        graphics.drawRect(15,74,851,575);

        //draw background for the gameplay
        graphics.setColor(Color.BLACK);
        graphics.fillRect(16,75,850,574);

    }
}
