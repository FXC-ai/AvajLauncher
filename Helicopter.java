
import java.io.IOException;



public class Helicopter extends Aircraft
{
	
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) throws IOException
	{
		super(p_id, p_name, p_coordinates);
	}
	
	@Override
	public void updateConditions() throws Exception
	{

		final String weather = this.weatherTower.getWeather(this.coordinates);
		//final String weather = "HELLO";
		final int currentLongitude = this.coordinates.getLongitude();
		final int currentHeight = this.coordinates.getHeight();
		
		switch(weather)
		{
		    case "SUN":
		        this.coordinates.setLongitude(currentLongitude + 10);
		        this.coordinates.setHeight(currentHeight + 2);
		        if (this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
		        this.logger.logMsg("Regarde comme il fait beau, faut sortir s'amuser !");
		        break;

		    case "FOG":
		        this.coordinates.setLongitude(currentLongitude + 1);
		        this.logger.logMsg("Ce brouillard est infernal ! Je pourrais le couper au couteau !");
		        break;

		    case "RAIN":
		        this.coordinates.setLongitude(currentLongitude + 5);
		        this.logger.logMsg("It's raining again ! On va être super trempé ;)");
		        break;

		    case "SNOW":
		    	int newHeight = (currentHeight > 12) ? currentHeight - 12 : 0;
		    	this.coordinates.setHeight(newHeight);
		    	this.logger.logMsg("La neige en vol c'est pas terrible ! C'est mieux pour le ski...");
		        break;

		    default:
		    	throw new Exception();

		}
		if (this.coordinates.getHeight() == 0)
		{
			this.logger.logMsg("Je suis au sol.");
			this.weatherTower.unregister(this);
		}
	}
	
    @Override
    public String toString() {
        return "" + this.getClass().getName() +"#"+ this.name + "(" + this.id + ")";
    }
}
