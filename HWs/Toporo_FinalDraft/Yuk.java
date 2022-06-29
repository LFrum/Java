import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Yuk extends Actor
{    
    public void remove() 
    {
        MyWorld world = (MyWorld)getWorld();
        
        if(getY() == world.getHeight() - 10){
            world.removeObject(this);
        }     
    }    
}
