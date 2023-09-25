package ui;

import inputs.MyMouseListener;
import scenes.SceneMethods;

import java.awt.*;
import static com.company.GameStates.*;
import static com.company.GameStates.SetGameState;


public class BottomBar {

    /**** Fields ****/
    private int x;
    private int y;
    private int width;
    private int height;
    private MyButton bMenu;


    /**** Constructors ****/
    public BottomBar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.initButtons();
    }


    /**** Methods ****/
    public void draw(Graphics g) {

        // Background
        g.setColor(new Color(220, 123, 15));
        g.fillRect(x, y, width, height);

        // Buttons
        this.drawButtons(g);
    }


    public void mouseClicked(int x, int y) {
        System.out.println("Coordinates: " + x + " " + y);
        if (this.bMenu.getBounds().contains(x, y)) {
            System.out.println("Menu button clicked!");
            SetGameState(MENU);
        }
    }


    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);

        if (this.bMenu.getBounds().contains(x, y)) {
            this.bMenu.setMouseOver(true);
        }
    }


    public void mousePressed(int x, int y) {

        if (this.bMenu.getBounds().contains(x, y)) {
            this.bMenu.setMousePressed(true);
        }
    }


    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();

    }

    private void initButtons() {
        this.bMenu = new MyButton("Menu", 2, 642, 100, 30);
    }

    private void drawButtons(Graphics g) {
        this.bMenu.draw(g);
    }
}