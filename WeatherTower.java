import java.util.ArrayList;
import java.util.List;

public class WeatherTower
{
	List<Flyable> observers;
	
	public WeatherTower()
	{
		this.observers = new ArrayList<Flyable>();
		System.out.println("WeatherTower instancied");
	}
		
	public void register(Flyable p_flyable)
	{
		this.observers.add(p_flyable);
	}
	
	public void unregister(Flyable p_flyable)
	{
		int index = observers.indexOf(p_flyable);
		observers.remove(index);

	}
	
	public void conditionChanged()
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
			System.out.println("Recherche");
		}
	}

	public String getWeather (Coordinates coordinates)
	{
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}
	
	void changeWeather()
	{
		
	}	
}
