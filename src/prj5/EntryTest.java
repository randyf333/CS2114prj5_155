package prj5;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Class to test Entry methods
 * 
 *  @author randy
 *  @version Nov 17, 2023
 */
public class EntryTest extends TestCase
{
    private Entry entry;
    /**
     * Setup method for testing
     */
    public void setUp() {
        entry = new Entry("Jan","user1","channel1","US","Games",1,2,3,4,5);
    }
    /**
     * Test toString method
     */
    public void testToString() {
        assertEquals("user1:1", entry.toString());
    }
    
    /**
     * Test getMonth method
     */
    public void testGetMonth() {
        assertEquals("Jan",entry.getMonth());
    }
    
    /**
     * Test getUsername method
     */
    public void testGetUsername() {
        assertEquals("user1",entry.getUsername());
    }
    /**
     * Test getChannelName method
     */
    public void testGetChannelName() {
        assertEquals("channel1",entry.getChannelName());
    }
    /**
     * Test getCountry method
     */
    public void testGetCountry() {
        assertEquals("US", entry.getCountry());
    }
    /**
     * Test getMainTopicMethod
     */
    public void testGetMainTopic() {
        assertEquals("Games",entry.getMainTopic());
    }
    /**
     * Test getLikes method
     */
    public void testGetLikes() {
        assertEquals(1, entry.getLikes());
    }
    /**
     * Test getPosts method
     */
    public void testGetPosts() {
        assertEquals(2, entry.getPosts());
    }
    /**
     * Test getFollowers method
     */
    public void testGetFollowers() {
        assertEquals(3, entry.getFollowers());
    }
    /**
     * Test getComments method
     */
    public void testGetComments() {
        assertEquals(4, entry.getComments());
    }
    /**
     * Test getViews method
     */
    public void testGetViews() {
        assertEquals(5, entry.getViews());
    }
}
