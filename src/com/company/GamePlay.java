package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    //Snake Configuration
    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private int lengthOfSnake = 3;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightmouth;
    private ImageIcon lefthmouth;
    private ImageIcon upmouth;
    private ImageIcon downhmouth;

    private ImageIcon snakeImage;

    //Game Configuration
    private Timer timer;
    private int delay = 100;
    private int moving = 0;

    //Gameplay panel configuration

    private ImageIcon titleImage;

    public GamePlay() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        timer.start();


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

        //draw snake
        //initial position
        if(moving == 0){
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;
        }

        rightmouth = new ImageIcon("Images/rightmouth.png");
        rightmouth.paintIcon(this, graphics, snakeXlength[0], snakeYlength[0] );

        for(int i=0; i<lengthOfSnake; i++){

            //head of the snake
            if(i==0 && right){
                rightmouth = new ImageIcon("Images/rightmouth.png");
                rightmouth.paintIcon(this, graphics, snakeXlength[i], snakeYlength[i] );
            }
            if(i==0 && left){
                lefthmouth = new ImageIcon("Images/lefthmouth.png");
                lefthmouth.paintIcon(this, graphics, snakeXlength[i], snakeYlength[i] );
            }
            if(i==0 && up){
                upmouth = new ImageIcon("Images/upmouth.png");
                upmouth.paintIcon(this, graphics, snakeXlength[i], snakeYlength[i] );
            }
            if(i==0 && down){
                downhmouth = new ImageIcon("Images/downmouth.png");
                downhmouth.paintIcon(this, graphics, snakeXlength[i], snakeYlength[i] );
            }

            //body of the snake
            if (i != 0) {
                snakeImage = new ImageIcon("Images/snakeimage.png");
                snakeImage.paintIcon(this, graphics, snakeXlength[i], snakeYlength[i] );
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
