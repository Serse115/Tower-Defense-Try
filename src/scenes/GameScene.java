package scenes;

import com.company.Game;

public class GameScene {

    /**** Fields ****/
    private Game game;

    /**** Constructors ****/
    public GameScene(Game game) {
        this.game = game;

    }


    /**** Methods ****/
    public Game getGame() {
        return this.game;
    }
}
