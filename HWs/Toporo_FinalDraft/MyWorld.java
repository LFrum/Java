import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private static final int WIDTH = 1500;
    private static final int HEIGHT = 850;
    private static final int MAX_WIDTH = WIDTH - 200; //200 pixels of the width will not have objects drop
    private static final int START_DROP_POSITION_Y = 0;
    
    private int numberOfHealthTouched;   
    private int upperLimitOfCookies;
    private int upperLimitOfIceCreams;
    private int upperLimitOfApple;
    private int upperLimitOfCabbage;
    private int upperLimitOfCoffee;
    private int upperLimitOfWater;
    private int theScore;
    private boolean fast;
    private int timer;
    
    White lifeBarWhite = new White();
    Red lifeBarRed = new Red();
    ScoreBoard score = new ScoreBoard();
    Toporo face = new Toporo();
    GameBoard board = new GameBoard();
    GameOver over = new GameOver();
    GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");

    public MyWorld()
    {    
        super(WIDTH, HEIGHT, 1); 
        numberOfHealthTouched = 0;
        upperLimitOfCookies = 10;
        upperLimitOfIceCreams = 10;
        upperLimitOfApple = 3;
        upperLimitOfCabbage = 2;
        upperLimitOfCoffee = 1;
        upperLimitOfWater = 1;
        theScore = 0;
        fast = false;
        timer = 500;
        setBackground("Background.png");
        addObject(face, WIDTH/2, HEIGHT-60);
        addObject(lifeBarWhite, 1460, 550);
        addObject(lifeBarRed, 1460, 550);
        addObject(score, 1350, 50);
    }
    
    public void makeFaster(){
        face.setSpeed(10);
        fast = true;
    }
    
    public void setTime(){
        if(fast == true && timer > 0){
            timer--;
        }
        else{
            timer = 500;
            face.setSpeed(5);
            fast = false;
        }
    }
    
    public void started(){
        backgroundMusic.play();
    }
    public void stoped(){
        backgroundMusic.pause();
    }
    public int getNumberOfHeathTouched() {
        return numberOfHealthTouched;
    }  
    public void setNumberOfHeathTouched(){
        if(numberOfHealthTouched < 3){
            numberOfHealthTouched++;
        }
    }
    public void decreaseHeath(){
        if(numberOfHealthTouched > 0){
            numberOfHealthTouched--;
        }
    }
    public void increaseScore(){
        theScore++;
        score.setScore(theScore);
    }
    public void setLifeBar(){
        lifeBarRed.setCounter(numberOfHealthTouched);
        face.switchImage(numberOfHealthTouched+1);
        gameOver();
    }
    public void levelUp(){
        int level;
        level = theScore/20 + 1;
        upperLimitOfApple = 3*level;
        upperLimitOfCabbage = 2*level;
        upperLimitOfCoffee = level;
        upperLimitOfWater = level;    
    }
    public void act()
    {
        if (Greenfoot.getRandomNumber(1000) < upperLimitOfCookies){
            addObject(new Cookie(), Greenfoot.getRandomNumber(MAX_WIDTH), START_DROP_POSITION_Y);
        }
         if (Greenfoot.getRandomNumber(1000) < upperLimitOfIceCreams){            
            addObject(new IceCream(), Greenfoot.getRandomNumber(MAX_WIDTH), START_DROP_POSITION_Y);
        }        
         if (Greenfoot.getRandomNumber(1000) < upperLimitOfApple){
            addObject(new Apple(), Greenfoot.getRandomNumber(MAX_WIDTH), START_DROP_POSITION_Y);
        }
         if (Greenfoot.getRandomNumber(1000) < upperLimitOfCabbage){
            addObject(new Cabbage(), Greenfoot.getRandomNumber(MAX_WIDTH), START_DROP_POSITION_Y);
        }
         if (Greenfoot.getRandomNumber(1000) < upperLimitOfCoffee){
            addObject(new Coffee(), Greenfoot.getRandomNumber(MAX_WIDTH), START_DROP_POSITION_Y);
        }    
        if (Greenfoot.getRandomNumber(1000) < upperLimitOfWater && numberOfHealthTouched > 0){
            addObject(new Water(), Greenfoot.getRandomNumber(MAX_WIDTH), START_DROP_POSITION_Y);
        }   
        setTime();
        levelUp();
        setLifeBar();
        musicStop();
    }
    
    public void gameOver(){
        if(numberOfHealthTouched == 3){
           addObject(board, 750, 425);
           over.setScore(theScore);
           addObject(over, 750, 425);
           stoped();
           Greenfoot.playSound("gameover.mp3");
           Greenfoot.stop();
        }
    } 
    public void musicStop(){
        if(!backgroundMusic.isPlaying()){
           addObject(board, 750, 425);
           over.setScore(theScore);
           addObject(over, 750, 425);
           Greenfoot.stop();
        }
    }
}
