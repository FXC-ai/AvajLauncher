
public abstract class Flyable
{
	protected WeatherTower weatherTower;
	
	public abstract void updateConditions() throws Exception;
	
	public abstract void registerTower(WeatherTower p_tower);
}
