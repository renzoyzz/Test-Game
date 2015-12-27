package entity.item;


import java.util.Random;

public enum Rarity
{
	COMMON(9750,1,1,0,1),
	UNIQUE(150,1.05,1,0,1.25),
	RARE(80,1.05,1.02,.05,1.5),
	LEGENDARY(20,1.1,1.05,.1,1.75),
	EPIC(0,1.2,1.05,.15,2),
	QUEST(0,1,1,0,0);
	
	private int weight;
	private double dmgMod;
	private double atkSpdMod;
	private double accMod;
	private double priceMod;
	
	private Rarity(int weight, double dmgMod, double atkSpdMod, 
			double accMod, double priceMod) 
	{
	    this.weight = weight;
	    this.dmgMod = dmgMod;
	    this.atkSpdMod = atkSpdMod;
	    this.accMod = accMod;
	    this.priceMod = priceMod;
	}
	
	public static Rarity randomize(int bonus, int pLvl, int eLvl, int iLvl)
	{
		Rarity[] elements = {COMMON, UNIQUE, RARE, LEGENDARY, EPIC};
		
		//Applying level bonuses
		elements[1].weight += (pLvl)+(2*eLvl)+(iLvl/2);
		elements[2].weight += (pLvl/3)+(eLvl/2)+(iLvl/5);
		elements[3].weight += (pLvl/5)+(eLvl/3)+(iLvl/5);
		elements[4].weight += (pLvl>20 && iLvl>30 ? 1:0) //Ensures minimum levels before
				*((pLvl/20)+(eLvl/20)+(iLvl/20));			 //dropping this rarity
		
		//Storing for ease of calculations
		int cWt = 8000; //Keeps Unique weight capped
		int uWt = elements[1].weight;
		int rWt = elements[2].weight;
		int lWt = elements[3].weight;
		int eWt = elements[4].weight;
		
		//Applying Find Chance bonuses
		elements[1].weight *= 1+(((double)cWt/uWt-1)*bonus/100);
		elements[2].weight *= 1+(((double)uWt/rWt-1)*bonus/100);
		elements[3].weight *= 1+(((double)rWt/lWt-1)*bonus/100);
		elements[4].weight *= 1+(((double)lWt/eWt-1)*bonus/100);

		elements[0].weight = 10000-(elements[1].weight+elements[2].weight+
				elements[3].weight+elements[4].weight);

		int position = new Random().nextInt(10000);
	    for (Rarity element : elements)
	    {
	       if (position < element.weight)
	       {
	           return element;
	       }
	       position -= element.weight;
	    }
	    
	    throw new IllegalStateException("Error occurred during randomization");
	}
	
	public double getDmgMod()
	{
		return dmgMod;
	}
	
	public double getAtkSpdMod()
	{
		return atkSpdMod;
	}
	
	public double getAccMod()
	{
		return accMod;
	}
	
	public double getPriceMod()
	{
		return priceMod;
	}
}
