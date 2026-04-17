import java.util.ArrayList;
import java.util.List;

public class WeatherTower
{
	private List<Flyable> observers;
	private List<Flyable> flyableToDelete;
	
	public WeatherTower()
	{
		this.observers = new ArrayList<Flyable>();
		this.flyableToDelete = new ArrayList<Flyable>();
		
	}
		
	public void register(Flyable p_flyable)
	{
		this.observers.add(p_flyable);
	}
	
	public void unregister(Flyable p_flyable)
	{
		this.flyableToDelete.add(p_flyable);
	}
	
	public void conditionChanged()
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}
		this.observers.removeAll(this.flyableToDelete);
		this.flyableToDelete.clear();
		// System.out.println(this.observers.size() + " " + this.flyableToDelete.size());
	}

	public String getWeather (Coordinates coordinates)
	{
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}
	
	void changeWeather()
	{
		
	}	
}
