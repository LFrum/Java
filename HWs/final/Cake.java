import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cake extends Actor
{
    
    private int dropRate;
    private GreenfootImage cake = getImage();
    public Cake()
    {
        dropRate = 2;
        cake.scale(cake.getWidth()/10, cake.getHeight()/10);
    }
    
    public void act() 
    {
        turn(2);
        setLocation(getX(), getY()+dropRate);
        MyWorld worldplace = (MyWorld)getWorld();
        if(getY() > 790){
            MyWorld world = (MyWorld)getWorld();
            world.removeObject(this);  
            worldplace.getCount();
        }
    }   
}
