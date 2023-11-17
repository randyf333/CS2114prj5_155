package prj5;

import cs1705.IOHelper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * This class is used to parse the input files
 * 
 * @author Team 155
 * @version Nov 15, 2023
 */
@SuppressWarnings("deprecation")
public class InputFileReader
{
    // ~ Fields ................................................................
    private String inputFile;
    private ArrayList<String> months;
    private ArrayList<String> firstQuarter;

    // ~ Constructors ..........................................................
    /**
     * Creates a new InputFileReader object while also creating variables
     * containing the input file and lists of months that need to be considered
     * 
     * @param input
     *            Name of the file that needs to be parsed
     */
    public InputFileReader(String input)
    {
        inputFile = input;
        months = new ArrayList<String>();
        firstQuarter = new ArrayList<String>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        firstQuarter.add("January");
        firstQuarter.add("February");
        firstQuarter.add("March");
        parseFiles();
    }


    // ~Private Methods ........................................................
    /**
     * Converts a string to an integer, returns 0 if the argument can not be
     * converted to an integer
     * 
     * @param str
     *            String that needs to be converted
     * @return either the integer that the string is converted to, or 0 if the
     *             string can not be converted to an integer
     */
    private int toInt(String str)
    {

        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    // ~Public Methods ........................................................
    /**
     * Checks if a certain line on an input file is valid data
     * 
     * @param values
     *            The values on the input file line we are looking at
     * @return if the input file line is the right length and has a valid data
     *             value for the month
     */
    public boolean isValid(String[] values)
    {
        return values.length == 10 && months.contains(values[0]);
    }


    // ----------------------------------------------------------
    /**
     * parse through files
     */
    public void parseFiles()
    {
        Scanner inStream = IOHelper.createScanner(inputFile);
        inStream.nextLine();
        SinglyLinkedList<Influencer> influencers =
            new SinglyLinkedList<Influencer>();

        CompareByChannelName nameComparer = new CompareByChannelName();
        CompareByReachEngagement reComparer = new CompareByReachEngagement();
        DecimalFormat df = new DecimalFormat("#.#");

        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            if (isValid(values))
            {
                String month = values[0];
                String username = values[1];
                String channelName = values[2];
                String country = values[3];
                String mainTopic = values[4];
                int likes = toInt(values[5]);
                int posts = toInt(values[6]);
                int followers = toInt(values[7]);
                int comments = toInt(values[8]);
                int views = toInt(values[9]);
                Entry e = new Entry(
                    month,
                    username,
                    channelName,
                    country,
                    mainTopic,
                    likes,
                    posts,
                    followers,
                    comments,
                    views);

                // Find the influencer the entry belongs to
                boolean correctEntry = false;
                for (int i = 0; i < influencers.size(); i++)
                {
                    if (e.getChannelName()
                        .equals(influencers.get(i).getChannelName()))
                    {
                        correctEntry = true;
                        influencers.get(i).addEntry(e);
                        break;
                    }
                }

                // make new influencer if not found
                if (!correctEntry)
                {
                    influencers.add(new Influencer(e.getChannelName()));
                    influencers.get(influencers.size() - 1).addEntry(e);
                }
            }
        }

        int quarterLength = 3; // First quarter is the first 3 months

        // OUTPUT PART 1: SORT BY NAME AND PRINT TRAD ENGAGEMENT
        influencers.sort(nameComparer);

        for (int i = 0; i < influencers.size(); i++)
        {
            Influencer inf = influencers.get(i); // this influencer

            System.out.println(inf.getChannelName());
            System.out.println(
                "traditional: "
                    + df.format(inf.getTradEngagement(quarterLength)));
            System.out.println("==========");
        }
        
        System.out.println("**********");
        System.out.println("**********");
        
        // OUTPUT PART 2: SORT BY REACH ENGAGEMENT
        influencers.sort(reComparer);

        for (int i = 0; i < influencers.size(); i++)
        {
            Influencer inf = influencers.get(i); // this influencer

            System.out.println(inf.getChannelName());
            System.out.println(
                "traditional: "
                    + df.format(inf.getReachEngagement(quarterLength)));
            System.out.println("==========");
        }
    }


    // ----------------------------------------------------------
    /**
     * Calculates the traditional engagement rate
     * 
     * @param comments
     *            number of comments
     * @param likes
     *            number of likes
     * @param followers
     *            number of followers
     * @return Traditional Engagement Rate
     */
    public double calcTradRate(int comments, int likes, int followers)
    {
        return ((comments + likes) / followers) * 100;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the reach engagement rate
     * 
     * @param comments
     *            number of comments
     * @param likes
     *            number of likes
     * @param views
     *            number of views
     * @return Engagement Rate by Reach
     */
    public double calcReachRate(int comments, int likes, int views)
    {
        return ((comments + likes) / views) * 100;
    }
}
