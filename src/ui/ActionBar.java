package ui;

import scenes.Playing;
import java.awt.*;
import static com.company.GameStates.*;
import static com.company.GameStates.SetGameState;

public class ActionBar extends Bar {

    /**** Fields ****/
    private int x;
    private int y;
    private int width;
    private int height;
    private MyButton bMenu;
    private Playing playing;


    /**** Constructors ****/
    public ActionBar(int x, int y, int width, int height, Playing playing) {
        super(x, y, width, height);
        this.playing = playing;
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

        if (this.bMenu.getBounds().contains(x, y)) {
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