package entity.item;


import java.util.Random;

public enum Type 
{
	EQUIPABLE(1500),
	CONSUMABLE(8000),
	OTHER(500);
	
	private int weight;

	private Type(int weight) 
	{
	    this.weight = weight;
	}

	public static Type randomize()
	{
		Type[] elements = {EQUIPABLE, CONSUMABLE, OTHER};
		
		int position = new Random().nextInt(10000);
	    for (Type element : elements)
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

