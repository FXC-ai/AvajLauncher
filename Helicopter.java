/*
 * Class Helicopter inherited from Aircraft
 * + Helicopter(long p_id, String p_name, Coordinates p_coordinates)
 * + void updateConditions()
 * 
 * */


public class Helicopter extends Aircraft
{
	
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
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
		        this.coordinates.setLongitude(currentLongitude + 10);
		        this.coordinates.setHeight(currentHeight + 2);
		        if (this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
		        this.logger.logMsg(this.toString() + " : Regarde comme il fait beau, faut sortir s'amuser !");
		        break;

		    case "FOG":
		        this.coordinates.setLongitude(currentLongitude + 1);
		        this.logger.logMsg(this.toString() + " : Ce brouillard est infernal ! Je pourrais le couper au couteau !");
		        break;

		    case "RAIN":
		        this.coordinates.setLongitude(currentLongitude + 5);
		        this.logger.logMsg(this.toString() + " : It's raining again ! On va être super trempé ;)");
		        break;

		    case "SNOW":
		    	int newHeight = (currentHeight > 12) ? currentHeight - 12 : 0;
		    	this.coordinates.setHeight(newHeight);
		    	this.logger.logMsg(this.toString() + " : La neige en vol c'est pas terrible ! C'est mieux pour le ski...");
		        break;

		}
		if (this.coordinates.getHeight() == 0)
		{
			this.logger.logMsg(this.toString() + " : Je suis au sol.");
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
        return ANSI_YELLOW + this.getClass().getName() +"#"+ this.name + "(" + this.id + ")" + ANSI_RESET;
    }
}
