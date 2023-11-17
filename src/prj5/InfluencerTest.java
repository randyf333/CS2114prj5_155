package prj5;

// -------------------------------------------------------------------------
/**
 * Test methods for the Influencer class
 * 
 * @author aravs
 * @version Nov 17, 2023
 */
public class InfluencerTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private Influencer influencer;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Initializes an Influencer object to test
     */
    public void setUp()
    {

        influencer = new Influencer("channel");
    }


    /**
     * Tests the addEntry method
     */
    public void testAddEntry()
    {
        assertEquals(0, influencer.getEntries().size());
        influencer.addEntry(
            new Entry(
                "January",
                "user",
                "channel2",
                "USA",
                "topic",
                1,
                2,
                3,
                4,
                5));
        assertEquals(1, influencer.getEntries().size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getChannelName method
     */
    public void testGetChannelName()
    {
        assertEquals("channel", influencer.getChannelName());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getEntries method
     */
    public void testGetEntries()
    {
        assertEquals(0, influencer.getEntries().size());
        influencer.addEntry(
            new Entry(
                "January",
                "user",
                "channel2",
                "USA",
                "topic",
                1,
                2,
                3,
                4,
                5));
        assertEquals(1, influencer.getEntries().size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method
     */
    public void testToString()
    {
// return this.channelName + ", "
// + this.getReachEngagement(this.getEntries().size());
        System.out.println(influencer.toString());
    }
}
