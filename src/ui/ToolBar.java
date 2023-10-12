package ui;

import objects.Tile;
import scenes.Editing;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static com.company.GameStates.MENU;
import static com.company.GameStates.SetGameState;

public class ToolBar extends Bar {

    /**** Fields ****/
    private MyButton bMenu;
    private MyButton bSave;
    private ArrayList<MyButton> tileButtons = new ArrayList<>();
    private Tile selectedTile;
    private Editing editing;



    /**** Constructors ****/
    public ToolBar(int x, int y, int width, int height, Editing editing) {
        super(x, y, width, height);
        this.editing = editing;
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

    private void saveLevel() {
        this.editing.saveLevel();
    }

    private void initButtons() {
        this.bMenu = new MyButton("Menu", 2, 642, 100, 30);
        this.bSave = new MyButton("Save",2, 674, 100, 30);

        int w = 50;
        int h = 50;
        int xStart = 110;
        int yStart = 650;
        int xOffset = (int)(w * 1.1f);

        int i = 0;
        for (Tile tile : this.editing.getGame().getTileManager().tiles) {

            this.tileButtons.add(new MyButton(tile.getName(), xStart + xOffset * i, yStart, w, h, i));
            i++;
        }
    }

    private void drawButtons(Graphics g) {
        this.bMenu.draw(g);
        this.bSave.draw(g);

        this.drawTileButtons(g);
        this.drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g) {
        if (this.selectedTile != null) {

            g.drawImage(this.selectedTile.getSprite(), 550, 650, 50, 50, null);
            g.setColor(Color.BLACK);
            g.drawRect(550, 650, 50, 50);
        }
    }

    private void drawTileButtons(Graphics g) {
        for (MyButton b : this.tileButtons) {

            // Sprite image
            g.drawImage(this.getButtImage(b.getId()), b.x, b.y, b.width, b.height, null);

            // MouseOver
            if (b.isMouseOver()) {
                g.setColor(Color.WHITE);
            }
            else {
                g.setColor(Color.BLACK);
            }

            // Border
            g.drawRect(b.x, b.y, b.width, b.height);

            // Mouse pressed
            if (b.isMousePressed()) {
                g.drawRect(b.x + 1, b.y + 1, b.width - 2, b.height - 2);
                g.drawRect(b.x + 2, b.y + 2, b.width - 4, b.height - 4);
            }
        }
    }

    public BufferedImage getButtImage(int id) {
        return(this.editing.getGame().getTileManager().getSprite(id));
    }

    public void mouseClicked(int x, int y) {

        if (this.bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
        }
        else if (this.bSave.getBounds().contains(x, y)) {
            this.saveLevel();
        }
        else {
            for (MyButton b : this.tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    this.selectedTile = this.editing.getGame().getTileManager().getTile(b.getId());
                    this.editing.setSelectedTile(this.selectedTile);
                    return;
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(false);
        this.bSave.setMouseOver(false);
        for (MyButton b : this.tileButtons) {
            b.setMouseOver(false);
        }

        if (this.bMenu.getBounds().contains(x, y)) {
            this.bMenu.setMouseOver(true);
        }
        else if (this.bSave.getBounds().contains(x, y)) {
            this.bSave.setMouseOver(true);
        }
        else {
            for (MyButton b: this.tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMouseOver(true);
                    return;
                }
            }
        }
    }


    public void mousePressed(int x, int y) {

        if (this.bMenu.getBounds().contains(x, y)) {
            this.bMenu.setMousePressed(true);
        }
        else if (this.bSave.getBounds().contains(x, y)) {
            this.bSave.setMousePressed(true);
        }
        else {
            for (MyButton b: this.tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMousePressed(true);
                    return;
                }
            }
        }
    }

    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();
        this.bSave.resetBooleans();
        for (MyButton b : this.tileButtons) {
            b.resetBooleans();
        }
    }
}
