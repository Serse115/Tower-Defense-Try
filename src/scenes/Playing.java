package scenes;

import com.company.Game;
import helpz.LevelBuild;
import helpz.LoadSave;
import ui.ActionBar;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Playing extends GameScene implements SceneMethods {

    /**** Fields ****/
    private int[][] lvl;
    private ActionBar bottomBar;
    private int mouseX;
    private int mouseY;
    private int lastTileX;


    /**** Constructors ****/
    public Playing(Game game) {
        super(game);
        this.loadDefaultLevel();
        this.lvl = LevelBuild.getLevelData();
        this.bottomBar = new ActionBar(0, 640, 640, 100, this);

        // LoadSave.CreateFile();
        // LoadSave.WriteToFile();
        // LoadSave.ReadFromFile();
    }


    /**** Methods ****/
    private void loadDefaultLevel() {
        this.lvl = LoadSave.GetLevelData("new_level");
    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < this.lvl.length; y++) {
            for (int x = 0; x < this.lvl[y].length; x++) {
                int id = lvl[y][x];
                 g.drawImage(this.getSprite(id), x * 32, y * 32, null);
            }
        }
        this.bottomBar.draw(g);
    }

    private BufferedImage getSprite(int spriteId) {
        return super.getGame().getTileManager().getSprite(spriteId);
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
        else {
            this.mouseX = (x / 32) * 32;
            this.mouseY = (y / 32) * 32;
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

    @Override
    public void mouseDragged(int x, int y) {

    }
}