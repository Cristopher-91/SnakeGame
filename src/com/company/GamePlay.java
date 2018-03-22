package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements  ActionListener, KeyListener {

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

    public int getMoving() {
        return moving;
    }

    public void setMoving(int moving) {
        this.moving = moving;
    }

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
        graphics.drawRect(24,10,851,55);

        //draw the title image
        titleImage = new ImageIcon("Images/snaketitle.jpg");
        titleImage.paintIcon(this, graphics, 25,11);

        //draw gameplay border
        graphics.setColor(Color.white);
        graphics.drawRect(24,74,851,576);

        //draw background for the gameplay
        graphics.setColor(Color.BLACK);
        graphics.fillRect(25,75,850,575);

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
                lefthmouth = new ImageIcon("Images/leftmouth.png");
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
        graphics.dispose();
    }
    //Mechanics of the game
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right){
            for(int i = lengthOfSnake-1; i>=0; i--){
                snakeYlength[i+1] = snakeYlength[i];
            }
            for(int i = lengthOfSnake; i>=0; i--){
                if(i==0){
                    snakeXlength[i] = snakeXlength[i] + 25;
                }
                else{
                    snakeXlength[i] = snakeXlength[i-1];
                }
                if(snakeXlength[i] > 850){
                    snakeXlength[i] = 25;
                }
            }
        }
        repaint();
        if(left){
            for(int i = lengthOfSnake-1; i>=0; i--){
                snakeYlength[i+1] = snakeYlength[i];
            }
            for(int i = lengthOfSnake; i>=0; i--){
                if(i==0){
                    snakeXlength[i] = snakeXlength[i] - 25;
                }
                else{
                    snakeXlength[i] = snakeXlength[i-1];
                }
                if(snakeXlength[i] < 25){
                    snakeXlength[i] = 850;
                }
            }
        }
        repaint();
        if(up){
            for(int i = lengthOfSnake-1; i>=0; i--){
                snakeXlength[i+1] = snakeXlength[i];
            }
            for(int i = lengthOfSnake; i>=0; i--){
                if(i==0){
                    snakeYlength[i] = snakeYlength[i] - 25;
                }
                else{
                    snakeYlength[i] = snakeYlength[i-1];
                }
                if(snakeYlength[i] < 75){
                    snakeYlength[i] = 625;
                }
            }
        }
        repaint();
        if(down){
            for(int i = lengthOfSnake-1; i>=0; i--){
                snakeXlength[i+1] = snakeXlength[i];
            }
            for(int i = lengthOfSnake; i>=0; i--){
                if(i==0){
                    snakeYlength[i] = snakeYlength[i] + 25;
                }
                else{
                    snakeYlength[i] = snakeYlength[i-1];
                }
                if(snakeYlength[i] > 625){
                    snakeYlength[i] = 75;
                }
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                moving++;
                right = true;
                if(!left){
                    right = true;
                }
                else{
                    right = false;
                    left = true;
                }
                up = false;
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("left");
                moving++;
                left = true;
                if(!right){
                    left = true;
                }
                else{
                    left = false;
                    right = true;
                }
                up = false;
                down = false;
                break;
            case KeyEvent.VK_UP:
                moving++;
                up = true;
                if(!down){
                    up = true;
                }
                else{
                    up = false;
                    down = true;
                }
                left = false;
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                moving++;
                down = true;
                if(!up){
                    down = true;
                }
                else{
                    down = false;
                    up = true;
                }
                left = false;
                right = false;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
