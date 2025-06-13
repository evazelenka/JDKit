package ru.gb.jdk.two.online.circles;

import ru.gb.jdk.two.online.common.CanvasMouseListener;
import ru.gb.jdk.two.online.common.CanvasRepaintListener;
import ru.gb.jdk.two.online.common.Interactable;
import ru.gb.jdk.two.online.common.MainCanvas;
import ru.gb.jdk.two.online.exceptions.BallsExceptional;
import ru.gb.jdk.two.online.exceptions.CirclesException;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class MainWindow extends JFrame implements CanvasRepaintListener{
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private final ArrayList<Interactable> sprites = new ArrayList<>();

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        sprites.add(new Background());
//        fillSpites();

        BallsExceptional be = new BallsExceptional(this);
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(be);
        Thread.setDefaultUncaughtExceptionHandler(be);
        add(canvas);
        setVisible(true);
    }

    private void fillSpites(){
        for (int i = 1; i < 14; i++) {
            sprites.add(new Ball());
        }
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void createBall(){
        if(checkSpritesSize()){
            sprites.add(new Ball());
        }else {
            throw new CirclesException("you cannot add more than 15 circles");
        }

    }

    private boolean checkSpritesSize(){
        return sprites.size() <= 15;
    }

    public void removeBall(){
        int r;
        if(sprites.size() > 1){
            r = (int) (Math.random() * (sprites.size() - 1) + 1);
            sprites.remove(sprites.get(r));
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
}
