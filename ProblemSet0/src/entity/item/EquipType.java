package entity.item;


import java.util.Random;

public enum EquipType 
{
	WEAPON(4000),
	ARMOR(5500),
	CHARM(500);
	
	private int weight;

	private EquipType(int weight) 
	{
	    this.weight = weight;
	}

	public static EquipType randomize()
	{
		EquipType[] elements = {WEAPON, ARMOR, CHARM};
		
		int position = new Random().nextInt(10000);
	    for (EquipType element : elements)
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
