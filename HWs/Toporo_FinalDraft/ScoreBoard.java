import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class ScoreBoard extends Actor
{
    private int theScore;
    private GreenfootImage imgScore;
    
    public ScoreBoard(){
        theScore = 0;
        scoreBoard();
    }
    
    public void act() 
    {
        scoreBoard();
    } 
    
    public int getScore(){
        return theScore;
    }
    
    public void setScore(int theScore){
        this.theScore = theScore;
    }
    
    private void scoreBoard(){
        imgScore = new GreenfootImage("Score: " + theScore, 50, Color.YELLOW, Color.BLUE);
        setImage(imgScore);
    }
}
