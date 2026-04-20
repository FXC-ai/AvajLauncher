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
	
    public void ReadFile()
    {
    	Set<String> setName = new HashSet<>();
    	
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename)))
        {
            String line;
            int index = 0;
            
            
            while ((line = br.readLine()) != null)
            {
            	line = line.trim();
            	line = line.replaceAll("\\s+", " ");
                System.out.println(index + " " + line);
                
                if (index == 0)
                {
                	this.repeat = Integer.parseUnsignedInt(line);
                }
                else
                {
                	String[] words = line.split(" ");
                	final int longitude;
                	final int latitude;
                	final int height;
                	
                	if (words.length != 5)
                	{
                		throw new TokenNumberException("");
                	}
                	
    				if
    				(
    						!(words[0].equals("Helicopter") || 
    						words[0].equals("Balloon") ||
    						words[0].equals("JetPlane"))
    				)
    				{
    					throw new InvalidAircraftTypeException(words[0] + " n'est pas un objet volant valide.");
    				}


    				if (!words[1].matches("^[a-zA-Z0-9]+"))
    				{
    					throw new InvalidAircraftNameException(words[1] + " : n'est pas un nom valide. Il ne doit comporter uniquement des caractères alphanumériques.");
    				}
    				
    				
    				
    				if (setName.contains(words[1]))
    				{
    					throw new NonUniqueNameException(words[1]);
    				}
    				
    				setName.add(words[1]);

    				longitude = Integer.parseUnsignedInt(words[2]);

    				latitude = Integer.parseUnsignedInt(words[3]);

    				height = Integer.parseUnsignedInt(words[4]);
    				
    				if (height > 100)
    				{
    					throw new InvalidHeightException(words[4]);
    				}

                	this.listFlyable.add(AircraftFactory.getAircraftFactory().newAircraft(words[0], words[1], new Coordinates(longitude, latitude, height)));
                }	
                index++;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Le fichier est introuvable.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de lire le fichier en entier.");
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            System.out.println("Nombre incorrect");	
        }
        catch (InvalidAircraftTypeException e)
        {
            e.printStackTrace();
            System.out.println("Type de Aircraft inconnu.");	
        }
        catch (InvalidAircraftNameException e)
        {
            e.printStackTrace();
            System.out.println("Nom du Aircraft invalide.");	
        }
        catch (TokenNumberException e)
        {
            e.printStackTrace();
            System.out.println("Nom du Aircraft invalide.");	
        }
        catch (NonUniqueNameException e)
        {
            e.printStackTrace();
            System.out.println("Ce nom n'est pas unique.");		
        }
        catch (InvalidHeightException e)
        {
            e.printStackTrace();
            System.out.println("Altitude trop élevée.");	       	
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
    
	
	

