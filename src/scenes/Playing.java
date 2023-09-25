package scenes;

import com.company.Game;
import helpz.LevelBuild;
import managers.TileManager;
import ui.BottomBar;
import java.awt.*;

public class Playing extends GameScene implements SceneMethods {

    /**** Fields ****/
    private int[][] lvl;
    private TileManager tileManager;
    private BottomBar bottomBar;


    /**** Constructors ****/
    public Playing(Game game) {
        super(game);

        this.lvl = LevelBuild.getLevelData();
        this.tileManager = new TileManager();
        this.bottomBar = new BottomBar(0, 640, 640, 150);
    }


    /**** Methods ****/
    @Override
    public void render(Graphics g) {

        for (int y = 0; y < this.lvl.length; y++) {
            for (int x = 0; x < this.lvl[y].length; x++) {
                int id = lvl[y][x];
                 g.drawImage(this.tileManager.getSprite(id), x * 32, y * 32, null);
            }
        }
        this.bottomBar.draw(g);

    }

    @Override
    public void mouseClicked(int x, int y) {

        if (y >= 640) {
            this.bottomBar.mouseClicked(x, y);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {

        if (y >= 640) {
            this.bottomBar.mouseMoved(x, y);
        }
    }

    @Override
    public void mousePressed(int x, int y) {

        if (y >= 640) {
            this.bottomBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {

        this.bottomBar.mouseReleased(x, y);
    }
}