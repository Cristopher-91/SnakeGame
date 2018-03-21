package com.company;

import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {

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
