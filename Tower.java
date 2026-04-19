import java.util.ArrayList;
import java.util.List;

public class Tower
{	
	private List<Flyable> observers;
	private List<Flyable> flyableToDelete;

	public Tower()
	{
		this.observers = new ArrayList<Flyable>();
		this.flyableToDelete = new ArrayList<Flyable>();
	}
		
	public void register(Flyable p_flyable)
	{
		this.observers.add(p_flyable);
		System.out.println(p_flyable + " registered to weather tower.");
	}
	
	public void unregister(Flyable p_flyable)
	{
		this.flyableToDelete.add(p_flyable);
		System.out.println(p_flyable + " unregistered from weather tower.");
	}
	
	public void conditionChanged() throws Exception
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}
		this.observers.removeAll(this.flyableToDelete);
		this.flyableToDelete.clear();
		// System.out.println(this.observers.size() + " " + this.flyableToDelete.size());
	}

	
}
