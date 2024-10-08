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
 * @author arav singh, ethan brown, randy fu
 * @version Nov 27, 2023
 */
public class GUIWindow
{
    // ~ Fields ................................................................
    private Window window;
    private SinglyLinkedList<Influencer> influencers;
    private int month;
    private boolean tradRate;
    private boolean sortC;

    // ~ Constructors ..........................................................
    /**
     * Declares a new InfluencerWindow while also creating the window as well as
     * creating and adding functions to the buttons
     * 
     * @param i
     *            The name of the file we are examining
     */
    public GUIWindow(String i)
    {
        this.window = new Window("Social Media Vis");
        tradRate = false;
        sortC = false;
        month = 0;
        InputFileReader input = new InputFileReader(i);
        influencers = input.parseFiles();

        Button quit = new Button("Quit");
        Button sortInfluencer = new Button("Sort by Channel Name");
        Button sortEngage = new Button("Sort by Engagment Rate");
        Button sortTrad = new Button("Traditional Engagment Rate");
        Button sortReach = new Button("Reach Engagment Rate");

        Button jan = new Button("January");
        Button feb = new Button("February");
        Button march = new Button("March");
        Button firstQ = new Button("First Quarter (Jan - March)");

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

        if (tradRate)
        {
            switch (this.month)
            {
                case 0:
                    influencers.sort(new CompareByTradEngagement());
                    break;
                case 1:
                    influencers.sort(new CompareByTradEngJan());
                    break;
                case 2:
                    influencers.sort(new CompareByTradEngFeb());
                    break;
                case 3:
                    influencers.sort(new CompareByTradEngMar());
                    break;
                default:
                    influencers.sort(new CompareByTradEngJan());
            }
        }
        else
        {
            switch (this.month)
            {
                case 0:
                    influencers.sort(new CompareByReachEngagement());
                    break;
                case 1:
                    influencers.sort(new CompareByReachJan());
                    break;
                case 2:
                    influencers.sort(new CompareByReachFeb());
                    break;
                case 3:
                    influencers.sort(new CompareByReachMar());
                    break;
                default:
                    influencers.sort(new CompareByReachJan());
            }
        }

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

        if (!sortC)
        {
            switch (this.month)
            {
                case 0:
                    influencers.sort(new CompareByTradEngagement());
                    break;
                case 1:
                    influencers.sort(new CompareByTradEngJan());
                    break;
                case 2:
                    influencers.sort(new CompareByTradEngFeb());
                    break;
                case 3:
                    influencers.sort(new CompareByTradEngMar());
                    break;
                default:
                    influencers.sort(new CompareByTradEngJan());
            }
        }

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
        tradRate = false;

        if (!sortC)
        {
            switch (this.month)
            {
                case 0:
                    influencers.sort(new CompareByReachEngagement());
                    break;
                case 1:
                    influencers.sort(new CompareByReachJan());
                    break;
                case 2:
                    influencers.sort(new CompareByReachFeb());
                    break;
                case 3:
                    influencers.sort(new CompareByReachMar());
                    break;
                default:
                    influencers.sort(new CompareByReachJan());
            }
        }

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

        if (!sortC)
        {
            if (tradRate)
            {
                influencers.sort(new CompareByTradEngJan());
            }
            else
            {
                influencers.sort(new CompareByReachJan());
            }
        }

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

        if (!sortC)
        {
            if (tradRate)
            {
                influencers.sort(new CompareByTradEngFeb());
            }
            else
            {
                influencers.sort(new CompareByReachFeb());
            }
        }

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

        if (!sortC)
        {
            if (tradRate)
            {
                influencers.sort(new CompareByTradEngMar());
            }
            else
            {
                influencers.sort(new CompareByReachMar());
            }
        }

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

        if (!sortC)
        {
            if (tradRate)
            {
                influencers.sort(new CompareByTradEngagement());
            }
            else
            {
                influencers.sort(new CompareByReachEngagement());
            }
        }

        update();
    }


    // ----------------------------------------------------------
    /**
     * Updates the window based on the most recent button clicks
     */
    public void update()
    {
        window.removeAllShapes();

        drawText();

        int start = 0;
        int end = 0;

        if (month == 0)
        {
            start = 1;
            end = 3;
        }
        else
        {
            start = month;
            end = month;
        }

        for (int i = 0; i < influencers.size(); i++)
        {
            Influencer inf = influencers.get(i);
            String channelName = inf.getChannelName();
            double rate = 0;

            if (tradRate)
            {
                rate = inf.getTradEngagement(start, end);
            }
            else
            {
                rate = inf.getReachEngagement(start, end);
            }

            drawInfluencer(channelName, rate, 4 - i);
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

        // limit bar height
        if (barHeight > 400)
        {
            barHeight = 400;
        }

        int x = 20 + 150 * pos;
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


    private void drawText()
    {
        String monthText = "";
        String rateType = "";
        String sortType = "";

        switch (this.month)
        {
            case 0:
                monthText = "First Quarter (Jan-March)";
                break;
            case 1:
                monthText = "January";
                break;
            case 2:
                monthText = "February";
                break;
            case 3:
                monthText = "March";
                break;
            default:
                monthText = "First Quarter (Jan-March)";
        }

        if (tradRate)
        {
            rateType = "Traditional Engagement Rate";
        }
        else
        {
            rateType = "Reach Engagement Rate";
        }

        if (sortC)
        {
            sortType = "Sorting by Channel Name";
        }
        else
        {
            sortType = "Sorting by Engagement Rate";
        }

        window.addShape(new TextShape(10, 20, monthText));
        window.addShape(new TextShape(10, 40, rateType));
        window.addShape(new TextShape(10, 60, sortType));

    }

}
