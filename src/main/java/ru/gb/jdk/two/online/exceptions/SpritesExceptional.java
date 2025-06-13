package ru.gb.jdk.two.online.exceptions;

import ru.gb.jdk.two.online.common.CanvasMouseListener;

import javax.swing.*;

import java.awt.event.MouseEvent;
import ru.gb.jdk.two.online.pngApp.MainWindow;
//import ru.gb.jdk.two.online.circles.MainWindow;


public class SpritesExceptional implements Thread.UncaughtExceptionHandler {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception!", JOptionPane.ERROR_MESSAGE);
    }
}
