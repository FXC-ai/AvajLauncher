/*
 * Inherited from Aircraft
 * class JetPlane
 * + JetPlane(long p_id, string p_name, Coordinates p_coordinate)
 * + void updateConditions()
 */


public class JetPlane extends Aircraft
{
	
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}
	
	@Override
	public void updateConditions()
	{
		final String weather = this.weatherTower.getWeather(this.coordinates);
		final int currentLatitude = this.coordinates.getLatitude();
		final int currentHeight = this.coordinates.getHeight();
		
		switch(weather)
		{
		    case "SUN":
		        this.coordinates.setLatitude(currentLatitude + 10);
		        this.coordinates.setHeight(currentHeight + 2);
		        if (this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
		        this.logger.logMsg(this.toString() + " : Mon Cesna et moi on adore le soleil !");
		        break;

		    case "RAIN":
		        this.coordinates.setLatitude(currentLatitude + 5);
		        this.logger.logMsg(this.toString() + " : Dans le cockpit ça va. La pluie ne dérange pas trop.");
		        break;

		    case "FOG":
		        this.coordinates.setLatitude(currentLatitude + 1);
		        this.logger.logMsg(this.toString() + " : Horrible ce brouillard. Je pilote aux instruments !");
		        break;

		    case "SNOW":
		    	int newHeight = (currentHeight > 7) ? currentHeight - 7 : 0;
		    	this.coordinates.setHeight(newHeight);
		    	this.logger.logMsg(this.toString() + " : La neige refroidit trop mon moteur, ça m'inquiète un peu.");
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
}