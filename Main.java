import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	public static ArrayList<Flyable> aircraftInitilizer (ArrayList<AircraftParameters> listAircraftParameters)
	{
		ArrayList<Flyable> listFlyables = new ArrayList<Flyable>();
		
		final AircraftFactory aircraftFactory = AircraftFactory.getAircraftFactory();
		for (AircraftParameters parameters : listAircraftParameters)
		{
			try
			{
				final Flyable currentAircraft = aircraftFactory.newAircraft(parameters.getType(), parameters.getName(), parameters.getCoord());
				listFlyables.add(currentAircraft);
			}
			catch (Exception e)
			{
				System.out.println("Erreur instanciation d'un aircraft.");
			}
		}
		return listFlyables;
	}
	
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger();
		Parser parser = new Parser("scenario.txt");
		parser.ReadFile();
		System.out.print(parser);
		System.out.print("\n");
		
		try
		{
			FileWriter fileCleaner = new FileWriter("output.txt", false);
			fileCleaner.write("");
			fileCleaner.close();
		}
		catch (IOException e)
		{
			System.out.println("Impossible de supprimer le contenu du fichier .txt");
		}


		WeatherTower TourMeteo = new WeatherTower();;

		for (Flyable flyable : parser.getListFlyable())
		{
			TourMeteo.register(flyable);
			flyable.registerTower(TourMeteo);
		}		

		int i = parser.getRepeat();
		while (i > 0)
		{
			logger.logMsg("\nTour " + i + "");
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

		
	}
    
}
