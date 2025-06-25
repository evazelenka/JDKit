package ru.gb.jdk.two.online.pngApp;

import ru.gb.jdk.two.online.common.*;
import ru.gb.jdk.two.online.exceptions.SpritesException;
import ru.gb.jdk.two.online.exceptions.SpritesExceptional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainWindow extends JFrame implements CanvasRepaintListener, CanvasMouseListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public final ArrayList<Interactable> sprites = new ArrayList<>();

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Hearts");


//        fillSprites();

        SpritesExceptional be = new SpritesExceptional();
        MainCanvas canvas = new MainCanvas(this);
        canvas.setBackground(Color.WHITE);
        addMouseListener(this);
        Thread.setDefaultUncaughtExceptionHandler(be);
        add(canvas);
        setVisible(true);
    }

    private void fillSprites(){
        for (int i = 1; i < 14; i++) {
            sprites.add(new ImagePng());
        }
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void createSprite(){
        if(checkSpritesSize()){
            sprites.add(new ImagePng());
        }else {
            throw new SpritesException("you cannot add more than 15 hearts");
        }

    }

    public void createSprite(float x, float y){
        if(checkSpritesSize()){
            Sprite img = new ImagePng();
            img.setXY(x, y);
            sprites.add(img);
        }else {
            throw new SpritesException("you cannot add more than 15 hearts");
        }

    }

    private boolean checkSpritesSize(){
        return sprites.size() < 15;
    }

    public void removeSprite(){
        int r;
        if(sprites.size() > 1){
            r = (int) (Math.random() * (sprites.size() - 1) + 1);
            sprites.remove(sprites.get(r));
        }else if(sprites.size() == 1){
            sprites.remove(0);
        }
    }

    private void update(MainCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(canvas,g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            removeSprite();
        }else if(SwingUtilities.isLeftMouseButton(e)){
            createSprite(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
