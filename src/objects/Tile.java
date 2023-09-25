package objects;

import java.awt.image.BufferedImage;

public class Tile {

    /**** Fields ****/
    private BufferedImage sprite;


    /**** Constructors ****/
    public Tile(BufferedImage sprite) {
        this.sprite = sprite;
    }


    /**** Methods ****/
    public BufferedImage getSprite() {
        return this.sprite;
    }
}
