import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coffee extends Drinks
{
    private int dropRate; 
    private GreenfootImage coffee = getImage();
    
    public Coffee(){
        dropRate = 2;
        coffee.scale(coffee.getWidth()/20, coffee.getHeight()/20);
    }  
    
    public void act(){
        turn(3);
        setLocation(getX(), getY() + dropRate);
        removeItem();
    }
}
