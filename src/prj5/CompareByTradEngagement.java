package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Comparator object to compare two Influencer objects by ChannelName
 * 
 * @author ethan
 * @version Nov 16, 2023
 */
public class CompareByTradEngagement
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
        return (int)i1.getTradEngagement(i1.getEntries().size())
            - (int)i2.getTradEngagement(i2.getEntries().size());
    }

}
