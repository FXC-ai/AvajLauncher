public class Helicopter extends Aircraft
{
	
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		final int currentLongitude = this.coordinates.getLongitude();
		final int currentHeight = this.coordinates.getHeight();
		
		switch(weather)
		{
		    case "SUN":
		        System.out.print(this.toString() + ": ");
		        System.out.print("SUN " + this.coordinates.toString() + " => ");
		        this.coordinates.setLongitude(currentLongitude + 10);
		        this.coordinates.setHeight(currentHeight + 2);
		        if (this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
		        System.out.print(this.coordinates.toString());
		        System.out.println(" Regarde comme il fait beau, faut sortir s'amuser !");
		        break;

		    case "FOG":
		        System.out.print(this.toString() + ": ");
		        System.out.print("FOG " + this.coordinates.toString() + " => ");
		        this.coordinates.setLongitude(currentLongitude + 1);
		        System.out.print(this.coordinates.toString());
		        System.out.println(" On n'y voit rien avec tout ce brouillard !");
		        break;

		    case "RAIN":
		        System.out.print(this.toString() + ": ");
		        System.out.print("RAIN " + this.coordinates.toString() + " => ");
		        this.coordinates.setLongitude(currentLongitude + 5);
		        System.out.print(this.coordinates.toString());
		        System.out.println(" Sortez les parapluies, ça mouille !");
		        break;

		    case "SNOW":
		        System.out.print(this.toString() + ": ");
		        System.out.print("SNOW " + this.coordinates.toString() + " => ");
		        if (currentHeight >= 12)
		        {
		            this.coordinates.setHeight(currentHeight - 12);
		        }
		        else
		        {
		            this.coordinates.setHeight(0);
		            this.weatherTower.unregister(this);
		        }
		        System.out.print(this.coordinates.toString());
		        if (this.coordinates.getHeight() == 0)
		        {
		        	System.out.println(" Je suis au sol. Continuez sans moi ! A bientôt ! ");
		        }
		        else
		        {
		        	System.out.println(" Il neige, c'est bien pour skier mais pas pour voler !");
		        };
		        break;

		    default:
		        System.out.println("Choix incorrect");
		        break;
		}
	}
	
	// Balloon#B1(1): Let's enjoy the good weather and take some pics.
	
    @Override
    public String toString() {
        return "" + this.getClass().getName() +"#"+ this.name + "(" + this.id + ")";
    }
}
