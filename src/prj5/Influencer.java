package prj5;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author ethan
 * @version Nov 16, 2023
 */
public class Influencer
{
    // ~ Fields ................................................................
    private ArrayList<Entry> entries;
    private String channelName;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param channelName
     *            channel name of the Influencer
     */
    public Influencer(String channelName)
    {
        this.entries = new ArrayList<Entry>();
        this.channelName = channelName;
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * calculates engagement by reach
     * 
     * @param months
     *            months since January to be calculated
     * @return reach engagement
     */
    public float getTradEngagement(int months)
    {
        int comments = 0;
        int likes = 0;

        // get most recent months followers
        int followers = this.entries.get(months - 1).getFollowers();

        // Add comments, likes, and views from all entries
        for (int i = 0; i < this.entries.size(); i++)
        {
            comments += this.entries.get(i).getComments();
            likes += this.entries.get(i).getLikes();
        }
        return ((comments + likes) / (float)followers) * 100;
    }


    // ----------------------------------------------------------
    /**
     * calculates engagement by reach
     * 
     * @param months
     *            months since January to be calculated
     * @return reach engagement
     */
    public float getReachEngagement(int months)
    {
        int comments = 0;
        int likes = 0;
        int views = 0;

        // Add comments, likes, and views from all entries
        for (int i = 0; i < this.entries.size(); i++)
        {
            comments += this.entries.get(i).getComments();
            likes += this.entries.get(i).getLikes();
            views += this.entries.get(i).getViews();
        }
        return ((comments + likes) / (float)views) * 100;
    }


    // ----------------------------------------------------------
    /**
     * adds entry to entries
     * 
     * @param e
     */
    public void addEntry(Entry e)
    {
        entries.add(e);
    }


    // ----------------------------------------------------------
    /**
     * Returns user name
     * 
     * @return user name
     */
    public String getChannelName()
    {
        return this.channelName;
    }


    // ----------------------------------------------------------
    /**
     * Returns user name
     * 
     * @return user name
     */
    public ArrayList<Entry> getEntries()
    {
        return this.entries;
    }


    // ----------------------------------------------------------
    /**
     * Converts Influencer to string
     * 
     * @return string
     */
    @Override
    public String toString()
    {
        return this.channelName + ", "
            + this.getReachEngagement(this.getEntries().size());
    }
}
