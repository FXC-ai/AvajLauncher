import ajexceptions.InvalidAircraftTypeException;

/*
 * Singleton
 * class AircraftFactory
 * + Flyable* newAircraft(string p_type, string p_name, Coordinates p_coordinates)
 * 
 * */

public class AircraftFactory
{
	private static AircraftFactory instance;
	
	private static long p_id;
	
	private AircraftFactory()
	{
		p_id = 0;
	}
	
	public static AircraftFactory getAircraftFactory()
	{
		if (instance == null)
		{
			instance = new AircraftFactory();
			return instance;
		}
		return instance;
	}
	
	public long getPid()
	{
		return p_id;
	}
	
	public Flyable newAircraft 
	(
			String p_type,
			String p_name,
			Coordinates p_coordinate
	) throws InvalidAircraftTypeException
	{
		p_id += 1;

		switch(p_type)
		{
			case "Helicopter":
				return new Helicopter(p_id, p_name, p_coordinate);
			case "JetPlane":
				return  new JetPlane(p_id, p_name, p_coordinate);
			case "Balloon":
				return  new Balloon(p_id, p_name, p_coordinate);
			default :
				throw new InvalidAircraftTypeException(p_type);
		}
		
	}
	
}
