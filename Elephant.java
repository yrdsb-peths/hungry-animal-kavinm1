import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elphant the Hero
 * 
 * @author Kavin 
 * @version November 2022
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    //Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor- The code that gets run one time when object is created
     */
    public Elephant()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        //Initial elephant image
        setImage(idleRight[0]);
    }
    
    /*
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    
    public void act()
    {
        int x = getX();
        int y = getY();
        
        if(Greenfoot.isKeyDown("left"))
        {
            x -= 2;
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right"))
        {
            x +=2;
            facing = "right";
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            y -= 2;
        }
        if(Greenfoot.isKeyDown("down"))
        {
            y +=2;
        }
        
        setLocation(x, y);
        
        // Remove apple if elephant eats it
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    
    /*
     * Eat the apple and spawn new apple if an apple is eaten
     */
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
