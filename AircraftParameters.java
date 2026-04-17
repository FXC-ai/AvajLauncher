
public class AircraftParameters
{
	protected final String type;
	protected final String name;
	protected final Coordinates coord;
	
	AircraftParameters
	(
			final String p_type,
			final String p_name,
			final Coordinates p_coordinates
	)
	{
		this.type = p_type;
		this.name = p_name;
		this.coord = p_coordinates;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Coordinates getCoord()
	{
		return this.coord;
	}
}
