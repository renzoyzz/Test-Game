package entity.item;


import java.util.Random;

public enum WeaponSubtypeStaff implements WeaponStat
{
	BASTONTH("Baston",10,2.00,88,true),
	MAKILATH("Makila",10,1.90,87,true),
	SHORTSTAFFTH("Short Staff",8,1.55,80,true);
	
	

	private String weaponName;
	private int baseDmg;
	private double baseAtkSpd;
	private int baseAcc;
	private boolean twoHanded;

	private WeaponSubtypeStaff(String name, int dmg, 
			double atkSpd, int acc, boolean th) 
	{
		weaponName = name;
	    baseDmg = dmg;
	    baseAtkSpd = atkSpd;
	    baseAcc = acc;
	    twoHanded = th;
	}
	
	public static WeaponSubtypeStaff randomize()
	{
		WeaponSubtypeStaff[] elements = {BASTONTH, MAKILATH, SHORTSTAFFTH};
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
