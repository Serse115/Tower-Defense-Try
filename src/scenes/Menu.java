package scenes;

import com.company.Game;
import ui.MyButton;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import static com.company.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

    /**** Fields ****/
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;
    private MyButton bPlaying;
    private MyButton bSettings;
    private MyButton bQuit;


    /**** Constructors ****/
    public Menu(Game game) {
        super(game);
        this.random = new Random();
        this.importImg();
        this.loadSprites();
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
        this.bSettings = new MyButton("Settings", x, y + yOffset, w, h);
        this.bQuit = new MyButton("Quit", x, y + yOffset * 2, w, h);
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
    }

    @Override
    public void mouseMoved(int x, int y) {
        this.bPlaying.setMouseOver(false);
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
    }

    @Override
    public void mouseReleased(int x, int y) {
        this.resetButtons();
    }

    private void resetButtons() {
        this.bPlaying.resetBooleans();
        this.bSettings.resetBooleans();
        this.bQuit.resetBooleans();
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/aspriteatlas.png");

        try {
            this.img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawButtons(Graphics g) {
        this.bPlaying.draw(g);
        this.bSettings.draw(g);
        this.bQuit.draw(g);
    }

    private void loadSprites() {

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 10; i++) {
                sprites.add(img.getSubimage(i * 32, j * 32, 32, 32));
            }
        }
    }

    private int getRandomInt() {
        return random.nextInt(20);
    }
}
