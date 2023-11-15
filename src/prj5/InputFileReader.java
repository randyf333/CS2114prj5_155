package prj5;

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
            return Integer.ParseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    // ~Public Methods ........................................................

}
