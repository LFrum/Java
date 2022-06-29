import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class White extends LifeBar
{
    private int lifeBarHeight = 600;
    private int lifeBarWidth = 40;
    private int counter = 0;    
    
    public White()
    {
        GreenfootImage lifeBarWhite = new GreenfootImage(lifeBarWidth, lifeBarHeight);  
        lifeBarWhite.setColor(Color.WHITE);
        lifeBarWhite.fill();
        setImage(lifeBarWhite);
    }  
}
