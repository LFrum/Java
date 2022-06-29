import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Water extends Drinks
{
    private int dropRate;
    private GreenfootImage water = getImage();
    
    public Water(){
        dropRate = 4;
        water.scale(water.getWidth()/10, water.getHeight()/10);
    }   
    
    public void act(){
        turn(5);
        setLocation(getX(), getY() + dropRate);
        removeItem();
    }
}
