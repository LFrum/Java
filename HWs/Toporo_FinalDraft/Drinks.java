import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Drinks extends Actor
{
    public void removeItem() 
    {
       MyWorld world = (MyWorld)getWorld();      
        if(getY() == world.getHeight() - 10){
            world.removeObject(this);
        }    
    }   
}
