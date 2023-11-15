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

    // ~ Constructors ..........................................................
    /**
     * Creates a new InputFileReader object
     * 
     * @param input
     *            Name of the file that needs to be parsed
     */
    public InputFileReader(String input)
    {
        inputFile = input;
        parseFiles();
    }


    // ~Private Methods ........................................................
    /**
     * Converts a string to an integer, throws an exception if the argument can
     * not be converted to an integer
     * 
     * @param str
     *            String that needs to be converted
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
    public void parseFiles()
    {
        Scanner inStream = IOHelper.createScanner(inputFile);
        inStream.nextLine();
        ArrayList<Object[]> collectedValues = new ArrayList<Object[]>();
        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
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

            // TODO : Populate the Classes created to store the data

        }
//        int val = 0;
//        while (collectedValues.size() > val)
//        {
//            Object[] v = collectedValues.get(val);
//            for (int x = 0; x < v.length; x++)
//            {
//                System.out.println(v[x]);
//            }
//            val++;
//        }
    }
}
