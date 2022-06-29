import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cabbage extends Yuk
{
    private GreenfootImage cabbage = getImage();
    private int dropRate;
    
    public Cabbage(){
        dropRate = 4;
        cabbage.scale(cabbage.getWidth()/3, cabbage.getHeight()/3);
    }
    
    public void act() 
    {
        turn(3);
        setLocation(getX(), getY() + dropRate);
        remove();    
    }    
}
