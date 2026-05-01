/* Abstract Class Flyable
 * 
 * 	# WeatherTower weatherTower;
 *	+ abstract void updateConditions();
 *	+ void registerTower(WeatherTower* p_tower);
 * 
 * */

public abstract class Flyable
{
	protected WeatherTower weatherTower;
	
	public abstract void updateConditions();
	
	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
	}
}
