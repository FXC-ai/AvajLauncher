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
		try
		{
			FileWriter fileCleaner = new FileWriter("output.txt", false);
			fileCleaner.write("");
			fileCleaner.close();
		}
		catch (IOException e)
		{
			System.out.println("Impossible de supprimerle contenu du fichier .txt");
		}
	    
		ArrayList<AircraftParameters> listAircraftParameters = new ArrayList<AircraftParameters>();
		
		listAircraftParameters.add(new AircraftParameters("JetPlane", "Alpha", new Coordinates(20, 50, 15)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Bravo", new Coordinates(80, 15, 40)));
		listAircraftParameters.add(new AircraftParameters("Baloon", "Delta", new Coordinates(200, 10, 6)));
		listAircraftParameters.add(new AircraftParameters("JetPlane", "Echo", new Coordinates(45, 80, 25)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Foxtrot", new Coordinates(120, 30, 90)));
		listAircraftParameters.add(new AircraftParameters("Baloon", "Golf", new Coordinates(300, 5, 10)));
		listAircraftParameters.add(new AircraftParameters("JetPlane", "Hotel", new Coordinates(12, 95, 88)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "India", new Coordinates(55, 25, 33)));
		listAircraftParameters.add(new AircraftParameters("Baloon", "Juliet", new Coordinates(400, 12, 120)));
		listAircraftParameters.add(new AircraftParameters("JetPlane", "Kilo", new Coordinates(99, 60, 44)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Lima", new Coordinates(10, 10, 10)));
		listAircraftParameters.add(new AircraftParameters("Baloon", "Mike", new Coordinates(180, 8, 200)));
		listAircraftParameters.add(new AircraftParameters("JetPlane", "November", new Coordinates(77, 40, 55)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Oscar", new Coordinates(25, 35, 65)));
		listAircraftParameters.add(new AircraftParameters("Baloon", "Papa", new Coordinates(500, 3, 300)));
		listAircraftParameters.add(new AircraftParameters("JetPlane", "Quebec", new Coordinates(33, 75, 12)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Romeo", new Coordinates(150, 20, 150)));
		listAircraftParameters.add(new AircraftParameters("Baloon", "Sierra", new Coordinates(220, 7, 80)));
		listAircraftParameters.add(new AircraftParameters("JetPlane", "Tango", new Coordinates(88, 55, 22)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Uniform", new Coordinates(66, 45, 99)));
	
		ArrayList<Flyable> listFlyables = Main.aircraftInitilizer(listAircraftParameters);
		WeatherTower TourMeteo;
		

		TourMeteo = new WeatherTower();

		
		
		for (Flyable flyable : listFlyables)
		{
			TourMeteo.register(flyable);
			flyable.registerTower(TourMeteo);
		}		
		
		int i = 15;
		while (i > 0)
		{
			try
			{
				Logger.getLogger().logMsg("\nTour " + i + "");
				TourMeteo.changeWeather();				
			}
			catch (Exception e)
			{
				System.out.println("Erreur de la simulation.");
			}
			i--;
		}
		
		try
		{
			Logger logger = Logger.getLogger();
			logger.writeLogs();
			logger.printLogs();
		}
		catch (IOException e)
		{
			System.out.println("Logger impossible à instancier.");
		}
		
	

	}
    
}
