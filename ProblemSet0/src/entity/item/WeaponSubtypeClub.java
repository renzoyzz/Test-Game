package entity.item;


import java.util.Random;

public enum WeaponSubtypeClub implements WeaponStat
{
	CLUB("Club",14,1.65,83,false),
	CUDGEL("Cudgel",15,1.65,82,false),
	TRUNCHEON("Truncheon",18,1.72,83,false),
	BLUDGEON("Bludgeon",17,1.7,85,false),
	WARCLUB("War Club",17,1.65,82,false),
	MACE("Mace",20,1.81,81,false),
	FLAIL("Flail",23,2.02,80,false),
	MORNINGSTAR("Morning Star",21,1.78,80,false),
	SHORTSCEPTRE("Short Sceptre",17,1.85,85,false),
	WARSCEPTRE("War Sceptre",19,1.79,84,false);

	private String weaponName;
	private int baseDmg;
	private double baseAtkSpd;
	private int baseAcc;
	private boolean twoHanded;

	private WeaponSubtypeClub(String name, int dmg, 
			double atkSpd, int acc, boolean th) 
	{
		weaponName = name;
	    baseDmg = dmg;
	    baseAtkSpd = atkSpd;
	    baseAcc = acc;
	    twoHanded = th;
	}
	
	public static WeaponSubtypeClub randomize()
	{
		WeaponSubtypeClub[] elements = {CLUB, CUDGEL, TRUNCHEON, BLUDGEON, WARCLUB,
				MACE, FLAIL, MORNINGSTAR, SHORTSCEPTRE, WARSCEPTRE};
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
