/*
 * Class Aircraft implements Flyable
 * # long id
 * # string name
 * # Coordinate coordinates
 * 
 * # Aircraft(long p_id, String p_name, Coordinates p_coordinates)
 * 
 * */
package Aircraft;

import AvajLauncher.Coordinates;
import AvajLauncher.Logger;

public class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected Logger logger;
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
	{
		this.coordinates = p_coordinates;
		this.name = p_name;
		this.id = p_id;
		this.logger = Logger.getLogger();

	}

	
	public void updateConditions()
	{

	}	

}
