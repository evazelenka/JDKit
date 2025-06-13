package ru.gb.jdk.two.online.circles;

import ru.gb.jdk.two.online.common.CanvasMouseListener;
import ru.gb.jdk.two.online.common.CanvasRepaintListener;
import ru.gb.jdk.two.online.common.Interactable;
import ru.gb.jdk.two.online.common.MainCanvas;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class MainWindow extends JFrame implements CanvasRepaintListener, CanvasMouseListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private final ArrayList<Interactable> sprites = new ArrayList<>();

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        fillSpites();

        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(this);
        add(canvas);
        setVisible(true);
    }

    private void fillSpites(){
        sprites.add(new Background());
        for (int i = 1; i < 5; i++) {
            sprites.add(new Ball());
        }
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void createBall(){
       sprites.add(new Ball());
        System.out.println(sprites.size() +" "+ new Random(5).nextInt());
    }

    private void removeBall(){
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
        new MainWindow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            createBall();
        }else if(SwingUtilities.isLeftMouseButton(e)){
            removeBall();
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
