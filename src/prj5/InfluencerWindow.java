package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import student.TestableRandom;
import java.text.DecimalFormat;

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
    private Button sortInfluencer;
    private Button sortEngage;
    private Button jan;
    private Button feb;
    private Button march;
    private Button firstQ;
    private SinglyLinkedList<Influencer> influencers;
    private Shape[] influencerBars;
    private TextShape[] influencerNames;
    private TextShape[] influencerValues;
    private String[] engagmentSortType;
    private String[] time;
    private String[] engagmentType;
    private TextShape engagmentSortText;
    private TextShape timeText;
    private TextShape engagmentTypeText;
    private Color[] influencerColor;
    private int month;
    private boolean tradRate;
    private boolean reachRate;
    private boolean sortC;
    private boolean sortE;
    public static final int MARGIN = 50;
    public static final int TEXT_SIZE = 20;
    public static final int BAR_WIDTH = 20;
    public static final double HEIGHT_MULTIPLIER = 1;

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
        this.window = new Window("Social Media Vis");
        tradRate = false;
        reachRate = true;
        sortC = false;
        sortE = true;
        month = 0;
        input = new InputFileReader(i);
        influencers = input.parseFiles();

        quit = new Button("Quit");
        sortInfluencer = new Button("Sort by Channel Name");
        sortEngage = new Button("Sort by Engagment Rate");
        sortTrad = new Button("Traditional Engagment Rate");
        sortReach = new Button("Reach Engagment Rate");

        jan = new Button("January");
        feb = new Button("February");
        march = new Button("March");
        firstQ = new Button("First Quarter (Jan - March)");

        quit.onClick(this, "clickedQuit");

        sortInfluencer.onClick(this, "clickedSortInfluencer");
        sortEngage.onClick(this, "clickedSortEngage");
        sortTrad.onClick(this, "clickedTradEngagment");
        sortReach.onClick(this, "clickedReachEngagment");

        jan.onClick(this, "clickedJanuary");
        feb.onClick(this, "clickedFebruary");
        march.onClick(this, "clickedMarch");
        firstQ.onClick(this, "clickedFirstQuarter");

        window.addButton(sortInfluencer, WindowSide.NORTH);
        window.addButton(sortEngage, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortTrad, WindowSide.WEST);
        window.addButton(sortReach, WindowSide.WEST);
        window.addButton(jan, WindowSide.SOUTH);
        window.addButton(feb, WindowSide.SOUTH);
        window.addButton(march, WindowSide.SOUTH);
        window.addButton(firstQ, WindowSide.SOUTH);

        time = new String[] { "January", "February", "March",
            "First Quarter (Jan - March)" };
        engagmentSortType = new String[] { "Traditional Engagment Rate",
            "Reach Engagment Rate" };
        engagmentType = new String[] { "Sorting by Channel Name",
            "Sorting by Engagment Rate" };

        timeText = new TextShape(300, 100, "temporary");
        engagmentSortText = new TextShape(300, 120, "tempor");
        engagmentTypeText = new TextShape(300, 140, "temp");

        window.addShape(timeText);
        window.addShape(engagmentSortText);
        window.addShape(engagmentTypeText);
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


    // ----------------------------------------------------------
    /**
     * Button method to sort by channel name
     * 
     * @param button
     *            button clicked
     */
    public void clickedSortInfluencer(Button button)
    {
        sortC = true;
        sortE = false;
        influencers.sort(new CompareByChannelName());
        update();
    }


    // ----------------------------------------------------------
    /**
     * Button method to sort by engagement rate
     * 
     * @param button
     *            button clicked
     */
    public void clickedSortEngage(Button button)
    {
        sortC = false;
        sortE = true;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Button method to sort by traditional engagement rate
     * 
     * @param button
     *            button clicked
     */
    public void clickedTradEngagment(Button button)
    {
        tradRate = true;
        reachRate = false;
        influencers.sort(new CompareByTradEngagement());
        update();
    }


    // ----------------------------------------------------------
    /**
     * Button method to sort by reach engagement rate
     * 
     * @param button
     *            button clicked
     */
    public void clickedReachEngagment(Button button)
    {
        reachRate = true;
        tradRate = false;
        influencers.sort(new CompareByReachEngagement());
        update();
    }


    // ----------------------------------------------------------
    /**
     * Get only january data
     * 
     * @param button
     *            button clicked
     */
    public void clickedJanuary(Button button)
    {
        month = 1;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Get only Feb data
     * 
     * @param button
     *            button clicked
     */
    public void clickedFebruary(Button button)
    {
        month = 2;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Get only March data
     * 
     * @param button
     *            button clicked
     */
    public void clickedMarch(Button button)
    {
        month = 3;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Get first quarter data
     * 
     * @param button
     *            button clicked
     */
    public void clickedFirstQuarter(Button button)
    {
        month = 0;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Updates the window based on the most recent button clicks
     */
    public void update()
    {
        window.removeAllShapes();

        if (month == 0)
        {
            if (sortC)
            {
                for (int i = 0; i < influencers.size(); i++)
                {
                    Influencer inf = influencers.get(i); // this influencer
                    String nameOfChannel = inf.getChannelName();
                    float rateToDisplay = (float)0.0;
                    // handle division by 0 in calculation
                    if (tradRate && inf.getTradEngagement(1, 3) > 0)
                    {
                        rateToDisplay = inf.getTradEngagement(1, 3);
                    }
                    if (reachRate && inf.getReachEngagement(1, 3) > 0)
                    {
                        rateToDisplay = inf.getReachEngagement(1, 3);
                    }
                    drawInfluencer(nameOfChannel, rateToDisplay, 4 - i);
                }

            }
            else
            {
                for (int i = 0; i < influencers.size(); i++)
                {
                    Influencer inf = influencers.get(i); // this influencer
                    String nameOfChannel = inf.getChannelName();
                    float rateToDisplay = (float)0.0;
                    // handle division by 0 in calculation
                    if (tradRate && inf.getTradEngagement(1, 3) > 0)
                    {
                        rateToDisplay = inf.getTradEngagement(1, 3);
                    }
                    if (reachRate && inf.getReachEngagement(1, 3) > 0)
                    {
                        rateToDisplay = inf.getReachEngagement(1, 3);
                    }
                    drawInfluencer(nameOfChannel, rateToDisplay, 4 - i);
                }
            }
        }
        else
        {
            if (sortC)
            {
                for (int i = 0; i < influencers.size(); i++)
                {
                    Influencer inf = influencers.get(i); // this influencer
                    String nameOfChannel = inf.getChannelName();
                    float rateToDisplay = (float)0.0;
                    // handle division by 0 in calculation
                    if (tradRate && inf.getTradEngagement(month, month) > 0)
                    {
                        rateToDisplay = inf.getTradEngagement(month, month);
                    }
                    if (reachRate && inf.getReachEngagement(month, month) > 0)
                    {
                        rateToDisplay = inf.getReachEngagement(month, month);
                    }
                    drawInfluencer(nameOfChannel, rateToDisplay, 4 - i);
                }

            }
            else
            {
                for (int i = 0; i < influencers.size(); i++)
                {
                    Influencer inf = influencers.get(i); // this influencer
                    String nameOfChannel = inf.getChannelName();
                    float rateToDisplay = (float)0.0;
                    // handle division by 0 in calculation
                    if (tradRate && inf.getTradEngagement(month, month) > 0)
                    {
                        rateToDisplay = inf.getTradEngagement(month, month);
                    }
                    if (reachRate && inf.getReachEngagement(month, month) > 0)
                    {
                        rateToDisplay = inf.getReachEngagement(month, month);
                    }
                    drawInfluencer(nameOfChannel, rateToDisplay, 4 - i);
                }
            }

        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method to draw for update
     * 
     * @param name
     *            name of influencer
     * @param rate
     *            data
     * @param pos
     *            position of bar
     */
    private void drawInfluencer(String name, double rate, int pos)
    {
        TestableRandom randomGen = new TestableRandom();
        int red = randomGen.nextInt(256);
        int green = randomGen.nextInt(256);
        int blue = randomGen.nextInt(256);
        int barHeight = 50 * (int)rate;
        int x = 20 + 50 * pos;
        int y = window.getGraphPanelHeight() - 75 - barHeight;
        Shape bar = new Shape(x, y, 25, barHeight, new Color(red, green, blue));
        window.addShape(
            new TextShape(x, window.getGraphPanelHeight() - 50, name));
        window.addShape(bar);
        DecimalFormat df = new DecimalFormat("#.#");
        window.addShape(
            new TextShape(
                x,
                window.getGraphPanelHeight() - 30,
                "" + df.format(rate)));
    }

}
