import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    private static final GreenfootSound mySound = new GreenfootSound("Twinkle-twinkle-little-star-piano.mp3");
    private static int volumeLevel = 60;
    
    public static GreenfootSound getMySound(){
        return mySound;    
    }
    
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //Play sound and change button to pause button
        if (!mySound.isPlaying() && Greenfoot.mouseClicked(this)) { 
            mySound.play();
            setImage(new GreenfootImage("PauseButton.png"));
        }
        //Pause sound and change button back to start button
        else if (mySound.isPlaying() && Greenfoot.mouseClicked(this)){
            mySound.pause();
            setImage(new GreenfootImage("play-button.jpg"));
        }
        
        //Increase volume
        if (!mySound.isPlaying() && Greenfoot.mouseClicked(VolumeUp.class)) {
            volumeLevel += 5;
            mySound.setVolume(volumeLevel);
        }
        //Decrease volume
        else if (mySound.isPlaying() && Greenfoot.mouseClicked(VolumeDown.class)){
            volumeLevel -= 5;
            mySound.setVolume(volumeLevel);
        }
    }    
}
