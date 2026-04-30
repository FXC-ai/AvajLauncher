
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser
{
	private int repeat = 0;
	private String filename;
	private List<Flyable> listFlyable;
	
	public Parser (String filename)
	{
		this.filename = filename;
		this.listFlyable = new ArrayList<Flyable>();
	}
	
    public void ParseFile()
    throws FileNotFoundException,
    IOException,
    NumberFormatException,
    FirstLineErrorException,
    InvalidAircraftTypeException,
    InvalidAircraftNameException,
    TokenNumberException,
    NonUniqueNameException,
    InvalidCoordinatesException,
    InvalidHeightException,
	NoAircraftException
    {
    	Set<String> setName = new HashSet<>();
    	
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename)))
        {
            String line;
            int index = 0;
            boolean firstLineParsed = false;
            
            while ((line = br.readLine()) != null)
            {
                index++;
            	line = line.trim();
            	line = line.replaceAll("\\s+", " ");
            	if (line.isEmpty())
            		continue;
                
                if (!firstLineParsed)
                {
                	try {this.repeat = Integer.parseUnsignedInt(line);} 
                	catch (NumberFormatException e) {throw new FirstLineErrorException(line);}
                	firstLineParsed = true;
                }
                else
                {
                	String[] words = line.split(" ");
                	final int longitude;
                	final int latitude;
                	final int height;
                	
                	if (words.length != 5)
                	{
                		throw new TokenNumberException(line);
                	}
                	
    				if
    				(
						!(words[0].equals("Helicopter") || 
						words[0].equals("Balloon") ||
						words[0].equals("JetPlane"))
    				)
    				{
    					throw new InvalidAircraftTypeException("(" + index + ") " + line + " | " + words[0]);
    				}

    				if (!words[1].matches("^[a-zA-Z0-9]+"))
    				{
    					throw new InvalidAircraftNameException("(" + index + ") " + line + " | " + words[1]);
    				}
    				
    				if (setName.contains(words[1]))
    				{
    					throw new NonUniqueNameException("(" + index + ") " + line + " | " + words[1]);
    				}
    				
    				setName.add(words[1]);
    				
    				try 
    				{
    					longitude = Integer.parseUnsignedInt(words[2]);
    					latitude = Integer.parseUnsignedInt(words[3]);
    					height = Integer.parseUnsignedInt(words[4]);    					
    				}
    				catch (NumberFormatException e)
    				{
    					throw new InvalidCoordinatesException("(" + index + ") " + line);
    				}
    				
                    // if (longitude == 0 || latitude == 0)
					// {
                    //     throw new InvalidCoordinatesException("(" + index + ") " + line + " | coordonnées strictement positives");
					// }
                    
    				// if (height > 100)
    				// {
    				//      throw new InvalidHeightException("(" + index + ") " + line + " | " + words[4]);
    				// }

                	this.listFlyable.add(AircraftFactory.getAircraftFactory().newAircraft(words[0], words[1], new Coordinates(longitude, latitude, height)));
                }
            }
            
            if (!firstLineParsed)
            {
                throw new FirstLineErrorException("<fichier vide>");
            }

			if (index <= 1)
			{
				throw new NoAircraftException();
			}
        }
    }
    
    
    public int getRepeat()
    {
    	return this.repeat;
    }
    
    public String getFilename()
    {
    	return this.filename;
    }

    public List<Flyable> getListFlyable()
    {
    	return this.listFlyable;
    }
    
    @Override
    public String toString()
    {
    	String listAircrafts = "Aircraft = \n";
    	for (Flyable flyable : this.listFlyable)
    	{
    		listAircrafts += flyable.toString() + "\n";
    	}
        return "Filename = " + this.filename + "\nRepeat = " + this.repeat + "\n" + listAircrafts;
    }
    
}


    
	
	

