package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test methods for the Influencer class
 * 
 * @author aravs
 * @version Nov 17, 2023
 */
public class InfluencerTest
    extends TestCase
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


    // ----------------------------------------------------------
    /**
     * Tests the getTradEngagement method
     */
    public void testGetTradEngagement()
    {
        assertEquals(0, influencer.getTradEngagement(1), 0.01);
        Entry entry1 = new Entry(
            "January",
            "User1",
            "TestChannel",
            "Country1",
            "Topic1",
            10,
            5,
            100,
            20,
            200);
        Entry entry2 = new Entry(
            "February",
            "User2",
            "TestChannel",
            "Country2",
            "Topic2",
            20,
            10,
            150,
            25,
            250);
        influencer.addEntry(entry1);
        influencer.addEntry(entry2);
        assertEquals(15.0, influencer.getTradEngagement(2), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getReachEngagement method
     */
    public void testGetReachEngagement()
    {
        assertEquals(0, influencer.getReachEngagement(1), 0.01);
        Entry entry1 = new Entry(
            "January",
            "User1",
            "TestChannel",
            "Country1",
            "Topic1",
            10,
            5,
            100,
            20,
            200);
        Entry entry2 = new Entry(
            "February",
            "User2",
            "TestChannel",
            "Country2",
            "Topic2",
            20,
            10,
            150,
            25,
            250);
        influencer.addEntry(entry1);
        influencer.addEntry(entry2);
        assertEquals(20.0, influencer.getReachEngagement(2), 0.01);
    }


    // ----------------------------------------------------------
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

}
