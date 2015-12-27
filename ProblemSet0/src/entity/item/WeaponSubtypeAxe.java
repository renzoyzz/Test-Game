package entity.item;


import java.util.Random;

public enum WeaponSubtypeAxe implements WeaponStat
{
	BATTLEAXE("Battle Axe",11,1.80,85,true),
	BATTLEAXETH("Battle Axe",24,2.90,85,false),
	BROADAXE("Broadaxe",10,1.70,86,false),
	CLEAVER("Cleaver",13,1.75,85,false),
	DOLOIRE("Doloire",9,1.70,82, true),
	EPSILONAXE("Epsilon Axe",12,1.80,83,true),
	HANDAXE("Hand Axe",8,1.50,76,false),
	HATCHET("Hatchet",9,1.60,80,false),
	ONO("Ono",11,1.65,85,false);
	
	private String weaponName;
	private int baseDmg;
	private double baseAtkSpd;
	private int baseAcc;
	private boolean twoHanded;

	private WeaponSubtypeAxe(String name, int dmg, 
			double atkSpd, int acc, boolean th) 
	{
		weaponName = name;
	    baseDmg = dmg;
	    baseAtkSpd = atkSpd;
	    baseAcc = acc;
	    twoHanded = th;
	}
	
	public static WeaponSubtypeAxe randomize()
	{
		WeaponSubtypeAxe[] elements = {BATTLEAXE, BATTLEAXETH, BROADAXE, CLEAVER,
				DOLOIRE, EPSILONAXE, HANDAXE, HATCHET, ONO};
		return elements[new Random().nextInt(elements.length)];
	}
	
	/**
	 * @return the base name for the item
	 */
	public String getWeaponName()
	{
		return weaponName;
	}
	
	/**
	 * @return the item's base damage value
	 */
	public int getBaseDamage()
	{
		return baseDmg;
	}
	
	/**
	 * @return the item's base attack speed value
	 */
	public double getBaseAttackSpeed()
	{
		return baseAtkSpd;
	}
	
	/**
	 * @return the item's base accuracy value
	 */
	public int getBaseAccuracy()
	{
		return baseAcc;
	}
	
	/**
	 * @return whether the item requires two hands for use
	 */
	public boolean isTwoHanded()
	{
		return twoHanded;
	}
}
