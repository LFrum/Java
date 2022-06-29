import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cookie extends Yummy
{
    private GreenfootImage cookie = getImage();
    private int dropRate;
    
    public Cookie(){
        dropRate = 3;
        cookie.scale(cookie.getWidth()/10, cookie.getHeight()/10);
    }
    

    public void act() 
    {
        turn(2);
        setLocation(getX(), getY() + dropRate);
        removeItem();
    }    
}
