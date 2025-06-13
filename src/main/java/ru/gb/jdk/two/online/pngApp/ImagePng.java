package ru.gb.jdk.two.online.pngApp;


import ru.gb.jdk.two.online.common.MainCanvas;
import ru.gb.jdk.two.online.common.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ImagePng extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX, vY;

    public ImagePng(){
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        ImageIcon image = new ImageIcon("src/main/java/ru/gb/jdk/two/online/images/heartImage.png");
        g.drawImage(image.getImage(), (int) getLeft(),(int) getTop(), (int) getWidth(), (int) getHeight(), null);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if(getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if(getRight() > canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }
}
