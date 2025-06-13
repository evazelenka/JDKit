package ru.gb.jdk.two.online.exceptions;

import ru.gb.jdk.two.online.common.CanvasMouseListener;

import javax.swing.*;

import java.awt.event.MouseEvent;
import ru.gb.jdk.two.online.circles.MainWindow;


public class BallsExceptional implements Thread.UncaughtExceptionHandler, CanvasMouseListener {
    MainWindow main;
    public BallsExceptional(MainWindow main){
        this.main = main;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception!", JOptionPane.ERROR_MESSAGE);
        }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            main.removeBall();
        }else if(SwingUtilities.isLeftMouseButton(e)){
            main.createBall();
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
