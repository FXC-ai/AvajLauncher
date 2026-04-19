import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    private static Logger instance;
    
    private FileWriter fw;
    
    private Logger() throws IOException
    {
    	try
    	{
    		fw = new FileWriter("output.txt", true);
            fw.write("");
            fw.close();
            System.out.println("Contenu supprimé.");
    	}
    	catch (IOException e)
    	{
    		throw new IOException();
    	}
    }

    public static Logger getInstance() throws IOException
    {
        if (instance == null)
        {
        	try
        	{
        		instance = new Logger();        		
        	}
        	catch (IOException e)
        	{
        		throw new IOException();
        	}
        }
        return instance;
    }
    
    
	
}
