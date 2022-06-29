import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameBoard extends Actor
{
    private GreenfootImage board = getImage();
    private int Height = board.getHeight()*2/3;
    private int Width = board.getWidth()*2/3;
    
    public GameBoard(){
        board.scale(Width, Height);   
    }
}
