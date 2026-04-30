
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main
{
	public static boolean testParser(Parser parser)
	{
		try
		{
			parser.ParseFile();

		}
		catch (FileNotFoundException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (IOException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (NumberFormatException e)
		{
		    System.out.println(e.getCause() + e.getMessage());
		    return false;
		}
		catch (FirstLineErrorException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (InvalidAircraftTypeException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (InvalidAircraftNameException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (TokenNumberException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (NonUniqueNameException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (InvalidCoordinatesException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		catch (InvalidHeightException e)
		{
		    System.out.println(e.getMessage());
		    return false;
		}
		
		return true;
	}
	
	public static void executeSimulation(int repeat, List<Flyable> listFlyable)
	{
		Logger logger = Logger.getLogger();
		try
		{
			FileWriter fileCleaner = new FileWriter("simulation.txt", false);
			fileCleaner.write("");
			fileCleaner.close();
		}
		catch (IOException e)
		{
			System.out.println("Impossible de supprimer le contenu du fichier .txt");
		}

		WeatherTower TourMeteo = new WeatherTower();;

		for (Flyable flyable : listFlyable)
		{
			TourMeteo.register(flyable);
			flyable.registerTower(TourMeteo);
		}		

		int i = repeat;
		while (i > 0)
		{
			// logger.logMsg("\nTour " + i + "");
			TourMeteo.changeWeather();				
			i--;
		}

		try
		{
			logger.writeLogs();			
		}
		catch (Exception e)
		{
			System.out.println("Impossible de log la simulation.");
		}
		logger.printLogs();
		System.out.println("Simulation terminée avec succés.");
	}
	
	public static void main(String[] args)
	{
		
		if(args.length != 1)
		{
			System.out.println("Erreur argument.");
			return;
		}
		
		final String scenario = args[0];
		
		Parser p = new Parser(scenario);
		
	    if (Main.testParser(p))
	    {
	    	// System.out.println(p);
	        Main.executeSimulation(p.getRepeat(), p.getListFlyable());
	    }	
	}    
}
