package prj5;

import cs1705.IOHelper;
import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * This class is used to parse the input files
 * 
 * @author aravs
 * @version Nov 15, 2023
 */
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
        ArrayList<Object[]> collectedValues = new ArrayList<Object[]>();
        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            if (isValid(values))
            {
                String month = values[0];
                String username = values[1];
                String channel = values[2];
                String country = values[3];
                String mainTopic = values[4];
                int likes = toInt(values[5]);
                int posts = toInt(values[6]);
                int followers = toInt(values[7]);
                int comments = toInt(values[8]);
                int views = toInt(values[9]);
                collectedValues.add(
                    new Object[] { month, username, channel, country, mainTopic,
                        likes, posts, followers, comments, views });
            }

            // TODO : Populate the Classes created to store the data

// int val = 0;
// while (collectedValues.size() > val)
// {
// Object[] v = collectedValues.get(val);
// for (int x = 0; x < v.length; x++)
// {
// System.out.println(v[x]);
// }
// val++;
// }
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
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
     * Place a description of your method here.
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
