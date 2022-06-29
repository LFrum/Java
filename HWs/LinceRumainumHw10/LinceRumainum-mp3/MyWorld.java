import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 88x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject (new StartButton(), 200, 300);
        addObject (new VolumeUp(), 600, 200);
        addObject (new VolumeDown(), 600, 450);
    }
}
