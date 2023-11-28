package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;

// -------------------------------------------------------------------------
/**
 * The main front-end work and the view for the Influencer statistics
 * 
 * @author aravs
 * @version Nov 27, 2023
 */
public class InfluencerWindow
{
    // ~ Fields ................................................................
    private InputFileReader input;
    private Window window;
    private Button quit;
    private Button sortReach;
    private Button sortTrad;
    private Button sortChannel;
    private Button sortEngage;
    private Button jan;
    private Button feb;
    private Button march;
    private Button firstQ;

    // ~ Constructors ..........................................................
    /**
     * Declares a new InfluencerWindow while also creating the window as well as
     * creating and adding functions to the buttons
     * 
     * @param i
     *            The name of the file we are examining
     */
    public InfluencerWindow(String i)
    {
        input = new InputFileReader(i);
    }


    // ~Public Methods ........................................................
    /**
     * Method to respond to the action of the quit button being clicked; exits
     * the window
     * 
     * @param button
     *            button that was clicked
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }
}
