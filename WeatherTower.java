public class WeatherTower extends Tower
{
	public WeatherTower()
	{
		super();
	}
		
	public String getWeather (Coordinates coordinates)
	{
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}
	
	void changeWeather() throws Exception
	{
		try
		{
			this.conditionChanged();			
		}
		catch (Exception e)
		{
			throw new Exception();
		}
	}	
}
