package ui;

import java.awt.*;

public class MyButton {

    /**** Fields ****/
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean mouseOver;
    private boolean mousePressed;
    private String text;
    private Rectangle bounds;    // Rectangle is a class that checks if the mouse is inside the rectangle's bounds


    /**** Constructors ****/
    public MyButton(String text, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.text = text;

        this.initBounds();
    }


    /**** Methods ****/
    public void draw(Graphics g) {

        // Body
        this.drawBody(g);


        // Border
        this.drawBorder(g);

        // Text
        this.drawText(g);
    }

    public void draw(Graphics g, int i) {

        if (i == 1) {
            // Body
            this.drawBody(g);

            // Border
            this.drawBorder(g);

            // Text
            this.drawText(g);
        }
    }


    private void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);

        if (this.mousePressed) {
            g.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2);
            g.drawRect(this.x + 2, this.y + 2, this.width - 4, this.height - 4);
        }
    }

    public void resetBooleans() {
        this.mouseOver = false;
        this.mousePressed = false;
    }

    private void drawBody(Graphics g) {
        if (this.mouseOver) {
            g.setColor(Color.GRAY);
        }
        else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    private void initBounds() {
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }

    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(this.text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(this.text, this.x - w / 2 + this.width / 2, this.y + h / 2 + this.height / 2 - 2);
    }


    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
}