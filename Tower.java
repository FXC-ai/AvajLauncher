import java.util.List;

public class Tower
{
	
	List<Flyable> observers;
	
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
		}
	}
	
}
