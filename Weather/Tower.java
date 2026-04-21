/*
 * Class Tower
 * - List<Flyable> observers
 * 
 * + void register(Flyable* p_flyable)
 * + void unregister(Flyable* p_flyable)
 * # void conditionChanged()
 * 
 */
package Weather;

import java.util.ArrayList;
import java.util.List;

import Aircraft.Flyable;
import AvajLauncher.Logger;

public class Tower
{	
	private List<Flyable> observers;
	private List<Flyable> flyableToDelete;
	private Logger logger;

	public Tower()
	{
		this.observers = new ArrayList<Flyable>();
		this.flyableToDelete = new ArrayList<Flyable>();
		this.logger = Logger.getLogger();
	}
		
	public void register(Flyable p_flyable)
	{
		this.observers.add(p_flyable);
		this.logger.logMsg("Tower says : " + p_flyable + " registered to weather tower.");
	}
	
	public void unregister(Flyable p_flyable)
	{
		this.flyableToDelete.add(p_flyable);
		this.logger.logMsg("Tower says : " + p_flyable + " unregistered from weather tower.");
	}
	
	public void conditionChanged()
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}
		this.observers.removeAll(this.flyableToDelete);
		this.flyableToDelete.clear();
	}

	
}
