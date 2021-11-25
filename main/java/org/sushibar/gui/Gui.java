package org.sushibar.gui;

import javax.swing.*;
import java.awt.*;

import org.sushibar.resources.MovingTableResource;

public class Gui {
    private JFrame frame;
    private JTextArea textArea;
    private MovingTableResource movingTableResource;

    public Gui(MovingTableResource movingTableResource) throws InterruptedException {
        this.movingTableResource = movingTableResource;
        guiInit();
        while (true){
            movingTableResource.moveLine();
            Thread.sleep(50);
            updateScreen();
        }
    }

    private void guiInit() {
        initComponents();
        frame.setSize(370, 250);
        frame.setResizable(false);
        textArea.setEditable(false);
        textArea.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        frame.add(textArea);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        frame = new JFrame("sushi bar");
        textArea = new JTextArea();
    }

    public void updateScreen() {
        frame.remove(textArea);
        textArea.setText("");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 36; j++) {
                textArea.append(Character.toString(movingTableResource.getSushiBar()[i][j]));
            }
            textArea.append("\n");
        }
        frame.add(textArea);
        frame.revalidate();
        frame.repaint();
    }
}
