package com.company;

import helpz.LoadSave;
import managers.TileManager;
import scenes.Editing;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;
import javax.swing.JFrame;

/***** Game Class *****/
public class Game extends JFrame implements Runnable {

    /**** Fields ****/
    private GameScreen gameScreen;
    private Thread gameThread;
    public GameScreen gameScreenz;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;
    private Editing editing;
    private TileManager tileManager;



    /**** Constructors ****/
    public Game() {
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);          // Close operation
        super.setLocation(300, 50);                      // Locate the frame to the center of the screen
        super.setResizable(false);

        this.initClasses();
        this.createDefaultLevel();
        this.tileManager = new TileManager();

        add(gameScreen);

        super.pack();
        super.setVisible(true);
    }


    /**** Methods ****/
    public void start() {
        this.gameThread = new Thread(this);

        this.gameThread.start();
    }

    private void updateGame() {
        //
    }

    private void createDefaultLevel() {

        int[]arr = new int[400];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        LoadSave.CreateLevel("new_level", arr);
    }

    @Override
    public void run() {

        double timePerFrame= 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;


        while (true) {

            now = System.nanoTime();

            if (now - lastFrame >= timePerFrame) {
                super.repaint();
                lastFrame = now;
                frames++;
            }

            if (now - lastUpdate >= timePerUpdate) {
                this.updateGame();
                lastUpdate = now;
                updates++;
            }

            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }

    public Render getRender() {
        return this.render;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public Settings getSettings() {
        return this.settings;
    }

    public Playing getPlaying() {
        return this.playing;
    }

    public Editing getEditing() {
        return this.editing;
    }

    public TileManager getTileManager() {
        return this.tileManager;
    }

    private void initClasses() {

        this.render = new Render(this);
        this.gameScreen = new GameScreen(this);
        this.gameScreenz = gameScreen;
        this.menu = new Menu(this);
        this.playing = new Playing(this);
        this.settings = new Settings(this);
        this.editing = new Editing(this);
    }
}