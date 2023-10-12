package objects;

import java.awt.image.BufferedImage;

public class Tile {

    /**** Fields ****/
    private BufferedImage sprite;
    private int id;
    private String name;


    /**** Constructors ****/
    public Tile(BufferedImage sprite, int id, String name) {
        this.sprite = sprite;
        this.id = id;
        this.name = name;
    }


    /**** Methods ****/
    public BufferedImage getSprite() {
        return this.sprite;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}