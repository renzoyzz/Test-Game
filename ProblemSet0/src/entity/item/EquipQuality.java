package entity.item;


import java.util.Random;

public enum EquipQuality 
{
	NORMAL(9000,"",1,1,0,1),
	CRUDE(75,"Crude ",.75,1,0,.9),
	FRAIL(175,"Frail ",.875,1,0,.95),
	HEAVY(125,"Heavy ",1.125,.85,0,1.05),
	LIGHT(125,"Light ",.875,1.15,0,1.05),
	REINFORCED(75,"Reinforced ",1.25,1,0,1.15),
	STURDY(175,"Sturdy ",1.125,1,0,1.1),
	SUPERIOR(100,"Superior ",1.125,1,.5,1.15),
	INFERIOR(100,"Inferior ",.875,1,-.5,.85),
	ETHEREAL(50,"Ethereal ",.875,1.3,.5,1.15);
	
	private int weight;
	private String nameMod;
	private double dmgMod;
	private double atkSpdMod;
	private double accMod;
	private double priceMod;

	private EquipQuality(int weight, String nameMod, double dmgMod, 
			double atkSpdMod, double accMod, double priceMod) 
	{
	    this.weight = weight;
	    this.nameMod = nameMod;
	    this.dmgMod = dmgMod;
	    this.atkSpdMod = atkSpdMod;
	    this.accMod = accMod;
	    this.priceMod = priceMod;
	}

	public static EquipQuality randomize()
	{
		EquipQuality[] elements = {NORMAL, CRUDE, FRAIL, HEAVY, LIGHT, 
				REINFORCED, STURDY, SUPERIOR, INFERIOR, ETHEREAL};
		
		int position = new Random().nextInt(10000);
	    for (EquipQuality element : elements)
	    {
	       if (position < element.weight)
	       {
	           return element;
	       }
	       position -= element.weight;
	    }
	    
	    throw new IllegalStateException("Error occurred during randomization");
	}
	
	public String getNameMod()
	{
		return nameMod;
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
