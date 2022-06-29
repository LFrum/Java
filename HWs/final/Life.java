import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Life extends Actor
{
    private int score = 520;
    private GreenfootImage lifeBar = new GreenfootImage(20, 520);
    public Life()
    { 
        lifeBar.setColor(Color.RED);
        lifeBar.fill();
        setImage(lifeBar);
    }
    
    public void act() 
    {
        drop(score);
    }    
    
    private void drop(int count)
    {
        lifeBar = new GreenfootImage(20, count);
        lifeBar.setColor(Color.RED);
        lifeBar.fill();
        setImage(lifeBar);
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public void moveDown()
    {
        setLocation(getX(), getY()+1);
    }
}
