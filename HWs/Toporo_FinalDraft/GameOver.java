import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

public class GameOver extends Actor
{
    private static final int WIDTH =800;
    private static final int HEIGHT = 600;
    private int score;
    MyWorld world = (MyWorld)getWorld();
    
    public void act(){
        showScore(score);
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    private void showScore(int score){
        GreenfootImage text = new GreenfootImage(WIDTH, HEIGHT);
        Font font = text.getFont();
        font = font.deriveFont(96.0f);
        text.setFont(font);
        text.setColor(Color.BLACK);
        text.drawString("  Game Over", 100 , 300);
        text.drawString("Final Score: " + score, 100 , 400);
        setImage(text);        
    }
}
