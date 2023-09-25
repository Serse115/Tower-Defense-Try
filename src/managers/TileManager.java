package managers;

import helpz.LoadSave;
import objects.Tile;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {

    /**** Fields ****/
    public Tile GRASS;
    public Tile WATER;
    public Tile ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();


    /**** Constructors ****/
    public TileManager() {
        this.loadAtlas();
        this.createTiles();
    }

    private void loadAtlas() {
        this.atlas = LoadSave.getSpriteAtlas();
    }

    private void createTiles() {
        this.tiles.add(GRASS = new Tile(this.getSprite(9, 0)));
        this.tiles.add(WATER = new Tile(this.getSprite(0, 0)));
        this.tiles.add(ROAD = new Tile(this.getSprite(7, 0)));
    }

    private BufferedImage getSprite(int xCord, int yCord) {
        return this.atlas.getSubimage(xCord * 32, yCord * 32, 32,32);
    }

    public BufferedImage getSprite(int id) {
        return this.tiles.get(id).getSprite();
    }
}
