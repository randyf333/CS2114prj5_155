package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Comparator object to compare two Influencer objects by ChannelName
 * 
 * @author ethan
 * @version Nov 16, 2023
 */
public class CompareByReachEngagement
    implements Comparator<Influencer>
{
    /**
     * Compare two Influencer objects based on channel name.
     * 
     * @param i1
     *            the first influencer to be compared
     * @param i2
     *            the second influencer to be compared
     * @return A negative integer if the first influencer has a preceding
     *             engagement rate. 0 if the engagement rates are the same. A
     *             positive integer if the second influencer follows the first
     *             influencer's engagement rate
     */
    @Override
    public int compare(Influencer i1, Influencer i2)
    {
        return (int)i1.getReachEngagement(1, 3)
            - (int)i2.getReachEngagement(1, 3);
    }

}
