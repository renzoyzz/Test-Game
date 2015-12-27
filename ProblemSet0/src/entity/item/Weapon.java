package entity.item;


import java.util.Random;

public class Weapon extends Equipable
{
	private WeaponType weaponType;
	private WeaponSubtype weaponSubtype;
	private WeaponStat weaponStat;
	private int damage;
	private double attackSpeed;
	private int accuracy;
	private boolean twoHanded;

	//Quest
	public Weapon()
	{
		super(EquipType.WEAPON);
		weaponType = WeaponType.randomize();
		weaponSubtype = WeaponSubtype.randomize(weaponType);
		weaponStat = WeaponSubtype.randomizeStats(weaponSubtype);
		damage = calculateDamage(weaponStat.getBaseDamage());
		attackSpeed = calculateAttackSpeed(weaponStat.getBaseAttackSpeed());
		accuracy = calculateAccuracy(weaponStat.getBaseAccuracy());
		twoHanded = weaponStat.isTwoHanded();
		super.setItemName(getEquipQuality().getNameMod()+
				weaponStat.getWeaponName());
		System.out.println(getEquipQuality());
		super.setItemPrice(determinePrice());
	}
	//Quest
	public Weapon(WeaponType type, WeaponSubtype subtype, EquipQuality quality, 
			String name, Rarity rarity, int level)
	{
		super(EquipType.WEAPON, quality, name, rarity, level);
		weaponType = type;
		weaponSubtype = subtype;
		damage = 1;
		attackSpeed = 1;
		accuracy = 1;
	}
	
	/**
	 * Calculates the final damage parameter for a given item based on
	 * its level, quality, rarity, and additional bonus attributes. A
	 * random offset to the base is applied to add variety.
	 * 
	 * @param base base damage value of the item
	 * @return the calculated damage value for the item
	 */
	private int calculateDamage(int base)
	{
		float dmg = (float)base;
		dmg+= (new Random().nextInt(2) > 0 ? 1 : -.5)*
				new Random().nextInt(4)*(float)base/13;
		//Item level bonus
		dmg *= getItemLevel();
		//Rarity level bonus
		dmg *= getItemRarity().getDmgMod();
		//Quality bonus
		dmg *= getEquipQuality().getDmgMod();
		//Attribute bonus(es)
		//TODO implement attributes
		return (int)dmg+1;
	}
	
	/**
	 * Calculates the final attack speed parameter for a given item based on
	 * its level, quality, rarity, and additional bonus attributes. A
	 * random offset to the base is applied to add variety.
	 * 
	 * @param base base attack speed value of the item
	 * @return the calculated attack speed value for the item
	 */
	private double calculateAttackSpeed(double base)
	{
		float atkSpd = (float)base;
		//Randomize base
		atkSpd += (new Random().nextInt(2) > 0 ? 1 : -.5)*
				new Random().nextInt(10)*base/200;
		//Item level bonus
		atkSpd /= 1+(float)getItemLevel()/700;
		//Rarity level bonus
		atkSpd /= getItemRarity().getAtkSpdMod();
		//Quality bonus
		atkSpd /= getEquipQuality().getAtkSpdMod();
		//Attribute bonus(es)
		//TODO implement attributes
		return atkSpd;
	}
	
	/**
	 * Calculates the final accuracy parameter for a given item based on
	 * its level, quality, rarity, and additional bonus attributes. A
	 * random offset to the base is applied to add variety.
	 * 
	 * @param base base accuracy value of the item
	 * @return the calculated accuracy value for the item
	 */
	//TODO change algorithm, since those with lower accuracies get a larger bonus and end up being irrelevant
	private int calculateAccuracy(int base)
	{
		float acc = (float)base;
		acc+= (new Random().nextInt(2) > 0 ? 1 : -.1)*
				new Random().nextInt(50)*(float)base/1000;
		//Item level bonus
		acc += (100-acc)*(float)getItemLevel()/200;
		//Rarity level bonus
		acc += (100-acc)*getItemRarity().getAccMod();
		//Quality bonus
		acc += (100-acc)*getEquipQuality().getAccMod();
		//Attribute bonus(es)
		//TODO implement attributes
		return (int)acc;
	}
	
	protected int determinePrice()
	{
		double price = 1;
		
		price += 10*(getItemLevel()/2+1);
		price *= (double)(damage+50)/50;
		price *= 1+1/attackSpeed;
		price *= 1+(double)accuracy/99;
		price *= getItemRarity().getPriceMod();
		price *= getEquipQuality().getPriceMod();
		
		return (int)price+1;
	}
	
	public WeaponType getWeaponType()
	{
		return weaponType;
	}
	
	public WeaponSubtype getWeaponSubtype()
	{
		return weaponSubtype;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public double getAttackSpeed()
	{
		return attackSpeed;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
	
	public boolean isTwoHanded()
	{
		return twoHanded;
	}
	
	@Override
	protected Item dropItem() {
		// TODO Auto-generated method stub
		return null;
	}
}
