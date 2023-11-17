package prj5;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author ethan
 * @version Nov 16, 2023
 */
public class Entry
{
    // ~ Fields ................................................................
    private String month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param month
     *            month of entry
     * @param username
     *            username of influencer
     * @param channelName
     *            name of channel
     * @param country
     *            country of influencer
     * @param mainTopic
     *            topic of influencer's content
     * @param likes
     *            number of likes
     * @param posts
     *            number of posts
     * @param followers
     *            number of followers
     * @param comments
     *            number of comments
     * @param views
     *            number of views
     */
    public Entry(
        String month,
        String username,
        String channelName,
        String country,
        String mainTopic,
        int likes,
        int posts,
        int followers,
        int comments,
        int views)
    {
        this.month = month;
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Converts Entry to string
     * 
     * @return string
     */
    @Override
    public String toString()
    {
        return this.username + ":" + this.likes;
    }


    // ----------------------------------------------------------
    /**
     * Returns month
     * 
     * @return month
     */
    public String getMonth()
    {
        return this.month;
    }


    // ----------------------------------------------------------
    /**
     * Returns username
     * 
     * @return username
     */
    public String getUsername()
    {
        return this.username;
    }


    // ----------------------------------------------------------
    /**
     * Returns channelName
     * 
     * @return channelName
     */
    public String getChannelName()
    {
        return this.channelName;
    }


    // ----------------------------------------------------------
    /**
     * Returns country
     * 
     * @return country
     */
    public String getCountry()
    {
        return this.country;
    }


    // ----------------------------------------------------------
    /**
     * Returns mainTopic
     * 
     * @return mainTopic
     */
    public String getMainTopic()
    {
        return this.mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Returns likes
     * 
     * @return likes
     */
    public int getLikes()
    {
        return this.likes;
    }


    // ----------------------------------------------------------
    /**
     * Returns posts
     * 
     * @return posts
     */
    public int getPosts()
    {
        return this.posts;
    }


    // ----------------------------------------------------------
    /**
     * Returns followers
     * 
     * @return followers
     */
    public int getFollowers()
    {
        return this.followers;
    }


    // ----------------------------------------------------------
    /**
     * Returns comments
     * 
     * @return comments
     */
    public int getComments()
    {
        return this.comments;
    }


    // ----------------------------------------------------------
    /**
     * Returns views
     * 
     * @return views
     */
    public int getViews()
    {
        return this.views;
    }
}
