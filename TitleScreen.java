import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Kavin
 * @version December 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }

    /*
     * The main world act loop
     */
    public void act()
    {
        //start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"));
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,200,286);
        label.setLocation(278,285);
        label.setLocation(262,301);
        Label label2 = new Label("Use <-- and --> to Move", 40);
        addObject(label2,291,256);
        label2.setLocation(322,251);
        label.setLocation(291,292);
        label.setLocation(300,320);
        label2.setLocation(305,297);
        label.setLocation(299,334);
    }
}
