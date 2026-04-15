
public abstract class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) 
	{
		this.coordinates = p_coordinates;
		this.name = p_name;
		this.id = p_id;
	}
	
	
	
}
