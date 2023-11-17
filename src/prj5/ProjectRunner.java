// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ethan Brown (ethanbrown33), Randy Fu (randyf333), Arav Singh (aravs)

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
     * @throws IOException
     */
    @SuppressWarnings("unused")
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
