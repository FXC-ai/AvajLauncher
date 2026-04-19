import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

public class Helicopter extends Aircraft
{
	
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}


	public void printMsg(String message) throws IOException
	{
		String fullMsg = this.toString() + ": " + message + " " + this.coordinates.toString();
		
		
	    FileWriter fw = new FileWriter("output.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(fullMsg);
	    bw.newLine();
	    bw.close();
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
		        this.printMsg("Regarde comme il fait beau, faut sortir s'amuser !");
		        break;

		    case "FOG":
		        this.coordinates.setLongitude(currentLongitude + 1);
		        this.printMsg("Ce brouillard est infernal ! Je pourrais le couper au couteau !");
		        break;

		    case "RAIN":
		        this.coordinates.setLongitude(currentLongitude + 5);
		        this.printMsg("It's raining again ! On va être super trempé ;)");
		        break;

		    case "SNOW":
		    	int newHeight = (currentHeight > 12) ? currentHeight - 12 : 0;
		    	this.coordinates.setHeight(newHeight);
		        this.printMsg("La neige en vol c'est pas terrible ! C'est mieux pour le ski...");
		        break;

		    default:
		    	throw new Exception();

		}
		if (this.coordinates.getHeight() == 0)
		{
			this.printMsg("Je suis au sol.");
			this.weatherTower.unregister(this);
		}
	}
	
    @Override
    public String toString() {
        return "" + this.getClass().getName() +"#"+ this.name + "(" + this.id + ")";
    }
}
