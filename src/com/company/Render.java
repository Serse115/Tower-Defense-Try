package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {

    /**** Fields ****/
    private Game game;

    /**** Constructors ****/
    public Render(Game game) {
        this.game = game;
    }


    /**** Methods ****/
    public void render(Graphics g) {
        switch(GameStates.gameState) {

            case MENU:
                this.game.getMenu().render(g);
                break;
            case PLAYING:
                this.game.getPlaying().render(g);
                break;
            case SETTINGS:
                this.game.getSettings().render(g);
                break;
        }
    }


}
