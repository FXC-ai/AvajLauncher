
public abstract class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	
	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
	}
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) 
	{
		this.coordinates = p_coordinates;
		this.name = p_name;
		this.id = p_id;
	}
}
