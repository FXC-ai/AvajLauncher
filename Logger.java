
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Logger
{
    private static Logger instance;
    private List<String> logs;
    
    private Logger() throws IOException
    {
    	FileWriter fileCleaner = new FileWriter("output.txt", false);
	    fileCleaner.write("");
	    fileCleaner.close();	
	    System.out.println("Contenu supprimé.");
	    
	    this.logs = new ArrayList<>();
		
    }

    public static Logger getLogger() throws IOException
    {
        if (instance == null)
        {
        	instance = new Logger();        		
        }
        return instance;
    }
    
    public void logMsg(String msg)
    {
    	this.logs.add(msg);
    }
    
    public void writeLogs() throws IOException
    {
    	FileWriter fw = new FileWriter("output.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String str : this.logs)
        {        	
        	bw.write(str);
        	bw.newLine();
        }
        bw.close();
        System.out.println("Texte ajouté avec succès !");
    }
    
    
}
