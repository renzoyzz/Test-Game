package entity.item;


import java.util.Random;

public enum WeaponSubtypePolearm implements WeaponStat
{
	HALBERDTH("Halberd",26,3.10,88,true),
	LOCHABERAXETH("Lochaber Axe", 23,2.70,86,true),
	TRIDENTTH("Trident",22,2.80,90,true),
	BRANDISTOCKTH("Brandistock",24,2.63,87,true),
	HASTATH("Hasta",23,2.7,90,true),
	LANCETH("Lance",24,2.65,89,true),
	PIKETH("Pike",25,2.8,87,true),
	QIANGTH("Qiang",23,2.66,89,true),
	SPETUMTH("Spetum",20,2.54,86,true),
	WARSPEARTH("Warspear",25,3.01,91,true),
	YARITH("Yari",22,2.98,90,true),
	BECDECORBINTH("Bec de Corbin",24,2.90,87,true),
	BARDICHETH("Bardiche",28,3.13,85,true),
	BILLTH("Bill",26,2.89,87,true),
	FAUCHARDTH("Fauchard",26,2.75,85,true),
	GLAIVETH("Glaive",29,3.1,85,true),
	NAGINATATH("Naginata",28,2.81,87,true),
	PARTISANTH("Partisan",27,2.93,84,true),
	POLLAXETH("Pollaxe",28,2.95,85,true),
	SCYTHETH("Scythe",30,2.78,78,true),
	VOULGETH("Voulge",29,2.87,84,true),
	WARSCYTHETH("War Scythe",34,2.89,76,true);
	
	private String weaponName;
	private int baseDmg;
	private double baseAtkSpd;
	private int baseAcc;
	private boolean twoHanded;

	private WeaponSubtypePolearm(String name, int dmg, 
			double atkSpd, int acc, boolean th) 
	{
		weaponName = name;
	    baseDmg = dmg;
	    baseAtkSpd = atkSpd;
	    baseAcc = acc;
	    twoHanded = th;
	}
	
	public static WeaponSubtypePolearm randomize()
	{
		WeaponSubtypePolearm[] elements = {HALBERDTH, LOCHABERAXETH, TRIDENTTH, BRANDISTOCKTH,
				HASTATH, LANCETH, PIKETH, QIANGTH, SPETUMTH, WARSPEARTH, YARITH, BECDECORBINTH,
				BARDICHETH, BILLTH, FAUCHARDTH, GLAIVETH, NAGINATATH, PARTISANTH, POLLAXETH,
				SCYTHETH, VOULGETH, WARSCYTHETH};
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
