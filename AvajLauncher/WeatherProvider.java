import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Singleton
 * class WeatherProvider
 * - String[] weather
 * 
 * - WeatherProvider()
 * + string getCurrentWeather(Coordinates p_coordinates)
 * 
 * */

public final class WeatherProvider
{
    private static WeatherProvider instance;

    private String[] weather = {"SUN", "FOG", "SNOW", "RAIN"};

    private WeatherProvider() {}

    public static WeatherProvider getInstance()
    {
        if (instance == null)
        {
            instance = new WeatherProvider();
        }
        return instance;
    }
    
	public String getCurrentWeather(Coordinates p_coordinates)
	{
		DateTimeFormatter secs = DateTimeFormatter.ofPattern("ss");

		return weather
		[
			(
					(Integer.parseInt(LocalDateTime.now().format(secs)) * 100) / 60 +  
					p_coordinates.getHeight() +  
					p_coordinates.getLatitude() +  
					p_coordinates.getLongitude()
			) % 4 
		];
	}
}