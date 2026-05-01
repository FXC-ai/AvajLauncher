/*Abstract Class Flyable
 * 
 * 	# WeatherTower weatherTower;
 *	+ abstract void updateConditions();
 *	+ void registerTower(WeatherTower* p_tower);
 * 
 * */

public abstract class Flyable
{
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	protected WeatherTower weatherTower;
	
	public abstract void updateConditions();
	
	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
	}
}
