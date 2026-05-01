/*
 * class Coordinates
 *	- int longitude;
 *	- int latitude;
 *	- int height;
 *	
 *	~Coordinates(int p_longitude, int p_latitude, int p_height)
 *	+ int getLongitude()
 *	+ int getLatitude()
 *	+ int getHeight()
 * 
 * */

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;
	
	Coordinates(int p_longitude, int p_latitude, int p_height)
	{
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = Math.min(100, p_height);		
	}
	
	public int getLongitude()
	{
		return this.longitude;
	}
	
	public int getLatitude()
	{
		return this.latitude;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public void setLongitude(int new_longitude)
	{
		this.longitude = new_longitude;
	}

	public void setLatitude(int new_latitude)
	{
		this.latitude = new_latitude;
	}	
	
	public void setHeight(int new_height)
	{
		this.height = Math.min(100, new_height);
	}
	
    @Override
    public String toString()
	{
        return "{" + this.latitude + "," + this.longitude + "," + this.height + "}";
    }
}
