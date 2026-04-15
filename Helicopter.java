public class Helicopter extends Aircraft
{
	
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
//		this.weatherTower.register(this);
	}
	
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		System.out.println(weather);
		final int currentLongitude = this.coordinates.getLongitude();
		final int currentHeight = this.coordinates.getHeight();
		
	   switch(weather)
	   {
	       case "SUN":
	    	   this.coordinates.setLongitude(currentLongitude + 10);
	    	   if (currentHeight < 100) { this.coordinates.setHeight(this.coordinates.getHeight() + 2); } ;    	   
	           System.out.println("Il fait beau, J'augmente mon altitude de 2 et ma longitude de 10.");
	           break;
	   
	       case "FOG":
	    	   this.coordinates.setLongitude(currentLongitude + 1);
	           System.out.println("Quel brouillard ! J'augmente ma longitude de 2.");
	           break;
	   
	       case "RAIN":
	    	   this.coordinates.setLongitude(currentLongitude + 5);
	           System.out.println("Quelle pluie infernale ! J'augmente ma longitude de 5. ");
	           break;
	           
	       case "SNOW":
	    	   if (currentHeight >= 12)
	    	   {
	    		   this.coordinates.setHeight(currentHeight - 12);
	    		   System.out.println("La neige c'est le pire ! Je diminue mon alititude de 12.");
	    	   }
	    	   else
	    	   {
	    		   this.coordinates.setHeight(0);
	    		   System.out.println("Je suis au sol ! Au revoir ...");
	    	   }
	    	   break;
	       default:
	           System.out.println("Choix incorrect");
	           break;
	   }
		
	}
	
}
