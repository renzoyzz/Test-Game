package entity.item;


import java.util.Random;

public enum WeaponType 
{
	MELEE(6000),
	RANGED(4000);
	
	private int weight;

	private WeaponType(int weight) 
	{
	    this.weight = weight;
	}

	public static WeaponType randomize()
	{
		WeaponType[] elements = {MELEE, RANGED};
		
		int position = new Random().nextInt(10000);
	    for (WeaponType element : elements)
	    {
	       if (position < element.weight)
	       {
	           return element;
	       }
	       position -= element.weight;
	    }
	    
	    throw new IllegalStateException("Error occurred during randomization");
	}
}
