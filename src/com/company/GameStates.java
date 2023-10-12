package com.company;

public enum GameStates {

    PLAYING,  MENU,  SETTINGS, EDIT;

    public static GameStates gameState = MENU;

    public static void SetGameState(GameStates state) {
        gameState = state;
    }
}
