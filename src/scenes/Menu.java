package scenes;

import com.company.Game;
import ui.MyButton;
import java.awt.*;
import java.util.Random;
import static com.company.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

    /**** Fields ****/
    private Random random;
    private MyButton bPlaying;
    private MyButton bEdit;
    private MyButton bSettings;
    private MyButton bQuit;


    /**** Constructors ****/
    public Menu(Game game) {
        super(game);
        this.random = new Random();
        this.initButtons();
    }


    /**** Methods ****/
    private void initButtons() {

        int w = 150;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y = 150;
        int yOffset = 100;

        this.bPlaying = new MyButton("Play", x, y, w, h);
        this.bEdit = new MyButton("Edit", x, y + yOffset, w, h);
        this.bSettings = new MyButton("Settings", x, y + yOffset * 2, w, h);
        this.bQuit = new MyButton("Quit", x, y + yOffset * 3, w, h);
    }

    @Override
    public void render(Graphics g) {
        this.drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (this.bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAYING);
        }
        else if (this.bSettings.getBounds().contains(x, y)) {
            SetGameState(SETTINGS);
        }
        else if (this.bQuit.getBounds().contains(x, y)) {
            System.exit(0);
        }
        else if (this.bEdit.getBounds().contains(x, y)) {
            SetGameState(EDIT);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        this.bPlaying.setMouseOver(false);
        this.bEdit.setMouseOver(false);
        this.bSettings.setMouseOver(false);
        this.bQuit.setMouseOver(false);

        if (this.bPlaying.getBounds().contains(x, y)) {
            this.bPlaying.setMouseOver(true);
        }
        else if (this.bSettings.getBounds().contains(x, y)) {
            this.bSettings.setMouseOver(true);
        }
        else if (this.bQuit.getBounds().contains(x, y)) {
            this.bQuit.setMouseOver(true);
        }
        else if (this.bEdit.getBounds().contains(x, y)) {
            this.bEdit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {

        if (this.bPlaying.getBounds().contains(x, y)) {
            this.bPlaying.setMousePressed(true);
        }
        else if (this.bSettings.getBounds().contains(x, y)) {
            this.bSettings.setMousePressed(true);
        }
        else if (this.bQuit.getBounds().contains(x, y)) {
            this.bQuit.setMousePressed(true);
        }
        else if (this.bEdit.getBounds().contains(x, y)) {
            this.bEdit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        this.resetButtons();
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    private void resetButtons() {
        this.bPlaying.resetBooleans();
        this.bSettings.resetBooleans();
        this.bQuit.resetBooleans();
        this.bEdit.resetBooleans();
    }

    private void drawButtons(Graphics g) {
        this.bPlaying.draw(g);
        this.bEdit.draw(g);
        this.bSettings.draw(g);
        this.bQuit.draw(g);
    }

    private int getRandomInt() {
        return random.nextInt(20);
    }
}