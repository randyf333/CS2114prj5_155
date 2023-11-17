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
    private ArrayList<String> months;

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

        this.months = new ArrayList<String>();
        this.months.add("January");
        this.months.add("February");
        this.months.add("March");
        this.months.add("April");
        this.months.add("May");
        this.months.add("June");
        this.months.add("July");
        this.months.add("August");
        this.months.add("September");
        this.months.add("October");
        this.months.add("November");
        this.months.add("December");
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * calculates engagement by reach
     * 
     * @param m
     *            months since January to be calculated
     * @return reach engagement
     */
    public float getTradEngagement(int m)
    {
        int comments = 0;
        int likes = 0;

        // get most recent months followers
        int lastMonth = 0;
        for (int i = 0; i < this.entries.size(); i++)
        {
            if (this.months.indexOf(this.entries.get(i).getMonth()) == m - 1)
            {
                lastMonth = i;
            }
        }
        int followers = this.entries.get(lastMonth).getFollowers();

        // Add comments, likes, and views from all entries
        for (int i = 0; i < this.entries.size(); i++)
        {
            if (this.months.indexOf(this.entries.get(i).getMonth()) < m)
            {
                comments += this.entries.get(i).getComments();
                likes += this.entries.get(i).getLikes();
            }
        }

        if (followers == 0)
        {
            return 0;
        }

        return ((comments + likes) / (float)followers) * 100;
    }


    // ----------------------------------------------------------
    /**
     * calculates engagement by reach
     * 
     * @param m
     *            months since January to be calculated
     * @return reach engagement
     */
    public float getReachEngagement(int m)
    {
        int comments = 0;
        int likes = 0;
        int views = 0;

        // Add comments, likes, and views from all entries
        for (int i = 0; i < m; i++)
        {
            if (this.months.indexOf(this.entries.get(i).getMonth()) < m)
            {
                comments += this.entries.get(i).getComments();
                likes += this.entries.get(i).getLikes();
                views += this.entries.get(i).getViews();
            }
        }

        if (views == 0)
        {
            return 0;
        }

        return ((comments + likes) / (float)views) * 100;
    }


    // ----------------------------------------------------------
    /**
     * adds entry to entries
     * 
     * @param e
     *            Entry that is added
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
     * Returns list of entries
     * 
     * @return list of entries
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
