import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Yuk
{
    private int dropRate;
    private int shiftRate;
    private GreenfootImage apple = getImage();
    
    public Apple(){
        shiftRate = -8 + Greenfoot.getRandomNumber(16);
        dropRate = 3 + Greenfoot.getRandomNumber(3);
        apple.scale(apple.getWidth()/4, apple.getHeight()/4);
    }  

    public void act() 
    {
        turn(5);
        changeShiftRate();
        setLocation(getX()+shiftRate, getY() + dropRate);
        remove();  
    }    
    
    private void changeShiftRate(){
        if (isAtEdge()){
            shiftRate = - shiftRate;
        }
    }
}
