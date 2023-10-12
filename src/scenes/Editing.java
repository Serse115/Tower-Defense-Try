package scenes;

import com.company.Game;
import helpz.LoadSave;
import objects.Tile;
import ui.ToolBar;
import java.awt.*;

public class Editing extends GameScene implements SceneMethods {

    /**** Fields ****/
    private int[][] lvl;
    private Tile selectedTile;
    private int mouseX;
    private int mouseY;
    private int lastTileX;
    private int lastTileY;
    private int lastTileId;
    private boolean drawSelect;
    private ToolBar toolBar;



    /**** Constructors ****/
    public Editing(Game game) {
        super(game);
        this.toolBar = new ToolBar(0, 640, 640, 100, this);
    }


    /**** Methods ****/
    @Override
    public void render(Graphics g) {

        this.toolBar.draw(g);
        this.drawSelectedTile(g);
    }

    public Game getGame() {
        return super.getGame();
    }

    @Override
    public void mouseClicked(int x, int y) {

        if (y >= 640) {
            this.toolBar.mouseClicked(x, y);
        }
        else {
            this.changeTile(this.mouseX, this.mouseY);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {

        if (y >= 640) {
            this.toolBar.mouseMoved(x, y);
            this.drawSelect = false;
        }
        else {
            this.drawSelect = true;
            this.mouseX = (x / 32) * 32;
            this.mouseY = (y / 32) * 32;
        }
    }

    @Override
    public void mousePressed(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {

        this.toolBar.mouseReleased(x, y);
    }

    @Override
    public void mouseDragged(int x, int y) {

        if (y >= 640) {

        }
        else {
            this.changeTile(x, y);
        }
    }

    public void drawSelectedTile(Graphics g) {
        if (this.selectedTile != null && this.drawSelect) {
            g.drawImage(this.selectedTile.getSprite(), this.mouseX, this.mouseY, 32, 32, null);
        }
    }

    public void saveLevel() {

        LoadSave.saveLevel("new_level", this.lvl);
    }

    public void setSelectedTile(Tile tile) {
        this.selectedTile = tile;
        this.drawSelect = true;
    }

    private void changeTile(int x, int y) {

        if (this.selectedTile != null) {
            int tileX = x / 32;
            int tileY = y / 32;

            if (this.lastTileX == tileX && this.lastTileY == tileY && this.lastTileId == this.selectedTile.getId()) {
                return;
            }

            this.lastTileX = x;
            this.lastTileY = y;
            this.lastTileId = this.selectedTile.getId();

            this.lvl[tileY][tileX] = this.selectedTile.getId();
        }
    }
}