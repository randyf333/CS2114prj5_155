package prj5;

import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * Runs the project
 * 
 * @author aravs
 * @version Nov 15, 2023
 */
public class ProjectRunner
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Method to run the code
     *
     * @param args
     *            Argument, if not empty, that contains the file needed to be
     *            parsed
     */
    public static void main(String[] args)
        throws IOException
    {
        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }
    }
}
