import java.io.IOException;

public class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected Logger logger;
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) throws IOException
	{
		this.coordinates = p_coordinates;
		this.name = p_name;
		this.id = p_id;
		this.logger = Logger.getLogger();

	}
	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
	}
	
	public void updateConditions() throws Exception
	{

	}	

}
