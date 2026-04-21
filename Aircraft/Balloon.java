/*
 * Inherited from Aircraft
 * class Balloon
 * + Balloon(long p_id, string p_name, Coordinates p_coordinate)
 * + void updateConditions()
 * 
 */
package Aircraft;

import AvajLauncher.Coordinates;

public class Balloon extends Aircraft
{
	
	public Balloon(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}
	
	@Override
	public void updateConditions()
	{
		final String weather = this.weatherTower.getWeather(this.coordinates);
		final int currentLongitude = this.coordinates.getLongitude();
		final int currentHeight = this.coordinates.getHeight();
		
		switch(weather)
		{
		    case "SUN":
		        this.coordinates.setLongitude(currentLongitude + 2);
		        this.coordinates.setHeight(currentHeight + 4);
		        if (this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
		        this.logger.logMsg(this.toString() + " : La Montgolfière par beau temps, c'est que du bonheur.");
		        break;

		    case "FOG":
		    	if (currentHeight > 3) { this.coordinates.setHeight(currentHeight - 3); } else { this.coordinates.setHeight(0);};
		        this.logger.logMsg(this.toString() + " : C'est dommage, ce brouillard empêche d'admirer le paysage.");
		        break;

		    case "RAIN":
		    	if (currentHeight > 5) { this.coordinates.setHeight(currentHeight - 5); } else { this.coordinates.setHeight(0);};
		        this.logger.logMsg(this.toString() + " : Il ne faudrait pas que cette pluie éteigne mon brûleur.");
		        break;

		    case "SNOW":
		    	if (currentHeight > 1) { this.coordinates.setHeight(currentHeight - 1); } else { this.coordinates.setHeight(0);};
		    	this.logger.logMsg(this.toString() +  " : Il fait bien froid dans cette nacelle.");
		        break;

		}
		if (this.coordinates.getHeight() == 0)
		{
			this.logger.logMsg(this.toString()  + ": Je suis au sol.");
			this.weatherTower.unregister(this);
		}
	}
	
    @Override
    public String toString()
    {
        return this.getClass().getName() +"#"+ this.name + "(" + this.id + ")";
    }
    
    public String toStringWithColor()
    {
        return ANSI_GREEN + this.getClass().getName() +"#"+ this.name + "(" + this.id + ")" + ANSI_RESET;
    }
	
}