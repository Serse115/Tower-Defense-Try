package com.company;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import javax.swing.JPanel;
import java.awt.*;

/***** Game Screen Class *****/
public class GameScreen extends JPanel {

    /**** Fields ****/
    private Dimension size;
    private Game game;
    private MyMouseListener myMouseListener;
    private KeyboardListener keyboardListener;


    /**** Constructors ****/
    public GameScreen(Game game) {
        this.game = game;

        this.setPanelSize();

    }


    /**** Methods ****/
    private void setPanelSize() {
        this.size = new Dimension(640, 740);
        super.setMinimumSize(this.size);
        super.setPreferredSize(this.size);
        super.setMaximumSize(this.size);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.game.getRender().render(g);


    }

    public void initInputs() {
        this.myMouseListener = new MyMouseListener(this.game);
        this.keyboardListener = new KeyboardListener();

        super.addMouseListener(this.myMouseListener);
        super.addMouseMotionListener(this.myMouseListener);
        super.addKeyListener(this.keyboardListener);

        super.requestFocus();
    }

    // Calculates the number of FPS per second
    private void callFPS() {
        }




}