import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int count = 0;
    Life lifeBar = new Life();
    public MyWorld()
    {    
        super(1500, 800, 1); 
        addObject(lifeBar, 1460, 530);
        
    }
    
    public void getCount()
    {
        count += 2;
        lifeBar.moveDown();
    }
    
    public void act()
    {
        lifeBar.setScore(520-count);
        if (Greenfoot.getRandomNumber(100)<2)
        {
            addObject(new Cake(), Greenfoot.getRandomNumber(1480)+10, 0);
        }   
        
        if(count>=500)
        {
            Greenfoot.stop();
        }
    }    
}
