import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IceCream extends Yummy
{
    private int dropRate;
    private int shiftRate;
    private int rotate;
    private GreenfootImage iceCream = getImage();
    
    public IceCream(){
        shiftRate = -8 + Greenfoot.getRandomNumber(16);
        dropRate = 3 + Greenfoot.getRandomNumber(4);
        rotate = Greenfoot.getRandomNumber(9)+1;
        iceCream.scale(iceCream.getWidth()/10, iceCream.getHeight()/10);
    }
    
    public void act() 
    {
        turn(2);
        changeShiftRate();
        setLocation(getX()+shiftRate, getY() + dropRate);
        removeItem();
    }   
    
    private void changeShiftRate(){
        if (isAtEdge()){
            shiftRate = - shiftRate;
        }
    }
}
