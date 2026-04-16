import java.util.ArrayList;
import java.util.List;


public class Main
{
	public static void main(String[] args)
	{
		
//		List<Integer> test = new ArrayList<>();
//		test.add(1);
//		test.add(3);
//		test.add(5);
//		
//		for (int nb : test)
//		{
//			System.out.println(nb);
//			
//			int index = test.indexOf(nb);
//			if (index == 1)
//			{
//				test.remove(index);
//			}
//		}

		
		Helicopter heli = new Helicopter(1,"heli", new Coordinates(1,2,3));
		Helicopter heli1 = new Helicopter(1,"heli", new Coordinates(1,2,3));
		WeatherTower TourMeteo = new WeatherTower();
		TourMeteo.register(heli);
		TourMeteo.register(heli1);
		heli.registerTower(TourMeteo);
		heli1.registerTower(TourMeteo);
		TourMeteo.conditionChanged();
		if (heli.coordinates.getHeight() == 0)
		{
			TourMeteo.unregister(heli);
		}
		if (heli1.coordinates.getHeight() == 0)
		{
			TourMeteo.unregister(heli1);
		}
	}
    
}
