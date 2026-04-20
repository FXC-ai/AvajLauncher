
/*
 * Class WeatherTower inherited from Tower
 * + string getWeather(Coordinates p_coordinates)
 * + void changeWeather()
 * 
 * */


public class WeatherTower extends Tower
{
//	public WeatherTower()
//	{
//		super();
//	}
		
	public String getWeather (Coordinates coordinates)
	{
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}
	
	void changeWeather()
	{

			this.conditionChanged();			

	}	
}
