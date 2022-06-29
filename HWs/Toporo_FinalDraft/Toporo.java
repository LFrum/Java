import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Toporo extends Actor
{
    private GreenfootImage defaultToporo = getImage();
    private GreenfootImage phase2 = new GreenfootImage("Toporo_Full.png");
    private GreenfootImage thirsty = new GreenfootImage("Toporo_LowHealth.png");
    private int speed;
    private int Width = defaultToporo.getWidth()/3;
    private int Height = defaultToporo.getHeight()/3;
    MyWorld world = (MyWorld)getWorld();
    
    public Toporo(){
        speed = 5;
        defaultToporo.scale(Width, Height);
        thirsty.scale(Width, Height);
        phase2.scale(Width, Height);
    }


    public void act() 
    {
        MyWorld world = (MyWorld)getWorld();
        // Add your action code here.
        if (Greenfoot.isKeyDown("left")){
            move(-speed);
        }
        else if (Greenfoot.isKeyDown("right")){
            move(speed);
        }
        
        if(isTouching(Cookie.class)){
            world.increaseScore();
            Greenfoot.playSound("cookie.mp3");
            removeTouching(Cookie.class);
        }
        
        if(isTouching(IceCream.class)){
            world.increaseScore();
            world.increaseScore();
            Greenfoot.playSound("ice cream.mp3");
            removeTouching(IceCream.class);
        }    
        
        if(isTouching(Apple.class)){
            world.setNumberOfHeathTouched();
            Greenfoot.playSound("apple.mp3");
            removeTouching(Apple.class);
        }
        
        if(isTouching(Cabbage.class)){
            Greenfoot.playSound("cabbage.mp3");
            world.setNumberOfHeathTouched();
            removeTouching(Cabbage.class);
        }
        
        if(isTouching(Coffee.class)){
            Greenfoot.playSound("coffee.mp3");
            world.makeFaster();
            for(int i =0; i<5; ++i){
                world.increaseScore();
            }
            removeTouching(Coffee.class);
        }
        
        if(isTouching(Water.class)){
            world.decreaseHeath();
            Greenfoot.playSound("water.mp3");
            removeTouching(Water.class);
        }
    }  
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void switchImage(int option){
        if(option == 1){
            setImage(defaultToporo);          
        }
        if(option == 2){
            setImage(phase2);
        }
        if(option == 3){
            setImage(thirsty);
        }
    }
}
