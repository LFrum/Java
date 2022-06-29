import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Red extends LifeBar
{
    private int lifeBarHeight;
    private int lifeBarWidth = 40;
    private int counter = 0;
    private GreenfootImage lifeBarRed;    
    
    public Red()
    {
        lifeBarRed = new GreenfootImage(lifeBarWidth, 600);
        lifeBarRed.setColor(Color.RED);
        lifeBarRed.fill();
        setImage(lifeBarRed);     
    }
    
   
    public void act() 
    {      
        barLength (counter);         
    }    
    
    public void setCounter(int counter){
        this.counter = counter;
    }
    
    private void barLength(int count){
        MyWorld myWorld = (MyWorld)getWorld();       
        if (count == 1) {            
            lifeBarHeight = 400;            
            lifeBarRed = new GreenfootImage(lifeBarWidth, lifeBarHeight);
            setLocation(getX(), 650);
        }
        else if (count == 2) {
            lifeBarHeight = 200;            
            lifeBarRed = new GreenfootImage(lifeBarWidth, lifeBarHeight);
            setLocation(getX(), 750);
        }
        else if(count == 0){
            lifeBarHeight = 600;            
            lifeBarRed = new GreenfootImage(lifeBarWidth, lifeBarHeight);
            setLocation(getX(), 550);
        }
        else if(count == 3){
            myWorld.removeObject(this);
        }
        
        lifeBarRed.setColor(Color.RED);
        lifeBarRed.fill();
        setImage(lifeBarRed);          
    }    
}
