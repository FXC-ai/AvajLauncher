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
		ArrayList<AircraftParameters> listAircraftParameters = new ArrayList<AircraftParameters>();
		
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Leo", new Coordinates(10,10,10)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Fan", new Coordinates(100,2,100)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Chr", new Coordinates(150,9,30)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Emm", new Coordinates(14,21,3)));
		listAircraftParameters.add(new AircraftParameters("Helicopter", "Mon", new Coordinates(100,42,100)));
	
		ArrayList<Flyable> listFlyables = Main.aircraftInitilizer(listAircraftParameters);
		WeatherTower TourMeteo = new WeatherTower();
		
        try {

            FileWriter fw = new FileWriter("output.txt", false);
            fw.write("");
            fw.close();
            System.out.println("Contenu supprimé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		for (Flyable flyable : listFlyables)
		{
			TourMeteo.register(flyable);
			flyable.registerTower(TourMeteo);
		}		
		
		int i = 10;
		while (i > 0)
		{
			System.out.println("Tour " + i + " :");
			try
			{
				TourMeteo.changeWeather();				
			}
			catch (Exception e)
			{
				System.out.println("Erreur de la simulation.");
			}
			i--;
		}

	}
    
}
